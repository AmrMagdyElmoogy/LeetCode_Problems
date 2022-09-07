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
    
    vector<int> rightSideView(TreeNode* root) {
        vector<vector<int>>v;

        queue<TreeNode*> n;
        if(root==NULL)
            return {};
        n.push(root);
        v.push_back({root->val});
        while(n.size() > 0)
        {
            int size = n.size();
            vector<int>result;
            for(int i=0; i<size;i++)
            {
                
                TreeNode* node = n.front();
                n.pop();
                if(node->left)
                {
                    n.push(node->left);
                    result.push_back(node->left->val);
                }
                if(node->right)
                {
                    n.push(node->right);
                    result.push_back(node->right->val);
                } 
                
            }
            if(!result.empty())
                v.push_back(result);
        }
        vector<int>rightView;
        for(int i=0; i<v.size();i++)
            rightView.push_back(v[i].back());
        return rightView;
    } 
   
};