#include <bits/stdc++.h>

using namespace std;

/*
    You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You
    are allowed to swap any two elements. Find the minimum number of swaps required to sort the array in ascending
    order.
*/
/*
    if N is the number of elements
    time : O(N)
    memory : O(1)
*/
int minimumSwaps(vector<int> arr) 
{
    int swapCount = 0;
    
    for (int i = 0; i < arr.size(); i++)
    {
        int correctNum = i + 1;
        if (arr[i] == correctNum)
            continue;
            
        int j = i + 1;
        while(arr[j] != correctNum)
            j++;
            
        arr[j] = arr[i];
        // full swapping isn't needed, 1 test fails with that :D
        // swap(arr[i], arr[j]);
        swapCount++;
    }
    
    return swapCount;
}
