#include <iostream>
#include <string>
#include <unordered_set>

using namespace std;

class SolutionBruteForce
{
public:
    /*
        if L1 = length(s1), L2 = length(s2)
        S2 = #s1 substr = L1 * (L1 + 1) / 2
        S2 = #s2 substr = L2 * (L2 + 1) / 2
        
        time complexity is O(max(S1, S2))
        space complexity is O(max(S1, S2))
    */
    // basicly find all the substrings
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

};

class SolutionBruteForce2
{
public:
    /*
         time complexity is O(max(S1, S2))
        space complexity is O(max(S1, S2))
        but can finish faster because it searches for substrings with increasing length
    */
    string twoStrings(string s1, string s2) {
        int len = min(s1.length(), s2.length());
        for (int i = 1; i <= len; i++)
        {
            unordered_set<string> first = generate_substrings_up_to_len(s1, i);
            unordered_set<string> second = generate_substrings_up_to_len(s2, i);

            for (const string& sub1 : first)
            {
                if (second.find(sub1) != second.end())
                    return "YES";
            }
        }
        
        return "NO";
    }
    // maybe could be optimized to generate only substrings with given length
    unordered_set<string> generate_substrings_up_to_len(string& s, int len) 
    {
        unordered_set<string> substrings;
        string substr;

        cout << s << ' ' << len << endl;
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i; j < s.length() && j - i < len; j++)
            {
                substr.clear();
                for (int k = i; k <= j; k++)
                {
                    substr += s[k];
                    if (substr.length() < len)
                        continue;
                    else
                        break;
                }
                cout << substr << endl;
                substrings.insert(substr);
            }
        }
                
        return substrings;
    }
};

/*
    time complexity : O(max(len(s1),len(s2)))
    space complexity : O(max(len(S1),len(s2)))
*/
string twoStrings(string s1, string s2) {
    unordered_set<char> first_letters;
    unordered_set<char> second_letters;

    for (char ch1 : s1) first_letters.insert(ch1);
    for (char ch2 : s2) second_letters.insert(ch2);

    bool common_letters = false;
    for (char let1 : first_letters)
    {
        if (second_letters.find(let1) != second_letters.end())
        {
            common_letters = true;
            break;
        }
    }

    return common_letters? "YES" : "NO";
}

void test_two_strings()
{
    cout << twoStrings("hello", "world") << " <-> YES" << endl;
    cout << twoStrings("hi", "world") << " <-> NO" << endl;
    cout << twoStrings("abc", "dddbc") << " <-> YES" << endl;
}

int main()
{
    test_two_strings();

    SolutionBruteForce2* sbf2 = new SolutionBruteForce2();
    string str1 = "hello";
    string str2 = "world";
    int len = min(str1.length(), str2.length());
    for (int i = 1; i <= len; i++)
    {
        auto first = sbf2->generate_substrings_up_to_len(str1, i);
        auto second = sbf2->generate_substrings_up_to_len(str2, i);
    }


    for (int i = 0; i < str1.length(); i++)
    {
        sbf2->generate_substrings_up_to_len(str1, i);
    }
}

