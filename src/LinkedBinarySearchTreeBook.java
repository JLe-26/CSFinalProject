import java.util.ArrayList;

/**
 * @author Jenny Le
 * This program uses a binary search tree data structure
 * @param <E> This class is written with generics, so it can be implemented with various data types
 */

public class LinkedBinarySearchTreeBook<E>{
    private ArrayList<Book> data;
    protected LinkedBinarySearchTreeBook<E> leftSubTree;
    protected LinkedBinarySearchTreeBook<E> rightSubTree;
    private int count;

    public LinkedBinarySearchTreeBook() {
        this.data = null;
        leftSubTree = null;
        rightSubTree = null;
    }

    public LinkedBinarySearchTreeBook(Book data){
        this.data = new ArrayList<>();
        this.data.add(data);
        leftSubTree = new LinkedBinarySearchTreeBook<>();
        rightSubTree = new LinkedBinarySearchTreeBook<>();
        count++;
    }

    /**
     * This method inserts a Book object into a LinkedBinarySearchTreeBook
     * @param book
     */
    public void insertTitle(Book book) {
        if(data == null){ // ensures that the tree is never empty
            this.data = new ArrayList<>();
            this.data.add(book);
            leftSubTree = new LinkedBinarySearchTreeBook<>();
            rightSubTree = new LinkedBinarySearchTreeBook<>();
        } else if (book.compareToTitle(data.get(0)) < 0) { // if the book comes first alphabetically, it goes to the left subtree
            leftSubTree.insertTitle(book);
        } else if (book.compareToTitle(data.get(0)) > 0) { // if the book comes second alphabetically, it goes to the right subtree
            rightSubTree.insertTitle(book);
        }
    }

    public void insertAuthor(Book book) {
        if(data == null){ // ensures that the tree is never empty
            this.data = new ArrayList<>();
            this.data.add(book);
            leftSubTree = new LinkedBinarySearchTreeBook<>();
            rightSubTree = new LinkedBinarySearchTreeBook<>();
        } else if (book.compareToAuthors(data.get(0)) < 0) { // if the book comes first alphabetically, it goes to the left subtree
            leftSubTree.insertAuthor(book);
        } else if (book.compareToAuthors(data.get(0)) > 0) { // if the book comes second alphabetically, it goes to the right subtree
            rightSubTree.insertAuthor(book);
        } else {
            data.add(book); // if there is another book with the same author, it is added to the arraylist
        }
    }

    public void insertCategory(Book book) {
        if(data == null){ // ensures that the tree is never empty
            this.data = new ArrayList<>();
            this.data.add(book);
            leftSubTree = new LinkedBinarySearchTreeBook<>();
            rightSubTree = new LinkedBinarySearchTreeBook<>();
        } else if (book.compareToCategories(data.get(0)) < 0) { // if the book comes first alphabetically, it goes to the left subtree
            leftSubTree.insertCategory(book);
        } else if (book.compareToCategories(data.get(0)) > 0) { // if the book comes second alphabetically, it goes to the right subtree
            rightSubTree.insertCategory(book);
        } else {
            data.add(book); // if there is another book with the same category, it is added to the arraylist
        }
    }


    public boolean remove(E e) {

        return false;
    }

    public ArrayList<Book> getRootList() {
        return data;
    }


    public int size() {
        if(this.isEmpty()){
            return 0;
        } else {
            return 1 + leftSubTree.size() + rightSubTree.size();
        }
    }


    public boolean isEmpty() {
        return count==0;
    }


    public boolean contains(E e) {
        if(this.isEmpty()){
            return false;
        } else {
            return data.equals(e) || leftSubTree.contains(e) || rightSubTree.contains(e);
        }
    }


    public ArrayList<Book> inOrder() {
        ArrayList<Book> booksInOrder = new ArrayList<>();
        if(this.isEmpty()){
            return null;
        } else {
            for(int i = 0; i < data.size(); i++){
                booksInOrder.add(data.get(i));
            }
            leftSubTree.inOrder();
            rightSubTree.inOrder();
        }
        return booksInOrder;
    }
}
