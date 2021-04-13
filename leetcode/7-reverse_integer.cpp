class Solution {
public:
    // integer reverse with bounds checking for 32-bit integer
    // time complexity is O(log(x)), bec there are log(10)(x) digits in a number x
    // space complexity is O(1)
    int reverse(int x) {
        const int UPPER_LIMIT = INT32_MAX;
        const int LOWER_LIMIT = INT32_MIN;
        int reversed = 0;

        while (x != 0)
        {
            int remainder = x % 10;
            
            if (reversed > UPPER_LIMIT / 10 || reversed < LOWER_LIMIT / 10)
                return 0;
            
            if (reversed == UPPER_LIMIT / 10 && remainder > 7)
                return 0;

            if (reversed == LOWER_LIMIT / 10 && remainder < -8)
                return 0;

            reversed = reversed * 10 + remainder;
            x /= 10;
        }

        return reversed;
    }
};