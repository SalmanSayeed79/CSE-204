#include<iostream>

using namespace std;
void mergeSort(int arr[],int size){

}

void quickSort(int arr[],int start,int end){
    //if(size==1) return;
    int pivot=arr[end-1];
    int i=-1,j=0;
    for(int p=start;p<end;p++){
        if(arr[p]<pivot){ 
            //Switch and 
            int temp=arr[i+1];
            arr[i+1]=arr[j];
            arr[j]=temp;
            i++;
            j++;
        }
        else{
            j++;
        }
        //Testing each step
        // cout<<"Step "<<p<<" : ";
        // for(int k=0;k<7;k++){
        //     cout<<arr[k]<<" ";
        // }
        // cout<<endl;

    }
    //Switching pivot and i
    arr[end-1]=arr[i+1];
    arr[i+1]=pivot;
    i++;
    j--;



    
    for(int k=0;k<7;k++){
        cout<<arr[k]<<" ";
    }
    cout<<endl;
    //Calling quicksort on the remaining part
        //Generating left array
        int leftArr[100001]={0};
        int rightArr[100001]={0};

        //cout<<"Left array : ";
        for(int k=0;k<i;k++){
            leftArr[k]=arr[k];
            //cout<<arr[k]<<" ";
        }
        //cout<<endl;

        //cout<<"Right array : ";
        for(int k=0;k<j-i;k++){
            rightArr[k]=arr[i+1+k];
           // cout<<arr[i+1+k]<<" ";
        }
        //cout<<endl;
        cout<<"I: "<<i<<" J "<<j<<endl;
        //Right Array
        
        
        //Left Array
        quickSort(arr,0,i);
        quickSort(arr,i+1,j+1);
}

void randomizedQuickSort(int arr[],int size){

}
int main(){
    //1 2 3 5 6 7 9
    int array[]={5,7,1,9,3,2,6};
    for(int i=0;i<7;i++){
        cout<<array[i]<<" ";
    }
    cout<<endl;
    quickSort(array,0,7);
    for(int i=0;i<7;i++){
        cout<<array[i]<<" ";
    }
    cout<<endl;  



    return 0;
}