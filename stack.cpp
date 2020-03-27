public class stack
{
    protected int[] st=new int[10];
    protected int idx=-1;
    stack()
    {
        this.st=new int[10];
    }
    stack(int size)
    {
        this.st=new int[size];
    }
    public void print()
    {
        for(int i=idx;i>=0;i--)
        {
            System.out.print(st[i]+" ");
        }
    }
    public int size()
    {
        return idx+1;
    }
    public boolean isempty()
    {
        return idx==-1;
    }
    public void push(int data)
    {
        if(idx==st.length)
        {
            System.err.print("Cannotpush");
        }
        idx++;
        this.st[idx]=data;
    }
    public void top()
    {
        if(isempty())
        {
            System.err.print("Stack is empty");
        }
        else
        {
            System.out.println(st[idx]);
        }
    }
    public int pop()
    {
        if(isempty())
        {
            System.err.print("stackisempty");
            return -1;
        }
        else 
        {
            int rv=st[idx];
            st[idx]=0;
            idx--;
        return rv;
        }
    }

}
