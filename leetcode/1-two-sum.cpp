#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;


class Solution 
{
public:
    // time : O(N)
    // memory : O(N)
    vector<int> twoSum(vector<int>& nums, int target) 
    {
        vector<int> indicies;
        unordered_map<int, int> unique_nums;
        
        for (int i = 0; i < nums.size(); i++) 
        {
            unique_nums.insert({nums[i], i});
        }
        
        for (int i = 0; i < nums.size(); i++) 
        {
            int difference = target - nums[i];

            auto search = unique_nums.find(difference);
            
            if ((search != unique_nums.end()) && (search->second != i)) 
            {
                indicies.emplace_back(i);
                indicies.emplace_back(search->second);
                
                return indicies;
            } 
        }
        
        // nothing found
        indicies.emplace_back(0);
        indicies.emplace_back(0);                
        return indicies;
    }
};

class BruteForceSolution
{
    // time : O(N^2)
    // memory : O(1)
    vector<int> twoSumBruteForce(vector<int>& nums, int target) 
    {
        vector<int> indicies;

        for (int i = 0; i < nums.size() - 1; i++) 
        {
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