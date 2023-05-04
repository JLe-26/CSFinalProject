import java.util.ArrayList;

public class OrganizeBooks {
// Methods that organize books alphabetically based on title, author, genre, or keyword
    public static ArrayList<Book> organizeTitle(ArrayList<Book> library){
        // Returns an ArrayList of Strings of books sorted by title (using in order)
        // Other methods will organize based on author, genre, or keyword (tag)
        LinkedBinarySearchTree<Book> sortedTitle = new LinkedBinarySearchTree<>();
        // Need to add data in order for the left and right subtrees to be created, but cannot put an array list of book objects
        for(int i = 0; i< library.size(); i++){
            if(library.get(i).compareToTitle(library.get(i+1)) < 1){
                // insert titles to the left subtree of sorted books by title
                sortedTitle.leftSubTree.insert(library.get(i));
                sortedTitle.rightSubTree.insert(library.get(i+1));
            } else if(library.get(i).compareToTitle(library.get(i+1)) > 1){
                // insert titles to the right subtree of sorted books by title
                sortedTitle.leftSubTree.insert(library.get(i+1));
                sortedTitle.rightSubTree.insert(library.get(i));
            }
        }
        return sortedTitle.inOrder();
    }

    public static ArrayList<Book> organizeAuthor(ArrayList<Book> library){
        LinkedBinarySearchTree<Book> sortedAuthor = new LinkedBinarySearchTree<>();
        for(int i = 0; i < library.size(); i++){
            if(library.get(i).compareToAuthors(library.get(i+1)) < 1){
                sortedAuthor.leftSubTree.insert(library.get(i));
                sortedAuthor.rightSubTree.insert(library.get(i+1));
            } else if(library.get(i).compareToAuthors(library.get(i+1)) > 1){
                sortedAuthor.leftSubTree.insert(library.get(i+1));
                sortedAuthor.rightSubTree.insert(library.get(i));
            }
        }
        return sortedAuthor.inOrder();
    }

    public static ArrayList<Book> organizeCategories(ArrayList<Book> library){
        LinkedBinarySearchTree<Book> sortedCategories = new LinkedBinarySearchTree<>();
        // need a compareTo method for categories
        return sortedCategories.inOrder();
    }

}
