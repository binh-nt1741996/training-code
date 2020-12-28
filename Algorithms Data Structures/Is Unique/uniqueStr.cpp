#include<iostream>
#include<string>

using namespace std;

bool checkUniqueString(std::string str);

int main(int argc, char const *argv[])
{
    string str;
    getline(cin, str);
    cout << "Uniqueness: " << checkUniqueString(str) << endl;
}

bool checkUniqueString(std::string str){
    int checker = 0;
    for (int i = 0; i < str.length(); i++){
        int val = str.at(i) - 'a';
        if ((checker & (1 << val)) > 0){
            return false;
        }
        checker |= (1 << val);
    }
    return true;
}