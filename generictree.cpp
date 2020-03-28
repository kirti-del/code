#include<iostream> 
#include<vector>
#include<stack>
using namespace std;

class Node
{
    public:
    int data=0;
    vector<Node*> childs;
    Node(int data)
    {
        this->data=data;
    }
};

int size(Node *root)
{
    int s=0;
    for(Node *child:root->childs)
    {
        s+=size(child);
    }
    return s+1;
}
int height(Node* root)
{
    int h=-1;
    for(Node *child:root->childs)
    {
        h+=max(h,height(child));
    }
    return h+1;
}
bool find(Node *root,int data)
{
    if(root->data==data)
    return true;

    bool res=false;
    for(Node *child:root->childs)
    {
        res=res||find(child,data);
    }
    return res;
}
Node *createtree(vector<int> &arr)
{
    stack<Node*> st;
    for(int i=0;i<arr.size()-1;i++)
    {
        if(arr[i]==-1)
        {
            Node *node=st.top();
            st.pop();
            st.top()->childs.push_back(node);
        }
        else
        {
            st.push(new Node(arr[i]));
        }
    }
    return st.top();
}
void display(Node *root)
{
    cout<<root->data<<"->";
    for(Node *child:root->childs)
    {
        cout<<child->data<<", ";
    }
    cout<<endl;
for(Node *child:root->childs)
    {
       display(child);
    }
}
vector<Node*> roottonode(Node *node,int data)
{
    if(node->data==data)
    {
        vector<Node*> base;
        base.push_back(node);
        return base;
    }
    for(Node *child:node->childs)
    {
        vector<Node*> list=roottonode(child,data);
        if(list.size()!=0)
        {
            list.push_back(node);
            return list;
        }
    }
    vector<Node*> myans;
    return myans;
}

void kaway(Node *node,Node *avoid,int level)
{
    if(node==avoid)
    {
        return;
    }
    if(level==0)
    {
        cout<<node->data<<" ";
        return;
    }
    for(Node *child:node->childs)
    {
        kaway(child,node,level-1);
    }
}
void kfar(Node *node,int k,int data)
{
    vector<Node*> list=roottonode(node,data);
    Node *avoid=nullptr;
    for(int i=0;i<list.size();i++)
    {
        kaway(list[i],avoid,k-i);
        avoid=list[i];
    }
}
/*int lca(Node node,int data1,int data2)
{
    vector<Node*> list1=roottonode(node,data1);
    vector<Node*> list2=roottonode(node,data2);

    int i=list1.size()-1;
    int j=list2.size()-1;

}*/
Node *gettail(Node *node)
{
   if(node->childs.size()==0)
    {
        return node;
    }
    return gettail(node->childs[0]);

}
void linearize(Node *node)
{
    for(Node *child:node->childs)
    {
        linearize(child);
    }
    for(int i=node->childs.size()-2;i>=0;i--)
    {
        Node *tail=gettail(node->childs[i]);
        tail->childs.push_back(node->childs[i+1]);
        node->childs.pop_back();
    }
}
Node *linearizeandreturntail(Node *node)
{
    if(node->childs.size()==0)
    {
        return node;
    }
    int n=node->childs.size();
    Node *otail=linearizeandreturntail(node->childs[n-1]);
    for(int i=n-2;i>=0;i--)
    {
        Node *tail=linearizeandreturntail(node->childs[i]);
        tail->childs.push_back(node->childs[i+1]);
        node->childs.pop_back();
    }
    return otail;
}
void removechilds(Node *node)
{
    vector<Node*> nchilds;
    for(Node *child:node->childs)
    {
        if(child->childs.size()!=0)
        {
            nchilds.push_back(child);
        }
    }
        node->childs=nchilds;
        for(Node *child:node->childs)
        {
            removechilds(child);
        }
}
int main(int args,char** argv)
{
    vector<int> arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
    Node* node = createtree(arr);
    //display(node);
    //kfar(node,3,80);
    // linearize(node);
    //linearizeandreturntail(node);
    removechilds(node);
    display(node);
}
