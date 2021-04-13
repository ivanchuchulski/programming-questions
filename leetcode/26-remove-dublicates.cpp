#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /*
        Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns
        the new length. Do not allocate extra space for another array, you must do this by modifying the input array
        in-place with O(1) extra memory.

         0  1  2  3  4  5  6  7  8  9, size = 10
        [0, 1, 1, 1, 1, 2, 2, 4, 5, 6]
        [0, 1, 2, 2, 4, 5, 6, 0, 0, 0]
        [0, 1, 2, 4, 5, 6, 0, 0, 0, 0], new_size = 6
    ---
        [1,1,2]
        [0,0,1,1,1,2,2,3,3,4]
        [1,1,1]
    */
    int removeDuplicates_1(vector<int>& nums) {
        int removed_count = 0;

        int k = 0;
        for (int i = 1; i < nums.size() - removed_count; i++) 
        {
            while (nums[i] == nums[k])
                continue;

            int distance = i - k;
        }
    }

    int removeDuplicates_1(vector<int>& nums) {
        int removed_count = 0;

        for (int i = 0; i < nums.size() - removed_count; i++)
        {
            int curr = nums[i];

            int j = i + 1;
            while (nums[j] == curr && j < nums.size() - removed_count)
                j++;

            int dublicate_count = j - i - 1;

            if (dublicate_count == 0) 
                continue;

            int limit = nums.size() - removed_count;
            int count = 0;
            while (j + count < limit)
            {
                nums[j - dublicate_count + count] = nums[j + count];
                count++;
            }

            removed_count += dublicate_count;
        }

        return nums.size() - removed_count;
    }
};

int main(int argc, char const *argv[])
{
    Solution sol = Solution();

    vector<int> arr = {0, 1, 1, 1, 1, 2, 2, 4, 5, 6};

    int reduced_len = sol.removeDuplicates(arr);
    cout << reduced_len << endl;


    return 0;
}
