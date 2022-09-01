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
    int good = 0;
    int goodNodes(TreeNode* root) {
        priority_queue<int>q;
        calculateGoodNotes(root,q);
        return good;
    }  
    
    void calculateGoodNotes(TreeNode *root, priority_queue<int>q)
    {
        if(root!=NULL)
        {
            q.push(root->val);
            if(q.top() == root->val)
                good++;
            calculateGoodNotes(root->left,q);
            calculateGoodNotes(root->right,q);
        }
    }
};