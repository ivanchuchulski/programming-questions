class Solution {
public:
    /*
        Given an array nums and a value val, remove all instances of that value in-place and return the new length.
        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
        extra memory.
        time complexity is O(nums.size())
        space complexity is O(1)
    */
    int removeElement(vector<int>& nums, int val)
    {
        int removed_count = 0;
        for (int i = 0; i < nums.size() - removed_count; i++)
        {
            if (nums[i] == val)
            {
                swap(nums[i], nums[nums.size() - removed_count]);
                removed_count++;
                i--;    
            }
        }
    }

    int removeElement_1(vector<int>& nums, int val) {
        int removed_count = 0;

        for (int i = 0; i < nums.size() - removed_count; i++)
        {
            if (nums[i] != val)
                continue;

            int count = 0;
            for (int j = i + 1; j < nums.size() - removed_count; j++)
            {   
                nums[i + count] = nums[j];
                count++;
            }
            removed_count++;
            i--;
        }

        return nums.size() - removed_count;
    }


};