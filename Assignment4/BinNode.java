package Assignement4;

public interface BinNode<E> {
  /** Get and set the element value */
  public E element();
  public void setElement(E v);
  /** @return The left child */
  public BinNode<E> left();
  /** @return The right child */
  public BinNode<E> right();
  /** @return True if a leaf node, false otherwise */
  public boolean isLeaf();
}