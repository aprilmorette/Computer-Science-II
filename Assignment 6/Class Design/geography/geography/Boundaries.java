package geography;
import java.util.*;

/*
 * An interface declaring methods used in all other classes.
 * It mainly focuses on boundaries and those that neighbor each other.
 */
public interface Boundaries {
    /*
     * Sets the length of a boundry for a given area
     * @param length The length of the boundary
     */
    void setBoundaryLength(int length);
    /*     
     * Returns the length of a boundry for a given area 
     * @return The length of the boundary
     */
    int boundaryLength();
    /*
     * Sets the neighbors of a given area
     * @param neighbors The list of neighbors in respect to the area
     */
    void setNeighbors(ArrayList<String> neighbors);
    /*
     * Returns the neighbors of a given area
     * @return The list of neighbors in respect to the area
     */
    ArrayList<String> borderOf();
    /*
     * Sets the area of a given area
     * @param area The amount of area 
     */
    void setArea(int area);
    /*
     * Returns the area of a given area
     * @return area The amount of area
     */
    int area();
}
