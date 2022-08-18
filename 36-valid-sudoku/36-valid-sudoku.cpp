class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int size = 9;
        vector<vector<bool>>row(9,vector<bool>(9,false));
         vector<vector<bool>>column(9,vector<bool>(9,false));
         vector<vector<bool>>sub(9,vector<bool>(9,false));
        for(int r = 0; r<size;r++)
        {
            for(int c = 0; c<size;c++)
            {
                if(board[r][c]!='.')
                {
                    int index = board[r][c] - '0' - 1;
                    int area = (r/3)*3 + (c/3);
                    if(row[r][index] || column[c][index] || sub[area][index])
                        return false;
                    row[r][index] = true;
                    column[c][index] = true;
                    sub[area][index] = true;
                } 
            }
        } 
        return true;
    }

};