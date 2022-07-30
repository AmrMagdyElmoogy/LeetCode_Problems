class Solution {
public:
    int factOfN  = 0;
    int numTrees(int n) {
        return catalanNumber(2*n,n) / (n+1);
    }  
    long catalanNumber(int n, int r)
    {
        long long ans = 1;
        for(int i=0; i<r;i++)
        {
            ans*= n-i;
            ans/= i+1;
        } 
        return ans;
    }
 
    
};