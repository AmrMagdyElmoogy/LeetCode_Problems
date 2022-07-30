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
    vector<string> numbers;
    string ans = "";
    int sumNumbers(TreeNode* root) {
        preOrder(root,ans);
        int sum =0;
        for(int i=0; i<numbers.size();i++)
            sum+= stringToInt(numbers[i]);
        return sum;
    } 
    void preOrder(TreeNode *root, string ans)
    {
        if(root!=NULL)
        {
            ans+= to_string(root->val);
            if(!root->left && !root->right)
              numbers.push_back(ans);
            preOrder(root->left,ans);
            preOrder(root->right,ans);
        }
    }
    int stringToInt(string s)
    {
        int n = s.size();
        int result = 0;
        for(int i=0; i<s.size();i++)
        {
            result+= (s[i] - '0') * pow(10,n-1);
            n--;
        }
        return result;
    }
};