#include<iostream>
#include<cstring>
using namespace std;

/*
 *  Turning bits on and off :
 * ==============================
 * 1<<n means 2^n in integer. That means 1<<3 would mean 8
 *
 * BASIC IDEA 
 * ==========================
 * So the idea is that in each time for selcting a city, we can choose from a set of n (1,{c1,c2,...cn})
 * Then, remaining problem (2,{c2,c3,....cn}) [We supposed we had chosen the first problem]
 * In the same way if we choose c3 for next city the problem would become (3,{c3,c4,....cn})
 * So we can see that there can be a recursive definition to be seen
 * Now to store which cities we have visited, storing an array would be expensive. So we can use bitmasking here 
 * 
 * DETERMINING THE RECURRENCE RELATION
 * =====================================================
 * The recurrence could look something like this,
 *      dp(i,mask)= min {[cij + (i+1,mask - jth bit)] for all available (not yet visited) j}
 * 
*/

//This array will store the cost of visiting the cities
long long int cost[10001][10001];
//This will be our memo
long long int visited[10001][10001];
//Custom defined min function
int min(int a ,int b){
    if(a<b) return a;
    return b;
}

long long int dp(int i, int mask, int n){
    // Case when we have visited all the cities
    if(i==n)
        return 0;
    //Case when we have already visited the city
    if(visited[i][mask] !=-1)
        return visited[i][mask];

    //If we haven't visited the city
    //Initializing ans with the maximum possible value
    long long int ans= INT_MAX;
    //Now iterating throught the mask and finding the 
    for(int j = 0; j < n; j++){
        if(mask&(1<<j)){
            // Counting for (i+1) th visit and also making the j the position visited with xor
            long long int totalCost= dp(i+1, (mask^(1<<j)), n);
            //Adding costs of all the visited countries
            for(int p=0;p<n;p++){
                if(mask&(1<<p)) totalCost+=cost[j][p];
            }
            ans = min(ans, totalCost);
        }
    }
    // Saving the ans to the memo
    visited[i][mask]=ans;
    return visited[i][mask];
    
}
int main(){
    int n;
    cin>>n;
    memset(visited,-1,sizeof(visited));
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin>>cost[i][j];
        }
    }
    cout<<dp(0,(1<<n)-1,n);
    return 0;
}


