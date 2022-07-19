class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        map<char,int>mp;
        for(int i=0; i<magazine.size();i++)
        {
            if(mp.count(magazine[i]) == 0)
            {
                mp.insert({magazine[i],1});
            }
            else 
            {
                mp[magazine[i]]++;
            }
        } 
        for(int i=0; i<ransomNote.size();i++)
        {
            if(mp[ransomNote[i]] > 0)
                mp[ransomNote[i]]--;
            else
                return false;
        }
        return true;
    }
};