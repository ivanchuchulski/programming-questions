vector<int> rotate_left(vector<int> arr, int shift) {
    unordered_map<int, int> indices;

    for (int i = 0 ; i < arr.size(); i++) {
        int shifted_index = (i + (arr.size() - shift)) % arr.size();
        indices.insert({shifted_index, arr[i]});    
    }    

    for (auto& p : indices) {
        int index = p.first;
        int element = p.second;

        arr[index] = element;
    }

    return arr;
}

