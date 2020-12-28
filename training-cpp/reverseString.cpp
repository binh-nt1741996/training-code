#include<iostream>

void reverseString(const char* str){
    const char* end = str;
    char temp;
    int count = 0;
    if (str){
        while(*end){
            end++;
            count++;
        }
        end--;
        while (str < end){
            temp = *str;
            *str++ = *end;
            *end-- = temp;
        }
    }
    for (int i = 0; i < count; i++){
        std::cout << *str++ << std::endl;
    }
}

int main(int argc, char const *argv[])
{
    const char* str = "Binh";
    reverseString(str);
    return 0;
}
