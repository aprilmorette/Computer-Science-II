package geography;
import java.util.*;

/*
 * The parent class in charge of creating countries and accessing their respective variables.
 */

public class Countries implements Boundaries {
    
    private String name;
    private int states;
    private int area;
    private ArrayList<String> neighbors;
    private int boundaryLength;

    /* 
     * A constructor for creating a country. The default name is United States and the amount of states is 50.
     */
    public Countries() {
        name = "United States";
        states = 50;
    }
    /*
     * A constructor that overloads the previous constructor and assigns the respective variables.
     * @param name The country's name
     * @param states The number of states within the country
     */
    public Countries(String name, int states) {
        this.name = name;
        this.states = states;
    }
    // Setters and getters for certain variables
    /*
     * @return name The name of the country
     */
    public String getCountry() {
        return name;
    }
    /*
     * @return states The number of states within the country
     */
    public int getStates() {
        return states;
    }
    /*
     * boundaryLength The length of the boundary surrounding the country
     */
    public void setBoundaryLength(int boundaryLength) {
        this.boundaryLength = boundaryLength;
    }
    public int boundaryLength() {
        return boundaryLength;
    }
    /*
     * neighbors The areas neighboring the country
     */
    public void setNeighbors(ArrayList<String> neighbors) {
        this.neighbors = neighbors;
    }
    public ArrayList<String> borderOf() {
        return neighbors;
    }
    /*
     * area The area of the country
     */
    public void setArea(int area) {
        this.area = area;
    }
    public int area() {
        return area;
    }
}