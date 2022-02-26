package Assignment4;

public class BSTMain <E> implements BSTInterface{

    private Node root;
    private int nodecount;

    BSTMain(){
        root=null;
        nodecount=0;
    }
    @Override
    public void Insert(Object value) {
        root=inserthelp(root, (E) value);
        nodecount++;
    }

    private Node inserthelp(Node<E> rt,E value){
        if(rt==null) return new Node(value);
        if(rt.compareTo(value)>0) rt.setLeft(inserthelp(rt.getLeft(),value));
        else rt.setRight(inserthelp(rt.getRight(),value));
        return rt;
    }
    @Override
    public Object Delete(Object value) {
        E temp= (E) findhelp(root, (E) value);

        if(temp!=null){
            root=removehelp(root, (E) value);
            nodecount--;
        }
        return temp;
    }
    private Node<E> getMax(Node<E> rt){
        if(rt.getRight()==null) return rt;
        return getMax(rt.getRight());
    }

    private Node<E> deleteMax(Node<E>rt){
        if(rt.getRight()==null) return rt.getLeft();
        rt.setRight(deleteMax(rt.getRight()));
        return rt;

    }

    private Node<E> removehelp(Node<E> rt,E value){
        if(rt==null) return null;
        
        if(rt.compareTo(value)>0) rt.setLeft(removehelp(rt.getLeft(),value));

        else if(rt.compareTo(value)<0) rt.setRight(removehelp(rt.getRight(),value));
        
        else{
            if(rt.getLeft()==null) return rt.getRight();
            else if(rt.getRight()==null) return rt.getLeft();
            else{
                Node temp=getMax(rt.getLeft());
                rt.setValue((E) temp.getValue());
                rt.setLeft(deleteMax(rt.getLeft()));
            }
        }
        return rt;

    }

    @Override
    public boolean Find(Object value) {
        if(findhelp(root, (E) value)==null) return false;
        
        else return true;
    
    }

    @Override
    public void Traversal(String type) {
        if(type.equalsIgnoreCase("in")){
          inOrder(root);
          System.out.println();
        }
        else if(type.equalsIgnoreCase("pre")){
          preOrder(root);
          System.out.println();
        }
        else{
           postOrder(root);
           System.out.println();
        }
    }

    @Override
    public void printBST() {
        Print(root);
        System.out.println();
    }

    private static<E> void preOrder(Node node){
        if (node == null) return;
        System.out.print(node.getValue() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }
    private static<E> void postOrder(Node node){
        if (node == null) return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getValue() + " ");
    }
    private static<E> void inOrder(Node node){
        if (node == null) return;
        inOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrder(node.getRight());
    }



    private E findhelp(Node<E>rt,E value){
        if(rt==null) return null;
        if(rt.compareTo(value)>0) return (E) findhelp(rt.getLeft(),value);
        else if(rt.compareTo(value)==0) return rt.getValue();
        else return (E) findhelp(rt.getRight(),value);
    }

    public static<E> void Print(Node node){
        if(node == null) return;
        System.out.print(node.getValue());
        if ((node.getLeft() == null) && (node.getRight() == null)) return;

        System.out.print("(");
        Print(node.getLeft());
        System.out.print(")");

        System.out.print("(");
        Print(node.getRight());
        System.out.print(")");

    }
}
