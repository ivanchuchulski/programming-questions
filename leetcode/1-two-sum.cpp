#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;

// complexity
// time : O(N)
// memory : O(N)
class TwoPassHash {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> indicies;
        unordered_map<int, int> unique_nums;
        
        for (int i = 0; i < nums.size(); i++) {
            unique_nums.insert({nums[i], i});
        }

        bool isFound = false;
        
        for (int i = 0; i < nums.size(); i++) {
            int difference = target - nums[i];
            auto search = unique_nums.find(difference);
            
            if ((search != unique_nums.end()) && (search->second != i)) {
                indicies.emplace_back(i);
                indicies.emplace_back(search->second);
                
                isFound = true;
                break;
            } 
        }
        
        if (!isFound) {
            indicies.emplace_back(0);
            indicies.emplace_back(0);
        }
                
        return indicies;
    }
};