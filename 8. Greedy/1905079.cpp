#include<iostream>
#include "MergeSort.h"

using namespace std;

/*Our plan is to
    - Sort the array so that the last element becomes the highest priced element
    - Traverse from the back and multiply currentMul with that price
    - Print the result
*/
int main(){
    int friendCount, plantCount;
    int plantPrices[10001]={0};
    // Taking count
    cin>>plantCount>>friendCount;
    // Taking the prices
    for(int i=0;i<plantCount;i++){
        cin>>plantPrices[i];
    }
    //sorting the plantArray according to price. Used the mergeSort from previous assessment
    MergeSort(plantPrices,0,plantCount-1);
    
    //Counting the actual minCost
    int minCost=0;
    int currentMul=1;
    for(int i=0;i<plantCount;){
        for(int p=0;p<friendCount;p++){
            minCost+=plantPrices[plantCount-i-1]*currentMul;
            i++;
        }
        currentMul++;
    }
    cout<<minCost;

    return 0;

}