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
    vector<vector<int>>v;
    map<int,vector<int>,greater<int>>m;
    int ans = -1;
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        preOrder(root,ans);
        for(auto it = m.begin();it!=m.end();it++)
        {
           v.push_back(it->second);
        }
        return v;
    }
    void preOrder(TreeNode *root, int ans)
    {
        if(root!=NULL)
        {
            ans++;
            if(m.count(ans) == 0)
                m.insert({ans,{root->val}});
            else 
            {
                vector<int>result = m[ans];
                result.push_back(root->val);
                m[ans] = result;
            }
            preOrder(root->left,ans);
            preOrder(root->right,ans);
        }
    }
};