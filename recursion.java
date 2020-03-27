import java.util.ArrayList;
public class rec
{
    public static void print(int st,int end)
    {
        if(st==end+1)
        {
            return;
        }
        System.out.println(st+" ");
        print(st+1,end);
    }
    public static void printdec(int st,int end)
    {
        if(end==st-1)
        {
            return;
        }
        printdec(st,end-1);
        System.out.println(end);
    }
    public static int returntype(int st,int end)
    {
        if(st==end)
        {
            return st;
        }
        int head=returntype(st+1,end);
        System.out.println(head);
        return head-1;
    }
    public static int factorial(int n)
    {
        if(n==0)
        {
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int power(int base,int n)
    {
        if(n==0)
        {
            return 1;
        }
        int recans=power(base,n/2);
        recans*=recans;
        return (n%2==0)?recans:recans*base;
    }
    public static void display1d(int[] arr,int vidx)
    {
        if(vidx==arr.length)
        {
            return;
        }
        System.out.print(arr[vidx]+" ");
        display1d(arr,vidx+1);
    }
    public static int maximum(int[] arr,int vidx)
    {
        if(vidx==arr.length-1)
        {
            return arr[vidx];
        }
        int recans=maximum(arr,vidx+1);
        if(arr[vidx]>recans)
        {
            return arr[vidx];
        }
        else
        return recans;
    }
    public static int minimum(int[] arr,int vidx)
    {
        if(vidx==arr.length-1)
        {
            return arr[vidx];
        }
        int recans=minimum(arr,vidx+1);
        if(arr[vidx]<recans)
        {
            return arr[vidx];
        }
        else
        {
            return recans;
        }
    }
    public static int lastindex(int[] arr,int vidx,int data)
    {
        if(vidx==0)
        {
            return -1;
        }
        int recans=lastindex(arr,vidx-1,data);
        if(arr[vidx]==data)
        {
            return vidx;
        }
        else 
        return recans;
    }
    public static int[] allindex(int[] arr,int vidx,int data,int size)
    {
        if(vidx==arr.length)
        {
            int[] basearray=new int[size];
            return basearray;
        }
        if(arr[vidx]==data)
        {
            size++;
        }
        int[] recans=allindex(arr,vidx+1,data,size);
        if(arr[vidx]==data)
        {
            recans[size-1]=vidx;
        }
        return recans;
    }
    public static int stairs(int n)
    {
        if(n==0)
        {
            return 1;
        }
        int count=0;
        if(n-1>=0)
        count+=stairs(n-1);
        if(n-2>=0)
        count+=stairs(n-2);
        if(n-3>=0)
        count+=stairs(n-3);
        return count;
    }
    public static ArrayList<String> subseq(String str)
    {
        if(str.length()==0)
        {
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        char ch=str.charAt(0);
        ArrayList<String> myans=new ArrayList<>();
        ArrayList<String> recans=subseq(str.substring(1));
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
        else{
            char ch=str.charAt(0);
            return ch+removehi(str.substring(1));
        }
    }
    public static String removehi2(String str)
    {
        if(str.length()==0)
        {
            return "";
        }
        if(str.length()>2 && str.substring(0,2).equals("hi"))
        {
            if(str.substring(0,3).equals("hit"))
            {
                char ch=str.charAt(0);
                return ch+removehi2(str.substring(1));
            }
            else{
                return removehi2(str.substring(2));
            }
        }
        else
        {
            char ch=str.charAt(0);
            return ch+removehi2(str.substring(1));
        }
    }
    /*public static String removedupli(String str)
    {
        if(str.length()==0)
        {
            return "";
        }
        char ch=str.charAt(0);
        String recans=removedupli(str.substring(1));
        if(ch==recans.charAt(0))
        {
            return recans;
        }
        else
        {
            return ch+recans;
        }
    }*/
    public static void main(String[] args)
    {
        //print(1,10);
        //printdec(1,10);
        //returntype(1,10);
        //System.out.println(factorial(5));
        //System.out.println(power(3,3));
        int[] arr={1,2,3,100,6,100,7};
        //display1d(arr,0);
        //System.out.println(maximum(arr,0));
        //System.out.println(minimum(arr,0));
        //System.out.println(lastindex(arr,arr.length-1,9));
        //int[] ans=allindex(arr,0,100,0);
        /*for(int i=0;i<ans.length;i++)
        {
            System.out.print(ans[i]+" ");
        }*/
        String str="aabbbccccc";
        //System.out.println(subseq(str));
        //System.out.println(removehi2(str));
       // System.out.println(removedupli(str));
       System.out.println(sub("abc"));
    }
    public String changePi(String str) {
  if(str.length()==0)
  {
    return "";
  }
  char ch=str.charAt(0);
  String myans=new String();
  myans=changePi(str.substring(1));
  if(str.length()>1 && str.substring(0,2).equals("pi"))
  {
    String recans=changePi(str.substring(2));
  return "3.14"+recans;
  }
  else
  {
  return ch+myans;
  }
}
public String noX(String str) {
  if(str.length()==0)
  {
    return "";
  }
  char ch=str.charAt(0);
  String recans=noX(str.substring(1));
  if(ch=='x')
  {
    return recans;
  }
  return ch+recans;
}
public boolean array6(int[] nums, int index) {
  if(index==nums.length)
  {
    return false;
  }
  if(nums[index]==6)
  {
    return true;
  }
  return array6(nums,index+1);
}
public int array11(int[] nums, int index) {
  if(index==nums.length)
  {
    return 0;
  }
  int ctr=0;
  if(nums[index]==11)
  {
    ctr++;
  }
  return ctr+array11(nums,index+1);
}
public String allStar(String str) {
  if(str.length()==0)
  {
    return "";
  }
  char ch1=str.charAt(str.length()-1);
  char ch=str.charAt(0);
  if(str.length()>1)
  {
    return ch+"*"+allStar(str.substring(1));
  }
  return allStar(str.substring(1))+ch;
}
public String pairStar(String str) {
if(str.length()==0)
{
  return "";
}
String recans=pairStar(str.substring(1));
if(str.length()>1 && str.charAt(0)==str.charAt(1))
{
  return str.charAt(0)+"*"+recans;
}
return str.charAt(0)+recans;
}
public String endX(String str) {
  if(str.length()==0)
  {
    return "";
  }
  char ch=str.charAt(0);
  String recans=endX(str.substring(1));
  if(ch=='x')
  {
    return recans+ch;
  }
  return ch+recans;
}
public int countPairs(String str) {
  if(str.length()==0)
  {
    return 0;
  }
  int ctr=0;
  if(str.length()>2 && str.charAt(0)==str.charAt(2))
  {
    ctr++;
  }
  return ctr+countPairs(str.substring(1));
}
public int countAbc(String str) {
  if(str.length()==0)
  {
    return 0;
  }
  int ctr=0;
  if(str.length()>2 && str.substring(0,3).equals("abc"))
  {
    ctr++;
  }
  if(str.length()>2 && str.substring(0,3).equals("aba"))
  {
    ctr++;
  }
  return ctr+countAbc(str.substring(1));
}
public String stringClean(String str) {
  if(str.length()==0)
  {
    return "";
  }
  char ch=str.charAt(0);
  if(str.length()>1 && ch==str.charAt(1))
  {
    return stringClean(str.substring(1));
  }
  return ch+stringClean(str.substring(1));
}
public int strCount(String str, String sub) {
  if(str.length()==0)
  {
    return 0;
  }
  int ctr=0;
  if(str.length()>=sub.length() && str.substring(0,sub.length()).equals(sub))
  {
    ctr++;
  }
  return ctr+strCount(str.substring(1),sub);
}
public boolean strCopies(String str, String sub, int n) {
  if(str.length()<sub.length())
  {
    if(n==0)
    return true;
    return false;
  }
  if(str.substring(0,sub.length()).equals(sub))
  {
    return true && strCopies(str.substring(sub.length()),sub,n-1);
  }
  return true&&strCopies(str.substring(sub.length()),sub,n);

}
public static ArrayList<String> sub(String ques)
{
    if(ques.length()==0)
    {
        ArrayList<String> base=new ArrayList<>();
        base.add("");
        return base;
    }
    char ch=ques.charAt(ques.length()-1);
    String roq=ques.substring(0,ques.length()-1);
    ArrayList<String> recans=sub(roq);
    ArrayList<String> myans=new ArrayList<>();
    myans.addll(recans);
    for(String s:recans)
    {
        myans.add(ch+s);
    }
    return myans;
}
}
