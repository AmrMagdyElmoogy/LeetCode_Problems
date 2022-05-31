class Solution {
public:
    string frequencySort(string s) {
        vector<int>v(63);
        for(int i=0; i<s.size();i++)
        {
            if(islower(s[i]))
                v[s[i]-'a']++;
            else if(isupper(s[i]))
                v[s[i]-'A' + 26]++;
            else if(isdigit(s[i]))
                v[s[i]-'0'+ 53]++;
        } 
        multimap<int,char,greater<int>> m;
        for(int i=0; i<v.size();i++)
        {
            if(v[i]>0)
            { 
                if(i<26)
                {
                   char c = i+'a';
                   m.insert({v[i],c});
                } 
                
                else if(i>52)
                {
                    char c = i - 53 +'0';
                    m.insert({v[i],c});
                }
                else 
                {
                    char c = i-26+'A';
                    m.insert({v[i],c});
                }
            } 
        } 
        string result = "";
        for(auto it = m.begin();it!=m.end();it++)
        {
            for(int i=0; i<it->first;i++)
            {
                result+= it->second;
            }
        }  
        return result;
    }
};