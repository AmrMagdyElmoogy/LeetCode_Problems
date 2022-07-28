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
    int postOrderIndex;
    map<int,int>map;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        postOrderIndex = postorder.size()-1;
         for(int i=0; i<inorder.size();i++)
            map.insert({inorder[i],i});
        return constructBST(postorder,0,inorder.size()-1);
    }
    TreeNode* constructBST(vector<int>postorder, int left,int right)
    {
        if(left > right)
            return NULL;
        int rootValue = postorder[postOrderIndex--];
        TreeNode* node = new TreeNode(rootValue);
        node->right = constructBST(postorder,map[rootValue]+1,right);
        node->left = constructBST(postorder,left,map[rootValue]-1);
        
        return node;
    }
};