import java.util.ArrayList;
public class diagnol
{
public static void main(String[] args)
{
    //ArrayList<String> arr=mazepath_multi(0,2,0,2);
    boolean[][] isdone=new boolean[8][8];
    int[][] ans=new int[8][8];
    //System.out.println(knightcalls(0,0,0,63,isdone,ans));
    //String[] keys={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    //System.out.println(keypad("245",keys));
   // String ques=new String;
    //ques="abc";
    //System.out.println(permutations("abc"));
    //System.out.println("".length());
    System.out.println(encoding("1146"));
}
    public static ArrayList<String> mazepath(int sr,int er,int sc,int ec)
    {
        if(sr==er && sc==ec)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> ans=new ArrayList<>();
        if(sc+1<=ec)
        {
            ArrayList<String> horizontal=mazepath(sr,er,sc+1,ec);
            for(String s:horizontal)
            {
                ans.add("h"+s);
            }
        }
        if(sr+1<=er)
        {
            ArrayList<String> vertical=mazepath(sr+1,er,sc,ec);
            for(String s:vertical)
            {
                ans.add("v"+s);
            }
        }
        if(sr+1<=er && sc+1<=ec)
        {
            ArrayList<String> diagnol=mazepath(sr+1,er,sc+1,ec);
            for(String s:diagnol)
            {
                ans.add("d"+s);
            }
        }
        return ans;
    }
    
