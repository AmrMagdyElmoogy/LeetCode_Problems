class Solution {
public:
    vector<int> findClosestElements(vector<int>& nums, int k, int x) {
        int n = nums.size();
        int l = 0;
        int r = nums.size()-k;
        while(l<r)
        {
            int mid = (l+r)/2;
            if(x-nums[mid] > nums[mid+k]-x)
                l = mid + 1;
            else 
                r = mid;
        } 
        vector<int>result = {nums.begin()+l,nums.begin()+l+k};
        return result;
        
    }
};