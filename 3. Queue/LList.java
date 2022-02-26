package Assignment3;
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

    public LList<E> next() {
        return next;
    }
    public E element(){
        return item;
    }
   
}
