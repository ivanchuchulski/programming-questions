#include <bits/stdc++.h>

using namespace std;

vector<string> find_substrings(const string& s)
{
    vector<string> substrings;
    
    for (int i= 0; i < s.length(); i++)
        for (int len = 1; len <= s.length() - i; len++)
            substrings.push_back(s.substr(i, len));
    
    return substrings;
}

int get_string_code(const string& str)
{
    unordered_map<char, int> symbols;
    
    for (char symbol : str)
    {
        if (symbols.find(symbol) != symbols.end())
            symbols[symbol]++;
        else 
            symbols[symbol] = 1;
    }
    
    int code = 0;
    for (auto& p : symbols)
        code += p.first * p.second;
        
    return code;
}

bool are_anagrams(const string& left, const string& right)
{
    return get_string_code(left) == get_string_code(right);
}

/* 
    if N = length(s), then 
    time complexity is O(N^3 + ((N * (N + 1) / 2)^2) * N) = O(N^5)
        #substrings are O(N * (N + 1) / 2) = O(N^2 + N) = O(N^2)
        so we have O(N^3 + N^2 *  N^2 * N) = O(N^5)
    space complexity is O(N * (N + 1) / 2)
 */
// Complete the sherlockAndAnagrams function below.
int sherlockAndAnagrams_slow(string s) 
{
    // O(N ^ 3)
    vector<string> substrings = find_substrings(s);
    
    int anagram_count = 0;
    // O(N * (N + 1) / 2)
    for (int i = 0; i < substrings.size() - 1; i++)    
    {
        // O(N * (N + 1) / 2)
        for (int j = i + 1; j < substrings.size(); j++)
        {
            // O(N)
            if (are_anagrams(substrings[i], substrings[j]))
                anagram_count++;
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
