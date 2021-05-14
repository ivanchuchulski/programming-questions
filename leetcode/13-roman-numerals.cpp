#include <string>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int romanToInt(string str) {
        unordered_map<char, int> romanValues;
        romanValues['I'] = 1;
        romanValues['V'] = 5;
        romanValues['X'] = 10;
        romanValues['L'] = 50;
        romanValues['C'] = 100;
        romanValues['D'] = 500;
        romanValues['M'] = 1000;
        
        int result = 0;
        for (int i = 0; i < str.size(); i++)
        {
            int current = str[i];

            int j = i + 1;
            if (j >= str.size())
            {
                result += romanValues[current];    
                continue;
            }
            
            char nextValue = str[j];
            if (romanValues[nextValue] > romanValues[current])
            {
                result += romanValues[nextValue] - romanValues[current];
                i++;
            }
            else
            {
                result += romanValues[current];
            }
        }
        
        return result;
    }

    // fails to "MDCXCV"
    int romanToInt_2(string str) {
        unordered_map<char, int> romanValues;
        romanValues['I'] = 1;
        romanValues['V'] = 5;
        romanValues['X'] = 10;
        romanValues['L'] = 50;
        romanValues['C'] = 100;
        romanValues['D'] = 500;
        romanValues['M'] = 1000;
        
        int result = 0;
        for (int i = 1; i < str.size(); i++)
        {
            if (romanValues[str[i]] > romanValues[str[i - 1]])
            {
                result += romanValues[str[i]] - romanValues[str[i - 1]];
                if (i == str.size() - 2)
                {
                    continue;
                }
                i++;
            }
            else
            {
                if (i == str.size() - 1)
                {
                    result += romanValues[str[i]];
                }
                result += romanValues[str[i - 1]];
             
            }
        }
     
        return result;
    }
};