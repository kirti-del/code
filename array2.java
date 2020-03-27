import java.util.Scanner;
public class find
{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args)
    {   int k=scn.nextInt();
        int n=scn.nextInt();
        int[] arr=new int[n];
        input(arr);
        display(arr);
        System.out.println(find(arr,k));

    }
    public static void input(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=scn.nextInt();

        }
        display(arr);
    }
    public static void display(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static boolean find(int[] arr,int k)
    {    int flag=0;
        for(int i=0;i<arr.length;i++)
          { 
            if(k==arr[i])
            {  flag=1;
               break;
            }
          }
          if(flag==1)
          return true;
          else return false;
   }
}
