#include <vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        inorder(root, result);
        return result;
    }

private:
    /* left-root-right traversal, use this to print a BST in an increasing order */    
    void inorder(TreeNode* root, vector<int>& nodes)
    {
        if (root == nullptr) return;
        
        inorder(root->left, nodes);
        nodes.emplace_back(root->val);
        inorder(root->right, nodes);
    }
};