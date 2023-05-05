import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @ author Jenny Le
 * This class creates a heap based on the ratings of each Book in the library database.
 * Will make use of the organizeCategory method of the OrganizeBooks class to allow the user
 * to look at the most popular books within a certain category
 */
public class PopularBooks extends ArrayHeap {
    // Will make use of a max-heap to rank the books by popularity (will use the ratings from the csv file)
    // Should do most popular by genre (makes a new heap for fiction, mystery, nonfiction, etc)
    private ArrayList<Book> library;

    /**
     * This is a constructor method for the popularity heap
     * @param library An ArrayList of Books, which is the library database
     */
    public PopularBooks(ArrayList<Book> library){
        super(); // Creates a heap
        this.library = library;
    }

    /**
     * Gets the ratings from the csv file?, then returns an arrayList of Books sorted by rating
     * @param library
     * @return
     */
    public ArrayList<String> getRatings(ArrayList<Book> library){
        // will go through the library and get the rating of each Book object (need all other info like title too)
        // need to create a max-heap of books by rating (create a different method for each thing like title)
        // return arraylist of these sorted books
        ArrayList<String> ratings = new ArrayList<>();
        return ratings;
    }




}


