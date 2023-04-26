import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }

    public static ArrayList<Book> organizeTitle(ArrayList<Book> library){
        // Returns an ArrayList of Book objects sorted by title (using in order)
        // Other methods will organize based on author, genre, or keyword (tag)
        ArrayList<Book> organizedByTitle = new ArrayList<>();
        LinkedBinarySearchTree<Book> sortedTitle = new LinkedBinarySearchTree<>(ArrayList<Book> library);
        // will need to make a linked list of books ?
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
        return organizedByTitle;
    }

    public static ArrayList<Book> bookSearch(ArrayList<Book> books){
        // will be used in organizeBooks method for keyword (tag)
        ArrayList<Book> organizedByTag = new ArrayList<>();
        return organizedByTag;
    }

}