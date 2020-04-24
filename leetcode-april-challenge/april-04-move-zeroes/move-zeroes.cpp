#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// problem : move all the zero elements in an array to the back of it
// complexity
// N is the size of the number array
// time : O(N)
// memory : O(M), where M is the number of non-zero elements

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        queue<int> non_zero;
        
        for (int num : nums) {
            if (num != 0) {
                non_zero.push(num);
            }
        }
        
        int non_zero_count = non_zero.size();
        int zeros_count = nums.size() - non_zero_count; 
        
        for (int i = 0; i < non_zero_count; i++) {
            int elem = non_zero.front();
            
            nums[i] = elem;
            
            non_zero.pop();
        }
        
        for (int i = non_zero_count; i < nums.size(); i++) {
            nums[i] = 0;
        }
    }
};