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
    vector<int>result;
    void PostOrder(Node* root)
    {
        if(root!=NULL)
        {
            for(Node* child : root->children)
            {
                PostOrder(child);
                result.push_back(child->val);
            }
        } 
      
            
    }
    vector<int> postorder(Node* root) {
        PostOrder(root);
        if(root!=NULL)
          result.push_back(root->val);
        return result;
        
    }
};