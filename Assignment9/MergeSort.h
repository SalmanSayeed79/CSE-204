#include<iostream>
using namespace std;

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