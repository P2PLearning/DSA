#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>




typedef struct Node{
    int value;
    struct Node* next;
    struct Node* prev;
}Node, pNode;


Node* head = (Node*)NULL;
int size = 0;

Node* Create(int w) {
    Node* new = (Node*)malloc(sizeof(Node));
    new ->next =(Node*)NULL;
    new->prev =(Node*)NULL;
    new->value =w;
    return new;
}

//Time complexity O(n)
//Space complexity O(1)
void add (Node* newNode, int index){
    int i = 0;
    Node* current = head;
    
    // Empty list, adding to head
    if (head==(Node*)NULL&& size ==0){
        head = newNode;
        size++;
        printf("adding to the head\n");
        return;
    }
    // Non empty list
    // adding to head
    if (index == 0){ 
        newNode->next = head;
        head->prev = newNode;
        head = newNode;
        size++;
        printf("adding to head \n");
        return;
    }
    for (i=0; current!=(Node*) NULL && i<index-1; i++){
         current = current->next; 
    }
    // adding to tail
    if (current->next==(Node*)NULL){ 
        current->next = newNode;
        newNode ->prev = current;
        size++;
        printf("adding to the tail \n");
        return ;
    }

    // adding to the middle
    newNode->next = current->next;
    current->next = newNode;
    newNode->prev = current;
    newNode->next->prev=newNode;
    size++;
    printf("adding to the middle at index = %d \n", index);
    return;
}

//Time complexity O(n)
//Space complexity O(1)
bool Remove(Node* node){
    
    // Empty list
    if (head==(Node*)NULL&& size ==0){
        printf("Empty list \n");
        return false;
    }

    //Non-emrty list
    // If position is more than number of ndoes 
    int index = 0;
    Node* mark = head;
    while (mark->value != node->value && mark->next!=NULL){
        mark = mark->next;
        index++;
    }

    if (index=size-1 && mark->value != node->value ){
        printf("No such node found\n");
        return false; 
    }

    //Deleting head
    Node* current = head;
    if (index == 0){
        head = head->next;
        free (current);
        size--;
        printf("Deleting head\n");
        return true;
    }
    
    //Deleting middle and tail
    int i;
    for (i=0; current!=(Node*)NULL && i<index-1; i++) 
         current = current->next; 
    Node* temp = current->next->next; 
    free(current->next);  // Free memory 
    current->next = temp; 
    size--;
    if (index==size){
        printf("Deleting the tail\n");
    }else{
        printf("Deleting in the middle at index: %d \n", index);
    }
    return true;
}


int PrintList(Node** list){
    int i=0;
    Node* current = head;
    while(current!=(Node*)NULL){
        printf("Node %d : %d \n",i, current->value);
        current = current->next;
        i++;
    }
    return 0;
}


int main(){

    //Build the house and bring the Nodes
    Node** house = (Node**)malloc(sizeof(Node*));
    Node* wolf  = Create(20);
    Node* lynx = Create(18); 
    Node* moose   = Create(200);
    //Node* human = Create(80); // uncomment for more test case
   
    //Put the Nodes inside the house
    add(wolf,1);
    PrintList(house);
    add(lynx,1);
    PrintList(house);
    add(moose,1);
    PrintList(house);
    //add(human,1,house);
    //PrintList(house); // uncomment for more test case
   

    //Let them out to play on a sunny day
    Remove(lynx);
    PrintList(house);
    Remove(moose);
    PrintList(house); // uncomment for more test case
    // Remove(1,house); //  uncomment for more test case
   
   

    return 1;
}
