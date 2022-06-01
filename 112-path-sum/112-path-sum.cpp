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
    int target = 0;
    int count = 0;
    bool flag = false;
    bool hasPathSum(TreeNode* root, int targetSum) {
        target = targetSum;
        preOrder(root,count);
        return flag;
    } 
    
    void preOrder(TreeNode* root,int count)
    {
        if(root!=NULL)
        {
             count+= root->val;
        if(!root->left && !root->right && count == target)
        {
            flag = true;
        }
        
        preOrder(root->left,count);
        preOrder(root->right,count);
        }
       
    }
};