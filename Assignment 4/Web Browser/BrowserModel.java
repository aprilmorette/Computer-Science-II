import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class BrowserModel {

    public static String webAddress = ""; 
    public static String filePath = "";
    public static String webPage = "";

    public static boolean checkHTTPS(String in) {
        String userHTTPS = ""; String correctHTTPS = "https://"; boolean valid = false;
        for (int i = 0; i < 8; i++) {
            userHTTPS += in.charAt(i);
        }
        if (userHTTPS.equals(correctHTTPS)) {
            valid = true;
        }
        return valid;
    }

    public static void getFilePath(String in) {
        for (int i = webAddress.length() + 8; i < in.length(); i++) {
            filePath += in.charAt(i);
        }
    }

    public static void getWebAddress(String in) {
        for (int i = 8; i < in.length(); i++) {
            if (in.charAt(i) != '/') {
                webAddress += in.charAt(i);
            } else {
                break;
            }
        }
    }

    public static String getTitle(String s) {
        int start = s.indexOf("<title>") + "<title>".length();
        int end = s.indexOf("</title>", start);
        String title = s.substring(start, end);
        return title;
    }

    public static String getBody(String s) {
        int start = s.indexOf("<body>") + "<body>".length();
        int end = s.indexOf("</body>", start);
        String body = s.substring(start, end);
        body = body.replaceAll("\\<.*?\\>", "");
        return body;
    }

    public static String getHeadings(String s, int headerNumber) {
        int start = s.indexOf("<h" + headerNumber + ">") + ("<h" + headerNumber + ">").length();
        int end = s.indexOf("</h" + headerNumber + ">", start);
        String header = s.substring(start, end);
        return header;
    }

    public static String getImage(String s) {
        int start = s.indexOf("<img src=\"") + "<img src=\"".length();
        int end = s.indexOf("\">", start);
        String URL = s.substring(start, end);
        return URL;
    }

    public static void setURL(String filePath, String webAddress) {

        String line;

        try {
            SSLSocket socket = (SSLSocket)SSLSocketFactory.getDefault().createSocket(webAddress, 443);
            socket.setSoTimeout(500);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.print("GET " + filePath + " HHTP/1.1\r\n");
            out.print("Host: " + webAddress + "\r\n\r\n");
            out.flush();
            while((line = in.readLine()) != null) {
                webPage += (line + "\n");
            }
        } catch (SocketTimeoutException e) {
        } catch (UnknownHostException e) {
            System.out.println("Please enter a valid URL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}