class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string>result;
        generateParentheses(n,0,0,"",result);
        return result;
    }
    void generateParentheses(int n, int open,int close,string s, vector<string>&result){
        if(open == n && close == n)
        {
            result.push_back(s);
            return;
        } 
        if(open < n)
            generateParentheses(n,open+1,close,s + "(",result);
        if(open > close)
            generateParentheses(n,open,close+1,s + ")",result);
        
    }
};