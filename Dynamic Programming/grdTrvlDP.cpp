#include<iostream>
#include<bits/stdc++.h>

using namespace std;


//With memoisation we'll create a memo
int grdTrvl(int m,int n,int **arr,bool initialize=true){
    //initializing all the array values to -1
    if(initialize){
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=-1;
            }
        }
    }


    //Main logic
    
    if(m==1 && n==1) return 1;
    if(m==0 || n==0) return 0;

    return grdTrvl(m-1,n,arr,false)+grdTrvl(m,n-1,arr,false);
}
int main(){
    cout<<grdTrvl(3,2);

    return 0;
}