class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        map<int,vector<int>>m;
        vector<vector<int>>v;
        for(int i=0; i<groupSizes.size();i++)
        {
            if(m.count(groupSizes[i]) == 0)
                m.insert({groupSizes[i],{i}});
            else 
            {
                vector<int>result = m[groupSizes[i]];
                result.push_back(i);
                m[groupSizes[i]] = result;
            }
        } 
        for(auto it = m.begin();it!=m.end();it++)
        {
            int s = it->first;
            int i = 1;
            vector<int>temp;
            while(it->second.size() > i-1)
            {
                temp.push_back(it->second[i-1]);
                if(i%s == 0)
                {
                    v.push_back(temp);
                    temp.clear();
                }
                i++;
            }
        } 
        return v;
    }
};