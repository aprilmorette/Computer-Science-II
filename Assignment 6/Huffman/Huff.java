import java.util.*;
import java.io.*;

public class Huff {
    public static void main(String[] args) {
        Map<Byte, Integer> freqMap;
        Map<Character, String> encodingMap;
        int read, i;
        
        try {
            String inFile = args[0];
            FileInputStream in = new FileInputStream(inFile);
            byte[] arr = new byte[in.available()];
            i = 0;

            while ((read = in.read()) != -1) {
                arr[i] = (byte) read;
                i++;
            }
            in.close();
            HashMap<Byte, Integer> b = new HashMap<>();
		    for (int j = 0; j < arr.length; j++) {
			    if (b.containsKey(arr[j])) {
				    int a = b.get(arr[j]);
				    b.put(arr[j], a + 1);
		    	} else {
			    	b.put(arr[j], 1);
			    }
	    	}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}