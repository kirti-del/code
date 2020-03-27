import java.util.Scanner;                                                                                                                                                                                                                                        import java.util.Scanner;
public class spiral
{
    public static Scanner scn=new Scanner(System.in);


public static void input(int[][] arr)
{
    
for(int row=0;row<arr.length;row++)
{
    for(int col=0;col<arr[0].length;col++)
    {
         arr[row][col]=scn.nextInt();
    }

}
}
public static void spiral(int[][] arr)
{
    int rmin=0;
    int cmin=0;
    int rmax=arr.length-1;
    int cmax=arr[0].length-1;
    int tne=arr.length*arr[0].length;

    while(tne>0)
    {
        for(int i=cmin;i<=cmax;i++)
        {
            System.out.print(arr[rmin][i]+" ");
            tne--;
        }
        rmin++;
        for(int i=rmin;i<=rmax;i++)
        {
            System.out.print(arr[i][cmax]+" ");
            tne--;
        }
        cmax--;
        for(int i=cmax;i>=cmin;i--)
        {
            System.out.print(arr[rmax][i]+" ");
             tne--;       
        }
        rmax--;
        for(int i=rmax;i>=rmin;i--)
        {
            System.out.print(arr[i][cmin]+" ");
            tne--;
        }
        cmin++;

    }
}

public static void main(String[] args )
{   int n=scn.nextInt();
    int m=scn.nextInt();
     
    int[][] arr=new int[n][m];
    input(arr);
    spiral(arr);
}
}
