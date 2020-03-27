import util.java.Scanner;
public class nearest
{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args)
    {   
        System.out.print("Enter the size of the array ");
        int n=scn.nextInt();
        System.out.print("Enter the data ");
        int r=scn.nextInt();
        int[] arr=new int[n];
        input(arr);
        nearest(arr,r);

    }
public static void input(int[] arr)
{
    for(int i=0;i<arr.length;i++)
    {
        arr[i]=scn.nextInt();
    }
    System.out.println();

}

public static int nearest(int[] arr,int data)
{   int mid=0;
    int si=0;
    int ei=arr.length-1;
    while(si<=ei)
    {   if(mid<0||mid>arr.length)
       mid=(si+ei)/2;
        if(arr[mid]==data)
        {
            break;
        }
        if(arr[si]-data<=arr[ei]-data)
        arr[si]=mid+1;
        else
        arr[ei]=mid-1;
    }
    return arr[mid];
}       
}
