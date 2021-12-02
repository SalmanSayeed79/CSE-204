package Assignment1.Array_Based_Implementation;
/** Array-based list implementation */
public class ArrayBased<E> implements ArrayInterface<E> {
    private static final int defaultSize = 10; // Default size
    private int maxSize; // Maximum size of list
    private int listSize; // Current # of list items
    private int curr; // Position of current element
    private E[] listArray; // Array holding list elements


    public ArrayBased() { 
        this(defaultSize); 
    }
    public ArrayBased(int size) {
        maxSize = size;
        listSize = curr = 0;
        listArray = (E[])new Object[size];
    }
    public void clear(){ 
        listSize = curr = 0; 
    }
    // Simply reinitialize values
    /** Insert "it" at current position */
    public void insert(E it) {
        assert listSize < maxSize : "List capacity exceeded";
        if(listSize>=maxSize) doubleSize();
        for (int i=listSize; i>curr; i--) // Shift elements up
        listArray[i] = listArray[i-1]; // to make room
        listArray[curr] = it;
        listSize++; // Increment list size
    }
    /** Append "it" to list */
    public void append(E it) {
        assert listSize < maxSize : "List capacity exceeded";
        if(listSize>=maxSize) doubleSize();
        listArray[listSize++] = it;
    }
    /** Remove and return the current element */
    public E remove() {
        if ((curr<0) || (curr>=listSize)) // No current element
        return null;
        E it = listArray[curr]; // Copy the element
        for(int i=curr; i<listSize-1; i++) // Shift them down
        listArray[i] = listArray[i+1];
        listSize--; // Decrement size
        return it;
    }
    public void moveToStart() {
        curr = 0; 
    } 
    public void moveToEnd() { 
        curr = listSize-1; 
    } 
    public void prev() { 
        if (curr != 0) curr--; 
    }
    public void next() { 
        if (curr < listSize) curr++; 
    }
    public int length() { 
        return listSize; 
    }
    /** @return Current position */
    public int currPos() { 
        return curr; 
    }
    /** Set current list position to "pos" */
    public void moveToPos(int pos) {
        assert (pos>=0) && (pos<=listSize) : "Pos out of range";
        curr = pos;
    }
    /** @return Current element */
    public E getValue() {
        assert (curr>=0) && (curr<listSize) :
        "No current element";
        return listArray[curr];
    }

    public int Search(E item){
        for(int i=0;i<listSize;i++){
            if(listArray[i]==item) return i;
        }
        return -1;
    }
    public String toString(){
        System.out.print("< ");
        for(int i=0;i<listSize;i++){
            if(curr==i) System.out.print(" | ");
            System.out.print(listArray[i]+" ");
        }
        System.out.print(">");
        return "";
    }
    public void doubleSize(){
        maxSize*=2;
        E[] newListArray=(E[])new Object[maxSize];
        for(int i=0;i<listSize;i++){
            newListArray[i]=listArray[i];
        }
        listArray=newListArray;
    }

    
}
