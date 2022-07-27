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
    int result = 10000;
    int prev = -1;
    int minDiffInBST(TreeNode* root) {
        if(root!=NULL)
        {
            
            minDiffInBST(root->left);
            if(prev >=0)
                result = min(result, root->val - prev);
            prev = root->val;
            minDiffInBST(root->right);
        }
        return result;
    } 
    
};