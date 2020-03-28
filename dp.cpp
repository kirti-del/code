#include<iostream>
#include<vector>

using namespace std;

void substring(string ques,string ans)
{
    if(ques.length()==0)
    {
        cout<<ans<<" ";
        return;
    }
    char ch=ques[0];
    substring(ques.substr(1),ans+ch);
    substring(ques.substr(1),ans);
}
void removeduplicates(string ques,string ans)
{
    if(ques.length()==0)
    {
        cout<<ans;
        return;
    }
    char ch=ques[0];
        if(ques.length()>1 && ques[1]==ch)
        {
            removeduplicates(ques.substr(1),ans);
        }
        else
        {
            removeduplicates(ques.substr(1),ans+ch);
        }
}
void stringcompress(string ques,string ans,int count)
{
    if(ques.length()==0)
    {
        cout<<ans<<" ";
        return;
    }
    if(ques.length()>1 && ques[0]==ques[1])
    {
        stringcompress(ques.substr(1),ans,count+1);
    }
    else{
        stringcompress(ques.substr(1),ans+ques[0]+to_string(count),1);
    }
}
int stringcompress2(string ques,string ans,int count)
{
    if(ques.length()==0)
    {
        cout<<ans<<endl;
        return 1;
    }
    int ctr=0;
    if(ques.length()>1 && ques[0]==ques[1])
    {
        ctr+=stringcompress2(ques.substr(1),ans,count+1);
    }
    else{
        ctr+=stringcompress2(ques.substr(1),ans+ques[0]+to_string(count),1);
    }
    return ctr;
}

