#include <iostream>

using namespace std;

class Solution {
public:
    int hammingDistance(int x, int y) {
        int count = 0, n = x^y;
        while (n){
            count++;
            cout << n << endl;
            n &= n - 1;
        }
        return count;
    }
};

int main(int argc, char const *argv[])
{   
    cout << "Arguments no: " << argc << endl;
    Solution* sol = new Solution();
    cout << sol->hammingDistance(93,73) << endl;
    return 0;
}
