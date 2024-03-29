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
    vector<int> v;
    vector<int> getAllElements(TreeNode* root1, TreeNode* root2) {    
        preOrder(root1);
        preOrder(root2);
        sort(v.begin(),v.end());
        return v;
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