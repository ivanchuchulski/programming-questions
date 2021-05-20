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
    int rangeSumBST(TreeNode* root, int low, int high) {
        int sum = 0;
        preorder(root, low, high, sum);
        return sum;
    }
    
private:
    void preorder(TreeNode* root, int low, int high, int& sum)
    {
        if (root == nullptr) 
            return;
        
        int val = root->val;
        if (val >= low && val <= high)
            sum += val;

        if (val >= low)
            preorder(root->left, low, high, sum);
        
        if (val <= high)
            preorder(root->right, low, high, sum);
    }
};