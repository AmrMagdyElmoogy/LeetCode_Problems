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
    int rangeSumBST(TreeNode* root, int low, int high) {
        preOrder(root,low,high);
        return sum;
    } 

    void preOrder(TreeNode* t,int low,int high)
    {
        if(t != NULL)
        {
            if(t->val >=low && t->val <=high)
             sum+=t->val;
           preOrder(t->left,low,high);
           preOrder(t->right,low,high);
        }
        
    }
};