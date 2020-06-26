int sock_merchant(vector<int> socks) {
    unordered_map<int, int> colors;

    for (int sock : socks) {
        ++colors[sock];
    }

    int pairs_count = 0;

    for (auto& color : colors) {
        pairs_count += color.second / 2;
    }

    return pairs_count;
}