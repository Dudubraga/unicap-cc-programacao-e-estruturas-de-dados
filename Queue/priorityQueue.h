#include <stdbool.h>

typedef struct priorityQueue PriorityQueue;

PriorityQueue * PriorityQueue_Create();
void PriorityQueue_Destroy(PriorityQueue * queue);
bool PriorityQueue_IsEmpty(PriorityQueue * queue);
void PriorityQueue_Enqueue(PriorityQueue * queue, int value);
int PriorityQueue_Dequeue(PriorityQueue * queue);
