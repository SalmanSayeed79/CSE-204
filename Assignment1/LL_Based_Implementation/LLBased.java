package Assignment1.LL_Based_Implementation;

import java.util.Scanner;

import Assignment1.LL_Based_Implementation.LL_Interface;

class LLBased<E> implements LL_Interface<E>{
    private LList<E> head;
    private LList<E> tail;
    private LList<E> curr;
    private int listSize;

    public LLBased(int listSize) {
        this();
    }

    public LLBased() {
        listSize = 0;
        curr = head = tail = new LList<E>(null);
    }

    public LLBased(E[] listArray){
        this();
        for(E item : listArray){
            this.append(item);
        }
    }
    @Override
    public void clear() {
        listSize = 0;
        curr = head = tail = new LList<E>(null);
    }

    @Override
    public void insert(E item) {
        curr.setNext(new LList<E>(item, curr.getNext()));
        if(tail == curr) tail = curr.getNext();
        listSize++;
    }

    @Override
    public void append(E item) {
        tail.setNext(new LList<E>(item, null));
        tail = tail.getNext();
        listSize++;
    }

    @Override
    public E remove() {
        if(curr.getNext() == null) return null;
        E removedItem = curr.getNext().getItem();
        if(tail == curr.getNext()) tail = curr;
        curr.setNext(curr.getNext().getNext());
        listSize--;
        return removedItem;
    }

    @Override
    public void moveToStart() {
        curr = head;
    }

    @Override
    public void moveToEnd() {
        curr = tail;
    }

    @Override
    public void prev() {
        if(curr == head) return;
        LList<E> temp = head;
        while(temp.getNext() != curr){
            temp = temp.getNext();
        }
        curr = temp;
    }

    @Override
    public void next() {
        if(curr == tail) return;
        curr = curr.getNext();
    }

    @Override
    public int length() {
        return listSize;
    }

    @Override
    public int currPos() {
        int pos;
        LList<E> temp = head;
        for(pos = 0; temp != curr; pos++){
            temp = temp.getNext();
        }
        return pos;
    }

    @Override
    public void moveToPos(int pos) {
        if(pos < 0 || pos > listSize) return;
        LList<E> temp = head;
        for(int i = 0; i < pos; i++){
            temp = temp.getNext();
        }
        curr = temp;
        //System.out.println(curr.getNext().getItem());
    }

    @Override
    public E getValue() {
        if(curr.getNext() == null) return null;
        return curr.getNext().getItem();
    }

    @Override
    public int Search(E item) {
        LList<E> temp = head;
        for(int i = 0; i < listSize; i++){
            if(temp.getNext().getItem() == item) return i;
            temp = temp.getNext();
        }
        return -1;
    }
    @Override
    public String toString() {
        String value = "< ";
        for(LList<E> temp = head; temp != tail; temp = temp.getNext()){
            if(curr == temp) value += "| ";
            value = value + temp.getNext().getItem() + " ";
        }
        if(curr == tail) value += "| ";
        value+=">";
        return value;
    }

}

