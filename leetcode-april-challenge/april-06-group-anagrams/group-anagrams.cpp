#include <iostream>
#include <vector>
#include <string>
#include <numeric>
#include <unordered_set>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> groups;
        vector<vector<string>> result;

        for (string& str : strs) {
            string stringCode = getStringCode(str);

            auto search = groups.find(stringCode);

            if (search == groups.end()) {
                groups.insert({stringCode, {str}});
            }
            else {
                search->second.emplace_back(str);
            }
        }

        for (auto& group : groups) {
            result.emplace_back(group.second);
        }        

        return result;
    }

    // returns a sorted string as code, two strings are anagrams if their sorted versions are equal 
    // here we do the same, we sort the string linearly
    string getStringCode(std::string& str) {
        // because input is only in lowercase
        int ALPHABET_SIZE = 'z' - 'a' + 1;
        vector<int> wordLetters(ALPHABET_SIZE, 0);
        string code;

        for (char symbol : str) {
            wordLetters[letterIndex(symbol)]++;
        }

        for (char letter = 'a'; letter <= 'z'; letter++) {
            int index = letterIndex(letter);

            code.append(wordLetters[index], letter);
        }

        return code;
    }

    int letterIndex(char letter)
	{
		return letter - 'a';
	}
};