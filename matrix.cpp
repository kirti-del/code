#include<iostream>
#include<vector>
using namespace std;
void input(vector<vector<int>>& arr1,vector<vector<int>>& arr2)
{
    
for(int row=0;row<arr1.size();row++)
{
    for(int col=0;col<arr1[0].size();col++)
    {
        cin>>arr1[row][col];
    }

}

    
for(int row=0;row<arr2.size();row++)
{
    for(int col=0;col<arr2[0].size();col++)
    {
        cin>>arr2[row][col];
    }

}

}
void add(vector<vector<int>>& arr1,vector<vector<int>>& arr2)
{
    for(int row=0;row<arr1.size();row++)
    {
        for(int col=0;col<arr1[0].size();col++)
        {
            arr1[row][col]+=arr2[row][col];
        }
    }
    
}
void display(vector<vector<int>>& arr1)
{
    for(int row=0;row<arr1.size();row++)
    {
        for(int col=0;col<arr1[0].size();col++)
        {
            cout<<arr1[row][col]<<" ";
        }
        cout<<endl;
    }
    
}
int main(int ar,char** args)
{   int n,m;
     cin>>n>>m;
    vector<vector<int>> arr1(m,vector<int>(n,0));
    vector<vector<int>> arr2(m,vector<int>(n,0));
    input(arr1,arr2);
    add(arr1,arr2);
    display(arr1);
    return 0;
}
