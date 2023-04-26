public class LinkedBinarySearchTree<E> implements BinaryTree<E> {
    private E data;
    private LinkedBinarySearchTree<E> leftSubTree;
    private LinkedBinarySearchTree<E> rightSubTree;
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
    public String toStringInOrder() {
        return null;
    }

}
