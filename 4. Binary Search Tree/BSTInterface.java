package Assignment4;

public interface BSTInterface<E> {
    public void Insert(E value);
    public E Delete(E value);
    public boolean Find(E value);
    public void Traversal(String type);
    public void printBST();
}
