#include<iostream>
#include<sstream>
#include<vector>

using namespace std;

struct node {
    int value;
    node *next;
};

class stack{
    node *top;
    public:
        stack();
        void push(int data);
        void pop();
        void display();
};

stack::stack(){
    top = NULL;
}

void stack::push(int data){
    node *temp;
    temp = (node*)malloc(sizeof(node));
    if (temp == NULL){
        cout << "Memory exhausted" << endl;
        exit(0);
    }
    temp = new node;
    temp->value = data;
    temp->next = NULL;

    if (top != NULL){
        temp->next = top;
    }

    top = temp;
}

void stack::pop(){
    node *temp;
    if (top == NULL){
        cout << "The stack is empty" << endl;
    } else{
        temp = top;
        top = top->next;
        cout << temp->value << endl;
        temp = NULL;
    }
}

void stack::display(){
    node *temp;
    if (top == NULL){
        cout << "The stack is empty" << endl;
    } else{
        temp = top;
        while (temp != NULL){
            cout << temp->value << endl;
            temp = temp->next;
        }
    }
}

int main(int argc, char const *argv[])
{
    stack a;
    int choice;
    do{
        cout << "What is your choice?\n1.PUSH 2. POP 3.DISPLAY 4.EXIT" << endl;
        cout << "Your choice: ";
        cin >> choice;
        switch (choice){
            case 1:
                cout << "Enter a number: ";
                int num;
                cin >> num;
                a.push(num);
                break;
            case 2:
                a.pop();
                break;
            case 3:
                a.display();
                break;
            case 4:
                exit(0);
                break;
            default:
                cout << "Choose again" << endl;
                break;
        }
        cout << "----------------------------------------------------------------" << endl;
    } while(choice);
    return 0;
}
