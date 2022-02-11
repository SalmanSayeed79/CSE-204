#include<iostream>

using namespace std;

int seqGenerator[10001][10001];
int dp[10001][10001];
int getLCS_DP(string str1,string str2){
    //int dp[str1.length()+1][str2.length()+1];
    //cout<<str1.length();
    // for(int i=0;i<=str1.length();i++){
    //     for(int j=0;j<=str2.length();j++){
    //         *(*(dp+j)+i)=1;
    //         *(*(seqGenerator+j)+i)=1;
    //     }
    // }
    for(int i=0;i<=str1.length();i++)    dp[0][i]=0;  
    for(int i=0;i<=str2.length();i++)    dp[i][0]=0;      
    
    for(int i=1;i<=str1.length();i++){
        //cout<<"I="<<i<<endl;
        for(int j=1;j<=str2.length();j++){
            //cout<<"J="<<j<<endl;
            if(str1[i-1]==str2[j-1])    {
                dp[i][j]=1+dp[i-1][j-1];
                seqGenerator[i][j]=1;  
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                dp[i][j]=dp[i-1][j];
                seqGenerator[i][j]=2;  
            }
            else{
                int p=dp[i][j-1];
                dp[i][j]=dp[i][j-1];
                seqGenerator[i][j]=3;
            }

        }
    }
    // for(int i=0;i<=str1.length();i++){
    //     for(int j=0;j<=str2.length();j++){
    //         //cout<<*(*(dp+j)+i)<<" ";
    //         cout<<dp[i][j]<<" ";

    //     }
    //     cout<<endl;
    // }
    return dp[str1.length()][str2.length()];
}
string constructLCS(string str1,string str2){
    int len1=str1.length();
    int len2=str2.length();
    string output="";
    int i=len1;
    int j=len2;
    while(i>0 && j>0){
        //cout<<i<<" "<<j<<endl;
        //cout<<"Current value :"<<seqGenerator[i][j]<<endl;
        //i--;j--;
        if(seqGenerator[i][j]==1){
            //cout<<"Match ! Added :"<<str1[i-1]<<endl;
            output+=str1[i-1];
            i--;
            j--;
        }
        else if(seqGenerator[i][j]==2){
            i--;
        }
        else if(seqGenerator[i][j]==3){
             j--;
        }
       
    }
    //reversing the output
    string temp="";
    for(int i=output.length();i>=0;i--){
        temp+=output[i];
    }
    output=temp;

    return output;
}
int main(){
    long long int **table;
    char *string1;
    char *string2;

    string s1,s2;
    cin>>s1;
    cin>>s2;
    cout<<getLCS_DP(s1,s2)<<endl;
    cout<<constructLCS(s1,s2)<<endl;

    return 0;
}