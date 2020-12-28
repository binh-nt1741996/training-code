#include <iostream>

using namespace std;

void merge(int* arr, int left, int mid, int right){
    int leftSec = mid - left + 1;
    int rightSec = right - mid;
    int* leftArr = new int[leftSec];
    int* rightArr = new int[rightSec];

    int leftIndex = 0, rightIndex = 0;
    for (int i = 0; i < leftSec; ++i){
        *(leftArr + i) = arr[left + i];
    }

    for (int i = 0; i < rightSec; ++i){
        *(rightArr + i) = arr[mid + i + 1];
    }

    for (int i = left; i < right; i++){
        if (*(leftArr) <= *(rightArr)){
            *(arr + i) = *(leftArr + leftIndex++);
        } else{
            *(arr + i) = *(rightArr + rightIndex++);
        }
    }
}

void sort(int* arr, int left, int right){
    if (left >= right) return;
    int mid = (int) (left + right)/2;
    sort(arr, left, mid);
    sort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

void display(int* arr, int length){
    for (int i = 0; i<length; i++){
        cout << *(arr + i) << endl;
    }
}

int main(int argc, char const *argv[])
{
    string inputStr;
    cout << "Enter an array: ";
    getline(cin, inputStr);
    int lenArr = (int)inputStr.length()/2 + 1;
    int* arr= new int[lenArr];
    cout << "Length of array: " << (int)inputStr.length()/2 + 1 << endl;
    int counter = 0;
    for (int i = 0; i < inputStr.length(); i++){
        if (inputStr[i] != ' '){
            *(arr + counter++) = inputStr[i] - '0';
        }
    }
    display(arr, lenArr);
    sort(arr, 0, lenArr);
    display(arr, lenArr);
    return 0;
}
