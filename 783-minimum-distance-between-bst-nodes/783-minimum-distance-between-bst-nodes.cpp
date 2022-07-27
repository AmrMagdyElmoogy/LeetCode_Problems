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
    vector<int>v;
    int minDiffInBST(TreeNode* root) {
        preOrder(root); 
        sort(v.begin(),v.end());
        int diff = 1000;
        for(int i=0; i<v.size()-1;i++)
        {
            if(v[i+1] - v[i] < diff)
                diff = v[i+1]-v[i];
        }
        return diff;
    } 
    void preOrder(TreeNode *root)
    {
        if(root!=NULL)
        {
            v.push_back(root->val);
            preOrder(root->left);
            preOrder(root->right);
        }
    }
};