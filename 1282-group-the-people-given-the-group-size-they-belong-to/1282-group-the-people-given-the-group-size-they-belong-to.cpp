class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        map<int,vector<int>>m;
        vector<vector<int>>v;
        for(int i=0; i<groupSizes.size();i++)
        {
            int key = groupSizes[i];
            if(m.count(key) > 0)
                m[key].push_back(i);
            else 
            {
                m[key] = vector<int>{i};
            }
            if(m[key].size() == key)
            {
                v.push_back(m[key]);
                m.erase(key);
            }
        } 
        return v;
    }
};