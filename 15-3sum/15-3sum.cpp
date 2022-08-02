class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
      sort(nums.begin(),nums.end());
      set<vector<int>>v;
        vector<vector<int>>result;
      for(int i=nums.size()-1; i>0;i--)
      {
          int r = i-1;
          int l = 0;
          while(l < r)
          {
              int sum = nums[l]+nums[r]+nums[i];
              if(sum == 0)
              {
                  v.insert({nums[i],nums[l],nums[r]}); 
                  r--;
                  l++;
              } 
              else if(sum > 0)
                  r--;
              else 
                  l++;
                  
          }
      }

        for(auto it = v.begin();it!=v.end();it++)
        {
            result.push_back(*it);
        }
        return result;
    }
};