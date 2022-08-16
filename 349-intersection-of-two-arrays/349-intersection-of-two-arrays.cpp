class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        set<int>s;
        map<int,int>m;
        vector<int>result;
        for(int i=0; i<nums1.size();i++)
            m[nums1[i]]++;
        for(int i=0; i<nums2.size();i++)
            s.insert(nums2[i]);
        for(auto it = s.begin();it!=s.end();it++)
        {
            int key = *it;
            if(m[key]!=0)
                result.push_back(key);
        }
        return result;
    }
};