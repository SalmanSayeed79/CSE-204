package Assignment4;

public class BinaryNode<E> {
    private E data;
    private BinaryNode<E> leftChild;
    private BinaryNode<E> rightChild;
    private boolean leftChildExists;
    private boolean rightChildExists;

    public BinaryNode(E data){
        this.data=data;
        this.leftChildExists=false;
        this.rightChildExists=false;
    }
    public BinaryNode(E data, BinaryNode<E> left, BinaryNode<E> right){
        this.data=data;
        this.leftChildExists=true;
        this.rightChildExists=true;
        this.leftChild=left;
        this.rightChild=right;
    }
    public void setLeftChild(BinaryNode<E> node){
        this.leftChildExists=true;
        this.leftChild=node;
    }
    public void setRightChild(BinaryNode<E> node){
        this.rightChildExists=true;
        this.rightChild=node;
    }
    public void removeLeftChild(){
        this.leftChildExists=false;
    }
    public void removeRightChild(){
        this.rightChildExists=false;
    }
}
