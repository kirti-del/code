import java.util.ArrayList;
import java.util.LinkedList;
public class graphprac
{
    public static class Edge{
        int v=0;
        int w=0;
        Edge(int val,int wt)
        {
            this.v=val;
            this.w=wt;
        }
        Edge()
        {
        }
    }
    static ArrayList<Edge>[] graph=new ArrayList[7];
    public static void addedge(int u,int v,int w)
    {
        if(v<0 || u<0 || v>=graph.length ||u>=graph.length)
        {
            return;
        }
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }
    public static void case1()
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<Edge>();
        }
        addedge(0,1,10);
        addedge(0,3,40);
        addedge(1,2,20);
        addedge(2,3,1);
        addedge(3,4,6);
        addedge(4,5,2);
        addedge(4,6,2);
        addedge(5,6,8);
    }
    public static void removeEdge(int u,int v)
    {
        for(int i=0;i<graph.length;i++)
        {
            if(graph[u].get(i).v==v)
            {
                graph[u].remove(i);
                break;
            }
        }
        for(int i=0;i<graph[u].size();i++)
        {
            if(graph[v].get(i).v==u)
            {
                graph[v].remove(i);
                break;
            }
        }
    }
    public static void removeVtx(int u)
    {
        for(int i=graph[u].size()-1;i>=0;i--)
        {
            removeEdge(graph[u].get(i).v,u);
        }
    }
    public static boolean hashpath(int src,int dest,boolean[] vis,String ans)
    {
        if(src==dest)
        {
            System.out.println(ans);
            return true;
        }
        boolean res=false;
        vis[src]=true;
        for(Edge e:graph[src])
        {
            int nbr=e.v;
            if(!vis[nbr])
            {
                res=res||hashpath(nbr,dest,vis,ans+nbr+"->");
            }
        }
        vis[src]=false;
        return res;
    }
    public static void allpath(int src,int dest,boolean[] vis,String ans)
    {
        if(src==dest)
        {
            System.out.println(ans);
            return;
        }
        vis[src]=true;
        for(Edge e:graph[src])
        {
            int nbr=e.v;
            if(!vis[nbr])
            {
                allpath(nbr,dest,vis,ans+nbr+"->");
            }
        }
        vis[src]=false;
    }
    public static void preorder(int src,int w,boolean[] vis,String ans)
    {
        System.out.println(ans+src+"->"+"@"+w);
        vis[src]=true;
        for(Edge e:graph[src])
        {
            int nbr=e.v;
            int wt=e.w;
            if(!vis[nbr])
                preorder(nbr,w+wt,vis,ans+src+" ");
        }
        vis[src]=false;
    }
    public static void display()
    {
        for(int i=0;i<graph.length;i++)
        {
            System.out.print(i+"->");
            for(int j=0;j<graph[i].size();j++)
            {
                System.out.print("("+graph[i].get(j).v+","+graph[i].get(j).w+")");
            }
            System.out.println();
        }
    }
    /*static int fwt=0;                   //for max weight
    static String fans="";*/
    static int fwt=101000;                 //for least
    static String fans="";              
    public static void maxwt(int src,int dest,int w,boolean[] vis,String ans)
    {
        if(src==dest)
        {
            if(fwt<w)
            {
                fwt=w;
                fans=ans;
            }
            return;
        }
        vis[src]=true;
        for(Edge e:graph[src])
        {
            int nbr=e.v;
            int wt=e.w;
            if(!vis[nbr])
            {
                maxwt(nbr,dest,w+wt,vis,ans+nbr+"->");
            }
        }
        vis[src]=false;
    }
    public static void lesswt(int src,int dest,int w,boolean[] vis,String ans)
    {
        if(src==dest)
        {
            if(fwt>w)
            {
                fwt=w;
                fans=ans;
            }
            return;
        }
        vis[src]=true;
        for(Edge e:graph[src])
        {
            int nbr=e.v;
            int wt=e.w;
            if(!vis[nbr])
            {
                lesswt(nbr,dest,w+wt,vis,ans+nbr+"->");
            }
        }
        vis[src]=false;
    }
    public static void hamiltonianpathcycle(int src,int osrc,int count,boolean[] vis,String ans)
    {
        if(count+1==graph.length)
        {
            System.out.print(ans);
            for(Edge e:graph[src])
            {
                if(e.v==osrc)
                {
                    System.out.print("cycle");
                }
            }
            System.out.println();
            return;
        }
        vis[src]=true;
        for(Edge e:graph[src])
        {
            int nbr=e.v;
            int wt=e.w;
            if(!vis[nbr])
            {
                hamiltonianpathcycle(nbr,osrc,count+1,vis,ans+src+"->");
            }
        }
        vis[src]=false;
    }
    /*public static void kthlargest(int from,int k,int ele)
    {
        if()
        {
            PriorityQueue<Integer> que=new PriorityQue<Integer>(k);
            if(Edge e:graph[from])
            {
                que.push(k);
                que.top(k);
                que.pop(k);
            }
            return;
        }
    }*/
    public static class bfs
    {
        int vtx=0;
        String psf="";
        int wsf=0;
        bfs(int vtx,String psf,int wsf)
        {
            this.vtx=vtx;
            this.psf=psf;
            this.wsf=wsf;
        }
    }
    public static void bfspair(int src,int dest)
    {
        LinkedList<bfs> que=new LinkedList<>();
        bfs root=new bfs(src,src+"",0);
        que.addLast(root);
        que.addLast(null);
        boolean[] vis=new boolean[7];
        boolean ispath=false;
        int cyclectr=0;
        int level=0;
        while(que.size()!=0)
        {
            bfs rpair=que.removeFirst();
            if(vis[rpair.vtx])
            {
                System.out.print("Cycle->"+cyclectr+" ");
                cyclectr++;
            }
            vis[rpair.vtx]=true;
           
            if(rpair.vtx==dest && !ispath)
            {
                System.out.println(rpair.psf+" "+rpair.wsf+" @"+level);
                ispath=true;
            }
            for(Edge e:graph[rpair.vtx])
            {
                if(!vis[e.v])
                {
                    bfs pair=new bfs(e.v,rpair.psf+e.v,rpair.wsf+e.w);
                    que.addLast(pair);
                }
            }
        }
        if(que.getFirst()==null)
        {
            que.removeFirst();
            que.addLast(null);
            level++;
        }
    }
    public static class dpair{
        int vtx=0;
        int pvtx=0;
        int wt=0;
        int wsf=0;
        String psf="";
        dpair(int vtx,int pvtx,int wt,int wsf,String psf)
        {
            this.vtx=vtx;
            this.pvtx=pvtx;
            this.wt=wt;
            this.wsf=wsf;
            this.psf=psf;
        }
        dpair()
        {

        }
        boolean dpair implements Comparable<dpair>
        {
            return this.wsf-o.wsf;
        }

    }
    public static void main(String[] args)
    {
        case1();
        //removeEdge(3,4);
        //removeVtx(3);
        boolean[] vis=new boolean[7];
        //System.out.println(hashpath(0,6,vis,0+"-> "));
        //display();
        //allpath(0,6,vis,0+"->");
        //preorder(0,0,vis," ");
        //maxwt(0,6,0,vis,"");
        //lesswt(0,6,0,vis,0+"->");
        //System.out.println(fans+" @"+fwt);
        //hamiltonianpathcycle(0,0,0,vis,"");
        //bfspair(0,6);
    }
}
