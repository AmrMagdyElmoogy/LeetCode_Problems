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
    bool first = true;
    TreeNode *q = NULL;
    TreeNode *t = NULL;
    TreeNode* increasingBST(TreeNode* root) {
        TreeNode *p = new TreeNode();
        return inOrder(root,p);
        
    } 
    TreeNode* inOrder(TreeNode *root , TreeNode *p)
    {
        if(root!= NULL)
        {
            inOrder(root->left,p);
            if(first)
            {
                p->val = root->val;
                q = p;
                first = false;
            } 
            else 
            {
              t = new TreeNode();
              t->val = root->val;
              q->right = t;
              q = t;
            }
            inOrder(root->right,p);
        }
        return p;
    }
};