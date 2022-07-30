class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        vector<pair<int,int>>v;
        map<int,int>mp;

        int n = nums.size();
        for(int i=0; i<n;i++)
        {
            if(mp.count(nums[i]))
                mp[nums[i]]++;
            else 
                mp.insert({nums[i],1});
        }
        for(auto it = mp.begin();it!=mp.end();it++)
        {
            v.push_back({it->first,it->second});
        } 
        sort(v.begin(), v.end(),
              [] (const auto &x, const auto &y) {return x.second > y.second;});
        vector<int>res;
        for(int i = 0; i<k;i++){
            res.push_back(v[i].first);
        } 
        return res;
    } 
};