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
    int maxx = 0;
    map<int,int>m;
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        for(int i=0; i<nums.size();i++)
            m.insert({nums[i],i});
        return constructTree(nums,0,nums.size());
    }  
    TreeNode* constructTree(vector<int>&nums,int start,int end)
    {
        if(start == end)
            return NULL;
        int maxx = *max_element(nums.begin()+start,nums.begin()+end);
        TreeNode *root = new TreeNode(maxx);
        int index = m[maxx];
        root->left = constructTree(nums,start,index);
        root->right = constructTree(nums,index+1, end);
        return root;
    }
    
};