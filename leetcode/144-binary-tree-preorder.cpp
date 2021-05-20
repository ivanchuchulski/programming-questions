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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        preorder(root, result);
        return result;
    }

private:
    /* root-left-right traversal, use this to copy a tree */
    void preorder(TreeNode* root, vector<int>& nodes)
    {
        if (root == nullptr) return;
        
        nodes.emplace_back(root->val);
        preorder(root->left, nodes);
        preorder(root->right, nodes);
    }
};