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
    int first = 0;
    bool flag = true;
    bool isUnivalTree(TreeNode* root) {
        first = root->val;
        preOrder(root);
        if(flag)
            return true;
        return false;
    } 
    void preOrder(TreeNode *root)
    {
        if(root!=NULL)
        {
            if(first!=root->val)
                flag = false;
            preOrder(root->left);
            preOrder(root->right);
        }
    }
};