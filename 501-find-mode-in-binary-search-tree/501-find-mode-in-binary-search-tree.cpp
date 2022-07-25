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
    vector<int>H;
    vector<int> findMode(TreeNode* root) {
        H.resize(200001,0);
        vector<int>data;
        preOrder(root);
        int maxx = *max_element(H.begin(),H.end());
        for(int i=0; i<H.size();i++)
        {
            if(H[i] == maxx)
                data.push_back(i-100000);
        } 
        return data;
    } 
    void preOrder(TreeNode *root)
    {
        if(root!=NULL)
        {
            H[root->val+100000]++;
            preOrder(root->left);
            preOrder(root->right);
        }
    }
};