    public static int mazepath_max(int sr,int er,int sc,int ec)
    {
        if(sr==er && sc==ec)
        {
            return 0;
        }
        int maxhei=0;
        if(sc+1<=ec)
        {
            maxhei=Math.max(maxhei,mazepath_max(sr,er,sc+1,ec));
        }
        if(sr+1<=er)
        {
            maxhei=Math.max(maxhei,mazepath_max(sr+1,er,sc,ec));
        }
        if(sr+1<=er && sc+1<=ec)
        {
            maxhei=Math.max(maxhei,mazepath_max(sr+1,er,sc+1,ec));
        }
        return maxhei+1;
    }
        public static ArrayList<String> mazepath_multi(int sr,int er,int sc,int ec)
    {
        if(sr==er && sc==ec)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add(" ");
            return base;

        }
        ArrayList<String> ans=new ArrayList<>();
        for(int i=1;(sc+i<=ec);i++)
        {
            ArrayList<String> horizontal=mazepath_multi(sr,er,sc+1,ec);
            for(String s:horizontal)
            {
                ans.add("h"+i+s);
            }
        }
        for(int i=1;sr+i<=er;i++)
        {
            ArrayList<String> vertical=mazepath_multi(sr+1,er,sc,ec);
            for(String s:vertical)
            {
                ans.add("v"+i+s);
            }
        }
        for(int i=1;(sr+i<=er && sc+i<=ec);i++)
        {
            ArrayList<String> diagnol=mazepath_multi(sr+1,er,sc+1,ec);
            for(String s:diagnol)
            {
                ans.add("d"+i+s);
            }
        }
        return ans;
    }
    public static ArrayList<String> floodpath(int sr,int er,int sc,int ec,boolean isdone[][])
    {
        if(sc==ec && sr==er)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        isdone[sr][sc]=true;
        ArrayList<String> ans=new ArrayList<>();
        if(sr-1>=0 && isdone[sr-1][sc]!=true)
        {
            ArrayList<String> up=floodpath(sr-1,er,sc,ec,isdone);
            for(String s:up)
            {
                ans.add("U"+s);
            }
        }
        if(sc+1<=ec && isdone[sr][sc+1]!=true)
        {
            ArrayList<String> right=floodpath(sr,er,sc+1,ec,isdone);
            for(String s:right)
            {
                ans.add("R"+s);
            }
        }
        if(sr+1<=er && isdone[sr+1][sc]!=true)
        {
            ArrayList<String> down=floodpath(sr+1,er,sc,ec,isdone);
            for(String s:down)
            {
                ans.add("D"+s);
            }
        }
        if(sc-1>=0 && isdone[sr][sc-1]!=true)
        {
            ArrayList<String> left=floodpath(sr,er,sc-1,ec,isdone);
            for(String s:left)
            {
                ans.add("L"+s);
            }
        }
        isdone[sr][sc]=false;
        return ans;
    }
    public static boolean isvalid(int x,int y,boolean[][] isdone)
    {
        if(x>=0 && y>=0 && x<isdone.length && y<isdone.length && isdone[x][y]!=true)
        {
            return true;
        }
        else
        {return false;}
    }
    /*public static int knightcalls(int sr,int er,int sc,int ec,boolean[][] isdone)
    {
        if(sr==er && sc==ec)
        {
             return 1;
        }
        int ctr=0;
        isdone[sr][sc]=true;
        int[] xmove={1,2,2,1,-1,-2,-2,-1};
        int[] ymove={2,1,-1,-2,2,1,-1,-2};
        for(int d=0;d<xmove.length;d++)
        {
            int x=sr+xmove[d];
            int y=sc+ymove[d];
            if (isvalid(x,er,y,ec,isdone))
            {
                System.out.print(x);
                System.out.println(y);
                ctr+=knightcalls(x,er,y,ec,isdone);
            }\
        }
        isdone[sr][sc]=false;
        return ctr;
    }*/
    public static boolean knightcalls(int sr,int sc,int count,int boxsize,boolean[][] isdone,int[][] ans)
    {
        isdone[sr][sc]=true;
        ans[sr][sc]=count;
        if(count==boxsize)
        {
            for(int[] ar:ans)
            {
                for(int j:ar)
                {
                    System.out.print(j+" ");
                }
                System.out.println();
            }
            return true;
        }
        int[] xmove={1,2,2,1,-1,-2,-2,-1};
        int[] ymove={2,1,-1,-2,2,1,-1,-2};
        boolean res=false;
        for(int d=0;d<xmove.length;d++)
        {
            int x=sr+xmove[d];
            int y=sc+ymove[d];
            
            if (isvalid(x,y,isdone))
            {
                res=res || knightcalls(x,y,count+1,boxsize,isdone,ans);
            }
        }
        isdone[sr][sc]=false;
        return res;
    }
    public static ArrayList<String> keypad(String ques,String[] keys)
    {
        if(ques.length()==0)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        char ch=ques.charAt(0);
        String roq=ques.substring(1);
        int idx=ch-'0';
        String word=keys[idx];

        ArrayList<String> myans=new ArrayList<>();
        ArrayList<String> recans=keypad(roq,keys);
        for(String s:recans)
        {
            for(int i=0;i<word.length();i++)
            {
                myans.add(word.charAt(i)+s);
            }
        }
        return myans;
        
    }

    public static ArrayList<String> permutations(String ques)
    {
        if(ques.length()==0)
        {
            ArrayList<String> base1=new ArrayList<>();
            base1.add("");
            return base1;
        }
        /*if(ques.length()==1)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }*/
        char ch=ques.charAt(0);
        String roq=ques.substring(1);
        ArrayList<String> myans=new ArrayList<>();
        ArrayList<String> recans=permutations(roq);
        for(String s:recans)
        {
            for(int i=0;i<=s.length();i++)
            {
            String ans=(s.substring(0,i)+ch+s.substring(i));
            myans.add(ans);
            }
        }
        return myans;
    }
    public static ArrayList<String> encoding(String ques) 
    {
        if(ques.length()==0)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        char ch=ques.charAt(0);
        ArrayList<String> myans=new ArrayList<>();
        if(ch=='0')
        {
           return encoding(ques.substring(1));
        }
        else
        {
            ArrayList<String> recans=encoding(ques.substring(1));
            for(String s:recans)
            {
                char ch1=(char)('a'+ch-'1');
                myans.add(ch1+s);
            }
        }
        if(ques.length()>1)
        {
            char ch1=ques.charAt(1);
            int num=(ch1-'0')*10+(ch-'0');
            if(num<27)
            {
                ArrayList<String> recans=encoding(ques.substring(2));
                for(String s:recans)
                {
                    ch1=(char)('a'+num-1);
                    myans.add(ch1+s);
                }
            }
        }
    return myans;
    }
    public static boolean isvalid1(int x,int r,int c,int[][] matrix)
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                if(matrix[i][j]==x || matrix[j][i]==x)
                return false;
            }
        }
        r/=3;
        c/=3;
        int k=r*3;
        int l=c*3;
        for(int row=0;row<3;row++)
        {
            for(int col=0;col<3;col++)
            {
                if(matrix[row+k][col+l]==x)
                {
                    return false;
                }
            }
        }
       return true;
    }
   
}
