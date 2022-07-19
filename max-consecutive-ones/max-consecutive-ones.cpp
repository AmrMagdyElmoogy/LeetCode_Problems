class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& arr) {
        int cons = 0;
        int maxx = 0;
        int n = arr.size();
        for(int i=0; i<n; i++)
        {
            if(arr[i] == 1)
            {
                 cons++;
                 if(cons> maxx)
                {
                    maxx = cons;
                }
            } 
            else 
                cons = 0;

        } 
        return maxx;
    }
};