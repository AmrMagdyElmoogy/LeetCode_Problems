class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int l = 0;
        int r = 0;
        vector<int>result = nums1;
        nums1.clear();
        while(l<m && r<n)
        {
            if(result[l] <=nums2[r])
            {
                nums1.push_back(result[l]);
                l++;
            }
            else if(result[l] > nums2[r])
            {
                nums1.push_back(nums2[r]);
                r++;
            } 
           
        }  
        for(int i=l ; i<m;i++)
            nums1.push_back(result[i]);
        for(int i=r;i<n;i++)
            nums1.push_back(nums2[i]);
  
    }
};