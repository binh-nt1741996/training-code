#include <iostream>
#include <fstream>

void printLastKLines(const char* filename, int K){
    std::ifstream file (filename);
    int size = 0;
    std::string L[K];
    while(file.peek() != EOF){
        getline(file, L[size%K]);
        size++;
    }
    std::cout << size << std::endl;
    int start = size > K? (size%K) : 0;
    int count = std::min(K, size);
    for (int i = 0; i < count; i++) {
        std::cout << L[(start + i)%K] << std::endl;
    }
}

int main(int argc, char const *argv[])
{
    const char* filename = "test.txt";
    printLastKLines(filename, 3);
    return 0;
}
