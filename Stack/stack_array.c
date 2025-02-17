#include <stdlib.h>
#include "stack.h"

typedef struct stack{
    int top;
    int * values;
} Stack;

Stack * Stack_Create(){
    Stack * stack = (Stack *) malloc(sizeof(Stack));
    stack->values = (int *) malloc(100 * sizeof(int));
    stack->top = 0;
    return stack;
}

void Stack_Destroy(Stack * s){
    free(s->values);
    free(s);
}

bool Stack_IsEmpty(Stack * s){
    return s->top == 0;
}

void Stack_Push(Stack * s, int value){
    *(s->values + s->top) = value;
    s->top++;
}

int Stack_Pop(Stack * s){
    int value = *(s->values + s->top-1);
    s->top--;
    return value;
}

int Stack_Peek(Stack * s){
    int value = *(s->values + s->top-1);
    return value;
}