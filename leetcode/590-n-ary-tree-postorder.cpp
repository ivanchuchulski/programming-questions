#include <vector>
using namespace std;

struct Node {
    int val;
    vector<Node*> children;

    Node() {}
    Node(int _val) : val(_val) {}
    Node(int _val, vector<Node*> _children) : val(_val), children(_children) {}
};
class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int> nodes;
        postorder_trav(root, nodes);
        return nodes;
    }

private:
    void postorder_trav(Node* root, vector<int>& nodes)
    {
        if (root == nullptr) return;

        for (Node* child : root->children)
            postorder_trav(child, nodes);

        nodes.emplace_back(root->val);
    }
};