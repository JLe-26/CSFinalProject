import java.util.ArrayList;

public interface BinaryTree<E extends Comparable<E>> {
    void insert(E e);
    boolean remove(E e);
    E getRootElement();
    int size();
    boolean isEmpty();
    boolean contains(E e);

    ArrayList<Book> inOrder();

}
