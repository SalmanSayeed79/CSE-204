package Assignment2;
import Assignment2.ArrayBasedStack;
import java.util.Scanner;
class Dish{
    int courseNumber, timePushed;
    public Dish(int courseNumber, int timePushed){
        this.courseNumber = courseNumber;
        this.timePushed = timePushed;
    }

    public int getCourseNumber(){ return courseNumber;}
    public int getTimePushed(){ return timePushed;}
}
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

        ArrayBasedStack<Dish> dirtyStack=new ArrayBasedStack<Dish>();
        ArrayBasedStack<Dish> cleanStack=new ArrayBasedStack<Dish>();
        Dish[] allDish= new Dish[50];
        ArrayBasedStack<Integer> tempCourseStack=new ArrayBasedStack<Integer>(invitees*courses);
        Object [] inviteeStackArray=new Object[invitees];
        for(int i=0;i<invitees;i++){
            inviteeStackArray[i]=new ArrayBasedStack<Integer>(courses);
        }


        int totalInput=0;
        while(true){
            int inviteeNumber=consoleScanner.nextInt();
            int time=consoleScanner.nextInt();
            int courseNumber=consoleScanner.nextInt();
            
            if(inviteeNumber>0) {
                ((ArrayBasedStack<Integer>) inviteeStackArray[inviteeNumber-1]).push(courseNumber);
                allDish[totalInput]=new Dish(time, courseNumber);
                totalInput++;
            }

            
            
            if(inviteeNumber==0 && time==0 && courseNumber==0) break;
            
        }
        int currentDish=0;
        int nextTime=0;
        for(int i=0;i<allDish.length;i++){
            System.out.print(allDish[i]+" ");
        }
        // while(true){
        //     while(currentDish < allDish.length && nextTime >= allDish[currentDish].getTimePushed()){
        //         dirtyStack.push(allDish[currentDish]);
        //         currentDish++;
        //     }
        //     if(dirtyStack.length()!=0){
        //         Dish current  = dirtyStack.pop();
        //         int courseNumber = current.getCourseNumber();
        //         int timePushed = current.getTimePushed();
        //         int finishTime = nextTime > timePushed ? nextTime + washTime[courseNumber - 1] - 1: timePushed+washTime[courseNumber-1]-1;
        //         cleanStack.push(new Dish(courseNumber, finishTime));
        //         nextTime = finishTime+1;
    
        //         if(dirtyStack.length() == 0 && currentDish == allDish.length) break;
        //         if(dirtyStack.length()==0 && nextTime < allDish[currentDish].getTimePushed()) nextTime = allDish[currentDish].getTimePushed();
        //     }
            
        // }
        // System.out.println(cleanStack.topValue().getTimePushed());

        // int[] finishTimes = new int[cleanStack.length()];
        // int nDishes = 0;
        // while(cleanStack.length() >0){
        //     finishTimes[nDishes++] = cleanStack.pop().getTimePushed();
        // }

        // for(int i=finishTimes.length-1; i>=0;i--){
        //     System.out.println(finishTimes[i] + (i==0 ? "" : ","));
        // }
   

//         //==================================
//         // New Code
//         //==================================
//         totalInput-=1;
//         System.out.println("Time stack" + timeStack);

//         int totalTime=0;
//         int cleaningCurrentTime=0;
//         int courseTime=timeStack.pop();
//         //cleanStack.length()==totalInput
//         boolean cleaned=false;
//         for(int i=200;i>0;i--){
// //            int currentDirtyTime=timeStack.pop();
// //            //System.out.println(currentDirtyTime);
// //            if(i==currentDirtyTime){
// //                int dirtyPlateAtHand = dirtyStack.pop();
// //                System.out.println("Cleaning "+dirtyPlateAtHand);
// //            }
//             //pushing into stack when numbers match
//             int time=timeStack.pop();
//             if(i!=time){
//                 timeStack.push(time);
//             }
//             if(i==time){
//                 dirtyStack.push(1);
//             }

//             //pushing the clean plates in the clean stack
//            if(cleaned==true){
//                if(tempCourseStack.length()>0){
//                    int tempCourse=tempCourseStack.pop();
//                    System.out.println("Current wash time : "+tempCourse);
//                    courseTime=washTime[tempCourse-1];

//                    cleaningCurrentTime=0;
//                    cleaned=false;
//                }
//            }
//            else{
//                cleaningCurrentTime++;
//                if(courseTime==cleaningCurrentTime){
//                    cleanStack.push(dirtyStack.pop());
//                    cleaned=true;
//                }
//            }

//         }
//         System.out.println(dirtyStack);
//         System.out.println(cleanStack);

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