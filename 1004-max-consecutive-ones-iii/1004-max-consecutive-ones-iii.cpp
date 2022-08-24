class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int l = 0;
   
        int zeros = 0;
        int result = 0;
        for(int i=0; i<nums.size();i++)
        {
            if(nums[i] == 0)
                zeros++;
            if(zeros <= k)
            {
                result = max(result,i-l+1);
            }
            else 
            {
                if(nums[l]== 0)
                    zeros--;
                l++;
            }
            
        } 
        return result;
    }
};