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
    TreeNode* result = NULL;
public:
    TreeNode* searchBST(TreeNode* root, int val) {
       return preOrder(root,val);
    } 
    TreeNode* preOrder(TreeNode* t, int val)
    {
        if(t!= NULL)
        {
            if(t->val == val)
            {
                result = t;
            
            }
            preOrder(t->left,val);
            preOrder(t->right,val);
        } 
        return result;
    }
};