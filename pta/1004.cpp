#include <iostream>
#include <vector>
#include <map>
#include <queue>

using namespace std;

struct Node {
    int id;
    vector<Node*> children;

    Node(int id) {
        this->id = id;
        this->children = {};
    }
};

queue<Node*> _queue = {};

vector<int> get_leafs_count(Node* root) {
    vector<int> leafs_count = {};
    _queue.push(root);

    while (_queue.size()) {
        leafs_count.push_back(0);
        int _queue_size = _queue.size();
        while (_queue_size > 0) {
            Node* cur_node = _queue.front();
            _queue.pop();
            for (auto i = 0u; i < cur_node->children.size(); i++) {
                _queue.push(cur_node->children[i]);
            }

            if (cur_node->children.size() == 0) {
                leafs_count.back()++;
            }
            _queue_size--;
        }
    }
    return leafs_count;
}

int main() {
    int n, m;
    std::cin >> n >> m;

    map<int, Node*> _map = {};
    for (int i = 0; i < n; i++) {
        Node* _node = new Node(i + 1);
        _map.insert(std::pair<int, Node*>(i + 1, _node));
    }

    for (int i = 0; i < m; i++) {
        int cur_id = 0;
        int k = 0;
        std::cin >> cur_id >> k;

        Node* cur_node = _map.find(cur_id)->second;
        for (int j = 0; j < k; j++) {
            int id;
            std::cin >> id;
            Node* _node = _map.find(id)->second;
            cur_node->children.push_back(_node);
        }
    }

    vector<int> leafs_count = get_leafs_count(_map.find(1)->second);
    for (auto i = 0u; i < leafs_count.size(); i++) {
        cout << leafs_count[i];
        if (i != leafs_count.size() - 1) {
            cout << " ";
        }
    }
    cout<<endl;
    return 0;
}
