#include<iostream>
#include<vector>
 using namespace std;
  void display(vector<int>& arr,int vidx)
  {
      if(vidx==arr.size())
      return;
      cout<<arr[vidx]<<" ";
      display(arr,vidx+1);
  }
  bool find(vector<int>& arr,int vidx,int data)
  {
      bool flag=true;
      if(arr[vidx]==data)
      {
          return flag;
      }
      else
      {
      if(vidx==arr.size())
      return flag;
      int a=find(arr,vidx+1,data);
      {
      if(a==data)
        flag=true;
      else
        flag=false;
      }
      }
  }
  int maximum(vector<int>& arr,int vidx)
  {
      int b=0;
      int m_02=arr[vidx];
          if(vidx==arr.size())
          return b;
      int a=maximum(arr,vidx+1);
      if(m_02>a)
      {
          b=m_02;
      }
      else
      {
          b=a;
      }
  }
  
  int minimum(vector<int>& arr,int vidx)
  {
      int c=0;
      int m_01=arr[vidx];
          if(vidx==arr.size())
          return c;
      int a=minimum(arr,vidx+1);
      if(m_01<a)
      {c=m_01;}
      else
      {c=a;}
  }
  int firstindex(vector<int>& arr,int vidx,int data)
  {
      int i=-1;
      if(arr[vidx]==data)
      {
          return vidx;
      }
      if(vidx==arr.size())
        {return i;}
        i=firstindex(arr,vidx+1,data);
        {
        if(arr[i]==data)
        return i;
        }
  }
  int lastindex(vector<int>& arr,int vidx,int data)
  {
      int i=-1;
      if(arr[vidx]==data)
      return vidx;
      if(vidx==0)
      return i;
        i=lastindex(arr,vidx-1,data);
        {
        if(arr[i]==data)
            {
            return i;
            }
        }
  }
  int main(int args,char** arg)
  {
      //int data=8;
     vector<int> arr={10,6,8,10,4,5,5,6,8,-3,2,12,8,3};
     display(arr,0);
     cout<<endl<<(boolalpha)<<find(arr,0,10)<<endl;
     cout<<"greatest no: "<<maximum(arr,0)<<endl;
     cout<<"smallest no: "<<minimum(arr,0)<<endl;
     cout<<"first index: "<<firstindex(arr,0,8)<<endl;
     cout<<"last index: "<<lastindex(arr,arr.size()-1,8);
     return 0;
  }
