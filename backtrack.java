import java.util.ArrayList;
public class backtrack
{
    public static ArrayList<String> mobile(String str,String[] keys)
    {
        if(str.length()==0)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        char ch=str.charAt(0);
        int idx=ch-'0';
        String word=keys[idx];
        ArrayList<String> myans=new ArrayList<>();
        ArrayList<String> recans=mobile(str.substring(1),keys);

        for(String s:recans)
        {
            for(int i=0;i<word.length();i++)
            {
                myans.add(word.charAt(i)+s);
            }
        }
        return myans;
    }
    public static boolean isvalid(int x,int y,boolean[][] isdone)
    {
        if(x>=0 && y>=0 && x<isdone.length && y<isdone[0].length && !isdone[x][y])
        {
            return true;
        }
        return false;
    }
    public static ArrayList<String> floodfill(int sr,int sc,int er,int ec,boolean[][] isdone)
    {
        if(sr==er && sc==ec)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> ans=new ArrayList<>();
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        String[] dirname={"L","R","U","D","dia1","dia2","dia3","dia4"};
        isdone[sr][sc]=true;
        for(int d=0;d<dir.length;d++)
        {
            int x=sr+dir[d][0];
            int y=sc+dir[d][1];
            if(isvalid(x,y,isdone))
            {
               ArrayList<String> recans=floodfill(x,y,er,ec,isdone);
                for(String s:recans)
                {
                    ans.add(dirname[d]+s);
                }
            }
        }
        isdone[sr][sc]=false;
        return ans;
    }
    public static int knightpath(int sr,int sc,int er,int ec,boolean[][] isdone,String ans)
    {
        if(sr==er && sc==ec)
        {
            System.out.println(ans);
            return 1;
        }
        //System.out.println(ans);
        int[][] dir={{2,1},{1,2}};//,{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
        isdone[sr][sc]=true;
        int count=0;
        for(int d=0;d<dir.length;d++)
        {
            int x=sr+dir[d][0];
            int y=sc+dir[d][1];
            if(isvalid(x,y,isdone))
            {
                count+=knightpath(x,y,er,ec,isdone,ans+"("+x+","+y+"), ");
            }
        }
        isdone[sr][sc]=false;
        return count;
    }
    public static boolean isvalid_sudoku(int i,int j,int num,int[][] board)
    {
        for(int idx=0;idx<board.length;idx++)
        {
            if(board[idx][j]==num)
            {
                return false;
            }
        }

        for(int idx=0;idx<board[0].length;idx++)
        {
            if(board[i][idx]==num)
            {
                return false;
            }
        }

        int r=(i/3)*3;
        int c=(j/3)*3;

        for(int row=0;row<3;row++)
        {
            for(int col=0;col<3;col++)
            {
                if(board[r+row][c+col]==num)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudoku(int[][] board,int vidx)
    {
        if(vidx==board.length*board[0].length)
        {
            for(int[] ar:board)
            {
                for(int ele:ar)
                {
                    System.out.print(ele+" ");
                }
                System.out.println();
            }
            System.out.println();
            return true;
        }
        
        int r=vidx/9;
        int c=vidx%9;
        boolean res=false;
        if(board[r][c]!=0)
        {
            res=res||sudoku(board,vidx+1);
        }
        else
        {   
        for(int num=1;num<=9;num++)
        {
            if(isvalid_sudoku(r,c,num,board))
            {
                board[r][c]=num;
                res=res||sudoku(board,vidx+1);
                board[r][c]=0;
            }
        }
        }
        return res;
     }
    // public static void nqueenscombi(int boxes,int tnq,int qloc,int qpsf,String ans)
    // {
    //     if(qpsf==tnq || qloc>=boxes)
    //     {
    //         if(qpsf==tnq)
    //         {
    //             System.out.print(ans+" ");
    //         }
    //         return;
    //     }
    //     nqueenscombi(boxes,tnq,qloc+1,qpsf+1,ans+"("+qloc+"@"+qpsf+") ");
    //     nqueenscombi(boxes,tnq,qloc+1,qpsf,ans);
    // }
    public static int nqueenscombi(int boxes,int tnq,int qloc,int qpsf,String ans)
    {
            if(qpsf==tnq)
            {
                System.out.println(ans);
                return 1;
            }
            
        int count=0;
        for(int i=qloc+1;i<=boxes;i++)
        {
            count+=nqueenscombi(boxes,tnq,i,qpsf+1,ans+"b"+(i)+"q"+(qpsf)+" ");
        }
        return count;
    }
    public static int nqueenscombi2(int boxes,int tnq,boolean[] loc,int qloc,int qpsf,String ans)
    {
        if(qpsf==tnq || qloc>=boxes)
        {
            if(qpsf==tnq)
            {System.out.print(ans+" ");
            return 1;}
            return 0;
        }
        int count=0;
        //loc[qloc]=true;
        if(!loc[qloc])
        {
            loc[qloc]=true;
            count+=nqueenscombi2(boxes,tnq,loc,qloc+1,qpsf+1,ans+"b"+(qloc+1)+"q"+(qpsf+1)+"");
            loc[qloc]=false;
        }
        count+=nqueenscombi2(boxes,tnq,loc,qloc+1,qpsf,ans);
        return count;
    }
    public static void main(String[] args)
    {
        String[] keys={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
       // System.out.println(mobile("245",keys));
       boolean[][] isdone={{false,false,false,false,false,false,false,false,false}};
       //System.out.println(floodfill(0,0,2,2,new boolean[3][3]));
       //System.out.println(knightpath(0,0,3,3,new boolean[4][4],"(0,0), "));
        int[][] board={{3,0,6,5,0,8,4,0,0},
                       {0,0,0,0,0,0,0,0,0},
                       {0,8,7,0,0,0,0,3,1},
                       {9,0,0,8,6,3,0,0,5},
                       {0,5,0,0,9,0,6,0,0},
                       {1,3,0,0,0,0,2,5,0},
                       {0,0,0,0,0,0,0,7,4},
                       {0,0,5,2,0,6,3,0,0}};
       // System.out.println(sudoku(board,0));    
        int n=nqueenscombi2(7,3,new boolean[8],0,0,"");
    }
}
