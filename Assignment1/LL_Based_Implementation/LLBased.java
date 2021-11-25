package Assignment1.LL_Based_Implementation;

import java.util.Scanner;

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

    public static void main(String []args){
        Scanner consoleInput=new Scanner(System.in);
    
        int initialSize=consoleInput.nextInt();
        int valueCount=consoleInput.nextInt();

        LLBased<Integer> arrayList=new LLBased<Integer>(initialSize);
        for(int i=0;i<initialSize;i++){
            arrayList.append(consoleInput.nextInt());
        }
        while(true){
            int option=consoleInput.nextInt();
            int param=consoleInput.nextInt();

            switch(option){
                // case 0:{
                //     System.out.println("Ending the program....Thank you!");
                //     consoleInput.close();
                //     break;
                // }
                case 1:{ 
                    arrayList.clear();
                    System.out.println(arrayList);
                    System.out.println("-1");
                    break;
                }
                case 2:{ 
                    //int param=consoleInput.nextInt();
                    arrayList.insert(param); 
                    System.out.println(arrayList);
                    System.out.println("-1");
                 break;
                }
                case 3:{ 
                    //int param=consoleInput.nextInt();
                    arrayList.append(param);
                    System.out.println(arrayList);
                    System.out.println("-1");
                    break;
                }
                case 4:{ 
                    //int param=consoleInput.nextInt();
                    int removed=arrayList.remove();
                    System.out.println(arrayList);
                    System.out.println(removed);
                    break;
                }
                case 5:{
                    arrayList.moveToStart();
                    System.out.println(arrayList);
                    System.out.println("-1");
                    break;
                }
                case 6:{
                    arrayList.moveToEnd();
                    System.out.println(arrayList);
                    System.out.println("-1");
                    break;
                }
                case 7:{
                    arrayList.prev();
                    System.out.println(arrayList);
                    System.out.println("-1");
                    break;
                }
                case 8:{
                    arrayList.next();
                    System.out.println(arrayList);
                    System.out.println("-1");
                    break;
                }
                case 9:{
                    System.out.println(arrayList);
                    System.out.println(arrayList.length());
                    break;
                }
                case 10:{
                    int curPos=arrayList.currPos();
                    System.out.println(curPos);
                    break;
                }
                case 11:{
                    //int param=consoleInput.nextInt();
                    arrayList.moveToPos(param);
                    System.out.println(arrayList);
                    System.out.println("-1");
                    break;
                }
                case 12:{
                    int value=arrayList.getValue();
                    System.out.println(arrayList);
                    System.out.println(value);
                    break;
                }
                case 13:{
                    int pos=arrayList.Search(param);
                    System.out.println(arrayList);
                    System.out.println(pos);
                    break;
                }
                case 14:
                    System.out.println(arrayList);
            }
        }
    }
}

