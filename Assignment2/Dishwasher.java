package Assignment2;

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

    }
}
