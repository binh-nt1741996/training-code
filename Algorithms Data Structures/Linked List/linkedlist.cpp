#include<iostream>

using namespace std;

struct Node{
    int data;
    Node *next = NULL;
};

class linkedList{
    private:
        Node *head;
    public:
        linkedList(){
            head = NULL;
        }
        void printList();
        void push(int data);
        void append(int data);
        void deleteByIndex(int index);
        void deleteByValue(int data);
        void deleteLinkedList();
        int countValue();
        void removeDuplicatesFromSortedList();
        void removeDuplicatesFromUnsortedList();
};

int linkedList::countValue(){
    Node *temp = head;
    int count = 0;
    if (head == NULL){
        return 0;
    }
    while (temp != NULL){
        count++;
        temp = temp->next;
    }
    return count;
}

void linkedList::deleteByValue(int data){
    Node *temp = head;
    if (head == NULL){
        cout << "The list is empty" << endl;
        exit(0);
    }
    if (head->data == data){
        head->next = head;
        exit(0);
    }
    while (temp != NULL){
        if (temp->next->data == data){
            temp->next = temp->next->next;
            break;
        }
        temp = temp->next;
    }
    free(temp);
}

void linkedList::deleteByIndex(int index){
    int count = 0;
    Node *temp = head;
    if (head == NULL){
        cout << "The list is empty" << endl;
        exit(0);
    }
    if (index == 0){
        head = head->next;
        exit(0);
    }
    while (temp != NULL){
        if (count == index - 1){
            temp->next = temp->next->next;
            break;
        }
        count++;
        temp = temp->next;
    }
    if (count > index){
        cout << "The inserted index is larger than the length of list!" << endl;
    }
}

void linkedList::printList(){
    Node *temp = head;
    if (head == NULL){
        cout << "The list is empty" << endl;
        exit(0);
    }
    while (temp != NULL){
        cout << temp->data << endl;
        temp = temp->next;
    }
}

void linkedList::push(int data){
    Node *newNode = new Node();
    newNode->data = data;
    if (head == NULL){
        head = newNode;
    } else{
        newNode->next = head;
        head = newNode;        
    }
}

void linkedList::append(int data){
    Node *newNode = new Node();
    newNode->data = data;
    if (head == NULL){
        head = newNode;
    } else{
        Node *temp = head;
        while (temp->next != NULL){
            temp = temp->next;
        }
        temp->next = newNode;
    }
}


int main(int argc, char const *argv[])
{
    linkedList list;
    list.push(17);
    list.append(4);
    list.push(19);
    list.push(9);
    list.append(6);
    list.append(16);
    list.push(0);
    list.printList();
    cout << "Counting: " << list.countValue() << endl;
    
    list.deleteByIndex(2);
    cout << "Delete index 2 value" << endl;
    list.printList();
    
    list.deleteByValue(6);
    cout << "Delete value 6" << endl;
    list.printList();
    return 0;
}
