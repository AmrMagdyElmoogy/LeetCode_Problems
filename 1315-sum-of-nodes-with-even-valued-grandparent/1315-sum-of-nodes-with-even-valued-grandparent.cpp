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
    int sum = 0;
    int sumEvenGrandparent(TreeNode* root) {
        vector<int>result(10001);
        int ans = 0;
        calculateEvenGrandParentsSummation(root,result,ans);
        return sum;
    } 
    void calculateEvenGrandParentsSummation(TreeNode *root,vector<int>&result,int ans)
    {
        if(root!=NULL)
        {
            result[ans] = root->val;
            if(ans>1)
                if(result[ans-2]%2 == 0)
                    sum+=root->val;
            ans++;
            calculateEvenGrandParentsSummation(root->left,result,ans);
            calculateEvenGrandParentsSummation(root->right,result,ans);
        }
    }
};