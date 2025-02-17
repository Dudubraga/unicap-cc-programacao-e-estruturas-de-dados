#include <stdlib.h>
#include "priorityQueue.h"

typedef struct priorityQueue{
    int head;
    int tail;
    int size;
    int * values;
} PriorityQueue;

PriorityQueue * PriorityQueue_Create(){
    PriorityQueue *priorityQueue = (PriorityQueue *) malloc(sizeof(PriorityQueue));
    priorityQueue->values = (int *) malloc(10 * sizeof(int));
    priorityQueue->head = 0;
    priorityQueue->tail = 0;
    priorityQueue->size = 0;
    return priorityQueue;
}

void PriorityQueue_Destroy(PriorityQueue * priorityQueue){
    free(priorityQueue->values);
    free(priorityQueue);
}

bool PriorityQueue_IsEmpty(PriorityQueue * priorityQueue){
    return (priorityQueue->size == 0);
}

int Find_IndexLocation(PriorityQueue * priorityQueue, int value){
    int i = 0;
    for(i = 0; i < priorityQueue->size; i++){
        if(value < *(priorityQueue->values + i)){
            return i;
        }
    }
    return i;
}

void Open_Space(PriorityQueue * priorityQueue, int index){
    int * new_values = (int *) malloc(10 * sizeof(int));
    int j = 0;
    for(int i = 0; i <= priorityQueue->size; i++){
        if(j == index){
            i++;
        }
        *(new_values + i) = *(priorityQueue->values + j);
        j++;
    }
    free(priorityQueue->values);
    priorityQueue->values = new_values;
}

void PriorityQueue_Enqueue(PriorityQueue * priorityQueue, int value){
    int index = Find_IndexLocation(priorityQueue, value);
    Open_Space(priorityQueue, index);
    *(priorityQueue->values + index) = value;
    priorityQueue->tail = (priorityQueue->tail + 1) % 10;
    priorityQueue->size++;
}

int PriorityQueue_Dequeue(PriorityQueue * priorityQueue){
    int value = *(priorityQueue->values + priorityQueue->head);
    priorityQueue->head = (priorityQueue->head + 1) % 10;
    priorityQueue->size--;
    return value;
}

bool PriorityQueue_IsFull(PriorityQueue * priorityQueue){
    return (!PriorityQueue_IsEmpty(priorityQueue) && priorityQueue->head == priorityQueue->tail);
}