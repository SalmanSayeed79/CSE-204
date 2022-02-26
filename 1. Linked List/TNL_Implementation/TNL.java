package Assignment1.TNL_Implementation;

import java.util.Scanner;

import Assignment1.Array_Based_Implementation.ArrayBased;

public class TNL {
    
    public static void main(String args[]) {
        Scanner consoleScanner=new Scanner(System.in);
        int rickshawStopsCount;
        int busStopsCount;
        int trainStationsCount;

        
        rickshawStopsCount=consoleScanner.nextInt();
        ArrayBased<Integer> rickshawStops=new ArrayBased<Integer>(rickshawStopsCount);
        for(int i=0;i<rickshawStopsCount;i++){
            rickshawStops.append(i);
        }
        //System.out.println(rickshawStops);

        for(int i=0;i<rickshawStopsCount;i++){
            if(i!=rickshawStopsCount-1) System.out.print(i+",");
            else if(i==rickshawStopsCount-1) System.out.println(i);
        }
        //=======================================
        //   BUS STOPS
        //=======================================
        busStopsCount=consoleScanner.nextInt();
        ArrayBased<Integer> busStops=new ArrayBased<Integer>(rickshawStopsCount);
        
        for(int i=0;i<rickshawStopsCount;i++){
            busStops.append(-1);
        }
        //System.out.println(busStops);

        //storing values in a temp array
        int[] busPosTempArray=new int[busStopsCount];
        for(int i=0;i<busStopsCount;i++){
            busPosTempArray[i]=consoleScanner.nextInt();
        }
        //adding bus routes
        for(int i=0;i<busStopsCount;i++){
            int value=busPosTempArray[i];
            //System.out.println("Currently adding to pos "+value);
            busStops.moveToPos(value);
            busStops.remove();
            busStops.insert(value);
            //System.out.println(busStops);
        }
        
        //Printing the bus list
        for(int i=0;i<rickshawStopsCount;i++){
            busStops.moveToPos(i);
            int curValue=busStops.getValue();
            if(curValue==-1) {
                System.out.print(",");
                continue;}
            if(i!=rickshawStopsCount-1) System.out.print(curValue+",");
            else if(i==rickshawStopsCount-1) System.out.println(curValue);
            
        }

         //=======================================
        //   Train STATIONS
        //=======================================
        trainStationsCount=consoleScanner.nextInt();
        ArrayBased<Integer> trainStations=new ArrayBased<Integer>(rickshawStopsCount);
        
        for(int i=0;i<rickshawStopsCount;i++){
            trainStations.append(-1);
        }
        System.out.println(trainStationsCount);

        //storing values in a temp array
        int[] trainPosTempArray=new int[trainStationsCount];
        for(int i=0;i<trainStationsCount;i++){
            trainPosTempArray[i]=consoleScanner.nextInt();
        }
   
        //adding bus routes
        for(int i=0;i<trainStationsCount;i++){
            int value=trainPosTempArray[i];
            //System.out.println("Currently adding to pos "+value);
            trainStations.moveToPos(value);
            trainStations.remove();
            trainStations.insert(value);
            //System.out.println(busStops);
        }
        
        //Printing the bus list
        for(int i=0;i<rickshawStopsCount;i++){
            trainStations.moveToPos(i);
            int curValue=trainStations.getValue();
            if(curValue==-1) {
                System.out.print(",");
                continue;}
            if(i!=rickshawStopsCount-1) System.out.print(curValue+",");
            else if(i==rickshawStopsCount-1) System.out.println(curValue);
        }
    }
}
