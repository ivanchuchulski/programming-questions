#include <cstdint>
#include <iostream>


class solution
{
public:
    static bool are_friends(const std::int64_t left, const std::int64_t right)
    {
        int64_t numbers_xor = left ^ right;
        int64_t difference = 0;
        while (numbers_xor != 0)
        {
            int64_t remainder = numbers_xor % 2;
            if (remainder == 1) difference++;
            numbers_xor /= 2;
        }

        return difference % 2 != 0 && is_prime_number(difference);

    }

    static void remove_friend_numbers(const std::int64_t* arr, const size_t size);

    static void print_array(const std::int64_t* arr, const size_t size)
    {
        for (size_t i = 0; i < size; i++)
        {
            std::cout << arr[i] << ' ';
        }
        
        std::cout << std::endl;
    }

private:
    static bool is_prime_number(int64_t number)
    {
        if (number == 0 || number == 1) return true;

        for(int i = 2; i < number; i++)
            if (number % i == 0) return false;
        
        return true;
    }
};

int main()
{
    size_t size;
    std::cin >> size;

    std::int64_t* arr = new int64_t[size];
    for (size_t i = 0; i < size; i++) std::cin >> arr[i];

    solution::print_array(arr, size);
    solution::remove_friend_numbers(arr, size);
    solution::print_array(arr, size);

    
    
}