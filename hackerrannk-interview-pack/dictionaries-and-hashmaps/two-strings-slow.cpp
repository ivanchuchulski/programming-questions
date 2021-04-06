#include <bits/stdc++.h>

using namespace std;

unordered_set<string> generate_substrings(string s) 
{
    unordered_set<string> substrings;
    
    for (int i = 0; i < s.length(); i++)
    {
        for (int j = i; j < s.length(); j++)
        {
            string substr;
            for (int k = i; k < j + 1; k++)
                substr += s[k];
                
            substrings.insert(substr);
            
        }
    }
            
    return substrings;
}

/*
    let L1 = length(s1), L2 = length(s2)
    S2 = #s1 substr = L1 * (L1 + 1) / 2
    S2 = #s2 substr = L2 * (L2 + 1) / 2
    
    time complexity is O(max(S1, S2))
    space complexity is O(max(S1, S2))
*/
// Complete the twoStrings function below.
string twoStrings(string s1, string s2) {
    unordered_set<string> first = generate_substrings(s1);
    unordered_set<string> second = generate_substrings(s2);
   
    for (const string& sub1 : first)
    {
        if (second.find(sub1) != second.end())
            return "YES";
    }
    
    return "NO";
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int q_itr = 0; q_itr < q; q_itr++) {
        string s1;
        getline(cin, s1);

        string s2;
        getline(cin, s2);

        string result = twoStrings(s1, s2);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}
