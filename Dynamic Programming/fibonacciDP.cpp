#include<iostream>
using namespace std;

// 1 1 2 3 5 8......
long long int fib(int n){
    long long int *fibArray=new long long int(n+1);
    fibArray[0]=1;
    fibArray[1]=1;
    for(int i=2;i<=n;i++){
        fibArray[i]=fibArray[i-1]+fibArray[i-2];
    }
    return fibArray[n];
}
int main(){
    cout<<fib(69);
    return 0;
}