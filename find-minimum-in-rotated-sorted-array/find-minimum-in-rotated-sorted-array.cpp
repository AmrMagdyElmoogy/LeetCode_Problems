class Solution {
public:
    int findMin(vector<int>& nums) {
        int l = 0;
        int r = nums.size()-1;
        int result = 1;
        if(nums.size()<=1)
            return nums[0];
        if(nums[r] > nums[0])
            return nums[0];
        while(l<r)
        {
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[mid+1])
            {
                result = nums[mid+1];
                break;
            }
            else if(nums[mid-1] > nums[mid])
            {
                result = nums[mid];
                break;
            }
            if(nums[mid] > nums[0])
                l = mid + 1;
            else 
                r = mid;
           
        
        }
        return result;
        
    }
};