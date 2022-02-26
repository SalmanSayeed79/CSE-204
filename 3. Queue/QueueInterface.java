package Assignment3;

public interface QueueInterface<E> {
    public void enqueue(E it);
    public E dequeue();
    public E frontValue();
    public int length();
    public E rearValue();
}
