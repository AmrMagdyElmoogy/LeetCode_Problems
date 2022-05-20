/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* result = NULL;
    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) {
        return preOrder(cloned,target);
    }
    TreeNode* preOrder(TreeNode* root,TreeNode* target)
    {
        if(root!= NULL)
        {
            if(root->val == target->val)
            {
                result = root;
            }
            preOrder(root->left,target);
            preOrder(root->right,target);
        }
        return result;
    }
    
};