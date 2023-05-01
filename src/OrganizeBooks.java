import java.util.ArrayList;
import java.util.Arrays;

public class OrganizeBooks {

    public static ArrayList<String> organizeTitle(ArrayList<Book> library){
        // Returns an ArrayList of Strings of books sorted by title (using in order)
        // Other methods will organize based on author, genre, or keyword (tag)
        ArrayList<String> organizedByTitle = new ArrayList<>();
        LinkedBinarySearchTree<Book> sortedTitle = new LinkedBinarySearchTree<>();
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
        sortedTitle.treeToList(sortedTitle);
        // tree is now sorted by title, need to insert the elements of the tree into an arraylist organizedByTitle
        return organizedByTitle;
    }

    public static ArrayList<Book> organizeAuthor(ArrayList<Book> library){
        ArrayList<Book> organizedByAuthor = new ArrayList<>();
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
        sortedAuthor.treeToList(sortedAuthor);
        // tree is now sorted by title, need to insert the elements of the tree into an arraylist organizedByAuthor
        return organizedByAuthor;
    }

}
