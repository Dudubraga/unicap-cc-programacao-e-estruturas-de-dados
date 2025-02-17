#include <stdlib.h>
#include "singlyLinkedList.h"

struct singlyLinkedList{
    SinglyListNode *head;
    int size;
};

SinglyLinkedList * SinglyLinkedList_Create(){
   SinglyLinkedList *list = (SinglyLinkedList *) malloc(sizeof(SinglyLinkedList));
   list->head = NULL;
   list->size = 0;
   return list;
}

void SinglyLinkedList_Destroy(SinglyLinkedList *list){
    if(list == NULL){
        return;
    }
    SinglyListNode *next = list->head;
    while(next != NULL){
        SinglyListNode *current = next;
        next = SinglyListNode_GetNext(next);
        SinglyListNode_Destroy(current);    
    }
    free(list); 
}

bool SinglyLinkedList_IsEmpty(SinglyLinkedList *list){
    return list->size == 0;
}

void SinglyLinkedList_AddFirst(SinglyLinkedList *list, int value){
    SinglyListNode *newHead = SinglyListNode_Create(value, list->head);
    SinglyLinkedList_SetHead(list, newHead);
    list->size++;
}

void SinglyLinkedList_AddLast(SinglyLinkedList *list, int value){
    SinglyListNode *node = SinglyListNode_Create(value, NULL);
    if(SinglyLinkedList_IsEmpty(list)){
        SinglyLinkedList_SetHead(list, node);
        list->size++;
        return;
    }
    SinglyListNode *current = list->head;
    while(SinglyListNode_GetNext(current) != NULL){
        current = SinglyListNode_GetNext(current);
    }
    SinglyListNode_SetNext(current, node);
    list->size++;
}

void SinglyLinkedList_Delete(SinglyLinkedList *list, SinglyListNode *nodeToDelete){
    if(nodeToDelete == list->head){
        SinglyLinkedList_SetHead(list, SinglyListNode_GetNext(nodeToDelete));
        SinglyListNode_Destroy(nodeToDelete);
        list->size--;
        return;
    }
    SinglyListNode *previous = list->head;
    while(SinglyListNode_GetNext(previous) != nodeToDelete){
        previous = SinglyListNode_GetNext(previous);
    }
    SinglyListNode_SetNext(previous, SinglyListNode_GetNext(nodeToDelete));
    SinglyListNode_Destroy(nodeToDelete);
    list->size--;
}

SinglyListNode * SinglyLinkedList_GetHead(SinglyLinkedList *list){
    return list->head;
}

void SinglyLinkedList_SetHead(SinglyLinkedList *list, SinglyListNode *newHead){
    list->head = newHead;
}

int SinglyLinkedList_GetSize(SinglyLinkedList *list){
    return list->size;
}

SinglyListNode *SinglyLinkedList_Search(SinglyLinkedList *list, int value){
    if(SinglyLinkedList_IsEmpty(list)){
        return NULL;
    }
    SinglyListNode *current = list->head;
    while(current != NULL){
        if(SinglyListNode_GetValue(current) == value){
            return current;
        }
        current = SinglyListNode_GetNext(current);
    }
    return current;
}

int * SinglyLinkedList_ToArray(SinglyLinkedList *list){
    int size = list->size;
    int *array = (int *) malloc(sizeof(int) * size);
    SinglyListNode *current = list->head;
    for(int i = 0; i < size; i++){
        *(array + i) = SinglyListNode_GetValue(current);
        current = SinglyListNode_GetNext(current);
    }
    return array; 
}