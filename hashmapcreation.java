import java.util.*;

public class Hashmap<K,V>
{
    public class Node{
        K key;
        V val;
        Node(K key,V val)
        {
            this.key=key;
            this.val=val;
        }
        @Override
        public String toString()
        {
            return this.key+"="+this.val;
        }
     }
    int size=0;
    LinkedList<Node>[] buckets=new LinkedList[10];
    Hashmap()
    {
        for(Integer i=0;i<buckets.length;i++)
        {
            buckets[i]=new LinkedList();
        }
    }
    @Override
    public String toString()
    {
        StringBuilder sb=new StringBuilder();
        sb.append("{");
        for(int i=0;i<buckets.length;i++)
        {
            if(buckets[i].size()>0)
            {
                int size=buckets[i].size();
                LinkedList<Node> group=buckets[i];
                while(size-->0)
                {
                    Node tnode=group.getFirst();
                    sb.append(tnode.toString()+", ");
                    group.addLast(group.removeFirst());
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }
    public Node get(K key)
    {
        int code=myhashcode(key);
        LinkedList<Node> group=buckets[code];
        Node rn=foundingroup(group,key);
        return rn;
    }
    public Node remove(K key) throws Exception
    {
        int code=myhashcode(key);
        LinkedList<Node> group=buckets[code];
        Node rn=foundingroup(group,key);
        if(rn!=null)
        {   this.size--;
            return group.removeFirst();
        }
        else
        {
            throw new Exception("Element not found: -1");
        }
    }
    public void put(K key,V val)
    {
        int code=myhashcode(key);
        LinkedList<Node> group=buckets[code];
        Node rn=foundingroup(group,key);
        if(rn!=null)
        {
            rn.val=val;
        }
        else{
            Node node=new Node(key,val);
            group.addFirst(node);
            this.size++;

            double lambda=group.size()*1.0/buckets.length;
            if(lambda>1.0)
            {
                rehash();
            }
        }
    }
    public void rehash()
    {
        LinkedList<Node>[] oldbuckets=buckets;
        buckets=new LinkedList[buckets.length*2];
        for(int i=0;i<buckets.length;i++)
        {
            if(oldbuckets[i].size()>0)
            {
                int size=oldbuckets[i].size();
                LinkedList<Node> group=oldbuckets[i];
                while(size-->0)
                {
                    Node tnode=group.removeFirst();
                    put(tnode.key,tnode.val);
                }
            }
        }
    }
    public ArrayList<K> keyset()
    {
        ArrayList<K> keys=new ArrayList<>();

        for(int i=0;i<buckets.length;i++)
        {
            if(buckets[i].size()>0)
            {
                int size=buckets[i].size();
                LinkedList<Node> group=buckets[i];
                while(size-->0)
                {
                    Node tnode=group.getFirst();
                    keys.add(tnode.key);
                    group.addLast(group.removeFirst());
                }
            }
        }
        return keys;
    }
    public boolean contains(Integer key)
    {
        int code=myhashcode(key);
        LinkedList<Node> group=buckets[code];
        Node rn=foundingroup(group,key);
        return rn!=null;
    }
    public Node foundingroup(LinkedList<Node> bucket,K key)
    {
        int size=buckets.length;
        Node rn=null;
        while(size-->0)
        {
            Node tnode=buckets.getFirst();
            if(tnode.key==key)
            {
                rn=tnode;
                break;
            }    
            buckets.addLast(buckets.removeFirst());
        }
        return rn;
    }
    public Integer myhashcode(int key)
    {
        int code=key.hashCode;
        return abs(code)%buckets.length;
    }
    
}
}
