#include <bits/stdc++.h>

using namespace std;

int hourglass(vector<vector<int>> arr, int row, int col)
{
    int sum = 0;    
    for (int i = 0; i < 3; i++)
        sum += arr[row][col + i];
        
    sum += arr[row + 1][col + 1];
    
    for (int i = 0; i < 3; i++)
        sum += arr[row + 2][col + i];
    
    return sum;
}

// Complete the hourglassSum function below.
int hourglassSum(vector<vector<int>> arr) {
    int max_sum = std::numeric_limits<int>::min();
    
    for (int i = 0; i < arr.size() - 2; i++)
    {
        for (int j = 0; j < arr.size() - 2; j++)
        {
            int curr_sum = hourglass(arr, i, j);
            max_sum = std::max(max_sum, curr_sum);
        }
    }
    
    return max_sum;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    vector<vector<int>> arr(6);
    for (int i = 0; i < 6; i++) {
        arr[i].resize(6);

        for (int j = 0; j < 6; j++) {
            cin >> arr[i][j];
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
    }

    int result = hourglassSum(arr);

    fout << result << "\n";

    fout.close();

    return 0;
}
