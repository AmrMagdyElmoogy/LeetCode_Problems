/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<string>> printTree(TreeNode* root) {
        int H = calculateHeight(root);
        int r = H;
        int c = pow(2,r)-1;
        vector<vector<string>>v(r,vector<string>(c,""));
        setUpMatrix(root,v,0,c-1,0);
        return v;
    } 
    int calculateHeight(TreeNode *root)
    {
        if(root == NULL)
            return 0;
        return 1+max(calculateHeight(root->left),calculateHeight(root->right));
    } 
    void setUpMatrix(TreeNode *root, vector<vector<string>>&v ,int start, int end, int i)
    {
        if(root!=NULL)
        {
            int mid = (start+(end-start)/2);
            v[i][mid] = to_string(root->val);
            setUpMatrix(root->left,v,start,mid,i+1);
            setUpMatrix(root->right,v,mid+1,end,i+1);
        }
    }
};