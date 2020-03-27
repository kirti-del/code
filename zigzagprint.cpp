#include<iostream>
#include<vector>
using namespace std;
void input(vector<vector<int>>& arr1)
{
    
for(int row=0;row<arr1.size();row++)
{
    for(int col=0;col<arr1[0].size();col++)
    {
        cin>>arr1[row][col];
    }

}

}
void add(vector<vector<int>>& arr1)
{
    for(int row=0;row<arr1.size();row++)
    {    
        if(row%2==0)
        {
           for(int col=0;col<arr1[0].size();col++)
            {
            cout<<arr1[row][col];
            }
        }
        else
        {
              for(int col=arr1.size()-1;col>=0;col--)
              {
                cout<<arr1[row][col];
              }
        }
        cout<<endl;


    }
    
}

int main(int ar,char** args)
{   int n,m;
     cin>>n>>m;
    vector<vector<int>> arr1(n,vector<int>(m,0));
    
    input(arr1);
    add(arr1);
    
    return 0;
}
