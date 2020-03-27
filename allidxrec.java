public class allindex
{
    public static void main(String[] s)
    {
        int[] arr={10,8,9,10,11,13,10,16,18,10,13};
        int[] arr2=all_index(arr,0,10,0);
        for(int i=0;i<arr2.length;i++)
        {
            System.out.print(arr2[i]+" ");
        }


    }
    public static int[] all_index(int[] arr,int vidx,int data,int size)
    {
        if(vidx==arr.length)
        {
        int[] basearr=new int[size];
        return basearr;
        }
        if(arr[vidx]==data)
         {
             size++;
         }
        int[] recans=all_index(arr,vidx+1,data,size);
        if(arr[vidx]==data)
        {
        recans[size-1]=vidx;
        }
        return recans;

    }  
}
