#include <stdbool.h>
#include "singlyListNode.h"

typedef struct singlyLinkedList SinglyLinkedList;

SinglyLinkedList * SinglyLinkedList_Create();
void SinglyLinkedList_Destroy(SinglyLinkedList * list);
bool SinglyLinkedList_IsEmpty(SinglyLinkedList * list);
void SinglyLinkedList_AddFirst(SinglyLinkedList * list, int value);
SinglyListNode * SinglyLinkedList_GetHead(SinglyLinkedList * list);
void SinglyLinkedList_SetHead(SinglyLinkedList * list, SinglyListNode * newHead);
int SinglyLinkedList_GetSize(SinglyLinkedList * list);
SinglyListNode * SinglyLinkedList_Search(SinglyLinkedList * list, int value);
void SinglyLinkedList_AddLast(SinglyLinkedList * list, int value);
int * SinglyLinkedList_ToArray(SinglyLinkedList * list);
void SinglyLinkedList_Delete(SinglyLinkedList * list, SinglyListNode * nodeToDelete);