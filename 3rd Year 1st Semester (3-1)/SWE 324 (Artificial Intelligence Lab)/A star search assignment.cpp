
#include<bits/stdc++.h>

using namespace std;

struct Node {
    char id;
    int f;
    int g;
    int h;

    Node(char i, int f_val, int g_val, int h_val) : id(i), f(f_val), g(g_val), h(h_val) {}

    bool operator<(const Node& other) const {
        return f > other.f;
    }
};

void AStarSearch(unordered_map<char, vector<pair<char, int>>> graph, char start, char goal, unordered_map<char, int> heuristic) {

    priority_queue<Node> open_list;

    unordered_map<char, bool> closed_list;

    unordered_map<char, int> g_values;

    open_list.push(Node(start, 0, 0, heuristic[start]));

    g_values[start] = 0;

    while (!open_list.empty()) {

        Node current_node = open_list.top();
        open_list.pop();

        vector<char> path;
        if (current_node.id == goal) {
            cout<<"Goal found!  Total cost is :  "<<current_node.f<<endl;
            cout << "Path found: " << endl;
            char node = current_node.id;
            path.push_back(node);
            while (node != start) {
                for (auto& neighbor : graph[node]) {
                    if (g_values[neighbor.first] == current_node.g - neighbor.second) {
                        path.push_back(neighbor.first);
                        current_node = Node(neighbor.first, current_node.f, g_values[neighbor.first], heuristic[neighbor.first]);
                        node = neighbor.first;
                        break;
                    }
                }
            }
            reverse(path.begin(),path.end());
            int i;
            for(i = 0; i < path.size()-1; i++)
            {
                cout<<path[i]<<" -> ";
            }
            cout << path[i]<<endl;
            return;
        }

        closed_list[current_node.id] = true;

        for (auto& neighbor : graph[current_node.id]) {

            if (closed_list[neighbor.first]) {
                continue;
            }


            int tentative_g = g_values[current_node.id] + neighbor.second;

            if (!g_values.count(neighbor.first) || tentative_g < g_values[neighbor.first]) {

                int f_val = tentative_g + heuristic[neighbor.first];

                Node neighbor_node = Node(neighbor.first, f_val, tentative_g, heuristic[neighbor.first]);

                open_list.push(neighbor_node);

                g_values[neighbor.first] = tentative_g;
            }
        }
    }


    cout << "No path found." << endl;
}

int main() {

    int n,e;
    cin>>n>>e;

    char start, goal;
    start = 'A';
    unordered_map<char, int> heuristic;
    for(int i = 0; i<n; i++)
    {
        char c;
        int hi;
        cin>>c>>hi;
        heuristic[c] = hi;
        if(hi==0){
            goal = c;
        }
    }

    unordered_map<char, vector<pair<char, int>>> graph;

    for(int i = 0; i<e; i++){
        char c1, c2;
        int ct;
        cin>>c1>>c2>>ct;
        graph[c1].push_back(make_pair(c2,ct));
        graph[c2].push_back(make_pair(c1,ct));
    }

    AStarSearch(graph, start, goal, heuristic);

    return 0;
}
/*
Input 1:
9 9
A 10
B 8
C 7
D 6
E 5
F 4
G 3
H 2
I 0
A B 4
A C 2
B D 5
B E 12
C F 3
D G 7
E H 7
F I 2
H I 4
*/

/*
Input 2:
20 23
A 366
B 0
C 160
D 242
E 161
F 178
G 77
H 151
I 226
L 244
M 241
N 234
O 380
P 98
R 193
S 253
T 329
U 80
V 199
Z 374
A Z 75
A S 140
A T 118
Z O 71
S F 99
S R 80
S O 151
T L 111
L M 70
M D 75
D C 120
C R 146
P R 97
P C 138
P B 101
B G 90
B F 211
B U 85
U H 98
H E 86
U V 142
V I 92
I N 87
*/
