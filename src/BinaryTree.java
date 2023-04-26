public interface BinaryTree<E> {
    void insert(E e);
    boolean remove(E e);
    E getRootElement();
    int size();
    boolean isEmpty();
    boolean contains(E e);

    String toStringInOrder();

}
