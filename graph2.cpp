#include<iostream>
#include<queue>
#include<list>
#include<vector>
using namespace std;
    
    class Edge{
        public:
        int v=0;
        int w=0;
        Edge(int v,int w)
        {
            this->v=v;
            this->w=w;
        }
        Edge()
        {

        }
    };
    vector<vector<Edge*>> dgraph(7,vector<Edge*>());
    vector<vector<Edge*>> graph(7,vector<Edge*>());
    void addedge(int v,int u,int w)
    {
        if(v<0||u<0||v>=graph.size()||u>=graph.size())
        {
            return;
        }
        graph[u].push_back(new Edge(v,w));
        graph[v].push_back(new Edge(u,w));
    }
    
    void addedge2(int v,int u,int w)
    {
        if(v<0||u<0||v>=dgraph.size()||u>=dgraph.size())
        {
            return;
        }
        dgraph[u].push_back(new Edge(v,w));
        //dgraph[v].push_back(new Edge(u,w));
    }
    void case1()
    {
        addedge(0,3,10);
        addedge(0,1,10);
        //addedge(1,0,10);
        addedge(1,2,10);
       // addedge(2,1,10);
        addedge(2,3,40);
       // addedge(3,2,40);
        addedge(3,4,2);
      //  addedge(4,3,2);
        addedge(4,5,2);
        addedge(4,6,8);
     //   addedge(5,4,2);
        addedge(5,6,3);
     //   addedge(6,5,3);
     //   addedge(6,4,8);
    }
    void display()
    {
        for(int i=0;i<graph.size();i++)
        {
            cout<<i<<"==> ";
            for(int j=0;j<graph[i].size();j++)
            {
                cout<<"("<<graph[i][j]->v<<","<<graph[i][j]->w<<")";
            }
            cout<<endl;
        }
    }
    void display2()
    {
        for(int i=0;i<dgraph.size();i++)
        {
            cout<<i<<"==> ";
            for(int j=0;j<dgraph[i].size();j++)
            {
                cout<<"("<<dgraph[i][j]->v<<","<<dgraph[i][j]->w<<")";
            }
            cout<<endl;
        }
    }

    class dpair{
        public:
        int vtx=0,pvtx=0,wt=0,wsf=0;
        string psf="";
        dpair(int vtx,int pvtx,int wt,int wsf,string psf)
        {
            this->vtx=vtx;
            this->pvtx=pvtx;
            this->wt=wt;
            this->wsf=wsf;
            this->psf=psf;
        }
        dpair()
        {

        }
        bool operator<(const dpair& o) const{
            return this->wsf>o.wsf;
        }
    };
    void dijkstra(int src)
    {
        priority_queue<dpair> que;
        dpair root(src,-1,0,0,to_string(src)+"");
        que.push(root);
        int dest=6;
        bool path=false;
        vector<bool> vis(graph.size(),false);
        while(que.size()>0)
        {
            dpair rpair=que.top();
            que.pop();
            if(vis[rpair.vtx])
            {
                continue;
            }
            if(rpair.vtx==dest && !path)
            {
                cout<<rpair.psf<<" "<<rpair.wsf<<endl;
                path=true;
            }
            
            if(rpair.vtx!=-1)
            {
                addedge2(rpair.vtx,rpair.pvtx,rpair.wt);
            }
            vis[rpair.vtx]=true;
            for(Edge* e:graph[rpair.vtx])
            {
                if(!vis[e->v])
                {
                    dpair npair(e->v,rpair.vtx,e->w,e->w+rpair.wsf,rpair.psf+to_string(e->v));
                    que.push(npair);
                }
            }
        }
    }
    class bfspair{
        public:
        int vtx=0;
        int wsf=0;
        string psf="";
        bfspair(int vtx,int wsf,string psf)
        {
            this->vtx=vtx;
            this->wsf=wsf;
            this->psf=psf;
        }
        bfspair()
        {

        }
    };
    void bfs(int src,int dest)
    {
        list<bfspair> que;
        bfspair root(src,0,to_string(src)+"");
        que.push_back(root);
        vector<bool> visited(graph.size(),false);
        bool path=false;
        int cyclectr=0;
        while(que.size()>0)
        {
            bfspair rpair=que.front();
            que.pop_front();
            if(visited[rpair.vtx])
            {
                cout<<"Cycle number: "<<cyclectr<<endl;
                cyclectr++;
                continue;
            }
            if(rpair.vtx==dest && !path)
            {
                path=true;
                cout<<rpair.vtx<<" @ "<<rpair.wsf<<endl;
            }
            
            for(Edge *e:graph[rpair.vtx])
            {
                if(!visited[e->v])
                {
                    bfspair npair(e->v,rpair.wsf+e->w,to_string(e->v)+rpair.psf+" ");
                    que.push_back(npair);
                }
            }
        }
    }
    bool hashpath(int src,int dest,vector<bool>& vis,string ans)
    {
       
        if(vis[src])
        {
            return false;
        }
        if(src==dest)
        {
            cout<<ans<<endl;
            return true;
        }
         bool res=false;
        vis[src]=true;
        for(Edge* e:graph[src])
        {
            if(!vis[e->v])
            res=res||hashpath(e->v,dest,vis,ans+to_string(e->v)+" ");
        }
        return res;
    }
    void bfsss(int src,int dest)
    {
        list<bfspair> que;
        bfspair root(src,0,to_string(src)+" ");
        que.push_back(root);
        bool ispath=false;
        vector<bool> vis(graph.size(),false);
        while(que.size()>=0)
        {
            bfspair rpair=que.front();
            que.pop_front();
            if(!vis[rpair.vtx])
            {
                continue;
            }
            if(rpair.vtx==dest && !ispath)
            {
                cout<<rpair.vtx<<" "<<endl;
                ispath=true;
            }
            
            vis[rpair.vtx]=true;
            for(Edge *e:graph[rpair.vtx])
            {
                if(!vis[e->v])
                {
                    bfspair npair(e->v,rpair.wsf+e->w,to_string(e->v)+" "+rpair.psf);
                    que.push_back(npair);
                }
            }
        }
    }
    bool topologicalsort(int src,vector<int>& st,vector<bool>& vis,vector<bool>& cycle)
    {
        vis[src]=true;
        for(Edge* e:graph[src])
        {
            if(!vis[e->v])
            {
                topologicalsort(e->v,st,vis,cycle);
            }
            else if(cycle[e->v])
            {
                return false;
            }
        }
        cycle[src]=false;
        st.push_back(src);
        return true;
    }  class sort
    {
        public:
        int v=0;
        sort(int v)
        {
            this->v=v;
        }
        sort()
        {}
    };
    void toposortbfs()
    {
        list<sort> que;
        vector<int> val;
        int ctr=0;
         vector<int> count(graph.size(),0);
         for(int i=0;i<graph.size();i++)
         {
             for(Edge* e:graph[i])
             {
                count[e->v]++;
             }
             if(count[i]==0)
             {
                que.push_back(i); 
             }
         }
        while(que.size()>0)
        {
            sort rpair=que.front();
            que.pop_front();
            val.push_back(rpair.v);
            
            for(Edge* e:graph[rpair.v])
            {
                if(--count[e->v]==0)
                {
                    que.push_back(e->v);
                }
                ctr++;
            }
            /*if(ctr!=rpair.v)
            {
                cout<<"Cycle ";
                return;
            }*/
            
        }
        for(int i=0;i<val.size();i++)
            {
                cout<<val[i]<<" ";
            }
    }
    int main(int args,char** argv)
    {
        case1();
        //dijkstra(0);
        //display2();
        vector<bool> cycle(graph.size(),false);
        vector<bool> vis(graph.size(),false); 
        vector<int> count(graph.size(),0);
        //cout<<hashpath(0,6,vis,"");
        //bfs(0,6);
        //bfsss(0,6);
        /*cout<<topologicalsort(0,st,vis,cycle);
        for(int i=st.size()-1;i>=0;i--)
        {
            cout<<st[i]<<" ";
        }*/
        toposortbfs();


    }
