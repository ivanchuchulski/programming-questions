#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;

// complexity
// time : O(N^2)
// memory : O(1)
class BruteForce {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> indicies;

        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = i + 1; j < nums.size(); j++)
            {
                if (nums[i] + nums[j] == target) {
                    indicies.emplace_back(i);
                    indicies.emplace_back(j);
                }
            }
        }


        return indicies;
    }
};