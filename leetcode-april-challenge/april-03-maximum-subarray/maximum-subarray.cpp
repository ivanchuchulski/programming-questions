#include <vector>
#include <algorithm>
#include <unordered_set>
#include <numeric>
#include <iostream>

using namespace std;

class Solution {
public:
    // Kadane's algorithm, but because there can be negative 
    // numbers consider the answer to be a the negative number
    // that's why line 20 and 21 have to be in that order
    int maxSubArray(vector<int>& nums) {        
        int largestSum = INT_MIN;
        int candidateSum = 0;
        
        for (int number : nums) {
            candidateSum += number;
            largestSum = std::max(largestSum, candidateSum);
            candidateSum = std::max(candidateSum, 0);
        }

        return largestSum;
    }
};