#include<iostream>
using namespace std;

int fib(int n){
    if(n<2) return 1;
    return fib(n-1)+fib(n-2);
}

int main(){
    cout<<fib(0)<<endl; //1
    cout<<fib(1)<<endl; //1
    cout<<fib(2)<<endl; //2
    cout<<fib(3)<<endl; //3
    cout<<fib(4)<<endl; //5
    cout<<fib(5)<<endl; //8
    cout<<fib(6)<<endl; //13
    cout<<fib(7)<<endl; //21
    cout<<fib(8)<<endl; //34
    cout<<fib(50)<<endl; //34
    return 0;
}