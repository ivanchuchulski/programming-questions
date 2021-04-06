#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;


int merging(vector<int>& arr, int first, int middle, int last)
{
    int left = first;
    int right = middle + 1;
    int element_count = last - first + 1;
    std::vector<int> buffer(element_count, 0);

    int inversions = 0;

    for (size_t i = 0; i < element_count; i++) {
        if (left > middle) {
            buffer[i] = arr[right++];
        }

        else if (right > last) {
            buffer[i] = arr[left++];
        }

        else if (arr[left] <= arr[right]) {
            buffer[i] = arr[left++];
        }

        else {
            buffer[i] = arr[right++];
            inversions += middle - left + 1;
        }
    }

    for (int i = 0; i < element_count; i++) {
        arr[first++] = buffer[i];
    }

    return inversions;
}

int merge_sort(vector<int>& arr, int first, int last) {
    int inversions = 0;

    if (first < last) {
        int middle = first + (last - first) / 2;

        inversions = MergeSort(arr, first, middle);
        inversions += MergeSort(arr, middle + 1, last);

        inversions += merging(arr, first, middle, last);
    }

    return inversions;
}


int find_inversions_slow(vector<int>& people) {
    int bribes = 0;

    for (int i = 0; i < people.size(); i++) {
        for (int j = i + 1; j < people.size(); j++) {
            if (people[i] > people[j]) {
                bribes++;
            }
        }
    }

    return bribes;
}

void minimum_bribes(vector<int>& people) {
    unordered_map<int, int> indices;

    for (int i = 0; i < people.size(); i++) {
        indices.insert({people[i], i + 1});
    }

    int bribes = 0;

    for (auto& index_pair : indices) {
        int real_position = index_pair.first;
        int position = index_pair.second;

        if ((real_position - position) > 2) {
            cout << "Too chaotic\n";
            return;
        }
    }

    bool fast = true;

    // N * log(N)
    if (fast) {
        cout << MergeSort(people, 0, people.size() - 1) << '\n';
    }
    // N^2
    else {
        find_inversions_slow(people);
    }
    
    return;
}

int main() {
    vector<int> poeple = {1, 2, 5, 3, 7, 8 , 6, 4};

    minimum_bribes(people);

    return 0;
}

