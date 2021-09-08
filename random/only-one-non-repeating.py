from typing import List

def solve(numbers: List[int]):
    """
     prints a number that is not-repeating from a given array of numbers, in which every one is occurring twice and
     only one once
    """
    non_repeating = set()

    for number in numbers:
        if number not in non_repeating:
            non_repeating.add(number)
        else:
            non_repeating.remove(number)

    for single in non_repeating:
        print("non-repeating number is : {}".format(single))

def main():
    numbers = [10, 211, 211, 10, 3213, 3213, 17, 9, 4, 9, 4]
    print(numbers)
    solve(numbers)

if __name__ == "__main__":
    main()