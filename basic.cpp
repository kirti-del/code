# code
#include<iostream>
using namespace std;
int prime(int n)
   { 
    for(int i=2;i*i<=n;i++)
    {
        if(n%i==0)
        n=1;
        else n=0;
    }   
        return n;
    }
    

int main(int args,char** ar)
{
    int n;
    cin>>n;
    if(prime(n)==1)
    cout<<"is not a prime no";
    else cout<<" a prime no";
    return 0;
}
