class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        vector<int>result;
        int row = matrix[0].size();
        int column = matrix.size();
        int l = 0;
        int r = (row * column)-1; 
        bool flag = false;
        while(l<=r)
        {
            int mid = (l+r)/2;
            int i = mid / row;
            int j = mid % row;
            if(matrix[i][j] == target)
            {
                flag = true;
                break;
            } 
            
            else if(matrix[i][j] < target)
                l = mid+1;
            else 
                r = mid-1;
        }
        return flag;
    }
};