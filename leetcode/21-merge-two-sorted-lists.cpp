#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
 
class Solution {
public:
    /*
        Merge two sorted linked lists and return it as a sorted list. 
        The list should be made by splicing together the nodes of the first two lists.
        time : O(N), N = max(#elements in both lists)
        memory : (N), or could be done with O(1) if we can reuse the old allocated nodes
    */
    ListNode* mergeTwoLists(ListNode* first, ListNode* second) {
        ListNode* head = new ListNode(0);
        ListNode* current = head;
        
        while (first != nullptr || second != nullptr)
        {
            if (first == nullptr)
            {
                current->next = new ListNode(second->val);
                second = second->next;
            }
            else if (second == nullptr)
            {
                current->next = new ListNode(first->val);
                first = first->next;
            }
            else if (first->val < second->val)
            {
                current->next = new ListNode(first->val);
                first = first->next;
            }
            else
            {
                current->next = new ListNode(second->val);
                second = second->next;
            }
            current = current->next;
        }
        return head->next;
    }
};

void print_list(ListNode* head)
{
    while (head != nullptr)
    {
        cout << head->val << endl;
        head = head->next; 
    }

    cout << endl;
}

int main(int argc, char const *argv[])
{
    ListNode* first = new ListNode(1, new ListNode(2, new ListNode(3)));   
    ListNode* second = new ListNode(1, new ListNode(3, new ListNode(4)));

    print_list(first);
    print_list(second);

    Solution* sol = new Solution();
    ListNode* result = sol->mergeTwoLists(first, second);
    print_list(result);


    return 0;
}
