package Assignment4;

public class Node <E>{
    private E value;
    private Node left;
    private Node right;

    public Node()
    {
        left=right=null;
    }
    public Node(E val)
    {
        this.value=val;
        left=right=null;
    }
    public Node(E val,Node left,Node right)
    {
        this.value=val;
        this.left=left;
        this.right=right;
    }

    public void setValue(E value)
    {
        this.value=value;
    }
    public E getValue()
    {
        return this.value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int compareTo(E val)
    {
        Integer a=(Integer) value;
        Integer b=(Integer) val;

        if(a>b)
        {
            return 1;
        }
        else if(a==b)
        {
            return 0;
        }
        else
        {
            return -1;
        }

    }
}
