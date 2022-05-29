class Solution {
public:
    int maxProduct(vector<string>& words) {
        int result = 0;
        vector<int>stringAsInteger;
        vector<int>len;
        for(int i=0; i<words.size();i++)
        {
            string x = words[i];
            int number = 0;
            for(int j=0;j<x.size();j++)
            {
                number|= (1<<(x[j]-'a'));
            } 
            stringAsInteger.push_back(number);
            len.push_back(x.size());
        }
        for(int i=0; i<stringAsInteger.size()-1;i++)
        {
            for(int j=i+1; j<stringAsInteger.size();j++)
            {
                if((stringAsInteger[i] & stringAsInteger[j]) == 0)
                    result = max(result,(len[i] * len[j]));
            } 
        } 
        return result;
    }
};