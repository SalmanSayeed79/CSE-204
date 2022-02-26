#include<iostream>
#include<string>
#include<cstring>

using namespace std;
long long int max(long long int a,long long int b){
    if(a>b) return a;
    return b;
}
string memo="";
long long int lcsRecursive(string a,string b,int first,int second){
    if(a[first]=='\0' || b[second]=='\0') {
        //cout<<"Null char reached"<<endl;
        //cout<<memo<<endl;
        return 0;}
    else if (a[first]==b[second]) {
        // strncat(memo,&a[first],1);
        cout<<"Current string1 : ";
        for(int i=0;i<first;i++){
            cout<<a[i];
        }
        cout<<"   Current String 2 : ";
        for(int i=0;i<second;i++){
            cout<<b[i];
        }
        cout<<endl;
        memo+=a[first];
        return 1+lcsRecursive(a,b,first+1,second+1);
        }
    else return max(lcsRecursive(a,b,first+1,second),lcsRecursive(a,b,first,second+1));
}
int main(){
    char *string1;
    char *string2;

    string s1,s2;
    cin>>s1;
    cin>>s2;
    // s1.strcpy(string1);
    // string2.strcpy(s2);
    // cout<<string1[2];
    long long int count=lcsRecursive(s1,s2,0,0);
    cout<<count<<endl;
    // for(int i=0;i<count;i++){
    //     cout<<memo[memo.length()-i-1];
    // }
    cout<<memo<<endl;
    return 0;
}