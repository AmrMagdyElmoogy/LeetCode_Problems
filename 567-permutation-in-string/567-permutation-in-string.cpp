class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if(s1.size()>s2.size())
            return false;
        int l = 0;
        vector<int>H1(26);
        vector<int>H2(26);
        int matches = 0;
        for(int i=0; i<s1.size();i++)
        {
            H1[s1[i]-'a']++;
            H2[s2[i]-'a']++;
        } 
        for(int i=0; i<26;i++)
            if(H1[i] == H2[i])
                matches++;
        for(int i=s1.size();i<s2.size();i++)
        {
            if(matches == 26)
                return true;
            
            int index = s2[i] - 'a';
            H2[index]++;
            if(H1[index] == H2[index])
                matches++;
            else if(H1[index] +1 == H2[index])
                matches--;
            index = s2[l] - 'a';
            H2[index]--;
            if(H1[index] == H2[index])
                matches++;
            else if(H1[index] - 1 == H2[index])
                matches--;
            l++;
        } 
        return matches == 26;
    }
};