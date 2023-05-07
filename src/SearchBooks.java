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
    /**
     * This method will first check if the string input by the user is in the list of common words
     * and then look at each book in the orgByTitleTree to see if the tag can be found in the description
     * Will return null if the tag is entered incorrectly
     * THIS METHOD IS CURRENTLY NOT BEING USED
     * @param tag String tag searched by the user
     * @param words ArrayList of Strings which is the list of all common words
     * @param orgByTitleTree a tree of books sorted by title (arbitrary, could search by tag in any sorted tree)
     * @return ArrayList of Books that contain the tag searched by the user
     */
    public static ArrayList<Book> tagSearch(String tag, ArrayList<String> words, LinkedBinarySearchTreeBook<ArrayList<Book>> orgByTitleTree){
        ArrayList<Book> orgByTitle = orgByTitleTree.getRootList(); // arraylist of books from the sorted title tree
        Book current = orgByTitle.get(0); // the first book from the arraylist
        String desc = current.getDescription(); // get the description of the book
        String[] arr3 = desc.split(" "); // parse the description into a string array
        ArrayList<Book> orgByTag = new ArrayList<>(); // Will contain the books that have the tag searched by the user
        for(String word: words){ // for every word in the arraylist of common words
            if(tag.compareTo(word) != 0){ // if the tag given is not in the array of common words, return null
                return null;
            } else { // the tag given is in the array of common words, proceed
                // Look at sorted title tree, get desc of each book in the tree
                if(orgByTitleTree.isEmpty()){
                    return null;
                } else { // Go to every book in the subtree recursively
                    for(String blah: arr3){ // for every string in the array of desc strings
                        if(tag.compareTo(blah) < 0){// if the given tag is in the desc
                            tagSearch(tag, words, orgByTitleTree.leftSubTree); // goes into the left subtree to search for the tag

                        } else if(tag.compareTo(blah) > 0){
                            tagSearch(tag, words, orgByTitleTree.rightSubTree); // goes into the right subtree to search for the tag
                        } else {
                            orgByTag.add(current); // add the book to the arraylist of books with the tag searched by the user
                        }
                    }
                }

            }
        }
        return orgByTag;
    }
}
