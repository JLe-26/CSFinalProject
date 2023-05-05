import java.util.ArrayList;

/**
 * @author Jenny Le
 * This class creates binary search trees based on values such as title, author, or category.
 * No user interaction is necessary.
 * The compareTo method compares the title, author, or category alphabetically.
 */

public class OrganizeBooks {
    private ArrayList<Book> library;
    /**
     * This is a method for the OrganizeBooks class that organizes Book objects by title alphabetically
     * @param library An arrayList of books, which is the library database
     * @return An ArrayList of Books which contains the sorted tree sortedTitle
     */
    public static ArrayList<Book> organizeTitle(ArrayList<Book> library){
        // Need to add data in order for the left and right subtrees to be created, but cannot put an array list of book objects
        LinkedBinarySearchTree<Book> sortedTitle = new LinkedBinarySearchTree<>();
        for(int i = 0; i< library.size(); i++){
            if(library.get(i).compareToTitle(library.get(i+1)) < 1 || library.get(i).compareToTitle(library.get(i+1)) == 0){
                // insert titles to the left subtree of sorted books by title
                sortedTitle.leftSubTree.insert(library.get(i)); //Inserts first book if it is alphabetically first to the left
                sortedTitle.rightSubTree.insert(library.get(i+1)); //Inserts other book to the right
            } else if(library.get(i).compareToTitle(library.get(i+1)) > 1){
                // insert titles to the right subtree of sorted books by title
                sortedTitle.leftSubTree.insert(library.get(i+1)); //Inserts second book if it is alphabetically first to the left
                sortedTitle.rightSubTree.insert(library.get(i)); // Inserts other book to the right
            }
        }
        // There is now a BST sorted by title called sortedTitle
        // Need to separate so this returns null and a separate getter will return the arraylist
        //
        return sortedTitle.inOrder();
    }

    /**
     * This is a method for the OrganizeBooks class that organizes Book objects by author alphabetically
     * @param library An arrayList of books, which is the library database
     * @return An ArrayList of Books which contains the sorted tree sortedAuthor
     */
    public static ArrayList<Book> organizeAuthor(ArrayList<Book> library){
        LinkedBinarySearchTree<Book> sortedAuthor = new LinkedBinarySearchTree<>();
        for(int i = 0; i < library.size(); i++){
            if(library.get(i).compareToAuthors(library.get(i+1)) < 1 || library.get(i).compareToAuthors(library.get(i+1)) == 0){ // If the first book is alphabetically first or equal to the second, it will go to the left
                sortedAuthor.leftSubTree.insert(library.get(i)); //Inserts first book if it is alphabetically first to the left
                sortedAuthor.rightSubTree.insert(library.get(i+1)); // Inserts other book to the right
            } else if(library.get(i).compareToAuthors(library.get(i+1)) > 1){
                sortedAuthor.leftSubTree.insert(library.get(i+1)); //Inserts second book if it is alphabetically first to the left
                sortedAuthor.rightSubTree.insert(library.get(i)); // Inserts other book to the right
            }
        }
        // There is now a BST sorted by author called sortedAuthor
        return sortedAuthor.inOrder();
    }

    /**
     * This is a method for the OrganizeBooks class that organizes Book objects by category alphabetically
     * @param library An arrayList of books, which is the library database
     * @return An ArrayList of Books which contains the sorted tree sortedCategory
     */
    public static ArrayList<Book> organizeCategories(ArrayList<Book> library){
        LinkedBinarySearchTree<Book> sortedCategories = new LinkedBinarySearchTree<>();
        for(int i = 0; i < library.size(); i++){
            if(library.get(i).compareToCategories(library.get(i+1)) < 1 || library.get(i).compareToCategories(library.get(i+1)) == 0){
                sortedCategories.leftSubTree.insert(library.get(i)); //Inserts first book if it is alphabetically first to the left
                sortedCategories.rightSubTree.insert(library.get(i+1)); // Inserts other book to the right
            } else if (library.get(i).compareToCategories(library.get(i+1)) > 1){
                sortedCategories.leftSubTree.insert(library.get(i+1)); //Inserts second book if it is alphabetically first to the left
                sortedCategories.rightSubTree.insert(library.get(i)); // Inserts other book to the right
            }
        }
        // There is now a BST sorted by category called sortedCategories
        return sortedCategories.inOrder();
    }

}
