#include<iostream>
#include<queue>
#include<string>

using namespace std;

int main(){
    int dieFaces,boardSize;
    int ladderNumber,snakeNumber;
    int parentof[10001],distance[10001],finalPosition[10001];
    //Pushing 1 into queue at initialization
    

    //Setting up file I/O
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);

    int testCases;
    cin>>testCases;
    for(int testNo=0;testNo<testCases;testNo++){
        //cout<<"Test Case : "<<testNo+1<<endl;
        cin>>dieFaces>>boardSize;
        queue<int> q({1});
        //==================================================
        // Initializing all the distance , finalPosition with -1 by default
        //==================================================
        // distance being -1 means it has not yet been visited
        // parentof being -1 means it has not yet been visited
        for(int i=1;i<=boardSize;i++){
            finalPosition[i]=-1;
            distance[i]=-1;
            parentof[i]=-1;
        }
        distance[1]=0;
        //==================================================
        //Saving the ladders and the snakes
        //==================================================
        cin>>ladderNumber;
        //cout<<"Ladders"<<endl;
        for(int i=1;i<=ladderNumber;i++){
            int start,end;
            cin>>start>>end;
            finalPosition[start]=end;
            //Testing
            //cout<<"Start "<<start<<" End "<<end<<endl;
        }
        cin>>snakeNumber;
        //cout<<"Snakes"<<endl;
        for(int i=1;i<=snakeNumber;i++){
            int start,end;
            cin>>start>>end;
            finalPosition[start]=end;
            //Testing
            //cout<<"Start "<<start<<" End "<<end<<endl;
        }
        
        // for(int i=1;i<=boardSize;i++){
        //     cout<<i<<" "<<finalPosition[i]<<endl;
        // }
        //==================================================
        // Doing the main BFS logic
        //==================================================
        while(q.size()!=0){
            int currentBlock=q.front();
            for(int k=1;k<=dieFaces;k++){
                int child=k+currentBlock;
                //Checking for when a node is not visited 
                if(distance[child]==-1){
                    parentof[child]=currentBlock;
                    distance[child]=distance[currentBlock]+1;
                    //Checking for ladder or snake
                    int ladderfound=0;
                    if(finalPosition[child]!=-1 ){
                        q.push(finalPosition[child]);
                        if(distance[finalPosition[child]]==-1){
                            parentof[finalPosition[child]]=child;
                            distance[finalPosition[child]]=distance[child];
                        }  
                        ladderfound=1;   
                    }
                    if(!ladderfound){
                        q.push(child);
                        ladderfound=0;
                    }
                    
                    
                }
            }
            //cout<<currentBlock<<"-> ";
            q.pop();
        }
        
        cout<<distance[boardSize]<<endl;
        //==================================================
        // Printing the path of the movement
        //==================================================
       
        if(distance[boardSize]!=-1){
            string path=to_string(boardSize);
            int parent=boardSize;
            while(parent!=-1){
               if(parent!=boardSize){
                string str = to_string(parent)+" -> ";
                path.insert(0,str);
               }
                
                parent=parentof[parent];
            }
            cout<<path<<endl;
        }
        else{
            cout<<"No solution"<<endl;
            for(int i=1;i<=boardSize;i++){
                if(distance[i]==-1){
                    cout<<i<<" ";
                }
            }
            cout<<endl;
        }
        //==================================================
        //Checking if all the nodes are reachable or not
        //==================================================
        bool allReachable=true;
        for(int i=1;i<=boardSize;i++){
            if(distance[i]==-1) {
                allReachable=false;}
        }
        if(allReachable) cout<<"All reachable"<<endl;
        //Printing the 



    cout<<endl;
    }
    //==================================================
    //Closing the streams
    //==================================================
    fclose(stdin);
    fclose(stdout);


    return 0;
}