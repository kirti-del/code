import java.util.Scanner;
public class power2                        
{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] arg)
    {
        int n=scn.nextInt();
        int p=scn.nextInt();
        System.out.println(power(n,p));

    }
    public static int power(int n,int p)
    {
        if(p<1)
        return 1;
        int res=power(n,(p/2));
        return (((p&1)==0)?res*res:res*res*n);
        
    }
}
