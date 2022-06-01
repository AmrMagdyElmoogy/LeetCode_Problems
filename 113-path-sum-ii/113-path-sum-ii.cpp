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
    vector<vector<int>>result;
    vector<int>v;
    int sum = 0;
    int targetSumm = 0;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        targetSumm = targetSum;
        preOrder(root,v,sum);
        return result;
        
    }
    
    void preOrder(TreeNode* root,vector<int>v,int sum)
    {
        if(root!=NULL)
        {
            sum+= root->val;
            v.push_back(root->val);
            if(!root->left && !root->right && sum == targetSumm)
            {
                result.push_back(v);
            }
            preOrder(root->left,v,sum);
            preOrder(root->right,v,sum);
        }
        
    }
};