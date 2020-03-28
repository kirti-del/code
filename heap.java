import java.util.ArrayList;
public class heap
{
    public static void main(String[] args)
    {  
        int[] arr1={10,20,30,-2,-3,-4,5,6,7,8,9,22,11,13};
        priorityque pq=new priorityque(arr1,false);

        while(pq.size()!=0)
        {
            System.out.print(pq.top()+" ");
            pq.pop();
        }
    }
    /*
    class Solution {
    public class pair
    {
        int i,j,ele;
        pair(int ele,int i,int j)
        {
            this.i=i;
            this.j=j;
            this.ele=ele;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<pair> pq=new PriorityQueue<>((pair a,pair b)->{
        return a.ele-b.ele;
        });
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++)
        {
                pq.add(new pair(matrix[i][0],i,0));
        }
        while(--k>0)
        {
            pair p=pq.poll();
            int x=p.i;
            int y=p.j;
            if(++y<m)
            {
                pq.add(new pair(matrix[x][y],x,y));
            }
        }
        return pq.poll().ele;
}
}
    */
    public static class priorityque
    {
        ArrayList<Integer> arr=new ArrayList<>();
        boolean ismax=false;
        priorityque(boolean ismax)
        {
            this.ismax=ismax;
        }
        priorityque()
        {
        }
        priorityque(int[] arr1,boolean ismax)
        {
            this.ismax=ismax;
            for(int i=0;i<arr1.length;i++)
            {
                arr.add(arr1[i]);
            }
            for(int i=arr.size()-1;i>=0;i--)
            {
                downheapify(i);
            }
        }
        public int size()
        {
            return arr.size();
        }
        public int compareto(int i,int j)
        {
            if(ismax)
            {
                return i-j;
            }
            else 
            {
                return j-i;
            }
        }
        public void downheapify(int idx)
        {
            int maxidx=idx;
            int lci=idx*2+1;
            int rci=idx*2+2;

            if(lci<arr.size() && compareto(arr.get(lci),arr.get(maxidx))>0)
            {
                maxidx=lci;
            }
            if(rci<arr.size() && compareto(arr.get(rci),arr.get(maxidx))>0)
            {
                maxidx=rci;
            }
            if(idx!=maxidx)
            {
                swap(maxidx,idx);
                downheapify(maxidx);
            }
        }
        public void upheapify(int cidx)
        {
            int pidx=(cidx-1)/2;
            if(pidx>=0 && compareto(arr.get(pidx),arr.get(cidx))>0)
            {
                swap(pidx,cidx);
                upheapify(pidx);
            }
        }
        public int top()
        {
            return arr.get(0);
        }
        public void push(int val)
        {
            arr.add(val);
            downheapify(arr.size()-1);
        }
        public void pop()
        {
            swap(0,arr.size()-1);
            Integer val=arr.get(arr.size()-1);
            arr.remove(val);
            downheapify(0);
        }
        public void update(int idx,int val)
        {
            if(idx==-1)
            {
                return;
            }
            arr.set(idx,val);
            upheapify(idx);
            downheapify(idx);
        }
        public void swap(int idx1,int idx2)
        {
            Integer temp=arr.get(idx1);
            Integer temp2=arr.get(idx2);
            arr.set(idx1,temp2);
            arr.set(idx2,temp);
        }
    }
}
