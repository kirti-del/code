#include<iostream>
#include<vector>
using namespace std;
void swap(vector<int>& arr,int si,int ei)
{
    int t;
    t=arr[si];
    arr[si]=arr[ei];
    arr[ei]=t;
}
void bubblesort(vector<int>& arr)
{
    for(int i=0;i<arr.size();i++)
    {
        for(int j=1;j<arr.size()-i;j++)
        {
            if(arr[j-1]>arr[j])
            {
                swap(arr,j-1,j);
            }
        }
    }
}
int main(int args,char** ar)
{
    int n;
    cin>>n;
    vector<int> arr(n,0);
    
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
    }
    bubblesort(arr);
    for(int i=0;i<n;i++)
    {
        cout<<arr[i]<<" ";
    }
    return 0;
}
