class Solution {
    public:
        bool is_alphanum(char ch)
        {
            return (ch >= 'a' && ch <= 'z') || 
                (ch >= 'A' && ch <= 'Z') ||
                (ch >= '0' && ch <= '9');
        }
        
        char to_lowercase(char ch)
        {
            if (ch >= 'A' && ch <= 'Z')
                return ch + 32;
            else 
                return ch;
        }
        
        /*
         Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
         time complexity : O(strlen(s))
         space complexity : O(1)
        */
        bool isPalindrome(string s) 
        {
            for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            {
                while (!is_alphanum(s[i]) && i != j)
                    i++;
                
                while (!is_alphanum(s[j]) && i != j)
                    j--;
                
                if (to_lowercase(s[i]) != to_lowercase(s[j]))
                    return false;
            }
            
            return true;
        }   
    };