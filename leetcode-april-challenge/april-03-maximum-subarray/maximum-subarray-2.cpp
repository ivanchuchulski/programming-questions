#include <vector>
#include <algorithm>
#include <unordered_set>
#include <numeric>
#include <iostream>

using namespace std;

class Solution {
public:
    int maxSubArray(vector<int>& nums) {        
        std::vector<int> leftSubArray;
        std::vector<int> rightSubArray;
        std::vector<int> allArray;
        std::unordered_set<int> sums;
        int left_start; 
        int right_start;

        if (nums.size() % 2 == 0) {
            left_start =  nums.size() / 2 - 1;
            right_start =  nums.size() / 2;
        }
        else {
            left_start =  nums.size() / 2 - 1;
            right_start =  nums.size() / 2 + 1;

            int centerIndex = nums.size() / 2;
            
            leftSubArray.push_back(nums[centerIndex]);
            rightSubArray.push_back(nums[centerIndex]);
            allArray.push_back(nums[centerIndex]);
            
            sums.insert(nums[centerIndex]);
        }

        for (int left = left_start, right = right_start; left >= 0 && right < nums.size(); left--, right++) {
            sums.insert(nums[left]);
            sums.insert(nums[right]);

            sums.insert(sumArrayWithSingleNum(rightSubArray, nums[left]));
            sums.insert(sumArrayWithSingleNum(leftSubArray, nums[right]));    

            leftSubArray.push_back(nums[left]);
            sums.insert(sumArray(leftSubArray));

            rightSubArray.push_back(nums[right]);
            sums.insert(sumArray(rightSubArray));

            sums.insert(sumArrayWithSingleNum(allArray, nums[left]));
            sums.insert(sumArrayWithSingleNum(allArray, nums[right]));

            allArray.push_back(nums[left]);
            allArray.push_back(nums[right]);
            sums.insert(sumArray(allArray));
        }
        
        auto begining = sums.begin();
        int result = *begining;  
        ++begining;

        for (auto it = begining; it != sums.end(); ++it) {
            result = std::max(result, *it);
        }

        return result;
    }

    int sumArrayWithSingleNum(std::vector<int>& arr, int num) {
        return std::accumulate(arr.begin(), arr.end(), 0) + num;
    }

    int sumArray(std::vector<int>& arr) {
        return std::accumulate(arr.begin(), arr.end(), 0);
    }
};