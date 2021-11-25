package Assignment1.Printing;
import Assignment1.Array_Based_Implementation.ArrayBased;
import java.util.Scanner;

public class Printing {
    public static void main(String args[]) {
        Scanner consoleInput=new Scanner(System.in);
        int initialSize=consoleInput.nextInt();

        ArrayBased<Integer> arrayList=new ArrayBased<Integer>(initialSize);

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
