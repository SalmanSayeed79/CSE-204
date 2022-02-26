/** Array-based stack implementation */
package Assignment2;
import java.security.DigestException;

import Assignment2.StackInterface;

class ArrayBasedStack<E> implements StackInterface<E> {
    private static final int defaultSize = 10;
    private int maxSize; // Maximum size of stack
    private int top; // Index for top Object
    private E [] listArray; // Array holding stack
    private int direction=1; // 1 means the stack grows upward. -1 means it grows downwards
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
        if(direction==-1){
            reversePush(it);
            return;
        }
        if(top>=maxSize) doubleSize();
        listArray[top++] = it;
        
        
    }
    /** Remove and top element */
    public E pop() {
        assert top != 0 : "Stack is empty";
        if(direction==-1){
            reversePop();
            return null;
        }
        return listArray[--top];
    }
    /** @return Top element */
    public E topValue() {
        assert top != 0 : "Stack is empty";
        if(top==0) {
            return null;
        }
        return listArray[top-1];
    }
    /** @return Stack size */
    public int length() { 
        return top; 
    }
    public void setDirection(int value){
        if(top!=0) {
            System.out.println("Stack not empty");
            return;
        }
        
        direction=value;
        if(value==-1) top=maxSize;
        else top=0;
        
    }
    public void doubleSize(){
        maxSize*=2;
        E[] newListArray=(E[])new Object[maxSize];
        for(int i=0;i<top;i++){
            newListArray[i]=listArray[i];
        }
        listArray=newListArray;
    }
    public String toString(){
        System.out.print("< ");
        for(int i=0;i<top;i++){
            System.out.print(listArray[i]+" ");
        }
        System.out.print(">");
        return "";
    }

    public void reversePush(E value){
        if(top<0){
            System.out.println("LimitExceeded");
        }
        else{
            listArray[--top]=value;
        }
    }
    public E reversePop(){
        if(top<0){
            System.out.println("LimitExceeded");
            return null;
        }
        return listArray[top--];
    }
}