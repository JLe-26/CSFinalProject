import java.util.ArrayList;

/**
 * @author Jenny Le
 * This program uses a binary search tree data structure
 * @param <E> This class is written with generics so it can be implemented with various data types
 */

public class LinkedBinarySearchTree<E extends Comparable<E>> implements BinaryTree<E> {
    private final E data;
    protected LinkedBinarySearchTree<E> leftSubTree;
    protected LinkedBinarySearchTree<E> rightSubTree;
    private int count;

    public LinkedBinarySearchTree() {
        this.data = null;
        leftSubTree = null;
        rightSubTree = null;
    }

    public LinkedBinarySearchTree(E data){
        this.data = data;
        leftSubTree = new LinkedBinarySearchTree<>();
        rightSubTree = new LinkedBinarySearchTree<>();
        count++;
    }
    @Override
    public void insert(E e) {
        if (e.compareTo(data) < 0) {
            leftSubTree.insert(e);
        } else if (e.compareTo(data) > 0) {
            rightSubTree.insert(e);
        } else {
            e = data;
        }
    }

    @Override
    public boolean remove(E e) {

        return false;
    }

    @Override
    public E getRootElement() {
        return data;
    }

    @Override
    public int size() {
        if(this.isEmpty()){
            return 0;
        } else {
            return 1 + leftSubTree.size() + rightSubTree.size();
        }
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public boolean contains(E e) {
        if(this.isEmpty()){
            return false;
        } else {
            return data.equals(e) || leftSubTree.contains(e) || rightSubTree.contains(e);
        }
    }

    @Override
    public ArrayList<Book> inOrder() {
        ArrayList<Book> booksInOrder = new ArrayList<>();
        if(this.isEmpty() != true){
            if(leftSubTree.isEmpty() != true){
                leftSubTree.inOrder();
                booksInOrder.add((Book) leftSubTree.data);
            } else {
                booksInOrder.add((Book) data);
                if (rightSubTree.isEmpty() != true) {
                    rightSubTree.inOrder();
                    booksInOrder.add((Book) rightSubTree.data);
                }
            }
        } else {
            System.out.println("This tree is empty!");
        }
        return booksInOrder;
    }
}
