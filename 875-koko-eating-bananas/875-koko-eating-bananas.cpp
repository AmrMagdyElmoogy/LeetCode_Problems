class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int l = 1;
        long int r = *max_element(piles.begin(),piles.end());
        long int result = r;
        
        while(l<=r)
        {
            long int mid = l+(r-l)/2;
            long int hours = 0;
            for(int i=0; i<piles.size();i++)
            {
                hours += ceil((double)piles[i]/mid);
            }
            if(hours <= h)
            {
                result = min(result,mid);
                r = mid - 1;
            }
            else 
                l = mid + 1;
        }
        return result;
    }  


};