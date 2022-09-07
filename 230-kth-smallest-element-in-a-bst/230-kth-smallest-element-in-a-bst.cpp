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
    priority_queue<int,vector<int>,greater<int>>q;
    int kthSmallest(TreeNode* root, int k) {
        treeTraversal(root);
        while(k>1)
        {
            q.pop();
            k--;
        }
        return q.top();
    } 
    void treeTraversal(TreeNode* root)
    {
        if(root!=NULL)
        {
            q.push(root->val);
            treeTraversal(root->left);
            treeTraversal(root->right);
        }
    }
};