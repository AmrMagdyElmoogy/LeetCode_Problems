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
    bool evaluateTree(TreeNode* root) {
      return preOrder(root);
    } 
    bool preOrder(TreeNode *root)
    {
           if(!root->left && !root->right) 
               return root->val;
            int l = preOrder(root->left);
            int r = preOrder(root->right);
            if(root->val == 2) 
                return l or r;
            return l and r;
    }
};