class Solution {
public:
    int minSteps(string s, string t) {
        vector<int>v(26);
        vector<int>v2(26);
        for(int i=0; i<s.size();i++)
        {
            v[s[i]-'a']++;
            v2[t[i]-'a']++;
        } 
        int result = 0;
        for(int i=0; i<t.size();i++)
        {
            if(v2[t[i]-'a'] > v[t[i]-'a'])
            {
                result += v2[t[i]-'a']-v[t[i]-'a'];
                v2[t[i]-'a']=0;
            }
                
        } 
        return result;
    }
};