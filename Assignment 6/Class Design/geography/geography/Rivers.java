package geography;
import java.util.*;
/*
 * The class in charge of creating rivers and accessing their respective variables.
 */
public class Rivers {
    
    private String name;
    private double length;
    private ArrayList<String> within;

    /* 
     * A constructor for creating a river. The default name is Nile River and the length is 4132.
     */
    public Rivers() {
        this.name = "Nile River";
        this.length = 4132;
    }
    /*
     * A constructor that overloads the previous constructor and assigns the respective variable.
     * @param name The river's name
     */
    public Rivers(String name) {
        this.name = name;
    }
    /*
     * A constructor that overloads the two previous constructors and assigns the respective variables.
     * @param name The river's name
     * @param length The length of the river in feet
     */
    public Rivers(String name, int length) {
        this.name = name;
        this.length = length;
    }
    /*
     * Gets the name of the river
     * @return name The name of the river
     */
    public String getRiver() {
        return name;
    }
    /*
     * Lists all the states the river flows through
     * @return within The list of states
     */
    public ArrayList<String> getWithin() {
        return within;
    }
}
