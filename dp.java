#include<iostream>
#include<vector>
using namespace std;

vector<vector<int>> multiplication(vector<vector<int>>&a,vector<vector<int>> arr)
{
    vector<vector<int>> ans(2,vector<int>(2,0));
    //vector<vector<int>> arr={{1,1},{1,0}};
    for(int i=0;i<2;i++)
    {
        for(int j=0;j<2;j++)
        {
            for(int k=0;k<2;k++)
            {
                ans[i][j]+=arr[i][k]*a[k][j];
            }
        }
    }
    return ans;
}
vector<vector<int>> fibonacci(vector<vector<int>>&a,vector<vector<int>>& i,int pow)
{
    if(pow==1)
    {
        return i;
    }
    vector<vector<int>> arr=fibonacci(a,i,pow/2);
    vector<vector<int>> ans=multiplication(arr,arr);
    return (pow%2!=0)?multiplication(ans,i):ans;
}
int boardpath(int target,vector<int>& dp)
{
    if(target==0)
    {
        dp[target]=1;
        return 1;
    }
    if(dp[target]!=0)
    {
        return dp[target];
    }
    int count=0;
    for(int dice=1;dice<=6;dice++)
    {
        if(target-dice>=0)
        {
            count+=boardpath(target-dice,dp);
        }
    }
    dp[target]=count;
    return count;
}
void boardpathitr(int tar,vector<int>& dp)
{
    int count=0;
    for(int i=tar-1;i>=0;i--)
    {
        for(int dice=0;dice<=6;dice++)
        {
            if(i+dice<=tar)
            {
                dp[i]=dp[dice+i];
                count++;
            }
        }
    }
cout<<count;
}
/*int multimoves(int sr,int sc,int er,int ec,vector<vector<int>> &dp)
{
    return count;
}*/

