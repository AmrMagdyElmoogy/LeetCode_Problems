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
        int maxx = INT_MIN;
        calculateGoodNotes(root,maxx);
        return good;
    }  
    
    void calculateGoodNotes(TreeNode *root, int maxx)
    {
        if(root!=NULL)
        {
            if(maxx <= root->val)
            {
                maxx = root->val;
                good++;
            }
            calculateGoodNotes(root->left,maxx);
            calculateGoodNotes(root->right,maxx);
        }
    }
};