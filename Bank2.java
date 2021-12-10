package Assignment3;
import java.util.Scanner;

public class Bank2 {
 
    public static int max(int a,int b){
        if(a>=b) return a;
        else return b;
    }
    public static int min(int a,int b){
        if(a<=b) return a;
        else return b;
    }
 
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
 
        LLBasedQueue<Integer> queueA= new LLBasedQueue<Integer>();
        LLBasedQueue<Integer> queueB= new LLBasedQueue<Integer>();

        int n=input.nextInt();
        int[] arrivals=new int[n+1];
        int[] times=new int[n+1];
 
        for(int i=0;i<n;i++){
            arrivals[i]=input.nextInt();
            times[i]=input.nextInt();
        }
        arrivals[n]=100000000;
        times[n]=100000000;
 
        int nextCustomer=0;
        int endA=0,endB=0;
        while(true){
            if((nextCustomer==n)&&(queueA.length()==0)&&(queueB.length()==0)){
                break;
            }
            if(((endA>0) && (endA<=arrivals[nextCustomer]) && (queueA.length()>0) )||((endB>0) && (endB<=arrivals[nextCustomer]) && (queueB.length()>0))){
                if((queueA.length()>0)&&(queueB.length()>0)) {
                    if (endA <= endB){
                        int elem=queueA.dequeue();
                        System.out.println("Customer "+elem+" went to teller of booth 1 at time "+endA);
                        endA += times[elem];
                    }
                    else{
                        int elem=queueB.dequeue();
                        System.out.println("Customer "+elem+" went to teller of booth 2 at time "+endB);
                        endB += times[elem];
                    }
                    continue;
                }
 
                if((endA<endB)&&(queueA.length()==0)&&(queueB.length()==1)){
                    int elem=queueB.dequeue();
                    System.out.println("Customer "+elem+" has left queue 2 and went to teller of queue 1 at time "+endA);
                    endA+=times[elem];
                    continue;
                }
                else if((endB<endA)&&(queueB.length()==0)&&(queueA.length()==1)){
                    int elem=queueA.dequeue();
                    System.out.println("Customer "+elem+" has left queue 1 and went to teller of queue 2 at time "+endB);
                    endB+=times[elem];
                    continue;
                }
 
                else if(queueA.length()>0){
                    int elem=queueA.dequeue();
                    System.out.println("Customer "+elem+" went to teller of booth 1 at time "+endA);
                    endA += times[elem];continue;
                }
                else{
                    int elem=queueB.dequeue();
                    System.out.println("Customer "+elem+" went to teller of booth 2 at time "+endB);
                    endB += times[elem];continue;
                }
            }
 
            if((arrivals[nextCustomer]<=endA)&&(arrivals[nextCustomer]<=endB)){
                if(queueA.length()<=queueB.length()){
                    System.out.println("Customer "+nextCustomer+" joined queue 1 at time "+arrivals[nextCustomer]);
                }
                else{
                    System.out.println("Customer "+nextCustomer+" joined queue 2 at time "+arrivals[nextCustomer]);
                    queueB.enqueue(nextCustomer);
                }
                nextCustomer++;
                continue;
            }
            if((arrivals[nextCustomer]>endA)&&(queueB.length()==0)&&(queueA.length()==0)){
                System.out.println("Customer "+nextCustomer+" went to teller of booth 1 at time "+arrivals[nextCustomer]);
                endA=arrivals[nextCustomer]+times[nextCustomer];
                nextCustomer++;
                continue;
            }
            else if((arrivals[nextCustomer]>endB)&&(queueA.length()==0)&&(queueB.length()==0)){
                System.out.println("Customer "+nextCustomer+" went to teller of booth 2 at time "+arrivals[nextCustomer]);
                endB=arrivals[nextCustomer]+times[nextCustomer];
                nextCustomer++;
                continue;
            }
            if(queueA.length()-queueB.length()>=2){
                int elem=queueA.leaveQueue();
                System.out.println("Customer "+elem+" has left queue 1 and joined queue 2");
                queueB.enqueue(elem);
                continue;
            }
            else if(queueB.length()-queueA.length()>=2){
                int elem= queueB.leaveQueue();
                System.out.println("Customer "+elem+" has left queue 2 and joined queue 1");
                queueA.enqueue(elem);
                continue;
            }
            if((endA<endB)&&(queueA.length()==0)&&(queueB.length()==1)){
                int elem=queueB.dequeue();
                System.out.println("Customer "+elem+" has left queue 2 and went to teller of queue 1 at time "+endA);
                endA+=times[elem];
            }
            else if((endB<endA)&&(queueB.length()==0)&&(queueA.length()==1)){
                int elem=queueA.dequeue();
                System.out.println("Customer "+elem+" has left queue 1 and went to teller of queue 2 at time "+endB);
                endB+=times[elem];
            }
        }
        System.out.println("Booth 1 finishes service at t= "+endA);
        System.out.println("Booth 2 finishes service at t= "+endB);
    }
}
