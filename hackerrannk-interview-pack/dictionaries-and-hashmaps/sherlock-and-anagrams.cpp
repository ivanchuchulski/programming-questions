#include <bits/stdc++.h>

using namespace std;

unordered_map<string, int> find_sorted_substrs(const string& s)
{
    unordered_map<string, int> substrings;
    
    for (int i= 0; i < s.length(); i++)
    {
        for (int len = 1; len <= s.length() - i; len++)
        {
            string substr = s.substr(i, len);
            
            sort(substr.begin(), substr.end()); // ascii strings can be sorted in O(length(str)) time
            
            if (substrings.find(substr) == substrings.end())
                substrings[substr] = 1;
            else
                substrings[substr]++;
        }
    }
    
    return substrings;
}

/* 
    if N = length(s), then 
    time complexity is O(N^4 + N^2) = O(N^4)
        #substrings are O(N * (N + 1) / 2) = O(N^2 + N) = O(N^2)
    space complexity is O(N * (N + 1) / 2)
*/
// Complete the sherlockAndAnagrams function below.
int sherlockAndAnagrams(string s) 
{
    // O(N^3 * N*logN), or O(N^4), if strings are sorted in linear time
    auto substrings = find_sorted_substrs(s);
    
    int anagram_count = 0;
    for (auto& substr : substrings)
    {
        int count = substr.second;
        if (count > 1)
        {
            // if we have more than 1 occurence of the sorted substr
            // then the number of substrs that were anagrams is
            // the number of pairs(aka strings that are anagrams), that can be formed from count items, which is
            // n * (n - 1) / 2
            anagram_count += count * (count - 1) / 2; 
        }
    }
    
    return anagram_count;
}   

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int q_itr = 0; q_itr < q; q_itr++) {
        string s;
        getline(cin, s);

        int result = sherlockAndAnagrams(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}
