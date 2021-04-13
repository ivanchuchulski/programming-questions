class Solution {
public:
    bool is_opening_symbol(char ch)
    {
        return ch == BRACE_OPENING || ch == BRACKET_OPENING || ch == PAREN_OPENING;
    }
    
    bool is_prev_symbol_the_same(char top, char closing)
    {   
        if (top == BRACE_OPENING)     
            return closing == BRACE_CLOSING;
        
        if (top == BRACKET_OPENING)
            return closing == BRACKET_CLOSING;
        
        if (top == PAREN_OPENING)
            return closing == PAREN_CLOSING;
        
        // return true if there is text in the str, or maybe check it in main if-else
        return false;
    }
    
    bool isValid(string s) {
        stack<char> st;

        for (char ch : s)
        {
            if (is_opening_symbol(ch))
            {
                st.push(ch);
            }
            else
            {
                if (st.empty())
                    return false;

                if (!is_prev_symbol_the_same(st.top(), ch))
                    return false;
                
                st.pop();
            } 
        }
        
        return st.empty();
    }
    
    char get_closing_symbol(char opening)
    {
        if (opening == BRACE_OPENING) return BRACE_CLOSING;
        if (opening == BRACKET_OPENING) return BRACKET_CLOSING;
        if (opening == PAREN_OPENING) return PAREN_CLOSING;

    }
    bool isValid2(string s) {
        stack<char> closing_needed;

        for (char ch : s)
        {
            if (is_opening_symbol(ch))
            {
                closing_needed.push(get_closing_symbol(ch));
            }
            else
            {
                if (closing_needed.empty())
                    return false;

                if (closing_needed.top() != ch)
                    return false;
                
                closing_needed.pop();
            } 
        }
        
        return closing_needed.empty();
    }
    
private:
    const char BRACE_OPENING = '{';
    const char BRACE_CLOSING = '}';
    
    const char BRACKET_OPENING = '[';
    const char BRACKET_CLOSING = ']';
    
    const char PAREN_OPENING = '(';
    const char PAREN_CLOSING = ')';
};