#include <iostream>
#include <unordered_set>
#include <vector>
using namespace std;


class Solution {
public:
    int singleNumber(vector<int>& nums) {
        // for faster I/O
        std::ios_base::sync_with_stdio(false);
        std::cin.tie(NULL);

        std::unordered_set<int> numberSet;
        
        for (int num : nums) {
            if (numberSet.find(num) == numberSet.end()) 
            {
                numberSet.insert(num);
            }
            else
            {
                numberSet.erase(num);
            }
            
        }
        
        return *numberSet.begin();
    }
};