import java.util.Scanner;                                                                                                                                                                                                                                        import java.util.Scanner;
public class exit
{
    public static Scanner scn=new Scanner(System.in);


public static void input(int[][] arr1)
{
    
for(int row=0;row<arr1.length;row++)
{
    for(int col=0;col<arr1[0].length;col++)
    {
    arr1[row][col]=scn.nextInt();   
    }
}
}
public static void exit(int[][] arr1)
{    
    int dir=0;
    int r=0,c=0;
    while(true)
    {
        dir=((dir+arr1[r][c])%4);
        if(dir==0)
        {
            c++;
            if(c==arr1[0].length)
            {
                System.out.println(r+","+(c-1));
                break;
            }
        }
        else if(dir==1)
        {
            r++;
            if(r==arr1.length)
            {
                System.out.println((r-1)+","+c);
                break;
            }

        }
        else if(dir==2)
        {
            c--;
            if(c==-1)
            {
                System.out.println(r+","+(c+1));
                break;
            }
        }
        else if(dir==3)
        {
            r--;
            if(r==-1)
            {
                System.out.println((r+1)+","+c);
                break;
            }
        }
    }
    
}
public static void main(String[] args )
{   int n=scn.nextInt();
    int m=scn.nextInt();
     
    int[][] arr1=new int[n][m];
    input(arr1);
    exit(arr1);
}
} 
