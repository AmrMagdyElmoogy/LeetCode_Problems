class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int>st;
        int result= 0;
        int first,second;
        first = second = 0;
        for(int i=0; i<tokens.size();i++)
        {
            string c = tokens[i];
            if(c == "+")
            {
                first = st.top(); 
                st.pop();
                second = st.top();
                st.pop();
                result = second + first;
                st.push(result);
            }
            else if(c == "-")
            {
                first = st.top(); 
                st.pop();
                second = st.top();
                st.pop();
                result = second - first;
                st.push(result);
            }
            else if(c == "*")
            {
               first = st.top(); 
                st.pop();
                second = st.top();
                st.pop();
                result = second * first;
                st.push(result);
            }
            else if(c == "/")
            {
                first = st.top(); 
                st.pop();
                second = st.top();
                st.pop();
                result = floor(second / first);
                st.push(result);
            }
            else
            {
                st.push(stoi(c));
            }                    
        } 
        return st.top();
    }
};