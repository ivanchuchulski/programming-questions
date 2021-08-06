#include <iostream>
#include <iomanip>

using namespace std;

struct Node
{
    int value;
    Node* left;
    Node* right;
    Node(int _value) : value(_value), left(nullptr), right(nullptr) {}
};

class BST
{
public:
    BST(int root_value) : root(new Node(root_value)) {}

    void insert(int value) { insert_at_root_2(root, value); }

    Node* get_root() { return root; }
    const Node* get_root() const { return root; }
    
private:
    Node* insert_at_root(Node* node, int value)
    {
        if (node == nullptr) 
            return new Node(value);

        if (node->value == value) 
            return node; // or whatever policy on dublicates
        else if (value < node->value) 
            node->left = insert_at_root(node->left, value);
        else 
            node->right = insert_at_root(node->right, value);

        return node;
    }

    void insert_at_root_2(Node*& node, int value)
    {
        if (node == nullptr) 
            node = new Node(value);

        if (node->value == value) 
            return; // or whatever policy on dublicates
        else if (value < node->value) 
            insert_at_root_2(node->left, value);
        else 
            insert_at_root_2(node->right, value);
    }

private:
    Node* root;
};

class Solution
{
public:
    bool mirror_trees(const BST& left, const BST& right)
    {
        return mirror_nodes(left.get_root(), right.get_root());
    }

private:
    bool mirror_nodes(const Node* left, const Node* right)
    {   
        if (left == nullptr && right == nullptr) return true;

        if (left == nullptr | right == nullptr) return false;

        if (left->value != right->value) return false;

        return mirror_nodes(left->left, right->right) && mirror_nodes(left->right, right->left);
    }
};

class Util
{
public:
    static void invert_tree(Node* node)
    {
        if (node == nullptr) return;

        std::swap(node->left, node->right);

        invert_tree(node->left);
        invert_tree(node->right);
    }

    static void dfs(const Node* root)
    {
        if (root == nullptr) return;

        cout << root->value << ' ';
        dfs(root->left);
        dfs(root->right);
    }
};

class Test
{
public:
    void test_mirror_tree(const BST& left, const BST& right)
    {
        Solution sol;
        cout << sol.mirror_trees(left, right) << endl; 
    }
};

int main(int argc, char const *argv[])
{
    BST bst1(10);
    bst1.insert(5);
    bst1.insert(1);
    bst1.insert(3);

    bst1.insert(20);
    bst1.insert(15);
    bst1.insert(30);

    BST bst2(10);
    bst2.insert(5);
    bst2.insert(1);
    bst2.insert(3);

    bst2.insert(20);
    bst2.insert(15);
    bst2.insert(30);

    Util::dfs(bst1.get_root());
    cout << endl;
    Util::dfs(bst2.get_root());
    cout << endl;

    Util::invert_tree(bst2.get_root());
    Util::dfs(bst2.get_root());
    cout << endl;

    Test test;
    test.test_mirror_tree(bst1, bst2);

    return 0;
}
