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
void selectionsort(vector<int>& arr)
{
    for(int i=0;i<arr.size();i++)
    {
        for(int j=i+1;j<arr.size();j++)
        {
            if(arr[i]>arr[j])
            {
                swap(arr,i,j);
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
    selectionsort(arr);
    for(int i=0;i<n;i++)
    {
        cout<<arr[i]<<" ";
    }
    return 0;
}
