import java.util.*;
public class binarytree
{
    public static class Node
    {
        int data=0;
        Node right=null;
        Node left=null;
        Node()
        {}
        Node(int data)
        {
            this.data=data;
        }
        Node(int data,Node left,Node right)
        {
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    static int idx=0;
    public static Node createtree(int[] arr)
    {
        if(arr[idx]==-1 || idx==arr.length)
        {
            idx++;
            return null;
        }
        Node node=new Node(arr[idx]);
        idx++;
        node.left=createtree(arr);
        node.right=createtree(arr);
        return node;
    }
    public static void display(Node node)
    {
        if(node==null)
        {
            return;
        }
        String ans="";
        ans+=node.left!=null?node.left.data:".";
        ans+="<-"+node.data+"->";
        ans+=node.right!=null?node.right.data:".";
        System.out.println(ans);
        display(node.left);
        display(node.right);
    }
    public static boolean finddata(Node node,int data)
    {
        if(node==null)
        {
            return false;
        }
        if(node.data==data)
        {
            return true;
        }
        boolean res=false;
        res=res||finddata(node.left,data);
        res=res||finddata(node.right,data);
        return res;
    }
    public static int size(Node node)
    {
        int ctr=0;
        if(node==null)
        {
            return 0;
        }
        ctr+=size(node.left);
        ctr+=size(node.right);
        return ctr+1;
    } 
    public static int height(Node node)
    {
        if(node==null)
        {
            return -1;
        }
        int lh=0;
        int rh=0;
        lh+=height(node.left);
        rh+=height(node.right);
        return Math.max(lh,rh)+1;
    }
    public static ArrayList<Node> nodetoroot(int root,Node node)
    {
        if(node==null)
            return null;
        if(root==node.data)
        {
            ArrayList<Node> base=new ArrayList<>();
            base.add(node);
            return base;
        }
        ArrayList<Node> left=nodetoroot(root,node.left);
        if(left!=null)
        {
            left.add(node);
            return left;
        }
        ArrayList<Node> right=nodetoroot(root,node.right);
        if(right!=null)
        {
            right.add(node);
            return right;
        }
        return null;
    }
    public static int LCA_01(Node node,int data1,int data2)
    {
        ArrayList<Node> list1=nodetoroot(data1,node);
        ArrayList<Node> list2=nodetoroot(data2,node);
        if(list1==null || list2==null)
            return -1;
        int i=list1.size()-1;
        int j=list2.size()-1;
        int prev=0;
        while(i>=0 && j>=0)
        {
            if(list1.get(i).data!=list2.get(j).data)
                break;
            prev=list1.get(i).data;
            i--;
            j--;
        }
        return prev;
    }
    public static int diameter(Node node)
    {
        if(node==null)
            return 0;
        
        int ld=diameter(node.left);
        int rd=diameter(node.right);

        int lh=height(node.left);
        int rh=height(node.right);

        return Math.max(Math.max(rd,ld),lh+rh+2);
    }
    static int maxdia=0;
    public static int diameter_02(Node node)
    {
        if(node==null)
            return -1;

        int ld=diameter_02(node.left);
        int rd=diameter_02(node.right);

        maxdia=Math.max(maxdia,ld+rd+2);
        return Math.max(ld,rd)+1;
    }
    static int max_=(int) -1e7;
    public static int maxsum(Node node)
    {
        if(node==null)
            return (int) -1e7;
        
        int lsum=maxsum(node.left);
        int rsum=maxsum(node.right);
        if(node.left!=null && node.right!=null)
            max_=Math.max(max_,lsum+rsum+node.data);
        
        return (node.left==null?rsum:node.right==null?lsum:Math.max(lsum,rsum))+node.data;
    }
    public static int nodetonode(Node node)
    {
        if(node==null)
            return 0;
        
        int ld=nodetonode(node.left);
        int rd=nodetonode(node.right);
        max_=Math.max(max_,ld+rd+node.data);
        int sidenode=Math.max(ld,rd)+node.data;
        max_=Math.max(Math.max(max_,sidenode),Math.max(ld+rd+node.data,node.data));
        return Math.max(sidenode,max_);
    }
    static int ans=0;
    static String path="";
    public static void pathsum(Node node,int tar,int prefixsum,HashMap<Integer,Integer> map)
    {
        if(node==null)
        {
            return;
        }

        prefixsum+=node.data;
        ans+=map.getOrDefault(prefixsum-tar,0);

        map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);

        pathsum(node.left,tar,prefixsum,map);
        pathsum(node.right,tar,prefixsum,map);

        map.put(prefixsum,map.getOrDefault(prefixsum,1)-1);
    }
    static int cameracount=0;
    // -1 camera reqd
    // 0 i m a camera
    // 1 not reqd
    public static int camera(Node node)
    {
        if(node==null)
            return 1;
        
        int left=camera(node.left);
        int right=camera(node.right);

        if(left==-1 || right==-1)
        {   
            cameracount++;
            return 0;
        }
        if(left==0 || right==0)
        {
            return 1;
        }
        return -1;
    }
    public static Node createBST(int[] arr,int si,int ei)
    {
        if(si>ei)
        return null;

        int mid=(si+ei)>>1;
        Node node=new Node(arr[mid]);

        node.left=createBST(arr,si,mid-1);
        node.right=createBST(arr,mid+1,ei);

        return node;
    }
    public static boolean findinBST(Node node,int data)
    {
        while(node!=null)
        {
            if(node.data==data)
            return true;

            else if(data<node.data)
            {
                node=node.left;
            }
            else 
                node=node.right;
        }
        return false;
    }
    public static class pair{
        int size=0;
        int height=0;
        boolean find=false;

