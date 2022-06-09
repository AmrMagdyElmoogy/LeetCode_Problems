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
    vector<double> result;
    vector<double> averageOfLevels(TreeNode* root) {
        return lvlOrder(root);
    } 
    vector<double> lvlOrder(TreeNode *root)
    {
        
        queue<TreeNode*> q;
        q.push(root);
        result.push_back(root->val);
        while(!q.empty())
        {
            double r = 0;
            int size = q.size();
            for(int i=0; i<size;i++)
            {
                TreeNode *p = q.front();
                q.pop();
                if(p->left)
                {
                    r+= p->left->val;
                    q.push(p->left);
                } 
                if(p->right)
                {
                    r+= p->right->val;
                    q.push(p->right);
                } 
            } 
              if(q.size()!=0)
                result.push_back(r/q.size());
            
            
        } 
        return result;
        
    }
};