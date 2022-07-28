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
    int preOrderIndex = 0;
    map<int,int>map;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {    
        for(int i=0; i<inorder.size();i++)
            map.insert({inorder[i],i});
        return constructBST(preorder,0,inorder.size()-1);
    } 
    TreeNode* constructBST(vector<int>preorder, int left,int right)
    {
        if(left > right)
            return NULL;
        int rootValue = preorder[preOrderIndex++];
        TreeNode* node = new TreeNode(rootValue);
        node->left = constructBST(preorder,left,map[rootValue]-1);
        node->right = constructBST(preorder,map[rootValue]+1,right);
        return node;
    }
};