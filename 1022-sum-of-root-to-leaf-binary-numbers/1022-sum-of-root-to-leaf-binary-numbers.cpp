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
    int sumRootToLeaf(TreeNode* root) {
        preOrder(root,0);
        return sum;
    } 

    void preOrder(TreeNode *root, int num)
    {
        num = 2 * num + root->val;
        if(!root->left && !root->right)
        {
            sum+=num;
        }
        if(root->left)
            preOrder(root->left,num);
        if(root->right)
            preOrder(root->right,num);
    }
};