package geography;
import java.util.*;
/*
 * The child class of States in charge of creating cities and accessing their respective variables.
 */
public class Cities extends States {

    private String name;
    private int area;
    private ArrayList<String> neighbors;
    private int boundaryLength;

    /* 
     * A constructor for creating a city. The default name is Stillwater and the area is 30 sq feet.
     */
    public Cities() {
        this.name = "Stillwater";
        this.area = 30;
    }
    /*
     * A constructor that overloads the previous constructor and assigns the respective variables.
     * @param name The state's name
     */
    public Cities(String name) {
        this.name = name;
    }
    /*
     * A constructor that overloads the previous two constructors and assigns the respective variables.
     * @param name The state's name
     * @param area The square footage of the city
     */
    public Cities(String name, int area) {
        this.name = name;
        this.area = area;
    }
    /*
     * Gets the name of the city
     * @return name The name of the city
     */
    public String getCity() {
        return name;
    }
}
