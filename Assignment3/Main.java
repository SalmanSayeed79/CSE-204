package Assignment3;

import java.util.Scanner;

public interface Main {
    public static void printQueue(LLBasedQueue<Integer> printingQueue, int queueSize){
        //Hello
        LLBasedQueue<Integer> tempQueue = new LLBasedQueue<Integer>();
        String value="< ";

        //Getting value out from the printingQueue and adding to the temp queue
        for(int i=0;i<queueSize;i++){
            Integer nextValue = printingQueue.dequeue();
            value+=nextValue+" ";
            tempQueue.enqueue(nextValue);
        }
        value+=">";
        //Restoring the printing queue from the tempQueue
        for(int i=0;i<queueSize;i++){
            Integer nextValue = tempQueue.dequeue();
            printingQueue.enqueue(nextValue);
        }
        System.out.println(value);
    }
    public static void main(String args[]){
        Scanner consoleScanner= new Scanner(System.in);
        int inputSize=consoleScanner.nextInt();

        LLBasedQueue<Integer> mainQueue = new LLBasedQueue<Integer>();
        for(int i=0;i<inputSize;i++){
            int input=consoleScanner.nextInt();
            mainQueue.enqueue(input);
        }
        printQueue(mainQueue,mainQueue.length());

        while(true){
            int option=consoleScanner.nextInt();
            int param=consoleScanner.nextInt();

            switch(option){
                case 1:{
                    mainQueue.clear();
                    printQueue(mainQueue, mainQueue.length());
                    System.out.println("-1");
                    break;
                }
                case 2:{
                    mainQueue.enqueue(param);
                    printQueue(mainQueue, mainQueue.length());
                    //System.out.println(mainQueue);
                    System.out.println("-1");
                    break;
                }
                case 3:{
                    int output=mainQueue.dequeue();
                    printQueue(mainQueue, mainQueue.length());
                    System.out.println(output);
                    break;
                }
                case 4:{
                    int length=mainQueue.length();
                    printQueue(mainQueue, mainQueue.length());
                    System.out.println(length);
                    break;
                }
                case 5:{
                    int frontValue=mainQueue.frontValue();
                    printQueue(mainQueue, mainQueue.length());
                    System.out.println(frontValue);
                    break;
                }
                case 6:{
                    int rearValue=mainQueue.rearValue();
                    printQueue(mainQueue, mainQueue.length());
                    System.out.println(rearValue);
                    break;
                }
                case 7:{
                    printQueue(mainQueue, mainQueue.length());
                    break;
                }
            }
        }
    }
}
