public class stairs
{
    public static void main(String[] s)
    {
        int n=4;
        System.out.println(stairs(n));
    }
    public static int stairs(int n)
    {
        int count=0;
        if(n==0)
        {
            return 1;
        }
        if(n-1>=0)
        {
            count+=stairs(n-1);
        }
        if(n-2>=0)
        {
            count+=stairs(n-2);
        }
        if(n-3>=0)
        {
            count+=stairs(n-3);
        }
        return count;
    }
}
