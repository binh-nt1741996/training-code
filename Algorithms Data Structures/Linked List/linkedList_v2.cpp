#include<iostream>

using namespace std;

struct Node
{
    int data;
    Node *next;
};

int main(int argc, char const *argv[])
{
    int k = 5;
    int l = 6;
    int *a = &k;
    int *b = &l;
    int *c = b;
    std::cout << *c << endl;
    return 0;
}
