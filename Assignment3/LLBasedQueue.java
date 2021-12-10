package Assignment3;

/** Linked queue implementation */
class LLBasedQueue<E> implements QueueInterface<E> {
    private LList<E> front; // Pointer to front queue node
    private LList<E> rear; // Pointer to rear queuenode
    private int size; // Number of elements in queue
    /** Constructors */
    public LLBasedQueue() { 
        init(); 
    }
    public LLBasedQueue(int size) { 
        init();
    } // Ignore size
    /** Initialize queue */
    private void init() {
        front = rear = new LList<E>(null);
        size = 0;
    }
    /** Reinitialize queue */
    public void clear() { 
        init(); 
    }
    /** Put element on rear */
    public void enqueue(E it) {
        rear.setNext(new LList<E>(it, null));
        rear = rear.next();
        size++;
    }
    /** Remove and return element from front */
    public E dequeue() {
        assert size != 0 : "Queue is empty";
        E it = front.next().element(); // Store dequeued value
        front.setNext(front.next().next()); // Advance front
        if (front.next() == null) rear = front; // Last Object
        size--;
        return it; // Return Object
    }
    /** @return Front element */
    public E frontValue() {
        assert size != 0 : "Queue is empty";
        return front.next().element();
    }
    /** @return Queue size */
    public int length() { 
        return size; 
    }
    public E rearValue(){
        return rear.element();
    }
}