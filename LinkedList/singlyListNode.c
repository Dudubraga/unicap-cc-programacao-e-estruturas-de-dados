#include <stdlib.h>
#include "singlyListNode.h"

struct singlyListNode{
    int value;
    SinglyListNode *next;
};

SinglyListNode * SinglyListNode_Create(int value, SinglyListNode *next){
    SinglyListNode *node = (SinglyListNode *) malloc(sizeof(SinglyListNode));
    node->value = value;
    node->next = next;
    return node;
}

void SinglyListNode_Destroy(SinglyListNode *node){
    free(node);
}

SinglyListNode * SinglyListNode_GetNext(SinglyListNode *node){
    return node->next;
}

void SinglyListNode_SetNext(SinglyListNode *node, SinglyListNode *next){
    node->next = next;
}

int SinglyListNode_GetValue(SinglyListNode *node){
    return node->value;
}

void SinglyListNode_SetValue(SinglyListNode *node, int value){
    node->value = value;
}