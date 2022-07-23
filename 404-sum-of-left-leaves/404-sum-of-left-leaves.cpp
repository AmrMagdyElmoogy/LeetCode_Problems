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
    int sum = 0;
    int sumOfLeftLeaves(TreeNode *root) {
       return preOrder(root);
    } 
    
    int preOrder(TreeNode *root)
    { 
        if(root!=NULL)
        {
            if(root->left!=NULL && root->left->left == NULL && root->left->right == NULL)
            {
                sum+=root->left->val;
            } 
            preOrder(root->left);
            preOrder(root->right);
        }
        
        return sum;
    }  
};