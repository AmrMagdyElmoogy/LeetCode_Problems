class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        int l = 0;
        vector<int>H(26);
        int result = 0;
        for(int i=0; i<answerKey.size();i++)
        {
            H[answerKey[i]-'A']++;
            int maxx = *max_element(H.begin(),H.end());
            if(i-l+1 - maxx <= k)
                result = max(result,i-l+1);
            else 
            {
                H[answerKey[l]-'A']--;
                l++;
            }
        }
        return result;
    }
};