int multimovestab(int sr,int sc,int er,int ec,vector<vector<int>> &dp)
{
    if(sc==ec && sr==er)
    {
        dp[sr][sc]=1;
        return 1;
    }
    int count=0;
    /*if(dp[sr][sc]!=0)
    {
        dp[sr][sc]=count;
    }
    if(dp.size()==dp[0].size() && dp[sc][sr]!=0)
    {
        dp[sc][sr]=count;
    }*/
    for(int i=1;i+sr<dp.size();i++)
    {
        count++;//multimovestab(sr+i,sc,er,ec,dp);
        dp[sr][sc]+=dp[sr+i][sc];
    }
    for(int i=1;sc+i<dp[0].size();i++)
    {
        count++;//multimovestab(sr,sc+i,er,ec,dp);
        dp[sr][sc]+=dp[sr][sc+i];
    }
    for(int i=1;sr+i<dp.size() && sc+i<dp[0].size();i++)
    {
        count+=multimovestab(sr+i,sc+i,er,ec,dp);
        dp[sr][sc]+=dp[sr+i][sc+i];
    }
    dp[sr][sc]=count;
    if(dp.size()==dp[0].size())
    {
        dp[sc][sr]=count;
    }
    return count;
}
void mazepathtabulation(int sr,int sc,int er,int ec)
{
    vector<vector<int>> dp(er+1,vector<int>(ec+1,0));
    dp[er][ec]=1;
    for(sr=er;sr>=0;sr--)
    {
        for(sc=ec;sc>=0;sc--)
        {
            if(dp[sr][sc]==1)
            {

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
    for(int i=0;i<dp.size();i++)
    {
        for(int j=0;j<dp[0].size();j++)
        {
            cout<<dp[i][j]<<" ";
        }
        cout<<endl;
    }
}
/*void minjumps(vector<int>& arr,int vidx,int count)
{
    if(vidx+1==arr.size())
    {
        cout<<count;
        return;
    }
    for(int i=1;i<arr.size();i++)
    {
        for(int j=0;j<=arr[i];j++)
        {
            if(arr[i]!=0)
            {
                minjumps(arr,vidx+i,count+1);
            }
        }
    }
    //return count;
}*/
void minjumps(vector<int>& arr)
{
    vector<int> dp(arr.size(),1e6);
    dp[arr.size()-1]=0;
    for(int i=arr.size()-2;i>=0;i--)
    {
        int minimum=1e6;
        for(int j=1;i+j<arr.size() && j<=arr[i];j++)
        {
            minimum=min(dp[i+j],minimum);
        }
        dp[i]=minimum+1;
    }
    cout<<dp[0]<<" ";
}
void npairs(int n)
{
    vector<int> dp(n+1,0);
    dp[0]=1;
    dp[1]=1;
    for(int i=2;i<=n;i++)
    {
        dp[i]=dp[i-1]+dp[i-2]*(i-1);
    }
    cout<<dp[n];
}
void divideinkgrps(int n,int k)
{
    vector<vector<int>> dp(k+1,vector<int>(n+1,0));
    dp[0][0]=1;
    for(int i=1;i<=k;i++)
    {
        for(int j=i;j<=n;j++)
        {
            dp[i][j]+=dp[i-1][j-1]+dp[i][j-1]*i;
        }
    }
    cout<<dp[k][n];
}
vector<vector<bool>> ispalindrome(string str)
{
    vector<vector<bool>> pali(str.length(),vector<bool>(str.length(),false));
    for(int gap=0;gap<str.length();gap++)
    {
        for(int i=0,j=gap;j<str.length();i++,j++)
        {
            if(gap==0)
            {
                pali[i][j]=true;
            }
            else if(str[i]==str[j])
            {
                if(gap==1)
                {
                    pali[i][j]=true;
                }
                else if(pali[i+1][j-1])
                {
                pali[i][j]=true;
                }
            }
            else{
                pali[i][j]=false;
            }
        }
    }
    /*for(int i=0;i<pali.size();i++)
    {
        for(int j=0;j<pali[0].size();j++)
        {
            cout<<(boolalpha)<<pali[i][j]<<" ";
        }
        cout<<endl;
    }*/
    return pali;
}
int substringdp(string str)
{
    vector<vector<int>> dp(str.length(),vector<int>(str.length(),0));
    vector<vector<bool>> palindrome(ispalindrome(str));
    for(int gap=0;gap<str.length();gap++)
    {
        for(int i=0,j=gap;j<str.length();j++,i++)
        {
            if(gap==0)
            {
                dp[i][j]=1;
            }
            else if(gap==1 && str[i]==str[j])
            {
                dp[i][j]=dp[i+1][j-1]+2;
            }
            else if(str[i]==str[j] && palindrome[i+1][j-1])
            {
                dp[i][j]=dp[i+1][j-1]+2;
            }
            else{
                dp[i][j]=max(dp[i+1][j],dp[i][j-1]);
            }
        }
    }
    for(int i=0;i<dp.size();i++)
    {
        for(int j=0;j<dp[0].size();j++)
        {
            cout<<dp[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<dp[0][str.length()-1];
}
/*int countpalidp(string str)
{
    vector<vector<int>> dp(str.length(),vector<int>(str.length(),0));
    vector<vector<bool>> palindrome(ispalindrome(str));
    for(int gap=0;gap<str.length();gap++)
    {
        for(int i=0,j=gap;j<str.length();j++,i++)
        {
            if(gap==0)
            {
                dp[i][j]=1;
            }
            else if(gap==1 && str[i]==str[j])
            {
                dp[i][j]=dp[i+1][j]+dp[i][j-1]+1;
            }
            else if(str[i]==str[j] && palindrome[i+1][j-1])
            {
                dp[i][j]=dp[i+1][j]+dp[i][j-1]+1;
            }
            else{
                dp[i][j]=max(dp[i+1][j],dp[i][j-1];
            }
        }
    }
}*/
void subseqdp(string str)
{
    vector<vector<int>> dp(str.length(),vector<int>(str.length(),0));
    for(int gap=0;gap<str.length();gap++)
    {
        for(int i=0,j=gap;j<str.length();i++,j++)
        {
            if(gap==0)
            {
                dp[i][j]=1;
            }
            else if(str[i]==str[j])
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
void countpalidp(string str)
{
    vector<vector<int>> dp(str.length(),vector<int>(str.length(),0));
    for(int gap=0;gap<str.length();gap++)
    {
        for(int i=0,j=gap;j<str.length();i++,j++)
        {
            if(gap==0)
            {
                dp[i][j]=1;
            }
            else if(str[i]==str[j])
            {
                dp[i][j]=dp[i+1][j]+dp[i][j-1]+1;
            }
            else{
                dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
            }
        }
    }
    for(int i=0;i<dp.size();i++)
    {
        for(int j=0;j<dp[0].size();j++)
        {
            cout<<dp[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<dp[0][str.length()-1];
}
int gmax=0;
void longestcmnsbstr(string str1,string str2)
{
    vector<vector<int>> dp(str1.length()+1,vector<int>(str2.length()+1,0));
    int lmax=0;
    for(int i=str1.length()-1;i>=0;i--)
    {
        for(int j=str2.length()-1;j>=0;j--)
        {
            if(str1[i]==str2[j])
            {
                if(dp[i+1][j+1]==0)
                {
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]+=dp[i+1][j+1]+1;
                }
            }
            lmax=dp[i][j];
            gmax=max(lmax,gmax);
        }
    }
    cout<<gmax<<endl;
}
void longestcmnsubseq(string str1,string str2)
{
    vector<vector<int>> dp(str1.length()+1,vector<int>(str2.length()+1,0));
    for(int i=str1.length()-1;i>=0;i--)
    {
        for(int j=str2.length()-1;j>=0;j--)
        {
            if(str1[i]==str2[j])
            {
                dp[i][j]+=dp[i+1][j+1]+1;
            }
            else
            {
                dp[i][j]+=max(dp[i+1][j],dp[i][j+1]);
            }
        }
    }
    for(int i=0;i<dp.size();i++)
    {
        for(int j=0;j<dp[0].size();j++)
        {
            cout<<dp[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<dp[0][0];
} 
void geeksques(string str1,string str2)
{
    vector<vector<int>> dp(str1.length()+1,vector<int>(str2.length()+1,0));
    dp[str1.length()][str2.length()]=1;
    for(int i=str1.length()-1;i>=0;i--)
    {
        for(int j=str2.length()-1;j>=0;j--)
        {
            if(str1[i]==str2[j])
            {
                dp[i][j]+=dp[i+1][j+1]+dp[i+1][j];
            }
            else{
                dp[i][j]+=dp[i+1][j];
            }
        }
    }
    for(int i=0;i<dp.size();i++)
    {
        for(int j=0;j<dp[0].size();j++)
        {
            cout<<dp[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<dp[0][0]+1;
}
/*void saturdaysunday(string str1,string str2)
{
    vector<vector<int>> dp(str1.length()+1,vector<int>(str2.length()+1,0));
    for(int i=str1.length()-1,i>=0;i--)
    {
        for(int j=str2.length()-1;j>=0;j--)
        {
            
        }
    }
}*/
void subseqnoduplidp(string str)
{
    str="$"+str;
    vector<int> dp(str.length(),0);
    vector<int> lastidx(27,-1);
    dp[0]=1;
    for(int i=1;i<str.length();i++)
    {
        dp[i]=2*dp[i-1];
        if(lastidx[str[i]-'a']!=-1)
        {
            int idx=lastidx[str[i]-'a']-1;
            dp[i]-=dp[idx];
        }
        lastidx[str[i]-'a']=i;
    }
    for(int i=0;i<dp.size();i++)
    {
        cout<<dp[i]<<" ";
    }
    cout<<endl<<dp[str.length()-1];
}
/*void aibjckdp(string str)
{
    str="$"+str;
    vector<int> dp(str.length(),0);
    dp[0]=1;
    vector<int> lastidx(27,-1);
    for(int i=1;i<str.length();i++)
    {
        int idx=lastidx[str[i]-'a']+1;
        lastidx[str[i]-'a']=i;
        dp[i]=2*dp[idx]-dp[idx-1];
    }
    for(int i=0;i<str.length();i++)
    {
        cout<<dp[i]<<" ";
    }
    cout<<endl<<dp[str.length()-1];
}*/
void longestincreasingsubseq(vector<int> &arr)
{
    vector<int> dp(arr.size(),0);
    dp[0]=1;
    for(int i=1;i<arr.size();i++)
    {
        for(int j=i-1;j>=0;j--)
        {
            if(arr[j]<arr[i])
            {
                dp[i]=max(dp[i],dp[j]);
            }
        }
        dp[i]++;
    }
    int max_=dp[0];
    for(int i=0;i<arr.size();i++)
    {
        cout<<dp[i]<<" ";
        max_=max(dp[i],max_);
    }
    cout<<endl<<max_;
}
void lds(vector<int>& arr)
{
    vector<int> dp(arr.size(),1);
    
    for(int i=arr.size()-2;i>=0;i--)
    {
        for(int j=i+1;j<arr.size();j++)
        {
            if(arr[i]>arr[j] && dp[j]+1>dp[i])
            {
                dp[i]=dp[j]+1;
            }
        }
    }
    int max_=dp[0];
    for(int i=0;i<arr.size();i++)
    {
        cout<<dp[i]<<" ";
        max_=max(dp[i],max_);
    }
    cout<<endl<<max_;
}
void lis(vector<int>& arr)
{
    vector<int> list;
    list.push_back(arr[0]);
    int len=1;
    for(int i=1;i<arr.size();i++)
    {
        if(arr[i]>list[len-1])
        {
            list.push_back(arr[i]);
            len++;
        }
        else{
            int li=0;
            int ri=len-1;
            while(li<=ri)
            {
                int mid=(li+ri)/2;
                if(list[mid]<arr[i])
                {
                    li=mid+1;
                }
                else
                {
                    ri=mid-1;
                }
            }
            list[ri]=arr[i];
        }
    }
    cout<<len+1;
}
void goldmine(vector<vector<int>>& arr)
{
    vector<vector<int>> dp(arr.size()+1,vector<int>(arr[0].size()+1,0));
    for(int i=arr.size()-1;i>=0;i--)
    {
        for(int j=arr[0].size()-1;j>=0;j--)
        {
            dp[i][j]=arr[i][j]+max(max(dp[i-1][j+1],dp[i][j+1]),dp[i+1][j+1]);
            cout<<dp[i][j]<<" ";
        }
        cout<<endl;
    }
    // int max1=dp[0][0];
     for(int i=0;i<dp.size();i++)
     {
         for(int j=0;j<dp[0].size();j++)
         {
             cout<<dp[i][j]<<" ";
         }
         cout<<endl;
     }
    // cout<<max1;
}
void square1s(vector<vector<int>>& arr)
{
    int max_=0;
    vector<vector<int>> dp(arr.size()+1,vector<int>(arr[0].size(),0));
    for(int i=arr.size()-1;i>=0;i--)
    {
        for(int j=arr[0].size()-1;j>=0;j--)
        {
            if(arr[i][j]!=0)
            {
                dp[i][j]=min(min(dp[i+1][j],dp[i][j+1]),dp[i+1][j+1])+1;
                max_=max(max_,dp[i][j]);
            }
        }
    }
    cout<<max_<<endl;
}
void coinchangepermu(vector<int> &coins,int target)
{
    vector<int> tar(target+1,0);
    tar[0]=1;
    for(int t=1;t<=target;t++)
    {
        for(int c=0;c<coins.size();c++)
        {
            if(t-coins[c]>=0)
            {
                tar[t]+=tar[t-coins[c]];
            }
        }
    }
    cout<<tar[target];
}
void coinchangecombi(vector<int> &coins,int target)
{
    vector<int> tar(target+1,0);
    tar[0]=1;
    for(int c=0;c<coins.size();c++)
    {
        for(int t=1;t<=target;t++)
        {
            if(t-coins[c]>=0)
            {
                tar[t]+=tar[t-coins[c]];
            }
        }
    }
    cout<<tar[target];
}
/*void maximumprofit(vector<vector<int>>& profit,int target)
{
    vector<vector<int>> dp(profit[0].size()+1,vector<int>(target+1,0));

    for(int i=1;i<profit[0].size();i++)
    {
        for(int j=0;j<=target;j++)
        {
            dp[0][j]
            if(j-profit[0][i]>=0)
            {
                if(dp[i-1][j-profit[0][i]]>dp[i-1][j])
                {
                    dp[i][j]+=profit[1][i]+dp[i-1][j-profit[0][i]];
                }
                else 
                {
                    dp[i][j]+=dp[i-1][j];
                }
            }
            else
            {
                dp[i][j]=0;
            }
           // cout<<dp[i][j]<<" ";
        }
    }
    cout<<dp[profit[0].size()-1][target];
}*/
void knapsack(vector<int>& weight,vector<int>& cost,int target)
{
    vector<vector<int>> dp(cost.size(),vector<int>(target+1,0));
    for(int i=0;i<cost.size();i++)
    {
        for(int j=1;j<=target;j++)
        {
            if(i==0)
            {
                dp[i][j]=(j-weight[i]>=0)?cost[i]:0;
            }
            else
            {
                int val=0;
                if(j-weight[i]>=0)
                {
                val=dp[i-1][j-weight[i]]+cost[i];
                }
                dp[i][j]+=max(dp[i-1][j],val);

            }
        }
    }
    for(int i=0;i<dp.size();i++)
    {
        for(int j=0;j<dp[0].size();j++)
        {
            cout<<dp[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<dp[cost.size()-1][target];
}
void encoding(string number)
{
    vector<int> dp(number.length()+1,0);
    dp[number.length()]=1;
    for(int i=number.length()-2;i>=0;i--)
    {
        if((number[i]-'a')*10+(number[i+1]-'a')<=26)
        {
            dp[i]=dp[i+1]+dp[i+2];
        }
        else{
            dp[i]=dp[i+1];
        }
        //cout<<dp[i]<<" ";
    }
    cout<<dp[0];
}
int mcm_rec(int st,int end,vector<int>& row,vector<int>& col,vector<vector<int>>& dp)
{
    if(st==end)
    {
        return 0;
    }
    if(dp[st][end]!=0)
    {
        return dp[st][end];
    }
    int min_=1e8;
    for(int cut=st;cut<end;cut++)
    {
        int left=mcm_rec(st,cut,row,col,dp);
        int right=mcm_rec(cut+1,end,row,col,dp);
        
        int cost=left+row[st]*col[cut]*col[end]+right;
        min_=min(min_,cost);
    }
    dp[st][end]=min_;
    return min_;
}
int cutrod(int n,vector<int>& arr)
{
    if(n<=0)
    {
        return 0;
    }
    int max_=0;
    for(int cut=0;cut<n;cut++)
    {
        int cost=arr[cut]+cutrod(n-1-cut,arr);
        max_=max(cost,max_);
    }
    return max_;
}
void mcm_dp(vector<int>& row,vector<int>& col,vector<vector<int>>& dp)
{
    
    for(int gap=0;gap<row.size();gap++)
    {
    for(int st=0,end=gap;end<row.size();st++,end++)
    {
        if(gap==0)
        {
            continue;
        }
        int min_=1e8;        
        for(int cut=st;cut<end;cut++)
        {    
        int left=dp[st][cut];
        int right=dp[cut+1][end];
        int cost=left+row[st]*col[cut]*col[end]+right;
        min_=min(min_,cost);
        }
        dp[st][end]=min_;
        }
    }
    cout<<dp[0][row.size()-1];
}

void cuttingrod_dp(vector<int>& row,vector<int>& col,vector<vector<int>>& dp)
{
    
    for(int gap=0;gap<row.size();gap++)
    {
    for(int st=0,end=gap;end<row.size();st++,end++)
    {
        if(gap==0)
        {
            continue;
        }
        int max_=0;        
        for(int cut=st;cut<end;cut++)
        {    
        int left=dp[st][cut];
        int right=dp[cut+1][end];
        int cost=left+right;
        max_=min(max_,cost);
        }
        dp[st][end]=max_;
        }
    }
    cout<<dp[0][row.size()-1];
}

int main(int args,char** argv)
 {
//     vector<vector<int>> a={{1,1},{1,0}};
//     vector<vector<int>> i={{1,1},{1,0}};
//     vector<vector<int>> ans=fibonacci(a,i,10);
//     //cout<<ans[1][0];
//     int target=10;
//     //subseqdp("pcbcpm");
//     vector<vector<int>> dp(4,vector<int>(4,0));
//     //cout<<boardpath(10,dp);
//     //boardpathitr(10,dp);
//     //cout<<multimoves(0,0,2,2,dp)<<endl;
//     /*cout<<multimovestab(0,0,2,2,dp)<<endl;    
//     *///mazepathtabulation(0,0,2,2);
//     /*for(int i=0;i<dp.size();i++)
//     {
//         for(int j=0;j<dp[0].size();j++)
//         {
//             cout<<dp[i][j]<<" ";
//         }
//         cout<<endl;
//     }*/
//     //mazepathtabulation(0,0,2,2);
//     vector<int> arr={1,3,0,4,0,0,2,1,1,0};
//     //minjumps(arr);
//     //npairs(5);
//     //divideinkgrps(5,2);
//     //substringdp("babad");
//     //ispalindrome("babad");
//     //countpalidp("babad");
//     // longestcmnsbstr("abcdgh","acdghr");
//     //longestcmnsubseq("acdghr","abcdgh");
//     //geeksques("geeksforgeeks","gks");
//     //subseqnoduplidp("ababc");
//     //aibjckdp("abcabc");
//     vector<int> arr1={0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
//     //longestincreasingsubseq(arr1);
//     //lds(arr1);
//     //lis(arr1);
//     vector<vector<int>> gm={{1,3,3},{2,1,4},{0,6,4}};
//     //goldmine(gm);
//     //vector<vector<int>> ones={{1,1,1,1,1,0},{0,0,1,1,1,0},{1,1,1,1,1,1},{0,1,1,1,1,1},{0,1,1,0,1,1},{1,1,1,1,1,1}};
//     //square1s(ones);
//     vector<int> coins={2,3,5,7};
//     //coinchangepermu(coins,10);
//     //coinchangecombi(coins,10);
//     /*vector<vector<int>> profit={{1,10},{3,40},{4,50},{5,70}};
//     maximumprofit(profit,8);*/
//     vector<int> weight={1,3,4,5};
//     vector<int> cost={10,40,50,70};
//     //knapsack(weight,cost,8);
//     //encoding("11028");
    vector<int> row={1,5,8,8,9,10,17,17};
    vector<int> col={5,8,8,9,10,17,17,20};
    //vector<vector<int>> dp(row.size(),vector<int>(row.size(),0));
    // //cout<<mcm_rec(0,row.size()-1,row,col,dp);
    // mcm_dp(row,col,dp);
    //cuttingrod_dp(row,col,dp);
    vector<int> arr={1,5,8,9,10,17,17,20};
    cout<<cutrod(8,arr);
}

