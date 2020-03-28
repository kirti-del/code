import java.util.Stack;
public class infixeval
{
    public static boolean isoperator(char ch)
    {
        if(ch=='+'||ch=='-'||ch=='/'||ch=='*'||ch=='%'||ch=='^')
        {
            return true;
        }
        return false;
    }
    public static int priority(char ch)
    {
        if(ch=='+'||ch=='-')
        {
            return 0;
        }
        else if(ch=='/'||ch=='*'||ch=='%')
        {
            return 1;
        }
        else if(ch=='^')
        {
            return 2;
        }
        return -1;
    }
    public static int evaluation(int val1,int val2,char ch)
    {
        if(ch=='+')
        {
            return val2+val1;
        }
        else if(ch=='-')
        {
            return val2-val1;
        }
        else if(ch=='/')
        {
            return val2/val1;
        }
        else if(ch=='*')
        {
            return val2*val1;
        }
        else if(ch=='%')
        {
            return val2%val1;
        }
        else
            return (int)Math.pow(val2,val1);
    }
    public static int infix(String str)
    {
        Stack<Integer> numst=new Stack<>();
        Stack<Character> opst=new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch>='0' && ch<='9')
            {
                numst.push(ch-'0');
            }
            else if(ch=='(')
            {
                opst.push(ch);
            }
        else if(isoperator(ch))
        {   
            while(opst.size()!=0 && opst.peek()!=')' && priority(opst.peek())>priority(ch))
            {
                int val1=numst.pop();
                int val2=numst.pop();    
                char c=opst.pop();
                int ans=evaluation(val1,val2,c);
                numst.push(ans);
            }
                opst.push(ch);
        }
        else 
        {
            while(opst.peek()!='(')
                {
                    int val1=numst.pop();
                    int val2=numst.pop();
                    char c=opst.pop();
                    int ans=evaluation(val1,val2,c);
                    numst.push(ans);
                }
                opst.pop();
            }
        }
        while(opst.size()!=0)
        {
            int val1=numst.pop();
            int val2=numst.pop();
            char c=opst.pop();
            int ans=evaluation(val1,val2,c);
            numst.push(ans);
        }
        return numst.pop();
    }
    public static void main(String[] args)
    {
        System.out.println(infix("8+4*3-9/3^(2-1)"));
    }
}
