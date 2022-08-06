class Solution {
public:
    int maximumGroups(vector<int>& grades) {
        int left = 0;
        int right = 1000;
        int n = grades.size();
        while(left < right)
        {
            int k = (left+right+1)/2;
            if(k*(k+1)/2 > n)
                right = k-1;
            else 
                left = k;
        } 
        return left;
    }
};