#include<iostream>
#include<vector>

using namespace std;

int compareto(vector<int>& arr,int child,int par,bool ismax)
{
    if(ismax)
        return arr[child]-arr[par];
    else
        return arr[par]-arr[child];
}

void downheapify(vector<int>& arr,int idx,int lidx,bool ismax)
{
    int maxidx=idx;
    int lci=idx*2+1;
    int rci=idx*2+2;

    if(lci<=lidx && compareto(arr,lci,maxidx,ismax)>0)
    {
        maxidx=lci;
    }
    
    if(rci<=lidx && compareto(arr,rci,maxidx,ismax)>0)
    {
        maxidx=rci;
    }

    if(maxidx!=idx)
    {
        swap(arr[maxidx],arr[idx]);
        downheapify(arr,maxidx,lidx,ismax);
    }
}
int main(int args,char** argv)
{
    vector<int> arr={10,20,30,-2,-3,-4,5,6,7,8,9,22,11,13};
    bool ismax=true;
    int n=arr.size()-1;
    for(int i=n;i>=0;i--)
    {
        downheapify(arr,i,n,ismax);
    }
    
    for(int i=0;i<n;i++)
    {
        /*for(int ele: arr)
        {
            cout<<ele<<" ";
        }*/
        swap(arr[0],arr[n-i]);
        downheapify(arr,0,n-i-1,ismax);
        cout<<endl;
    }
    for(int ele: arr)
    {
        cout<<ele<<" ";
    }
}
