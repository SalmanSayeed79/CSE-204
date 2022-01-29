#include <bits/stdc++.h>
using namespace std;
using namespace std::chrono;

void Merge(int array[], int start, int mid, int end){
    int fragment1_size = mid - start + 1;
    int fragment2_size = end - mid;
    int *fragment1 = new int[fragment1_size + 1];
    int *fragment2 = new int[fragment2_size + 1];
    for(int i = 0; i < fragment1_size; i++) fragment1[i] = array[start + i];
    for(int i = 0; i < fragment2_size; i++) fragment2[i] = array[mid + 1 + i];
    fragment1[fragment1_size] = INT32_MAX;
    fragment2[fragment2_size] = INT32_MAX;

    int i = 0;
    int j = 0;

    for(int k = start; k <= end; k++){
        if(fragment1[i] <= fragment2[j]){
            array[k] = fragment1[i];
            i++;
        }
        else{
            array[k] = fragment2[j];
            j++;
        }
    }

    delete[] fragment1;
    delete[] fragment2;
}

void MergeSort(int array[], int start, int end){
    if(start < end){
        int mid = (start + end) / 2;
        MergeSort(array, start, mid);
        MergeSort(array, mid + 1, end);
        Merge(array, start, mid, end);
    }
}

int Partition(int array[], int start, int end, bool makeRandonPivot){
    if(makeRandonPivot){
        int pivot_index = start + rand() % (end - start + 1);
        swap(array[end], array[pivot_index]);
    }
    
    int pivot = array[end];
    int i = start - 1;
    for(int j = start; j < end; j++){
        if(array[j] <= pivot){
            i++;
            swap(array[j], array[i]);
        }
    }
    swap(array[i + 1], array[end]);
    return i + 1;
}

void QuickSort(int array[], int start, int end, bool makeRandonPivot = false){
    if(start < end){
        int pos = Partition(array, start, end, makeRandonPivot);
        QuickSort(array, start, pos - 1);
        QuickSort(array, pos + 1, end);
    }
}

void InsertionSort(int *array, int size){
    for(int i=0; i<size; i++){
        for(int j=i; j>0 && array[j]<array[j-1]; j--){
            swap(array[j],array[j-1]);
        }
    }
}

void print_array(int array[], int size){
    for(int i = 0; i < size; i++) {
        cout << array[i] << " ";
        }
    cout << endl;
}

int generateReqTime(int n,int option){
    long long int sum = 0;
    for(int i = 0; i < 20; i++){
        srand(123);
        int* array = new int[n];
        int* sortedArray = new int[n];
        //Generating array with random values
        for(int i = 0; i < n; i++) {
            int random=rand();
            array[i] = random;
            sortedArray[i]=random;
        }
        //Generate the sorted array before startting time
        sort(sortedArray, sortedArray + n);

        auto start = high_resolution_clock::now();
        // change function name
        switch(option){
            case 1:
                MergeSort(array,0,n-1);
                break;
            case 2:
                QuickSort(array,0,n-1);
                break;
            case 3:
                QuickSort(array,0,n-1,true);
                break;
            case 4:
                InsertionSort(array,n);
                break;
            case 5:
                //sorted input quicksort
                QuickSort(sortedArray,0,n-1);
                break;
            case 6:
                //randomized sorted input quicksort
                QuickSort(sortedArray,0,n-1,true);
                break;
            case 7:
                //STL sort
                sort(array, array + n);
                break;
        }
        auto stop = high_resolution_clock::now();
        auto duration = duration_cast<microseconds>(stop - start);
        sum += duration.count();
        //cout << i + 1 << " : " << is_sorted(array, array + n) << " "<<endl;
        delete[] array;
    }
    return sum / 20;
}

int main()
{
    freopen("output.txt","w",stdout);
    int arraySizes[6]={5,10,100,1000,10000,100000};
    cout<<"n,Merge Sort,Quicksort,Randomized Quicksort,Insertion Sort,Quicksort with Sorted Imput,Randomized Quicksort with Sorted Imput,STL sort() function"<<endl;
    for(int i=0;i<6;i++){
        cout<<arraySizes[i]<<",";
        //first 6 options
        for(int p=1;p<=6;p++){
            cout<<generateReqTime(arraySizes[i],p)/1000<<",";
        }
        //Last option without comma
        cout<<generateReqTime(arraySizes[i],7)/1000<<endl;
 
    }
    //cout << (double)generateReqTime(100000,4) / 1000 << endl;
    fclose(stdout);
}
