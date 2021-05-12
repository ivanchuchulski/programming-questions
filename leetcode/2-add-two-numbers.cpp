#include <iostream>
#include <cmath>
#include <vector>
#include <cstdint>
#include <stack>

using namespace std;
// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* left, ListNode* right) {
        ListNode* head = new ListNode(0);
        ListNode* prev = head;

        int carry = 0;
        while (left != nullptr && right != nullptr)
        {
            int sum = left->val + right->val + carry;

            carry = sum > 9 ? 1 : 0;
            int val_in_result = sum % 10;

            left = left->next;
            right = right->next;

           prev->next = new ListNode(val_in_result);
           prev = prev->next;
           
        }

        if (left == nullptr)
        {
            while (right != nullptr)
            {
                int sum = right->val + carry;

                carry = sum > 9 ? 1 : 0;
                int val_in_result = sum % 10;

                right = right->next;

                prev->next = new ListNode(val_in_result);
                prev = prev->next;
            }
        }
        else
        {
            while (left != nullptr)
            {
                int sum = left->val + carry;

                carry = sum > 9 ? 1 : 0;
                int val_in_result = sum % 10;

                left = left->next;

                prev->next = new ListNode(val_in_result);
                prev = prev->next;
            }
        }

        if (carry > 0)
        {
            prev->next = new ListNode(carry);
            prev = prev->next;
        }

        return head->next;
    }
};

void print_sum(ListNode* node)
{
    while (node != nullptr)
    {
        cout << node->val;
        node = node->next;
    }
    cout << endl;
}

ListNode* build_list_from_number(int number)
{
    ListNode* head = new ListNode(number % 10);
    number /= 10;
    ListNode* prev = head;
    while (number != 0)
    {
        ListNode* node = new ListNode(number % 10);
        number /= 10;
        prev->next = node;
        prev = node;
    }

    return head;
}

void test_add_two_numbers(int leftNum, int rightNum)
{
    Solution sol = Solution();

    ListNode* left = build_list_from_number(leftNum);
    ListNode* right = build_list_from_number(rightNum);
    ListNode* sum = sol.addTwoNumbers(left, right);

    print_sum(left);
    print_sum(right);
    print_sum(sum);
}

int main()
{
    test_add_two_numbers(342, 465);
    test_add_two_numbers(99, 2);
    test_add_two_numbers(942, 9465);
}