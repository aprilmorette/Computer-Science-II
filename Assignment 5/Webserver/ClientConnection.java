import java.net.Socket;
import java.nio.file.*;
import java.io.*;

public class ClientConnection implements Runnable {

    private Socket socket;

    public ClientConnection(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        
        try {
            String fileName = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("GET")) {
                    fileName = line.substring(4, line.indexOf(" HTTP"));
                }
            }
            // if request is empty
            if (fileName.equals("/")) {
                fileName = "index.html";
            } 
            if (fileName.contains("..")) {
                System.out.println("You are only allowed to stay within the directory.");
            }
            // finding requested file on the filesystem and loading it to memory
            File request = new File(fileName);
            //PrintWriter out = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
            OutputStream out = socket.getOutputStream();
            PrintWriter printwriter = new PrintWriter(out, true);
            if (request.exists()) {
                printwriter.print("HTTP/1.1 200 OK\r\n");
                printwriter.print("Content-type: text/html\r\n\r\n");
                BufferedInputStream contents = new BufferedInputStream(new FileInputStream(request));
                
            } else {
                printwriter.println("file not found");
                printwriter.flush();
            }
            Path files = FileSystems.getDefault().getPath(fileName);
                Files.copy(files, out);
                printwriter.flush();
                printwriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("HTTP/1.1 404 Not Found\r\n\r\n");
        } catch (IOException e) {
            System.out.println("HTTP/1.1 500 Internal Server Error\r\n\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
