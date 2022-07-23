class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        map<long long,int> map;
        long long num = 0;
        int maxx = *max_element(nums.begin(),nums.end());
        if(maxx<=0)
            return 1;
        for(int i=0; i<nums.size();i++)
        {
            map[nums[i]] = 1;
        } 
        for(int i=1; i<=maxx;i++)
        {
            if(map[i]!= 1)
            {
                num = i;
                break;
            }
        }
        if(num == 0)
            return maxx+1;
        return num;
    }
};