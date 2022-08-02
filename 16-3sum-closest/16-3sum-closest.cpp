class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
          int maxx = nums[0] + nums[1] + nums[nums.size()-1];
          sort(nums.begin(),nums.end());
          for(int i=nums.size()-1; i>0;i--)
          {
              int r = i-1;
              int l = 0;
              while(l < r)
              {
                  int sum = nums[l]+nums[r]+nums[i];
                  if(abs(sum - target) < abs(maxx-target))
                      maxx = sum;
                  if(sum > target)
                       r--;
                  else
                      l++;
              }
          }
        return maxx;

    }
};