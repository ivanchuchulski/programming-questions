#include <iostream>
#include <unordered_set>
#include <vector>
using namespace std;

// problem : all the numbers in the array are dublicated except for one, find it 
// complexity
// N is the size of the number array
// time : O(N)
// memory : O(N), N/2 + 1, in case first N/2 + 1 numbers are all unique 
// and then we begin to find dublicates and remove them from the hash set
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