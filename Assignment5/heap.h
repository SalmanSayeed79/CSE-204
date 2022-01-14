#include<iostream>
#include<vector>

using namespace std;

class Heap {
private:
    int* heap;
    int maxSize;
    int n;
    int leftChild(int pos){
        return 2*pos + 1;
    }

    int rightChild(int pos){
        return 2*pos + 2;
    }

    int parent(int pos){
        return (pos - 1) / 2;
    }
    void swapValues(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    int shiftUp(int pos){
        if(pos >= n) return -1;
        while((pos != 0) && heap[pos] > heap[parent(pos)]){
            swapValues(pos, parent(pos));
            pos = parent(pos);
        }
        return pos;
    }

    void shiftDown(int pos){
        while(!isLeaf(pos)){
            int maxPos = leftChild(pos);
            if(maxPos < n - 1 && heap[maxPos] < heap[maxPos + 1]) maxPos++;
            if(heap[pos] > heap[maxPos]) return;
            swapValues(pos, maxPos);
            pos = maxPos;
        }
    }

    bool isLeaf(int pos){
        return (pos >= n/2) && (pos < n);
    }

    

public: 
    Heap(int maxSize){
        n = 0;
        this->maxSize = maxSize;
        heap = new int[maxSize];
        
    }

    Heap(vector<int> &elements){
        this->maxSize = elements.size();
        n = maxSize;
        this->heap = new int[maxSize];
        for(int i=0;i<elements.size();i++){
            heap[i]=elements.at(i);
        }
        heapify();
    }

    int size(){
        return n;
    }

    int getMax(){
        return heap[0];//Top value is basically the root
    }

    void insert(const int& element){
        heap[n++] = element;
        shiftUp(n - 1); //(n-1) because n got increased
    }

    int deleteKey(){
        swapValues(0, --n);
        if(n != 0) shiftDown(0);
        return heap[n];
    }

    //Heapify
    void heapify(){
        for(int i = n / 2 - 1; i >= 0; i--){
            shiftDown(i);
        }
    }

    // For testing reasons
    void printHeap(){
        for(int i=0;i<n;i++){
            cout<<heap[i]<<endl;
        }
    }

};

void heapsort(vector<int>&v){
    Heap h(v);
    for(int i = 0; i < v.size(); i++){
        v[i] = h.deleteKey();
    }
}