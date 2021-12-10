package Assignment3;

import java.util.Scanner;


public class Customer{
    int enterTime;
    int serviceTime;

    public void Customer(int a,int b){
        this.enterTime=a;
        this.serviceTime=b;
    }
    public int enterTime(){
        return this.enterTime;
    }
    public int serviceTime(){
        return this.serviceTime;
    }
}
public class Bank {
    public static void main(String[] args) {
        Scanner consoleScanner= new Scanner(System.in);
        int customerCount= consoleScanner.nextInt();

        LLBasedQueue<Integer> allCustomers= new LLBasedQueue<Integer>(customerCount);

        for(int i=0;i<customerCount;i++){
            int enter_time=consoleScanner.nextInt();
            int service_time=consoleScanner.nextInt();
            Customer newCustomer=new Customer(enter_time,service_time);
            allCustomers.enqueue(newCustomer);
        }

        printQueue(allCustomers);
    }
}
