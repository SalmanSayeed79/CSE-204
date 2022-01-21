#include<iostream>
#include<queue>

using namespace std;

int main(){
    int edges[ 10001], lvl[10001],par[10001],path[10001];
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    int T=0;
    cin>>T;
    while(T--){
        int n,x,a;
        cin>>n>>x;
        for(int i=0;i<=x;i++)
            edges[i]=lvl[i]=par[i]=path[i]=-1;
        int ldrNo, snkNo;
        cin>>ldrNo;
        for(int i=0;i<ldrNo;i++)
            cin>>a>>edges[a];
        cin>>snkNo;
        for(int i=0;i<snkNo;i++)
            cin>>a>>edges[a];
        queue<int> Q({1});
        lvl[1]=par[1]=0;
        while(!Q.empty()){
            int u= Q.front();
            Q.pop();
            for(int i=1;i+u<=x && i<=n;i++){
                if(lvl[u+i]==-1){
                    lvl[u+i]=lvl[u]+1;
                    par[u+i]=u;
                   
                    int curr=u+i;
                    while(edges[curr]!=-1 && lvl[edges[curr]]==-1){
                        par[edges[curr]]=curr;
                        curr=edges[curr];
                        lvl[curr]=lvl[u]+1;
                        
                    }
                    if(edges[curr]==-1)Q.push(curr);
                }
            }
        }
        if(lvl[x]==-1){
            cout<<-1<<endl<<"No solution\n";
        }
        else{
            cout<<lvl[x]<<endl;
            int cnt=0,u=x;
            path[cnt++]=x;
            while(par[u]!=1){
                u=par[u];
                path[cnt++]=u;
            }
            path[cnt++]=1;
            cout<<1;
            for(int i=cnt-2;i>-1;i--)
                cout<<" -> "<<path[i];
            cout<<endl;
        }
        int cnt=0;
        for(int i=2;i<=x;i++){
            if(lvl[i]==-1)
            {   cout<<i<<' ';
                cnt++;
            }
        }
        if(!cnt)
            cout<<"All reachable";
        cout<<endl<<endl;
    }

    fclose(stdout);
    fclose(stdin);
    return 0;
}