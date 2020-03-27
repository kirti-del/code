import java.util.Scanner;
public class arrayinjava
{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args)
    {   
        int n=scn.nextInt();
        int[] arr=new int[n];
        input(arr);
        display(arr);


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
    
}
