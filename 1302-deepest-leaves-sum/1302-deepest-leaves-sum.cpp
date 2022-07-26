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
    int ans = 0;
    map<int,int>map;
    int deepestLeavesSum(TreeNode* root) {
        preOrder(root,ans);
        auto it = map.end();
        it--;
        return it->second;
    } 
    void preOrder(TreeNode *root,int ans)
    {
        if(root!=NULL)
        {
            ans++;
            if(!root->left && !root->right)
                map[ans]+= root->val;
            preOrder(root->left,ans);
            preOrder(root->right,ans);
        }
    }
};