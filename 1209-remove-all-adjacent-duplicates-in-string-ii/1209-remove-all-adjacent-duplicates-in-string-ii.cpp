class Solution {
public:
    string removeDuplicates(string s, int k) {
        int n = s.size(); 
        vector<int> f(n,1);
        string ans; 
        stack<int> st;
        st.push(0); 
        for(int i=1; i<n;i++)
        {
            if(!st.empty())
            {
                if(s[st.top()] == s[i])
                {
                    f[i] = f[st.top()]+1;
                } 
            } 
            st.push(i); 
            if(f[st.top()] == k)
            {
                for(int i=0; i<k;i++)
                    st.pop();
            } 
        } 
        while(!st.empty())
        {
            ans+= s[st.top()]; 
            st.pop();
        } 
        reverse(ans.begin(),ans.end()); 
        return ans;
    }
};