int stringcompress2dp(string ques,string ans,int count,vector<int>& dp)
{
    if(ques.length()==0)
    {
        cout<<ans<<endl;
        dp[count]=1;
        return 1;
    }
    int ctr=0;
    if(dp[0]!=0)
    {
        dp[0]=ctr;
    }
    if(ques.length()>1 && ques[0]==ques[1])
    {
        ctr+=stringcompress2dp(ques.substr(1),ans,count+1,dp);
    }
    else{
        ctr+=stringcompress2dp(ques.substr(1),ans+ques[0]+to_string(count+1),0,dp);
    }
    dp[count]=ctr;
    return ctr;
}
int boardpath(int st,int end)
{
    if(st==end)
    {
        return 1;
    }
    int count=0;
    for(int dice=1;dice<=6;dice++)
    {
        if(st+dice<=end)
        {
            count+=boardpath(st+dice,end);
        }
    }
    return count;
}
int baordpath(int st,int end,vector<int>& dp)
{
    if(st==end)
    {
        dp[st]=1;
        return 1;
    }
    int count=0;
    if(dp[st]!=0)
    {
        dp[st]=count;
    }
    for(int dice=1;dice<=6;dice++)
    {
        if(st+dice<=end)
        {
            count+=baordpath(st+dice,end,dp);
        }
    }
    dp[st]=count;
    return count;
}
/*void boardpathtabulation(int st,int end)
{
    vector<int> dp(end+1,0);
    dp[end]=1;
    for(int i=end;i>=0;i--)
    {
        int count=0;
        if(st==i)
        {
            //dp[i]=1;
            continue;
        }
        if(dp[i]!=0)
        {
            dp[i]=count;
        }
        for(int dice=1;dice<=6;dice++)
        {
            if(st+dice<=end)
            {
                count+=dp[i-st+dice];
            }
        }
        dp[i]+=count;
    }
    cout<<dp[0];
    //492 248 125 63 32 16 8 4 2 1 1
}*/
void mazepath(int sr,int sc,int er,int ec)
{
    vector<vector<int>> dp(er+1,vector<int>(ec+1,0));
    dp[er][ec]=1;
    for(sr=er;sr>=0;sr--)
    {
        for(sc=ec;sc>=0;sc--)
        {
            if(sr==er && sc==ec)
            {
                dp[sr][sc]=1;
                continue;
            }
            if(sr+1<=er)
            {
                dp[sr][sc]+=dp[sr+1][sc];
            }
            if(sc+1<=ec)
            {
                dp[sr][sc]+=dp[sr][sc+1];
            }
            if(sr+1<=er && sc+1<=ec)
            {
                dp[sr][sc]+=dp[sr+1][sc+1];
            }
        }
    }
    cout<<dp[0][0];
}
int mazepathmemo(int sr,int sc,int er,int ec)
{
    if(sr==er && sc==ec)
    {
        return 1;
    }
    int count=0;
    if(sr+1<=er)
    {
        count+=mazepathmemo(sr+1,sc,er,ec);
    }
    if(sc+1<=ec)
    {
        count+=mazepathmemo(sr,sc+1,er,ec);
    }
    if(sr+1<=er && sc+1<=ec)
    {
        count+=mazepathmemo(sr+1,sc+1,er,ec);
    }
    return count;
}
/*vector<vector<bool>> ispalindrome(string str)
{
    vector<vector<bool>> ispali(str.length(),vector<bool>(str.length(),false));
    for(int gap=0;gap<str.length();gap++)
    {
        for(int i=0,j=gap;j<str.length();j++,i++)
        {
            if(gap==0)
            {
                ispali[i][j]=true;
            }
            else if(str[i]==str[j])
            {
                if(gap==1)
                {
                    ispali[i][j]=true;
                }
                else if(ispali[i+1][j-1])
                {
                    ispali[i][j]=ispali[i+1][j-1];
                }
            }
            else{
                ispali[i][j]=false;
            }
        }
    }
    return ispali;
}
void subtringdp(string str)
{
    vector<vector<int>> dp(str.length(),vector<int>(str.length(),0));
    vector<vector<bool>> palindrome=ispalindrome(str);
    for(int gap=0;gap<str.length();gap++)
    {
        for(int i=0,j=gap;j<str.length();i++,j++)
        {
            if(gap==0)
            {
                dp[i][j]=1;
            }
            else if(str[i]==str[j] && gap==1)
            {
                dp[i][j]=dp[i+1][j-1]+2;
            }
            else if(str[i]==str[j] && palindrome[i+1][j-1])
            {
                dp[i][j]=dp[i+1][j-1]+2;
            }
            else
            {
                dp[i][j]=max(dp[i+1][j],dp[i][j-1]);
            }
        }
    }
    cout<<dp[0][str.length()-1];
}*/
vector<vector<bool>> checkpali(string str)
{
    vector<vector<bool>> dp(str.length(),vector<int>(str.length(),false));
    for(int gap=0;gap<str.length();gap++)
    {
        for(int i=0,j=gap;j<str.length();j++,i++)
        {
            if(gap==0)
            {
                dp[i][j]=true;
            }
            else if(str[i]==str[j])
            {
                if(gap==1)
                {
                    dp[i][j]=true;
                }
                else if(dp[i+1][j-1]){
                    dp[i][j]=true;
                }
            }
        }
    }
    return dp;
}
void palindromicsubstr(string str)
{
    vector<vector<bool>> pali=checkpali(str);
    vector<vector<int>> dp(str.length()+1,vector<int>(str.length()+1,0));
    for(int gap=0;gap<str.length();gap++)
    {
        for(int i=0,j=gap;j<str.length();i++,j++)
        {
            if(gap==0)
            {
                dp[i][j]=1;
            }
            else if(gap==1 && str[i]==str[j])
            {
                dp[i][j]=2;
            }
            else if(str[i]==str[j] && pali[i+1][j-1])
            {
                dp[i][j]=dp[i+1][j-1]+2;
            }
            else{
                dp[i][j]=max(dp[i+1][j],dp[i][j-1]);
            }
        }
    }
    cout<<dp[0][str.length()-1];
}
int main(int args,char** argv)
{
   // substring("abc","");
    //removeduplicates("aaabbbcccc","");
    //stringcompress("aaaabbbcc","",1);
    //cout<<stringcompress2("aaaabbbccc","",1);
    //vector<int> dp(2,0);
    //cout<<stringcompress2dp("aaabbbccc","",0,dp)<<endl;
    //cout<<dp[0]<<" "<<dp[1];
    //stringcmprstabulation("aaaabbbcc","",0);
    //cout<<boardpath(0,10);
    vector<int> dp(11,0);
    /*cout<<baordpath(0,10,dp)<<endl;
    for(int i=0;i<dp.size();i++)
    {
        cout<<dp[i]<<" ";
    }*/
    //boardpathtabulation(0,10);
    //mazepath(0,0,5,5);
    //cout<<mazepathmemo(0,0,5,5);
    //subtringdp("babad");
    palindromicsubstr("babad");
    return 0;
}
