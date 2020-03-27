import java.util.ArrayList;
public class mazepath
{

public static void main(String[] args)
{
    ArrayList<String> arr=mazepath(0,2,0,2);
    System.out.println(arr);
}
    public static ArrayList<String> mazepath(int sr,int er,int sc,int ec)
    {
        if(sr==er && sc==ec)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add(" ");
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
        if(sr+1<=ec)
        {
            ArrayList<String> vertical=mazepath(sr+1,er,sc,ec);
            for(String s:vertical)
            {
                ans.add("v"+s);
            }
        }
        return ans;
    }
}
