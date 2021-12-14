package Assignment4;

public class BinaryNode<E> {
    private E data;
    private BinaryNode<E> leftChild;
    private BinaryNode<E> rightChild;
    private boolean leftChildExists;
    private boolean rightChildExists;

    public BinaryNode(E data){
        this.data=data;
        leftChildExists=false;
        rightChildExists=false;
    }
    public void setLeftChild(BinaryNode<E> node){
        leftChildExists=true;
        leftChild=node;
    }
    public void setRightChild(BinaryNode<E> node){
        rightChildExists=true;
        this.rightChild=node;
    }
    public void removeLeftChild(){
        leftChildExists=false;
    }
    public void removeRightChild(){
        rightChildExists=false;
    }
}
