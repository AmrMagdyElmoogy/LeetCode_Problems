class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        return {BinarySearch(nums,target,false), BinarySearch(nums,target,true)};
    } 
    int BinarySearch(vector<int>nums, int target, bool find)
    {
        int l = 0;
        int r = nums.size()-1;
        int result = -1;
        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(nums[mid] == target)
            {
                result = mid;
                find == false ? r = mid - 1 : l = mid + 1;
            }
            else if(nums[mid] < target)
                l = mid + 1;
            else 
                r = mid - 1;
        } 
        return result;       
    }
};