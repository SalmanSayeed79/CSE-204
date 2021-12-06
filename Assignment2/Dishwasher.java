package Assignment2;
import Assignment2.ArrayBasedStack;
import java.util.Scanner;

public class Dishwasher {
    public static void main(String args[]){
        Scanner consoleScanner= new Scanner(System.in);
        int invitees=consoleScanner.nextInt();
        int courses=consoleScanner.nextInt();

        int[] washTime=new int[courses];
        for(int i=0;i<courses;i++){
            washTime[i]=consoleScanner.nextInt();
        }
        // member Number
        // Time wash
        // course no

        ArrayBasedStack<Object> dirtyStack=new ArrayBasedStack<Object>(invitees*courses);
        ArrayBasedStack<Object> cleanStack=new ArrayBasedStack<Object>(invitees*courses);
        Object [] inviteeStackArray=new Object[invitees];
        for(int i=0;i<invitees;i++){
            inviteeStackArray[i]=new ArrayBasedStack<Integer>(courses);
        }
        while(true){
            int inviteeNumber=consoleScanner.nextInt();
            int time=consoleScanner.nextInt();
            int courseNumber=consoleScanner.nextInt();
            //Exiting at 0 0 0
            if(inviteeNumber==0 && time==0 && courseNumber==0) break;

            int [] time_courseTime_Tuple=new int[2];
            time_courseTime_Tuple[0]=time;
            time_courseTime_Tuple[1]=washTime[courseNumber-1];
            
            dirtyStack.push(time_courseTime_Tuple);
            switch(inviteeNumber){
                case 1:
                    ((ArrayBasedStack<Integer>) inviteeStackArray[0]).push(courseNumber);
                    break;
                case 2:
                    ((ArrayBasedStack<Integer>) inviteeStackArray[1]).push(courseNumber);
                    break;
                case 3:
                    ((ArrayBasedStack<Integer>) inviteeStackArray[2]).push(courseNumber);
                    break;
                
            }
            
            
        }
        System.out.println("Dirty Stack");
        System.out.println(dirtyStack);
        //=========================================
        //Checking who ate the full meal
        //=========================================
        int fullCourseEatenCount=0;
        int []fullCourseEatenArray=new int[invitees];
        //Checking which courses are full
        for(int i=0;i<invitees;i++){
            if(((ArrayBasedStack<Integer>) inviteeStackArray[i]).length()==3){
                //System.out.println(i+1);
                fullCourseEatenArray[fullCourseEatenCount]=i+1;
                fullCourseEatenCount++;
            }
        }
        if(fullCourseEatenCount==invitees) System.out.println("Y");
        else System.out.println("N");

        //Printing the users who have completed the meals
        for(int i=0;i<fullCourseEatenCount;i++){
            int value=fullCourseEatenArray[i];
            System.out.print(value);
            if(i!=fullCourseEatenCount-1) System.out.print(",");
        }
       


    }
}
