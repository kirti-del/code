#include<iostream>
#include<vector>

using namespace std;

void mazepath(int sr,int sc,int er,int ec,string ans)
{
    bool isdone=false;
    if(sr==er && sc==ec)
    {
        cout<<ans<<" ";
        return;
    }
    if(sc+1<=ec && !isdone)
    {
        isdone=true;
        return mazepath(sr,sc+1,er,ec,ans+"H");
        isdone=false;
    }
    if(sr+1<=er && !isdone)
    {
        isdone=true;
        return mazepath(sr+1,sc,er,ec,ans+"V");
        isdone=false;
    }
}
vector<string> mobile(string str,vector<string> keys)
{
    if(str.length()==0)
    {
        vector<string> base(0,"");
        return base;
    }
    char ch=str[0];
    int idx=ch-'0';
    string word=keys[idx];

    vector<string> myans={""};
    vector<string> recans=mobile(str.substr(1),keys);
    for(string s:recans)
    {
        for(int i=0;i<word.length();i++)
        {
            myans[i]+=to_string(word[i])+s;
        }
    }
    return myans;
    
}
int main(int args,char** argv)
{
    //mazepath(0,0,2,2,"");
    vector<string> keys={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    cout<<mobile("245",keys);
}
