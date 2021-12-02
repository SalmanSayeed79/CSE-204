/** Array-based stack implementation */
package Assignment2;
import Assignment2.StackInterface;

class ArrayBasedStack<E> implements StackInterface<E> {
    private static final int defaultSize = 10;
    private int maxSize; // Maximum size of stack
    private int top; // Index for top Object
    private E [] listArray; // Array holding stack
    /** Constructors */
    ArrayBasedStack() { 
        this(defaultSize); 
    }
    @SuppressWarnings("unchecked") // Generic array allocation
    ArrayBasedStack(int size) {
        maxSize = size;
        top = 0;
        listArray = (E[])new Object[size]; // Create listArray
    }
    /** Reinitialize stack */
    public void clear() { 
        top = 0; 
    }
    /** Push "it" onto stack */
    public void push(E it) {
        assert top != maxSize : "Stack is full";
        listArray[top++] = it;
    }
    /** Remove and top element */
    public E pop() {
        assert top != 0 : "Stack is empty";
        return listArray[--top];
    }
    /** @return Top element */
    public E topValue() {
        assert top != 0 : "Stack is empty";
        return listArray[top-1];
    }
    /** @return Stack size */
    public int length() { 
        return top; 
    }
}