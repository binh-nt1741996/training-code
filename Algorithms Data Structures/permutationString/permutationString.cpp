#include <iostream>
#include <string>

using namespace std;

bool checkPermutation(char *&str1, char *&str2, int length){
    int letters[128] {};
    for (int i = 0; i < length; i++){
        int c = int(*(str1 + i));
        letters[c]++;
    }
    for (int i = 0; i < length; i++){
        int c = int(*(str2 + i));
        letters[c]--;
        if (letters[c] < 0){
            return false;
        }
    }
    return true;
}
int main(int argc, char const *argv[])
{
    cout << "Enter two strings for checking: " << endl;
    const char * str1;
    str1 = "Hello";
    cout << *(str1+1) << endl;
    /*
    char *str1;
    char *str2;
    string inputStr;
    getline(cin, inputStr);
    string delimiter = " ";
    string token;
    int pos = 0;
    while((pos = inputStr.find(delimiter)) != string::npos){
        token = inputStr.substr(0, pos);
        str1 = token;
        inputStr.erase(0, pos + delimiter.length());
    }
    */
    return 0;
}
