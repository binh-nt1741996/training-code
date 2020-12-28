#include<cstddef>
#include<iostream>
#include<queue>

using namespace std;

struct Node
{
    Node(int value);
    int value;
    struct Node* left;
    struct Node* right;
};

Node::Node(int value){
    Node::value = value;
    Node::left = NULL;
    Node::right = NULL;
}

void inOrder(struct Node* root){
    if (root == NULL) return;
    inOrder(root->left);
    std::cout << root->value << std::endl;
    inOrder(root->right);
}

void insert(struct Node* root, int data){
    if (root == NULL){
        root = new Node(data);
        return;
    }
    std::queue<Node*> q;
    q.push(root);
    struct Node* temp = NULL;
    while(!q.empty()){
        temp = q.front();
        q.pop();
        if (temp->value > data){
            if (temp->left == NULL){
                temp->left = new Node(data);
                return;
            } else{
                q.push(temp->left);
            }
        } else{
            if (temp->right == NULL){
                temp->right = new Node(data);
                return;
            } else{
                q.push(temp->right);
            }
        }
    }
}

bool search(struct Node* root, int key){
    if (root == NULL) return false;
    struct Node* temp = root;
    while (temp->value != key){
        if (temp != NULL){
            if (temp->value > key){
                temp = temp->left;
            } else{
                temp = temp->right;
            }
        } else{
            delete temp;
            return false;
        }
    }
    return true;
}

int main(int argc, char const *argv[])
{
    struct Node* root = new Node(5);
    insert(root, 7);
    insert(root, 4);
    insert(root, 8);
    insert(root, 2);
    insert(root, 6);
    inOrder(root);
    std::string result = search(root,10)? "true" : "false";
    cout << result << endl;
    return 0;
}
