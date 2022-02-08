#include<iostream>

using namespace std;
int grdTrvl(int m,int n){
    if(m==1 && n==1) return 1;
    if(m==0 || n==0) return 0;

    return grdTrvl(m-1,n)+grdTrvl(m,n-1);
}
int main(){
    cout<<grdTrvl(3,2);

    return 0;
}