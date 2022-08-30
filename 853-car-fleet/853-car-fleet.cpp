class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        map<int,int,greater<int>>m;
        for(int i=0; i<position.size();i++)
            m.insert({position[i],speed[i]});
        stack<pair<int,int>> st;
        double first = 0;
        double distance = 0;
        for(auto it = m.begin();it!=m.end();it++)
        {
            distance = (double)(target-it->first)/it->second;
            st.push({it->first,distance});
            if(st.size() >= 2)
            {
                if(distance <= first)
                  st.pop();
                else 
                    first = distance;
            }
            else 
            {
                first = distance;
            }
        }
       return st.size();
        
    }
};