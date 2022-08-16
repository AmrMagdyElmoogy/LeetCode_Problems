class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
   
        vector<int>result;
        sort(nums1.begin(),nums1.end());
        for(int i = 0; i<nums2.size();i++)
        {
            int target = nums2[i];
            int l = 0;
            int r = nums1.size()-1;
            while(l<=r)
            {
                int mid = l+(r-l)/2;
                if(nums1[mid] == target)
                {
                    result.push_back(target);
                    nums1.erase(nums1.begin()+mid);
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