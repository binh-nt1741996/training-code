#include<iostream>
#include<vector>
#include<array>

using namespace std;

int func(int& x){
    return x;
}
int main(int argc, char const *argv[])
{
    int (*funcPtr)(int&) = &func;
    int b = 5;
    int a = (*funcPtr)(b);
    cout << a << endl;
    return 0;
}
