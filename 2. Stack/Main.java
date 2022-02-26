package Assignment2;

import java.util.Scanner;

import Assignment2.ArrayBasedStack;
import Assignment2.LLBasedStack;

public class Main {

    public static void printStack(StackInterface stackInput){
        System.out.println("Stack len "+stackInput.length());
        ArrayBasedStack<Object> tempStack=new ArrayBasedStack<Object>(stackInput.length());
        Object[] tempArray=new Object[stackInput.length()];
        //System.out.print("<");
        for(int i=0;i<stackInput.length();i+=1){
            System.out.println("i value = "+i+" ");
            Object value=stackInput.pop();
            System.out.println("value = "+ value);
        }
       
    }
    public static void main(String args[]) {

    Scanner consoleInput = new Scanner(System.in);

    int size = consoleInput.nextInt();
    ArrayBasedStack<Integer> currentStack=new ArrayBasedStack<Integer>(size);
    for(int i = 0;i<size;i++)
    {
        int value=consoleInput.nextInt();
        currentStack.push(value);
    }
    System.out.println(currentStack);
    //printStack(currentStack);
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
                currentStack.clear();
                System.out.println(currentStack);
                //printStack(currentStack);
                System.out.println("-1");
                break;
            }
            case 2:{ 
                //int param=consoleInput.nextInt();
                System.out.println(param);
                currentStack.push(param); 
                System.out.println(currentStack);
                System.out.println("-1");
             break;
            }
            case 3:{ 
                //int param=consoleInput.nextInt();
                int popedValue=currentStack.pop();
                System.out.println(currentStack);
                System.out.println(popedValue);
                break;
            }
            case 4:{ 
                //int param=consoleInput.nextInt();
                int length=currentStack.length();
                System.out.println(currentStack);
                System.out.println(length);
                break;
            }
            case 5:{
                int topValue = currentStack.topValue();
                System.out.println(currentStack);
                System.out.println(topValue);
                break;
            }
            case 6:{
                //currentStack.setDirection(param);
                System.out.println(currentStack);
                System.out.println("-1");
                break;
            }
            
            
        }
    }
}
    
}
