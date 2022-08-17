class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        map<int,int>m;
        for(int i=0; i<nums.size();i++)
            m[nums[i]]++;
        int result = 0;
        for(auto it = m.begin();it!=m.end();it++)
        {
           if(it->second > 1){
                result = it->first;
                break;
            } 
        }
        return result;    
    }
};