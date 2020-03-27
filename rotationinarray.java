import java.util.Scanner;
public class rotatearray
{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args)
    {   
        System.out.print("Enter the size of the array ");
        int n=scn.nextInt();
        System.out.print("Enter the no of rotations ");
        int r=scn.nextInt();
        int[] arr=new int[n];
        input(arr);
        reverse(arr,r,n);
        rotatearray(arr,r,n);
        display(arr);
    }
public static void input(int[] arr)
{
    for(int i=0;i<arr.length;i++)
    {
        arr[i]=scn.nextInt();
    }
    System.out.println();

}

public static void rotatearray(int[] arr,int r,int l)
{
    reverse(arr,0,r);
    reverse(arr,r,l);
    reverse(arr,0,l);
}
public static void reverse(int[] arr,int si,int ei)
{
    while(si<ei)
    {
    swap(arr,si,ei);
    si++;
    ei++;
    }
}
public static void swap(int[] arr,int si,int ei)
{   
    while(si<ei)
   {
    int t=arr[si];
    arr[si]=arr[ei];
    arr[ei]=t;
   }
}
public static void display(int[] arr)
{
    for(int i=0;i<arr.length;i++)
    {
        System.out.print(arr[i]);
    }
    System.out.println();
}
}
