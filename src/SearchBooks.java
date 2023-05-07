import java.util.ArrayList;

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
        ArrayList<Book> orgByTitle = orgByTitleTree.getRootList(); // arraylist of books with the title from the sorted title tree
        Book current = orgByTitle.get(0);
        if (orgByTitleTree.isEmpty()) {
            return null;
        }
        else if (tit.compareTo(current.getTitle()) < 0) { // if the title given is alphabetically before the root, search for titles on the left
            titleSearch(tit, library, orgByTitleTree.leftSubTree);
        }
        else if (tit.compareTo(current.getTitle()) > 0) { // if the title given is alphabetically after the root, search for titles on the right
            titleSearch(tit, library, orgByTitleTree.rightSubTree);
        }
        return orgByTitle;
    }
    /**
     * This method will first organize the books in the library database by author
     * and then search for Books with the author indicated by the string input by the user.
     * Assumes the user enters the author correctly
     * @param aut String author searched by the user, needs to be the full name of the author
     * @param library ArrayList of Books which is the library database
     * @return ArrayList of Books that contain the author searched by the user
     */
    public static ArrayList<Book> authorSearch(String aut, ArrayList<Book> library, LinkedBinarySearchTreeBook<ArrayList<Book>> orgByAuthorTree){
        ArrayList<Book> orgByAuthor = orgByAuthorTree.getRootList(); // Will contain the books that have the author searched by the user
        Book current = orgByAuthor.get(0);
        String[] arr = aut.split(" "); // Array of author full name, will use last item in array as last name
        String other = current.getAuthors()[0];
        String[] arr2 = other.split(" "); // Array of other author full name, will use last item in array as last name
        if (orgByAuthorTree.isEmpty()) {
            return null;
        }
        else if (arr.length < 2){ // when the array length of the author name is less than two, it is not a full name
            return null; // Will result in a NullPointerException when printing out a book by a certain author because orgByAuthorTree will be null
        }
        else if (arr[arr.length-1].compareTo(arr2[arr2.length-1]) < 0) { // if the last name of the first author comes first alphabetically, search the left subtree
            authorSearch(aut, library, orgByAuthorTree.leftSubTree);
        }
        else if (arr[arr.length-1].compareTo(arr2[arr2.length-1]) > 0) { // if the last name of the first author comes second alphabetically, search the right subtree
            authorSearch(aut, library, orgByAuthorTree.rightSubTree);
        } else {
            if(arr[0].compareTo(arr2[0]) < 0){ // if the last name of both authors is the same, compare by first name
                authorSearch(aut, library, orgByAuthorTree.leftSubTree);
            } else if (arr[0].compareTo(arr2[0]) > 0){
                authorSearch(aut, library, orgByAuthorTree.rightSubTree);
            }
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
        ArrayList<Book> orgByCategory = orgByCatTree.getRootList(); // Will contain the books that have the category searched by the user
        Book current = orgByCategory.get(0);
        if (orgByCatTree.isEmpty()){
            return null;
        }
        else if(cat.compareTo(current.getCategories()[0]) < 0) { // if given category is alphabetically before the root, search in the left subtree
            categorySearch(cat, library, orgByCatTree.leftSubTree);
        }
        else if(cat.compareTo(current.getCategories()[0]) > 0){ // if given category is alphabetically after the root, search in the right subtree
            categorySearch(cat, library, orgByCatTree.rightSubTree);
        }
        return orgByCategory;
    }

}
