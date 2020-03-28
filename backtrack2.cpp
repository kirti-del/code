#include<iostream>
#include<string>
#include<vector> 
#include<climits>
using namespace std;
void subseq(string ques,string ans)
{
    if(ques.length()==0)
    {
        cout<<ans<<" ";
        return;
    }
    subseq(ques.substr(1),ans+ques[0]);
    subseq(ques.substr(1),ans);
}
void removehi(string ques,string ans)
{
    if(ques.length()==0)
    {
        cout<<ans<<" ";
        return;
    }
    if(ques.length()>1 && ques.substr(0,2)=="hi")
    {
        removehi(ques.substr(2),ans);
    }
    else
    {removehi(ques.substr(1),ans+ques[0]);
    }
}
void removedupli(string ques,string ans)
{
    if(ques.length()==0)
    {
        cout<<ans;
        return;
    }
    if(ques.length()>1 && ques[0]==ques[1])
    {
        removedupli(ques.substr(1),ans);
    }
    else{
        removedupli(ques.substr(1),ans+ques[0]);
    }
}
void stringcompress(string ques,string ans,int count)
{
    if(ques.length()==0)
    {
        cout<<ans;
        return;
    }
    if(ques.length()>1 && ques[0]==ques[1])
    {
        stringcompress(ques.substr(1),ans,count+1);
    }
    else{
        if(count!=1)
        {
        stringcompress(ques.substr(1),ans+ques[0]+to_string(count),1);
        }
    }
}
void mazepath(int sr,int er,int sc,int ec,string ans)
{
    if(sr==er && sc==ec)
    {
        cout<<ans<<endl;
        return;
    }
    if(sr+1<=er)
    {
        mazepath(sr+1,er,sc,ec,ans+"H");
    }
    if(sc+1<=ec)
    {
        mazepath(sr,er,sc+1,ec,ans+"V");
    }
}
void boardpath(int si,int arr,string ctr)
{
    if(si==arr)
    {
        cout<<ctr<<" ";
        return;
    }
    for(int i=1;si+i<=arr && i<=6;i++)
    {
    boardpath(si+i,arr,ctr+to_string(i));
    }
}
int permutations(string ques,string ans)
{
    if(ques.length()==0)
    {
        cout<<ans<<endl;
        return 1;
    }
    int ctr=0;
    for(int i=0;i<ques.length();i++)
    {
        char ch=ques[0];
        string roq=ques.substr(0,i)+ques.substr(i+1);
        ctr+=permutations(roq,ans+ch);
    }
 return ctr;
}
int permutations2(string ques,string ans)
{
    if(ques.length()==0)
    {
        cout<<ans<<endl;
        return 1;
    }
    int mapping=0;
    int ctr=0;
    for(int i=0;i<ques.length();i++)
    {
        char ch=ques[i];
        if((mapping & (1<<(ch-'a')))==0)
        {
            mapping|=~(1<<(ch-'a'));
            string roq=ques.substr(0,i)+ques.substr(i+1);
            ctr+=permutations2(roq,ans+ch);
        }
    }
    return ctr;
}
/*int unique(vector<int> arr1)
{

}*/
int coinchangeper(vector<int> arr,int vidx,int target,string ans)
{
    if(target==0)
    {
        cout<<ans<<" ";
        return 1;
    }
    int count=0;
    for(int ele:arr)
    {
         if(target-ele>=0)
         {
            count+=coinchangeper(arr,vidx,target-ele,ans+to_string(ele));
         }
    }
    return count;
}
int coinchangeper2(vector<int> arr,vector<bool> isdone,int vidx,int target,string ans)
{
    if(target==0)
    {
        cout<<ans<<" ";
        return 1;
    }
    int count=0;
    for(int i=0;i<arr.size();i++)
    {
        if(isdone[i]==false)
        {
            int ele=arr[i];
            isdone[i]=true;
         if(target-arr[i]>=0)
         {
            count+=coinchangeper2(arr,isdone,i,target-ele,ans+to_string(ele));
            isdone[i]=false;
         }
        }
    }
    return count;
}
int coinchangecombi2(vector<int> arr,int vidx,int target,string ans)
{
    if(target==0)
    {
        cout<<ans<<" ";
        return 1;
    }
    int count=0;
    for(int i=vidx;i<arr.size();i++)
    {
        if(target-arr[i]>=0)
        {
            count +=coinchangecombi2(arr,i,target-arr[i],ans+to_string(arr[i]));
        }
    }
    return count;
}
int coinchangecombi(vector<int> arr,int vidx,int target,string ans)
{
    if(target==0)
    {
        cout<<ans<<" ";
        return 1;
    }
    int count=0;
    for(int i=vidx;i<arr.size();i++)
    {
        if(target-arr[i]>=0)
        {
            count +=coinchangecombi(arr,i+1,target-arr[i],ans+to_string(arr[i]));
        }
    }
    return count;
}
int equiset(vector<int> &arr,int vidx,int set1,int set2,string ans1,string ans2)
{
    if(vidx==arr.size())
    {
        if(set1==set2)
        {
            cout<<ans1<<"="<<ans2<<endl;
            return 1;
        }
        return 0;
    }
    int count=0;
    count+=equiset(arr,vidx+1,set1+arr[vidx],set2,ans1+to_string(arr[vidx])+" ",ans2);
    count+=equiset(arr,vidx+1,set1,set2+arr[vidx],ans1,ans2+to_string(arr[vidx])+" ");
    return count;
}
int coinchange2(vector<int> &arr,int vidx,int target,string ans)
{
    if(vidx==arr.size()||(target==0 && ans.length()!=0))
    {
        cout<<ans<<" ";
        return 1;
    }
    int count=0;
    if(target-arr[vidx]>=0)
    {
        count+=coinchange2(arr,vidx,target-arr[vidx],ans+to_string(arr[vidx]));
    }
    count+=coinchange2(arr,vidx+1,target,ans);
    return count;
}
int nqueens(int boxes,int tnq,int qloc,int qpsf,string ans)
{
    if(qpsf==tnq)
    {
        cout<<ans<<" ";
        return 1;
    }
    int count=0;
    for(int i=qloc+1;i<boxes;i++)
    {
        count+=nqueens(boxes,tnq,i,qpsf+1,ans+"b"+to_string(i+1)+"q"+to_string(qpsf+1)); 
    }
    return count;
}
int nqueens2(int boxes,int tnq,int qpsf,vector<bool>& isdone,string ans)
{
    if(qpsf==tnq)
    {
        cout<<ans<<" ";
        return 1;
    }
    int count=0;
    for(int i=0;i<=boxes;i++)
    {
        if(isdone[i]==false)
        {
            isdone[i]=true;
            count+=nqueens2(boxes,tnq,qpsf+1,isdone,ans+"b"+to_string(i+1)+"q"+to_string(qpsf+1));
            isdone[i]=false;
        }
    }
    return count;
}
int nqueenscombi(int boxes,int tnq,int qpsf,int qloc,string ans)
{
    if(qpsf==tnq || qloc==boxes)
    {
        if(qpsf==tnq)
        {
        cout<<ans<<" ";
        return 1;
        }
        return 0;
    }
    int count=0;
    count += nqueenscombi(boxes,tnq,qpsf+1,qloc+1,ans+"b"+to_string(qloc+1)+"q"+to_string(qpsf+1));
    count += nqueenscombi(boxes,tnq,qpsf,qloc+1,ans);
    return count;
}
/*int nqueensper(int boxes,int qpsf,int qloc,vector<bool>& isdone,string ans)
{
    int count=0;
    if(!isdone[qloc])
    {
        isdone[qloc]=true;
        count+=nqueensper(boxes,tnq,)
    }
}*/
bool is_safetoplace(vector<vector<bool>>& boxes,int x,int y)
{
    int dir[4][2]={{0,-1},{-1,-1},{-1,0},{-1,1}};
    for(int d=0;d<4;d++)
    {
        for(int rad=1;rad<boxes[0].size();rad++)
        {
            int r=x+rad*dir[d][0];
            int c=y+rad*dir[d][1];
            if(r>=0 && c>=0 && r<boxes.size() && c<boxes[0].size() && boxes[r][c])
            {
                return false;
            }
        }
    }
    return true;
}
void nqueens1(vector<vector<bool>>& boxes,int i,int qpsf,int tnq,string ans)
{
    if(qpsf==tnq || i>=boxes.size()*boxes[0].size())
    {
        if(qpsf==tnq)
        {
            cout<<ans<<endl;
        }
        return;
    }
            int x=i/boxes.size();
            int y=i%boxes[0].size();
    if(is_safetoplace(boxes,x,y))
    {
            boxes[x][y]=true;
            nqueens1(boxes,i+1,qpsf+1,tnq,ans+"("+to_string(x)+","+to_string(y)+")");
            boxes[x][y]=false;
    }
    nqueens1(boxes,i+1,qpsf,tnq,ans);
}
string a="send";
string b="more";
string c="money";
string str=a+b+c;
vector<int> mapping(26,-1);
vector<bool> numused(10,false);
int decode(string str)
{ 
    int res=0;
    for(int i=0;i<str.length();i++)
    {
        int num=mapping[str[i]-'a'];
        res=res*10+num;
    }
    return res;
}
int crypto(string str,int idx)
{
    if(idx==str.length())
    {
        int num1=decode(a);
        int num2=decode(b);
        int num3=decode(c);
        if(num1+num2==num3)
        {
            cout<<num1<<" +"<<num2<<"="<<num3 <<endl;
            return 1;
        }
        return 0;
    }
    char ch=str[idx];
    int count=0;
    for(int i=0;i<10;i++)
    {
        if(!numused[i])
        {
            numused[i]=true;
            mapping[ch-'a']=i;
            count+=crypto(str,idx+1);
            numused[i]=false;
            mapping[ch-'a']=-1;
        }
    }
    return count;
}
void encoding(string str)
{
    vector<int> freqmap(26,0);
    for(int i=0;i<str.length();i++)
    {
        int idx=str[i]-'a';
        freqmap[idx]++;
    }
    string ans="";
    for(int i=0;i<26;i++)
    {
        if(freqmap[i]!=0)
        {
            ans+=(char)(i+'a');
        }
    }
    cout<<crypto(ans,0);
}
vector<string> dict={"i","ili","ilike","ke","man","mango","and","sam","samsung","sung"};
bool checkword(string word)
{
    for(string s:dict)
    {
        if(s.compare(word)==0)
        {
            return true;
        }
    }
    return false;
}
int wordbreak(string word,string ans)
{
    if(word.length()==0)
    {
        cout<<ans<<endl;
        return 1;
    }
    string temp="";
    int count=0;
    for(int i=0;i<word.length();i++)
    {
        temp+=word[i];
        if(checkword(temp))
        {
           count+= wordbreak(word.substr(i+1),ans+temp+" ");
        }
    }
    return count;
}
/*bool isvalid(vector<vector<int>> boxes,int r,int c,int num)
{
    for(int idx=0;idx<boxes[0].size();idx++)
    {
        if(arr[r][idx]==num)
        {
            return false;
        }
    }
    
    for(int idx=0;idx<boxes.size();idx++)
    {
        if(arr[idx][c]==num)
        {
            return false;
        }
    }
    int x=(r/3)*3;
    int y=(c/3)*3;
    for(int row=0;row<3;row++)
    {
        for(int col=0;col<3;col++)
        {
            if(arr[row+x][row+y]==num)
            {
                return false;
            }
        }
    }
    return true;
}*/
/*bool sudoku(vector<vector<int>> boxes,int vidx)
{
        if(vidx==boxes.size()*boxes[0].size())
        {

        }
        int r=vidx/9;
        int c=vidx%9;
        if(boxes[r][c]==0)
        {
            for(int num=1;num<=9;num++)
            {
                int mask=1<<num;
                if((row[r]&num)==0 && (col[c]&num)==0 && (mat[r/3][c/3]&num)==0)
                {
                    boxes[r][c]=num;
                    row[r]|=mask;
                    col[c]|=mask;
                    mat[r/3][c/3]|=mask;
                    count+=sudoku(boxes,vidx+1);
                    boxes[r][c]=0;
                    row[r]^=mask;
                    col[c]^=mask;
                    mat[r/3][c/3]^=mask;
                }
            }
        }
        return count;
}*/
void solve()
{
    //subseq("abc","");
    //removehi("hihiii","");
    //removedupli("aaabbccc","");
    //stringcompress("aaaabbbbcccc","",1);
    //mazepath(0,2,0,2,"");
    //multimoves(0,2,0,2,"");
    //boardpath(0,10,"");
    //cout<<permutations2("abcd","");
    //vector<int> arr={2,3,5,7};
    vector<vector<bool>> boxes(4,vector<bool>(4,false));
    //vector<bool> isdone(arr.size(),false);
    //cout<<coinchangeper2(arr,isdone,0,10,"");
    //cout<<coinchangecombi2(arr,0,10,"");
    //cout<<coinchangecombi(arr,0,10,"");
    //cout<<equiset(arr,0,0,0,"","");
    //cout<<coinchange2(arr,0,10,"");
    //cout<<nqueens(5,3,-1,0,"");
    //cout<<nqueens2(7,3,0,isdone,"");
   // cout<<nqueenscombi(7,3,0,0,"");
   //nqueens1(boxes,0,0,4,"");
   //encoding(str);
   //cout<<wordbreak("ilikemangoandsamsung","");
}
int main(int args,char** ch)
{
    solve();
    return 0;
}
