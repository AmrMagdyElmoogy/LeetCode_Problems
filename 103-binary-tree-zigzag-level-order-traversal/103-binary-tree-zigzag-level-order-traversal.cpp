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
    map<int,vector<int>>m;
    vector<vector<int>>v;
    int ans = -1;
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        preOrder(root,ans);
        bool flag = false;
        for(auto it = m.begin();it!=m.end();it++)
        {
            if(!flag)
                v.push_back(it->second);
            else 
            {
                reverse(it->second.begin(),it->second.end());
                v.push_back(it->second);
            } 
            flag =!flag;
        }
        return v;
    } 
    void preOrder(TreeNode *root, int ans)
    {
        if(root!=NULL)
        {
            ans++;
            if(m.count(ans) == 0)
                m[ans] = vector<int>{root->val};
            else 
                m[ans].push_back(root->val);
            preOrder(root->left,ans);
            preOrder(root->right,ans);
        } 
        
    }
};