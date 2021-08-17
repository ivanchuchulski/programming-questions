#include <list>
#include <algorithm>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

/*  Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a
value greater than X.

Return the number of good nodes in the binary tree.  */

class Solution {
public:
    int goodNodes(TreeNode* root) {
        int good_nodes = 0; 
        
        std::list<TreeNode*> route;
        find_good_nodes(root, good_nodes, route);

        return good_nodes;
    }

private:
    void find_good_nodes(TreeNode* curr, int& good_nodes, std::list<TreeNode*>& route)
    {
        if (curr == nullptr) return;

        route.push_front(curr);

        if (std::all_of(route.begin(), route.end(), [curr](const TreeNode* elem) { return elem->val <= curr->val; }))
            good_nodes++;

        find_good_nodes(curr->left, good_nodes, route);
        find_good_nodes(curr->right, good_nodes, route);

        route.pop_front();
    }
};