class Solution {
public:
    string convertToTitle(int columnNumber) {
        string result = "";
        while(columnNumber > 0)
        {
            int quo = (columnNumber-1) % 26;
            result.push_back('A'+quo);
            columnNumber= (columnNumber-1)/26;
        } 
        reverse(result.begin(),result.end());
        return result;
    }
};