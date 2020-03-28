import java.util.*;
public class rec
{
    public static void printinc(int st,int end)
    {
        if(st==end+1)
        {
            return;
        }
        System.out.print(st+" ");
        printinc(st+1,end);
    }
    public static void printdec(int st,int end)
    {
        if(st==end+1)
        {
            return;
        }
        printdec(st+1,end);
        System.out.print(st+" ");
    }
    public static int factorial(int n)
    {
        if(n<=1)
            return 1;
        int res=factorial(n-1);
        return res*n;
    }
    public static int power(int n,int p)
    {
        if(p==0)
        {
            return 1;
        }
        int res=power(n,p/2);
        res*=res;
        return (p%2==0)?res:res*n;
    }

    //=============recursion with array==========================
    public static void display(int[] arr,int vidx)
    {
        if(vidx==arr.length)
        {
            return;
        }
        System.out.print(arr[vidx]+" ");
        display(arr,vidx+1);
    }
    public static boolean find(int[] arr,int vidx,int data)
    {
        if(vidx==arr.length)
        {
            return false;
        }
        boolean res=false;
        if(arr[vidx]==data)
            res=true;
        res=res||find(arr,vidx+1,data);
        return res;
    }
    public static int maximum(int[] arr,int vidx)
    {
        if(vidx==arr.length-1)
        {
            return arr[vidx];
        }
        return Math.max(maximum(arr,vidx+1),arr[vidx]);

    }
    public static int minimum(int[] arr,int vidx)
    {
        if(vidx==arr.length-1)
        {
            return arr[vidx];
        }
        return Math.min(minimum(arr,vidx+1),arr[vidx]);
    }
    public static int lastindex(int[] arr,int vidx,int data)
    {
        if(vidx==arr.length)
        {
            return -1;
        }
        int recans=lastindex(arr,vidx+1,data);
        if(recans!=-1)
        {
            return recans;
        }
        else
        {
            return (arr[vidx]==data?vidx:-1);
        }
    }
    public static ArrayList<Integer> allindex(int[] arr,int vidx,int data)
    {
        if(vidx==arr.length)
        {
            ArrayList<Integer> base=new ArrayList<>();
            return base;
        }
        ArrayList<Integer> recans=allindex(arr,vidx+1,data);
        if(arr[vidx]==data)
        {
            recans.add(vidx);
        }
        return recans;
    }
    //===================string type===========================================
    public static ArrayList<String> subseq(String str)
    {
        if(str.length()==0)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        char ch=str.charAt(0);
        ArrayList<String> recans=subseq(str.substring(1));
        ArrayList<String> myans=new ArrayList<>();
        myans.addAll(recans);
        for(String s:recans)
        {
            myans.add(ch+s);
        }
        return myans;
    }
    public static String removehi(String str)
    {
        if(str.length()==0)
        {
            return "";
        }
        if(str.length()>1 && str.substring(0,2).equals("hi"))
        {
            return removehi(str.substring(2));
        }
        char ch=str.charAt(0);
        return ch+removehi(str.substring(1));
    }
    public static String removeduplicates(String str)
    {
        if(str.length()==0)
        {
            return "";
        }
        char ch=str.charAt(0);
        String recans=removeduplicates(str.substring(1));
        if(str.length()>1 && ch==recans.charAt(0))
            return recans;
        else
            return ch+recans;
    }
    public static String compression(String str,int idx,int count)
    {
        if(idx==str.length())
        {
            String ans=str.charAt(idx-1)+(count>1?count+"":"");
            return ans;
        }
        char ch=str.charAt(idx-1);
        if(ch==str.charAt(idx))
        {
            return compression(str,idx+1,count+1);
        }
        else
        {
            String ans=(str.charAt(idx-1)+(count>1?count+"":""));
            return ans+compression(str,idx+1,1);
        }
    }
    //====================mazepath==================================
    public static ArrayList<String> mazepath(int sr,int sc,int er,int ec)
    {
        if(sr==er && sc==ec)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> ans=new ArrayList<>();
        if(sr+1<=er)
        {
            ArrayList<String> vertical=mazepath(sr+1,sc,er,ec);
            for(String s:vertical)
            {
                ans.add("V"+s);
            }
        }
        if(sc+1<=ec)
        {
            ArrayList<String> horizontal=mazepath(sr,sc+1,er,ec);
            for(String s:horizontal)
            {
                ans.add("H"+s);
            }
        }
        if(sr+1<=er && sc+1<=ec)
        {
            ArrayList<String> diagnol=mazepath(sr+1,sc+1,er,ec);
            for(String s:diagnol)
            {
                ans.add("D"+s);
            }
        }
        return ans;
    }
    public static ArrayList<String> mazepathmulti(int sr,int sc,int er,int ec)
    {
        if(sr==er && sc==ec)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> ans=new ArrayList<>();
        for(int i=1;i+sc<=ec;i++)
        {
            ArrayList<String> horizontal=mazepathmulti(sr,sc+i,er,ec);
            for(String s:horizontal)
            {
                ans.add("H"+i+s);
            }
        }
        for(int i=1;i+sr<=er;i++)
        {
            ArrayList<String> vertical=mazepathmulti(sr+i,sc,er,ec);
            for(String s:vertical)
            {
                ans.add("V"+i+s);
            }
        }
        for(int i=1;i+sr<=er && i+sc<=ec;i++)
        {
            ArrayList<String> diagnol=mazepathmulti(sr+i,sc+i,er,ec);
            for(String s:diagnol)
            {
                ans.add("D"+i+s);
            }
        }
        return ans;
    }
    //=======================floodfill=======================================
    public static ArrayList<String> floodpath(int sr,int sc,int er,int ec,boolean[][] isdone)
    {
        if(sr==er && sc==ec)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        isdone[sr][sc]=true;
        ArrayList<String> ans=new ArrayList<>();
        if(sr+1<=er && !isdone[sr+1][sc])
        {
            ArrayList<String> down=floodpath(sr+1,sc,er,ec,isdone);
            for(String s:down)
            {
                ans.add(s+"D");
            }
        }
        if(sc+1<=ec && !isdone[sr][sc+1])
        {
            ArrayList<String> right=floodpath(sr,sc+1,er,ec,isdone);
            for(String s:right)
            {
                ans.add(s+"R");
            }
        }
        if(sr-1>=0 && !isdone[sr-1][sc])
        {
            ArrayList<String> up=floodpath(sr-1,sc,er,ec,isdone);
            for(String s:up)
            {
                ans.add(s+"U");
            }
        }
        if(sc-1>=0 && !isdone[sr][sc-1])
        {
            ArrayList<String> left=floodpath(sr,sc-1,er,ec,isdone);
            for(String s:left)
            {
                ans.add(s+"L");
            }
        }
        isdone[sr][sc]=false;
        return ans;
    }

    public static void main(String[] args)
    {
        //printinc(1,10);
        //printdec(1,10);
        //System.out.print(factorial(5));
        //System.out.print(power(3,2));
        int[] arr={1,2,3,8,5,6,8,7};
        //display(arr,0);
        //System.out.print(find(arr,0,6));
        //System.out.print(maximum(arr,0));
        //System.out.print(minimum(arr,0));
        //System.out.print(lastindex(arr,0,8));
        //System.out.print(allindex(arr,0,8));
        //System.out.print(subseq("bcd"));
        //System.out.print(removehi("hithithit"));
        //System.out.print(removeduplicates("abaaad"));
        //System.out.print(compression("abaaad",1,0));
        //System.out.print(mazepath(0,0,2,2));
        //System.out.print(mazepathmulti(0,0,2,2));
        boolean[][] isdone=new boolean[3][3];
        System.out.print(floodpath(0,0,2,2,isdone));
    }
}
