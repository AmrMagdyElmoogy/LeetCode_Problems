class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        stack<pair<int,int>>st;
        vector<int>v(temperatures.size());
        for(int i=0; i<temperatures.size();i++)
        {
            if(st.empty())
            {
                st.push({temperatures[i],i});
            }
            else 
            {
                while(!(st.empty()) && temperatures[i] > st.top().first)
                {
                    pair<int,int> value = st.top();
                    int index = value.second;
                    v[index] = i - index;
                    st.pop();
                } 
                st.push({temperatures[i],i});
            } 
        }
        return v;
    }
};