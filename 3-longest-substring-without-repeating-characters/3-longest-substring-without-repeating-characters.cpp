class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int longestSub = 0;
        int l = 0;
        set<int>non;
        int i = 0;
        while(i<s.size())
        {
            //not found
            if(non.find(s[i]) == non.end())
            {
                non.insert(s[i]);
                longestSub = max(longestSub,i-l+1);
                i++;
            }
            else 
            {
                non.erase(s[l]);   
                l++;
            }
        }
        return longestSub;
    }
};