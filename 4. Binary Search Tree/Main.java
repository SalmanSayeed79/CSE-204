package Assignment4;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BSTMain tree= new BSTMain();
        try{
            File inputFile= new File("F:/Classes/! Varsity Courses/2-1/CSE 204/Assignment4/input.txt");
            Scanner fileScanner= new Scanner(inputFile);
            while(fileScanner.hasNextLine()){
                
                String newLine=fileScanner.nextLine();
                //Adding element
                if(newLine.startsWith("I")){
                    String[] arr = newLine.split(" ");
                    int value=Integer.parseInt(arr[1]);
                    //System.out.println("Taking input " + value);
                    tree.Insert(value);
                    tree.printBST();
                }
                //Finding value
                if(newLine.startsWith("F")){
                    String[] arr = newLine.split(" ");
                    int value=Integer.parseInt(arr[1]);
                    //System.out.println("Finding Value "+value );
                    boolean found=tree.Find(value);
                    if(found) System.out.println("True");
                    else System.out.println("False");
                }
                //Traversing tree
                if(newLine.startsWith("T")){
                    String[] arr = newLine.split(" ");
                    String value=arr[1].trim();
                    if(value.equalsIgnoreCase("In")){
                        //System.out.println("Inorder Traversal");
                        tree.Traversal("In");
                    }
                    if(value.equalsIgnoreCase("Pre")){
                        //System.out.println("Preorder Traversal");
                        tree.Traversal("Pre");
                    }
                    if(value.equalsIgnoreCase("Post")){
                        //System.out.println("Postorder Traversal");
                        tree.Traversal("Post");
                    }
                }
                //Deleting element
                if(newLine.startsWith("D")){
                    String[] arr = newLine.split(" ");
                    int value=Integer.parseInt(arr[1]);
                    //System.out.println("Deleting Element " + value);
                    Object sucessfulRemove= tree.Delete(value);
                    if(sucessfulRemove==null) System.out.println("Invalid Operation");
                    else tree.printBST();
                }
            }
            fileScanner.close();
            
        }catch(Exception  e){
            System.out.println("File not found "+e);
        }
    }
    
    
}
