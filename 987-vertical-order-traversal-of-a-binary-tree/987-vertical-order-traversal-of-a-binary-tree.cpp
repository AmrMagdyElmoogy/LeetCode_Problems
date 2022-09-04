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
    map<int,map<int,multiset<int>>> m;
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        createVerticalTraversal(root,0,0);
        vector<vector<int>>v;
        for(auto m1 : m)
        { 
            v.push_back(vector<int>());
            for(auto m2 : m1.second)
            {
                for(auto m3: m2.second)
                    v.back().push_back(m3);
            }
        }
        return v;
    } 
    void createVerticalTraversal(TreeNode *root,int r, int c)
    {
        if(root!=NULL)
        {
            m[c][r].insert(root->val);
            createVerticalTraversal(root->left,r+1,c-1);
            createVerticalTraversal(root->right,r+1,c+1);
        } 
    } 
};