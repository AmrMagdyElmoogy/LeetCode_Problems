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
    int result = INT_MIN;
    int maxPathSum(TreeNode* root) {
        dfs(root,0);
        return result;
    } 
    int dfs(TreeNode *root,int sum)
    {
        if(root == NULL)
            return 0;
        int left = dfs(root->left,sum);
        int right = dfs(root->right,sum);
        left = max(left,0);
        right = max(right,0);
        result = max(result,root->val + left+right);
        return root->val + max(left,right);            
    }
};