import java.util.Scanner;
public class rotate{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args)

    { int n=scn.nextInt();
       int r=scn.nextInt();
       System.out.println(rotation(n,r));

    }
    public static int noOfDigits(int n)
    {
        int count=0;
        while(n!=0)
        {
            n/=10;
            count++;
        }
        return count;
    }
    public static int rotation(int n,int r)
    {
        int digit=noOfDigits(n);
        r%=digit;
        r=r<0?r+digit:r;
        int div=1; int mul=1;
        for(int i=1;i<=digit;i++)
        {
            if(i<=r)
            mul*=10;
            else
            div*=10;
        }
        int rem=n%div;
        n=n/div;
        return(rem*mul+n);

    }
} 
