class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        vector<int>result;
        int row = matrix[0].size();
        int column = matrix.size();
        for(int i=0; i<column;i++)
        {
            for(int j = 0; j<row; j++)
                result.push_back(matrix[i][j]);
        }
        int l = 0;
        int r = result.size()-1; 
        bool flag = false;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if( result[mid] == target)
            {
                flag = true;
                break;
            } 
            
            else if(result[mid]< target)
                l = mid+1;
            else 
                r = mid-1;
        
        }
        return flag;
    }
};