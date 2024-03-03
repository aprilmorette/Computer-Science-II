import org.w3c.dom.Node;
import java.io.*;

public class HuffmanNode implements Serializable {
    int freq;
    byte b;
    Node right, left;
    HuffmanNode (int freq, byte b, Node right, Node left) {
        this.freq = freq;
        this.b = b;
        this.right = right;
        this.left = left;
    }
}
