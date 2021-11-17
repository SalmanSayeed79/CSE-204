package Assignment1.printing;
import java.util.Scanner;

class node<T>{
    public T value;
    public node next;
}
class list{
    node head;
    node tail;
    node current;
}
class printing{
    public static void main(String[] args) {
        Scanner consoleInput=new Scanner(System.in);
        System.out.print("Enter the first value : ");
        String firstInput=consoleInput.next();
        System.out.println("Hello "+firstInput);
    }
}