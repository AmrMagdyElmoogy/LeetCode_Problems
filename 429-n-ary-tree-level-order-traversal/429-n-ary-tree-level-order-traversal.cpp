/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if(root==NULL)
            return {};
       vector<vector<int>>ans;
        queue<Node*> s;
        s.push(root);
        int size = s.size();
        while(size > 0)
        {
            vector<int>singleRow(size);
            for(int i=0; i<size;i++)
            {
                Node* node = s.front();
                s.pop();
                singleRow[i] = node->val;
                for(int i=0; i<node->children.size();i++)
                {
                    s.push(node->children[i]);
                }
            } 
            ans.push_back(singleRow);
            size = s.size();
        }
        return ans;
    }
    
   
};