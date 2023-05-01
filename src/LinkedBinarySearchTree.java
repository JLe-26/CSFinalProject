import java.util.ArrayList;
import java.util.Arrays;

public class LinkedBinarySearchTree<E> implements BinaryTree<E> {
    private E data;
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
    public String toStringInOrder(LinkedBinarySearchTree<E> tree) {
        // WILL REVISE TO AN IN ORDER METHOD THAT RETURNS AN ARRAYLIST OF BOOKS OBJECTS, NOT A STRING
        String inOrderTree;
        StringBuilder sb = new StringBuilder();
        if (tree.getRootElement() == null){
            return "Tree is empty!";
        } else {
            toStringInOrder(leftSubTree);
            sb.append(leftSubTree.data);
            toStringInOrder(rightSubTree);
            sb.append(rightSubTree.data);
        }
        return sb.toString();

    }

    public ArrayList<String> treeToList(LinkedBinarySearchTree<Book> tree){
        // Will convert a sorted binary tree into an array list that can be returned in any of the other sort methods
        // returns an array list of book objects, not null
        String str = tree.toStringInOrder(tree);
        String[] strSplit = str.split("");
        ArrayList<String> strList = new ArrayList<String>();
        Arrays.asList(strSplit);
        return strList;
    }

}
