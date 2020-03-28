import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class huffmanencoding
{
    static HashMap<String,String> encode=new HashMap<>();
    static HashMap<String,String> decode=new HashMap<>();
    static class Node implements Comparable<Node>
    {
        
        String str;
        int freq;
        Node left;
        Node right;

        Node(String str,int freq,Node left,Node right)
        {
            this.str=str;
            this.freq=freq;
            this.left=left;
            this.right=right;
        }
        Node()
        {

        }
        public int compareTo(Node o)
        {
            return this.freq-o.freq;
        }
    }
    static void run(String str)
    {
        int[] arr=new int[26];
        for(int i=0;i<str.length();i++)
        {
            arr[str.charAt(i)-'a']++;
        }
        huffmantree(arr);
    }
    
    static void huffmantree(int[] arr)
    {
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
                String st=(char)(i+'a')+"";
                Node node=new Node(st,arr[i],null,null);
                pq.add(node);
            }
        } 
        while(pq.size()!=1)
        {
            Node one=pq.remove();
            Node two=pq.remove();
            Node node=new Node(one.str+two.str,one.freq+two.freq,one,two);
            pq.add(node);
        }
        huffmantravel(pq.remove(),"");
        String enco=encode("aaabccaddeafbccfff");
        String deco=decode(enco);
        System.out.println(deco);
    }
    static void huffmantravel(Node root,String str)
    {
        if(root.left==null && root.right==null)
        {
            encode.put(root.str,str);
            decode.put(str,root.str);
            return;
        }
        huffmantravel(root.left,str+"0");
        huffmantravel(root.right,str+"1");
    }
    static String encode(String str)
    {
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<str.length();i++)
        {
            String ch=str.charAt(i)+"";
            if(encode.containsKey(ch))
            {
                ans.append(encode.get(ch));
            }
        }
        return ans.toString();
    }
    static String decode(String str)
    {
        StringBuilder ans=new StringBuilder();
        //String st=encoded(str);
        int i=0;
        for(int j=1;j<=str.length();j++)
        {
            String ch=str.substring(i,j);
            if(decode.containsKey(ch))
            {
                ans.append(decode.get(ch));
                i=j;
            }
        }
        return ans.toString();
    }
    public static void main(String[] args)
    {
        String str="aaabcaddeafbccff";
        run(str);
    }
}
