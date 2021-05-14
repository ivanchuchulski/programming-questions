#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    /*
        time : O(#strings)
        memory : O(1)
    */
    string longestCommonPrefix(vector<string>& strs) {
        string common = strs[0];
        if (common == "")
            return "";

        for (int i = 1; i < strs.size(); i++)
        {
            string& curr = strs[i];
            
            int cutoff = 0;
            while(common[cutoff] == curr[cutoff] && cutoff < common.length())
                cutoff++;
            
            if (cutoff == common.length())
                continue;
  
            if (cutoff == 0)
                return "";

            common.erase(common.begin() + cutoff, common.end());
        }
        
        return common;
    }
};

int main(int argc, char const *argv[])
{
    vector<string> strs = {"flower", "flower"};
    Solution* sol = new Solution();
    cout << sol->longestCommonPrefix(strs) << endl;
}
