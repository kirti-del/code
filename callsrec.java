public class calls
{
    public static int calls(int n)
    {
        if(n<=1)
        {
            System.out.println("base:"+n);
            return n+1;
        }
        int count=0;
        System.out.println("pre:"+n);
        count+=calls(n-1);
        System.out.println("in:"+n);
        count+=calls(n-2);
        System.out.println("post:"+n);
        return count+3;
    }
    public static void main(String s[])
    {
        int n=4;
        System.out.println(calls(n));
    }
}
