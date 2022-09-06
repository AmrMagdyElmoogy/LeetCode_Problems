class Solution {
public:
    vector<int> numsSameConsecDiff(int n, int k) {
        vector<int>result;
        for(int i=1;i<=9;i++)
            DFS(n-1,i,k,result);
        return result;
    }
    
    void DFS(int n,int num,int k,vector<int>&result){
        if(n==0)
        {
            result.push_back(num);
            return;
        }

        vector<int>v;
        int lastDigit = num%10;
        v.push_back(lastDigit+k);
        if(k!=0)
            v.push_back(lastDigit-k);
        for(int i=0; i<v.size();i++)
        {
            if(v[i] >=0 && v[i]<10)
            {
                int newInt = (num*10) + v[i];
                DFS(n-1,newInt,k,result);
            }

        }
    }
    
};