package geography;
import java.util.*;
/*
 * The child class of Countries in charge of creating states and accessing their respective variables.
 */
public class States extends Countries {
    
    private String name;
    private String capital;
    private int area;
    private ArrayList<String> neighbors;
    private int boundaryLength;
    /* 
     * A constructor for creating a state. The default name is Oklahoma, the area is 69899 sq feet, and
     * the neighboring states are Texas, Arkansas, Kansas, Colorado, Missouri, and New Mexico.
     */
    public States() {
        this.name = "Oklahoma";
        this.area = 69899;
        this.neighbors.add("Texas"); this.neighbors.add("Arkansas"); this.neighbors.add("Kansas");
        this.neighbors.add("Colorado"); this.neighbors.add("Missouri"); this.neighbors.add("New Mexico");
    }
    /*
     * A constructor that overloads the previous constructor and assigns the respective variable.
     * @param name The state's name
     */
    public States(String name) {
        this.name = name;
    }
    // Setters and getters for certain variables
    /*
     * @return name The name of the state
     */
    public String getState() {
        return name;
    }
    /*
     * @param capital The capital of the state
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }
    /*
     * @return capital The capital of the state
     */
    public String getCapital() {
        return capital;
    }
}
