package Assignment3;
import java.util.Scanner;


class Customer{
    public int enterTime;
    public int serviceTime;

    public Customer(int a,int b){
        this.enterTime=a;
        this.serviceTime=b;
    }
  
}
public class Bank {
    public static boolean isInArray(int[]array,int a){
        for(int i=0;i<array.length;i++){
            if(array[i]==a) return true;
        }
        return false;
    }

    public static void showCustomerQueue(LLBasedQueue<Customer> printingQueue, int queueSize){
        LLBasedQueue<Customer> tempQueue= new LLBasedQueue<Customer>(printingQueue.length());
        String enterString="Enter Times : ";
        String serviceString="Servc Times : ";
        //getting values out from the stack and printing them
        for(int i=0;i<queueSize;i++){
            Customer currentCustomer= printingQueue.dequeue();
            enterString+=currentCustomer.enterTime+" ";
            serviceString+=currentCustomer.serviceTime+" ";
            tempQueue.enqueue(currentCustomer);
        }
        System.out.println(enterString);
        System.out.println(serviceString);
    }


    public static void main(String[] args) {
        Scanner consoleScanner= new Scanner(System.in);
        int customerCount= consoleScanner.nextInt();

        ArrayBasedQueue<Customer> allCustomers= new ArrayBasedQueue<Customer>();
        ArrayBasedQueue<Customer> queue1= new ArrayBasedQueue<Customer>();
        ArrayBasedQueue<Customer> queue2= new ArrayBasedQueue<Customer>();

        int [] allTimes=new int[customerCount];
        //Adding all customers to the list
        for(int i=0;i<customerCount;i++){
            int enter_time=consoleScanner.nextInt();
            int service_time=consoleScanner.nextInt();
            Customer newCustomer=new Customer(enter_time,service_time);
            allCustomers.enqueue(newCustomer);
            allTimes[i]=enter_time;
        }

        //Creating the timeLine
        int currentTime=0;
        int queue1RemainingTime=0;
        int queue2RemainingTime=0;
        int queue1TotalRunTime=0;
        int queue2TotalRunTime=0;
        boolean queue1Active=true;
        boolean queue2Active=true;
        boolean queue1FullDone=false;
        boolean queue2FullDone=false;


        Customer queue1CurrentCustomer;
        Customer queue2CurrentCustomer;
        //|| queue1Active || queue2Active
        while((queue1.length()!=0 || queue2.length()!=0) || allCustomers.length()!=0 || queue1Active || queue2Active){
            //Things I have to do
            //==================================
            /**
             * Track both the queues for each time according to length
             * Push a new user from the allusers queue until that is empty
             * Switch users from the queus to the smaller queue
             * Count time for each of the queue 
             * count time for each of the user with their service time
             */

            
            //System.out.println("Inside loop for time "+currentTime);
            int queue1Len=queue1.length();
            int queue2Len=queue2.length();

            //System.out.println("Current queue 1 size : "+queue1Len+" Current queue 2 size : "+queue2Len);
            //Pushing customers to the newQueue when a queue is inactive
            if(!queue1Active && queue1Len!=0){
            
                queue1Active=true;
                //System.out.println("Service done in queue 1");
                queue1CurrentCustomer=queue1.dequeue();
                queue1RemainingTime=queue1CurrentCustomer.serviceTime;
                //System.out.println("Current remaining time in queue 1 is "+queue1RemainingTime);
                
            }
            if(!queue2Active && queue2Len!=0){
               
                queue2Active=true;
                //System.out.println("Service done in queue 2");
                queue2CurrentCustomer=queue2.dequeue();
                queue2RemainingTime=queue2CurrentCustomer.serviceTime;
                
            }


            //Pushing the customer to the smaller queue if the time of the customer matches
            if(isInArray(allTimes, currentTime)){
                Customer nextNewCustomer=allCustomers.dequeue();
                //System.out.println("AllCustomer Decreased now size : "+allCustomers.length());
                if(nextNewCustomer.enterTime==currentTime){
                    //pushing to the smaller queue
                    if(queue2Len>queue1Len){
                        System.out.println("Pushing new customer to queue 2");
                    
                        queue1.enqueue(nextNewCustomer);
                    }else{
                        System.out.println("Pushing new customer to queue 1");
                        queue2.enqueue(nextNewCustomer);
                    }
                }
            }
            

            //Switching customers
            if(queue1Len>queue2Len){
                if(queue1.length()>=1){
                    System.out.println("Switched a customer to queue 2");
                    Customer movingCustomer=queue1.leaveQueue();
                    queue2.enqueue(movingCustomer);
                }
                
            }
            if(queue2Len>queue1Len){
                if(queue2.length()>=1){
                System.out.println("Switched a customer to queue 1");
                Customer movingCustomer=queue2.leaveQueue();
                queue1.enqueue(movingCustomer);
                }
            }
            
            //Changing all the times
            currentTime++;
            if(queue1RemainingTime>0) {
                queue1RemainingTime--;
                //System.out.println("queue1 remaining time : "+queue1RemainingTime);
            }
            if(queue2RemainingTime>0) queue2RemainingTime--;
            if(queue1RemainingTime==0) queue1Active=false;
            if(queue2RemainingTime==0) queue2Active=false;

            //Assigning time to the queue when queue is empty
            if(queue1Len==0 && allCustomers.length()==0 && queue1FullDone==false ){
                //System.out.println("Queue 1 done");
                queue1FullDone=true;
                queue1TotalRunTime=currentTime+queue1RemainingTime-1;
            }
            if(queue2Len==0 && allCustomers.length()==0 && queue2FullDone==false){
                //System.out.println("Queue 2 done");
                queue2FullDone=true;
                queue2TotalRunTime=currentTime+queue2RemainingTime-1;
            }

        }
        System.out.println("Booth 1 finishes service at t = "+queue1TotalRunTime);
        System.out.println("Booth 2 finishes service at t = "+queue2TotalRunTime);

    }
}
