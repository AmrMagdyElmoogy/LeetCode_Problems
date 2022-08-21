class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int currentSub = 0;
        int longestSub = 0;
        map<int,int>m;
        for(int i=0; i<s.size();i++)
        {
            if(m.count(s[i]) == 0)
            {
                currentSub++;
                m.insert({s[i],i});
            }
            else 
            {
                longestSub = max(longestSub,currentSub);
                i = m[s[i]];
                m.clear();
                currentSub = 0;    
            }
        
        } 
        longestSub = max(longestSub,currentSub);
        return longestSub;
    }
};