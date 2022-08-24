class Solution {
public:
    int characterReplacement(string s, int k) {
        int l = 0;
        int distance = 0;
        vector<int>H(26);
        for(int i=0; i<s.size();i++)
        {
            H[s[i]-'A']++;
            int maxx = *max_element(H.begin(),H.end());
            if(i-l+1 - maxx > k) 
            {
                H[s[l]-'A']--;
                l++;
            }
            distance = max(distance,i-l+1);
        } 
        return distance;
    }
};