#include <limits>
#include <queue>

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
    bool isSymmetric(const TreeNode* root) {
        return check_symmetry(root->left, root->right);
    }

    // doesn't work for now
    bool isSymmetric_2(const TreeNode* root) {
        std::queue<const TreeNode*> left_subtree;
        std::queue<const TreeNode*> right_subtree;

        get_left_tree(left_subtree, root->left);
        get_right_tree(right_subtree, root->right);
        
        if (left_subtree.size() != right_subtree.size()) return false;

        while (!left_subtree.empty() && ! right_subtree.empty())
        {
            if (left_subtree.front() != right_subtree.front()) return false;

            left_subtree.pop(); right_subtree.pop();
        }

        return true;
    }

private:
    bool check_symmetry(const TreeNode* left_subtree, const TreeNode* right_subtree)
    {
        if (left_subtree == nullptr && right_subtree == nullptr) return true;

        if (left_subtree == nullptr || right_subtree == nullptr) return false;

        if (left_subtree->val != right_subtree->val) return false;
        
        return check_symmetry(left_subtree->left, right_subtree->right) 
                    && check_symmetry(left_subtree->right, right_subtree->left);
    }

    void get_left_tree(std::queue<const TreeNode*> que, const TreeNode* node) 
    {
        if (node == nullptr) return;

        que.push(node);
        get_left_tree(que, node->left);
        get_left_tree(que, node->right);
    }

    void get_right_tree(std::queue<const TreeNode*> que, const TreeNode* node) 
    {
        if (node == nullptr) return;

        que.push(node);
        get_right_tree(que, node->right);
        get_right_tree(que, node->left);
    }
};