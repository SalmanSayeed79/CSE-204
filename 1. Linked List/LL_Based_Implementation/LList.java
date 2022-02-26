package Assignment1.LL_Based_Implementation;

public class LList<E> {
    private E item;
    private LList<E> next;

    LList(E item, LList<E> next){
        this.item = item;
        this.next = next;
    }

    LList(LList<E> next){
        this.next = next;
    }

    public void setNext(LList<E> next) {
        this.next = next;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public E getItem() {
        return item;
    }

    public LList<E> getNext() {
        return next;
    }
}
