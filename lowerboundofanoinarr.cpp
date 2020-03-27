#include<iostream>
#include<vector>
using namespace std;
void display(vector<int>& arr)
{
    for(int i=0;i<arr.size();i++)
    {
        cout<<arr[i]<<" ";
    } cout<<endl;
}

void input(vector<int>& arr)
{
    for(int i=0;i<arr.size();i++)
    {
        cin>>arr[i];
    }cout<<endl;
    display(arr);
}
int search(vector<int>& arr,int data)
{   int flag=0;
    int si=0;
    int ei=arr.size()-1;
    while(si<=ei)
    {   int mid=(si+ei)/2;
        if(arr[mid]==data)
        {
            flag=1;
            break;
        }
        else if(arr[mid]<data)
        {
            si=mid+1;
        }
        else
        {
            ei=mid-1;
        }
    }
    return flag;
}       

        


        

int main(int args,char** ar)
{
    int data;
    int n;
    cin>>n;
    vector<int> arr(n,0);
    cout<<"enter data";
    cin>>data;
    input(arr);
    display(arr);
    if(search(arr,data)==1)
        cout<<"true";
    else
    cout<<"false";
}
