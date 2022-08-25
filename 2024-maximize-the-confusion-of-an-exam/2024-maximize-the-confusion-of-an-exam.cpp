class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        int l = 0;
        int trueAnswers = 0;
        int falseAnswers = 0;
        int result = 0;
        for(int i=0; i<answerKey.size();i++)
        {
            answerKey[i] == 'T' ? ++trueAnswers : ++falseAnswers;
            int maxx = max(trueAnswers,falseAnswers);
            if(i-l+1 - maxx <= k)
                result = max(result,i-l+1);
            else 
            {
                answerKey[l] == 'T' ? --trueAnswers : --falseAnswers;
                l++;
            }
        }
        return result;
    }
};