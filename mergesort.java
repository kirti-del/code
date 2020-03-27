public class merge
{
    public static int[] mergesorted(int[] arr,int li,int ri)
    {
        if(li==ri)
        {
            int[] base=new int[1];
            base[0]=arr[li];
            return base;
        }
        int mid=(li+ri)>>>1;
        int[] arr1=mergesorted(arr,li,mid);
        int[] arr2=mergesorted(arr,mid+1,ri);
        return mergesort(arr1,arr2);
    }
    
    public static void dis(int[] arr1)
    {
        for(int i=0;i<arr1.length;i++)
        {
            System.out.print(arr1[i]+" ");
        }
    }
    public static int[] mergesort(int[] arr1,int[] arr2)
    {
        int[] arr3=new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length || j<arr2.length)
        {
            if(i<arr1.length && j<arr2.length){
             if(arr1[i]<arr2[j]){
                arr3[k++]=arr1[i++];
                }
                else{
                    arr3[k++]=arr2[j++];    
                    }    
            }
            else
            {
                if(j<arr2.length)
                    arr3[k++]=arr2[j++];
                if(i<arr1.length)
                    arr3[k++]=arr1[i++];    
            }
        }
        return arr3;
    }
    public static void swap(int[] arr, int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void sort(int[] arr)
    {
        int pt=0;
        int itr=0;
        while(itr<arr.length)
        {if(arr[itr]==0)
        {
            swap(arr,itr,pt);
            pt++;
        }
        itr++;
        }
        dis(arr);
    }
    
    public static void sort1(int[] arr,int li,int ri,int pivot)
    {
        int pt=li;
        int itr=li;
        while(itr<=ri)
        {if(arr[itr]>=pivot)
        {
            swap(arr,itr,pt);
            pt++;
        }
        itr++;
        }
        dis(arr);
    }
    public static void sort2(int[] arr)
    {
        int pt=0;
        int itr=0;
        int pt1=arr.length-1;
        while(itr<=pt1)
        {     
            if(arr[itr]==0)
            {
                swap(arr,itr,pt);
                pt++;
            }
            else if(arr[itr]==2)
            {
                swap(arr,pt1,itr);
                pt1--;
                continue;
            }
            itr++;
        }
        dis(arr);
    }
    public static void main(String[] args)
    {
        int[] arr1={0,0,1,2,0,1,1,2,2,2,0};
        int[] arr2={1,5};
        //int[] res=mergesorted(arr1,0,arr1.length-1);
        //dis(res);
        sort2(arr1);
    }
}
