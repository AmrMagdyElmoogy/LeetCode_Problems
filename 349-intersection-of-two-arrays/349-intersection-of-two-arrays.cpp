class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        set<int>s;
        vector<int>result;
        sort(nums1.begin(),nums1.end());
        for(int i=0;i<nums2.size();i++)
        {
            s.insert(nums2[i]);
        } 
        for(auto it = s.begin();it!=s.end();it++)
        {
            int target = *it;
            int l = 0;
            int r = nums1.size()-1;
            while(l<=r)
            {
                int mid = l+(r-l)/2;
                if(nums1[mid] == target)
                {
                    result.push_back(target);
                    break;
                }
                else if(nums1[mid] < target)
                    l =  mid + 1;
                else 
                    r =  mid - 1;
            }
        } 
        return result;
    }
};