import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Jenny Le
 * This class makes use of the OrganizeBooks class to search for books that are sorted alphabetically
 * by title, author, or category
 * It also includes a method where the user can search for a book based on a keyword/tag
 */
public class SearchBooks {
    private ArrayList<Book> library;
    /**
     * This method will first organize the books in the library database by title
     * and then search for Books with the title indicated by the string input by the user.
     * Assumes the user enters the title correctly
     * @param tit String title searched by the user
     * @param library ArrayList of Books which is the library database
     * @return ArrayList of Books that contain the title searched by the user
     */
    public static ArrayList<Book> titleSearch(String tit, ArrayList<Book> library, LinkedBinarySearchTreeBook<ArrayList<Book>> orgByTitleTree)  {
        ArrayList<Book> orgByTitle = orgByTitleTree.getRootList();
        Book current = orgByTitle.get(0);
        if (orgByTitleTree.isEmpty()) {
            return null;
        }
        else if (tit.compareTo(current.getTitle()) < 0) {
            titleSearch(tit, library, orgByTitleTree.leftSubTree);
        }
        else if (tit.compareTo(current.getTitle()) > 0) {
            titleSearch(tit, library, orgByTitleTree.rightSubTree);
        }
        return orgByTitle;
    }
    /**
     * This method will first organize the books in the library database by author
     * and then search for Books with the author indicated by the string input by the user.
     * Assumes the user enters the author correctly
     * @param aut String author searched by the user
     * @param library ArrayList of Books which is the library database
     * @return ArrayList of Books that contain the author searched by the user
     */
    public static ArrayList<Book> authorSearch(String aut, ArrayList<Book> library, LinkedBinarySearchTreeBook<ArrayList<Book>> orgByAuthorTree){
        ArrayList<Book> orgByAuthor = orgByAuthorTree.getRootList(); // Will contain the books that have the author searched by the user
        Book current = orgByAuthor.get(0);
        if (orgByAuthorTree.isEmpty()) {
            return null;
        }
        else if (aut.compareTo(Arrays.toString(current.getAuthors())) < 0) {
            authorSearch(aut, library, orgByAuthorTree.leftSubTree);
        }
        else if (aut.compareTo(Arrays.toString(current.getAuthors())) > 0) {
            authorSearch(aut, library, orgByAuthorTree.rightSubTree);
        }
        return orgByAuthor;
    }
    /**
     * This method will first organize the books in the library database by category
     * and then search for Books with the category indicated by the string input by the user.
     * Assumes the user enters the category correctly
     * @param cat String category searched by the user
     * @param library ArrayList of Books which is the library database
     * @return ArrayList of Books that contain the category searched by the user
     */
    public static ArrayList<Book> categorySearch(String cat, ArrayList<Book> library, LinkedBinarySearchTreeBook<ArrayList<Book>> orgByCatTree){
        ArrayList<Book> orgByCategory = orgByCatTree.getRootList();
        Book current = orgByCategory.get(0);// Will contain the books that have the category searched by the user
        if (orgByCatTree.isEmpty()){
            return null;
        }
        else if(cat.compareTo(Arrays.toString(current.getCategories())) < 0) {
            categorySearch(cat, library, orgByCatTree.leftSubTree);
        }
        else if(cat.compareTo(Arrays.toString(current.getCategories())) > 0){
            categorySearch(cat, library, orgByCatTree.rightSubTree);
        }
        return orgByCategory;
    }
    /**
     * This method will first organize the books in the library database by tag
     * and then search for Books with the tag indicated by the string input by the user.
     * Will return null if the tag is entered incorrectly
     * @param tag String tag searched by the user
     * @param library ArrayList of Books which is the library database
     * @return ArrayList of Books that contain the tag searched by the user
     */
    public static ArrayList<Book> tagSearch(String tag, ArrayList<Book> library){
        // will be used in organizeBooks method for keyword (tag)
        ArrayList<Book> orgByTag = new ArrayList<>(); // Will contain the books that have the tag searched by the user
        // Look at library database
        // For each book object, if the tag is contained in the desc, add it to the arraylist
        return orgByTag;
    }
}
