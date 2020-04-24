#include <iostream>
#include <algorithm>
#include <unordered_set>

using namespace std;


class Solution {
public:
    bool isHappy(int n) {
        // fast I/O
        std::ios_base::sync_with_stdio(0);
        std::cin.tie(0);

        std::unordered_set<int> visited;

        while (true) {
            if (n == 1) {
                return true;
            }

            n = getSumOfSquaredDigits(n);

            if (visited.count(n) == 1) {
                return false;
            }
            else {
                visited.insert(n);
            }

        }
        
        /* 
        ->16
        1 + 36 = 37
        9 + 49 = 58
        25 + 64 = 100

        ->43
        16 + 9 = 25
        4 + 25 = 29
        4 + 81 = 93
        81 + 9 = 90
        81 + 0 = 81
        64 + 1 = 65
        36 + 25 = 61
        36 + 1 = 37
        9 + 49 = 58
        25 + 64 = 100


        */

    }

    bool getSumOfSquaredDigits(int number) {
        int sumOfSquaredDigits = 0;

        while (number != 0) {
            int digit = number % 10;
            sumOfSquaredDigits += digit * digit;
            number /= 10;
        }

        return sumOfSquaredDigits;
    }
};