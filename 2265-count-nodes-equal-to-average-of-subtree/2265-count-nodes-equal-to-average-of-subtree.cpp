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
    int cntt = 0;
    int averageOfSubtree(TreeNode* root) {
        auto p1 = func(root);
        return cntt;
    }
    pair<int,int> func(TreeNode *root)
    {
        if(root==NULL)
        {
           return {0,0};
        } 
        
        auto left = func(root->left);
        auto right = func(root->right);
        int sum = left.first + right.first + root->val;
        int n = 1 + left.second + right.second; 
        if(sum / n == root->val)
            cntt++;
        return {sum,n};
    }
};