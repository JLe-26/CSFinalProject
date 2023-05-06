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

    public void insertTitle(Book book) {
        if (book.compareToTitle(data.get(0)) < 0) {
            leftSubTree.insertTitle(book);
        } else if (book.compareTo(data.get(0)) > 0) {
            rightSubTree.insertTitle(book);
        } else {
            data.add(book);
        }
    }

    public void insertAuthor(Book book) {
        if(data == null){
            data.add(book);
        } else if (book.compareToAuthors(data.get(0)) < 0) {
            leftSubTree.insertAuthor(book);
        } else if (book.compareToAuthors(data.get(0)) > 0) {
            rightSubTree.insertAuthor(book);
        }
    }

    public void insertCategory(Book book) {
        if (book.compareToCategories(data.get(0)) < 0) {
            leftSubTree.insertCategory(book);
        } else if (book.compareToCategories(data.get(0)) > 0) {
            rightSubTree.insertCategory(book);
        } else {
            data.add(book);
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
