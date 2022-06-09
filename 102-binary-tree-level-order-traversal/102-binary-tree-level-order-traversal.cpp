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
    vector<vector<int>> result;
    int lvl = 1;
    int cnt = 0;
    vector<vector<int>> levelOrder(TreeNode* root) {
        return lvlOrder(root);
    } 
    vector<vector<int>> lvlOrder(TreeNode *root)
    {
        queue<TreeNode*> q;
        vector<int>r;
          if(root==NULL)
             return {};
            r.push_back(root->val);
            result.push_back(r);
            r.clear();
            q.push(root); 
      
        while(!q.empty())
        { 
            int size = q.size();
            for(int i=0; i<size;i++)
            {
                TreeNode *p = q.front();
                q.pop();
                if(p->left)
                {
                    r.push_back(p->left->val);
                    q.push(p->left);
                } 
                if(p->right)
                {
                    r.push_back(p->right->val);
                    q.push(p->right);
                }
            }
            if(!r.empty())
              result.push_back(r);
            r.clear();
    
        }
        return result;
    }
};