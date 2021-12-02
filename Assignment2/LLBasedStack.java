/** Linked stack implementation */
package Assignment2;
import Assignment2.StackInterface;
class LLBasedStack<E> implements StackInterface<E> {
    private LList<E> top; // Pointer to first element
    private int size; // Number of elements
    /** Constructors */
    public LLBasedStack() { top = null; size = 0; }
    public LLBasedStack(int size) { top = null; size = 0; }
    /** Reinitialize stack */
    public void clear() { top = null; size = 0; }
    /** Put "it" on stack */
    public void push(E it) {
    top = new LList<E>(it, top);
    size++;
    }
    /** Remove "it" from stack */
    public E pop() {
    assert top != null : "Stack is empty";
    E it = top.element();
    top = top.next();
    size--;
    return it;
    }
    /** @return Top value */
    public E topValue() {
    assert top != null : "Stack is empty";
    return top.element();
    }
/** @return Stack length */
public int length() { return size; }
}