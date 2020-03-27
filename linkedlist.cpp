#include<iostream>

using namespace std;

class linkedlist
{   
    public:
    class Node
    {
        public:
        Node* next=nullptr;
        int data=0;
        Node(int data)
        {
            this->data=data;
        }
    };
    private: Node *head=nullptr;
    private: Node *tail=nullptr;
    int size=0;
    public:
    ~linkedlist()
    {
        Node* temp=head;
        while(head!=nullptr)
        {
            head=head->next;
            delete temp;
            temp=head;
        }
    }
    void addfirst(int data)
    {
        Node *temp=new Node(data);
        if(head==nullptr)
        {
            head=temp;
            tail=temp;
        }
        else
        {
            temp->next=head;
            head=temp;
        }
        size++;
    }
    int removefirst()
    {
        Node *temp=nullptr;
        if(head!=nullptr)
        {
            if(head!=tail)
            {
                temp=head;
                head=temp->next;
            }
            else{
                temp=head;
                head=nullptr;
                tail=nullptr;
            }
        }
        int rn=(temp==nullptr)?-1:temp->data;
        delete temp;
        size--;
        return rn;
    }
    void addlast(int data)
    {
        Node *temp=new Node(data);
        if(head==nullptr)
        {
            head=temp;
            tail=temp;
        }
        else{
            tail->next=temp;
            tail=temp;
        }
        size++;
    }
    int removelast()
    {
        int rn=-1;
        if(head==tail)
        {
            rn=head->data;
            head=nullptr;
            tail=nullptr;
            size--;
        }
        else
        {
            Node* temp=getnodeat(size-2);
            rn=tail->data;
            temp->next=nullptr;
            tail=temp;
            size--;
        }
        return rn;
    }
    void addat(int idx,int val)
    {
        if(idx>=size || idx<0)
        {
            return;
        }
        if(idx==0)
        {
            addfirst(val);
        }
        else if(idx==size-1)
        {
            addlast(val);
        }
        else
        {
        Node* temp=getnodeat(idx-1);
        Node* tnode=temp->next;
        Node* fnode=new Node(val);
        temp->next=fnode;
        fnode->next=tnode;
        size++;
        }

    }
    void removeat(int idx)
    {
        if(idx<0 || idx>size-1)
        {
            return;
        }
        if(idx==0)
        {
            removefirst();
        }
        if(idx==size-1)
        {
            removelast();
        }
        else{
            Node* temp=getnodeat(idx-1);
            Node* tnode=temp->next;
            
            temp->next=tnode->next;
            size--;
            delete tnode;
        }
    }
    Node* mid()
    {
        Node* slow=head;
        Node* fast=head;
        while(fast!=slow)
        {
            slow=slow->next;
            fast=fast->next->next;
        }
        return slow;
    }
    Node* getnodeat(int idx)
    {
        if(head==nullptr)
        {
            return nullptr;
        }
        Node* temp=head;
        if(idx==0)
        {
            Node* temp=head;
        }
        else
        {
            while(idx!=0)
            {
                temp=temp->next;
                idx--;
            }
        }
        return temp;
    }

    void display()
    {
        Node *curr=head;
        while(curr!=nullptr)
        {
            cout<<curr->data<<" ";
            curr=curr->next;
        }
        cout<<endl;
    }
};
    int main(int args,char** argv)
    {
        linkedlist ll;
        ll.addfirst(10);
        ll.addlast(30);
        ll.display();
    }
