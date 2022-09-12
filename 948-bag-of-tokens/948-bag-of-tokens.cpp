class Solution {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
        int score = 0;
        int l = 0;
        int r = tokens.size()-1;
        if(tokens.size()==1)
        {
            if(power >= tokens[0])
                score++;
            return score;
        }
        sort(tokens.begin(),tokens.end());
        while(l<=r)
        {
            if(power >= tokens[l])
            {
                power -= tokens[l];
                score++;
                l++;
            }  
            else if (score > 0)
            {
                if(l!=r)
                {
                    power += tokens[r];
                    score--;
                }
                r--;
            }
            else
            {
                l++;
                r--;
            }
        }
        return score;
    }
};