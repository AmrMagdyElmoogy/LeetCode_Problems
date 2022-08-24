class Solution {
public:
    int numberOfSubstrings(string s) {
        int l = 0;
        vector<int>H(3);
        int result = 0;
      
        for(int i=0; i<s.size();i++)
        {
            H[s[i]-'a']++;
            
            while(H[0] >=1 && H[1]>=1 && H[2]>=1)
            {
                result+= s.size()-i;
                H[s[l]-'a']--;
                l++;
            }
          
        } 
        return result;  
    }
};