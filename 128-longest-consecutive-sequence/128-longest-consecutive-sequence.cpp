class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int,int>m;
        for(int i=0; i<nums.size();i++)
            m[nums[i]]++;
        int longestStreak = 0;
        for(auto it = m.begin();it!=m.end();it++)
        {
            int key = it->first;
            int currentStreak = 1;
            if(m.count(key-1) == 0)
            {
                key++;
                while(m.count(key) > 0)
                {
                    currentStreak++;
                    key++;
                }

            }
            longestStreak = max(longestStreak,currentStreak);
        } 
        return longestStreak;
    }
};