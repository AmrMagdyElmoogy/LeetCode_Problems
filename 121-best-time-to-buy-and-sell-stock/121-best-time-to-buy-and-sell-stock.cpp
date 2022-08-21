class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int l = 0;
        int r = 0;
        int n = prices.size();
        int maxP = 0;
        int profit = 0;
        while(r<n)
        {
            if(prices[l] < prices[r])
            {
                profit = prices[r]-prices[l];
                maxP = max(profit,maxP);
            }
            else 
                l = r;
            r++;
        } 
        return maxP;
    }
};