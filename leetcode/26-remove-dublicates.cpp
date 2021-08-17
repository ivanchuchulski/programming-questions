#include <iostream>
#include <vector>

using namespace std;

/*
    Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns
    the new length. Do not allocate extra space for another array, you must do this by modifying the input array
    in-place with O(1) extra memory.

     0  1  2  3  4  5  6  7  8  9, size = 10
     -  -  -  -  -  -  -  -  -  -
    [0, 1, 1, 1, 1, 2, 2, 4, 5, 6]
    [0, 1, 2, 2, 4, 5, 6, 0, 0, 0]
    [0, 1, 2, 4, 5, 6, 0, 0, 0, 0], new_size = 6
---
    [1,1,2]
    [0,0,1,1,1,2,2,3,3,4]
    [1,1,1]
*/
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) 
            return 0;

        int slow = 0;
        for (int fast = 1; fast < nums.size(); fast++) {
            if (nums[fast] != nums[slow])
            {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    // gives Runtime Error adress sanitizer for some reason
    int removeDuplicates_1(vector<int>& nums) {
        int limit = nums.size();

        for (int i = 0; i < limit; i++)
        {
            int j = i + 1;
            while (nums[j] == nums[i] && j < limit) 
                j++;

            int dublicate_count = j - i - 1;

            if (dublicate_count != 0)
            {
                size_t count = 0;
                while (j + count < limit)
                {
                    nums[i + 1 + count] = nums[j + count];
                    count++;
                }

                limit -= dublicate_count; // recalc array limit
            }
        }

        return limit;
    }
};

int main(int argc, char const *argv[])
{
    Solution sol = Solution();

    vector<int> arr = { 0, 1, 1, 1, 1, 2, 2, 4, 5, 6 };

    int reduced_len = sol.removeDuplicates(arr);
    cout << reduced_len << endl;


    return 0;
}
