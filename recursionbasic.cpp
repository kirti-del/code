#include<iostream>
using namespace std;
 void incre(int st,int end)
 {
     if(st==end+1)
     return;
     cout<<st<<" ";
     incre(st+1,end);
 }
 void decr(int st,int end)
 {
     if(st==end+1)
     return;
     decr(st+1,end);
     cout<<st<<" ";
 }
 int main(int ar,char** ard)
 {
     int st,end;
     cin>>st>>end;
     incre(st,end);
     cout<<endl;
     decr(st,end);
     return 0;
 }
