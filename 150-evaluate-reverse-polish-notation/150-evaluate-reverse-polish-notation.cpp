class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int>st;
        int result= 0;
        vector<int>elements(2);
        for(int i=0; i<tokens.size();i++)
        {
            string c = tokens[i];
            if(c == "+")
            {
                elements = getFirstAndSecondElements(st);
                result = elements[0] + elements[1];
                st.push(result);
            }
            else if(c == "-")
            {
                elements = getFirstAndSecondElements(st);
                result = elements[0] - elements[1];
                st.push(result);
            }
            else if(c == "*")
            {
                elements = getFirstAndSecondElements(st);
                result = elements[0] * elements[1];
                st.push(result);
            }
            else if(c == "/")
            {
                elements = getFirstAndSecondElements(st);
                result = floor(elements[0] / elements[1]);
                st.push(result);
            }
            else
            {
                st.push(convertToInt(c));
            }                    
        } 
        return st.top();
    }
    
    vector<int> getFirstAndSecondElements(stack<int>&st){
        vector<int>res(2);
        res[1] = st.top();
        st.pop();
        res[0] = st.top();
        st.pop();
        return res;
    }
    int convertToInt(string s)
    {
        int sum = 0;
        bool v = false;
        if(s[0] == '-')
            v = true;
        for(int i=0; i<s.size();i++)
        {
            if(s[0] == '-' && i == 0)
                continue;
            sum += (s[i]-'0') * pow(10,s.size()-i-1);
        }
        if(v)
            sum -= sum*2;
        return sum;
    }
};