        int ceil=Integer.MAX_VALUE;
        int floor=Integer.MIN_VALUE;

        int prev=0;
        int pred=0;
        int succ=0;
    }
    public static void allsolution(Node node,int level,pair p,int data)
    {
        if(node==null)
            return;
        p.height=Math.max(p.height,level);
        p.size++;

        p.find=p.find||node.data==data;
        
        if(node.data==data && p.pred==0 )
        {
            p.pred=p.prev;
        }
        if(p.prev==data && p.succ==0 && p.prev!=0)
        {
            p.succ=node.data;
        }
        if(node.data<data)
        {
            p.floor=Math.max(p.floor,node.data);
        }
        if(node.data>data)
        {
            p.ceil=Math.min(p.ceil,node.data);
        }
        //p.prev=node.data;         //PRE order
        allsolution(node.left,level+1,p,data);
        //p.prev=node.data;          //In order
        allsolution(node.right,level+1,p,data);
        p.prev=node.data;          //Post order
    }
    public static void inorderpredsuc(Node node,int data)
    {
        pair p;
        while(node!=null)
        {
            if(node.data==data)
            {
                if(node.left!=null)
                {
                    p.floor=p.prev;
                }
                if(node.left!=null)
                {
                    p.succ=node.right;
                }
            }
        }
    }
    public static void main(String[] args)
    {
    //     int[] arr={10,20,40,60,-1,-1,70,-1,-1,50,80,-1,-1,-1,30,90,-1,110,150,-1,-1,-1,120,-1,-1,-1};
    //     Node node=createtree(arr);
        // display(node);
        // System.out.println(size(node));
        // System.out.println(finddata(node,30));
        //System.out.println(height(node));
        //System.out.println(nodetoroot(80,node));
        //System.out.println(LCA_01(node,60,80));
        // System.out.println(diameter_02(node));
        // System.out.println(maxdia);
        // System.out.println(maxsum(node));
        // System.out.println(max_);
        // System.out.println(nodetonode(node));
        // // System.out.println(max_);
        // HashMap<Integer,Integer> map=new HashMap<>();
        // map.put(0,1);
        // pathsum(node,10,0,map);
        // System.out.println(ans);
        // int val=camera(node);
        // if(val==-1)
        // {
        //     cameracount++;
        // }
        // System.out.println(cameracount);
        int[] arr={2,6,10,25,36,37,39,40,52,68,72};
        Node node=createBST(arr,0,arr.length-1);
        // display(node);
        //System.out.println(findinBST(node,1));
        // pair p=new pair();
        allsolution(node,0,p,10);
        // System.out.println("FLOOR = "+p.floor);
        // System.out.println("CEIL = "+p.ceil);
        // System.out.println("PREDECESSOR = "+p.pred);
        // System.out.println("SUCCESSOR = "+p.succ);
    }
}
