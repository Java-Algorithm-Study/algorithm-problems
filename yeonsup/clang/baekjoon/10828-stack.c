#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int data;
    struct Node *next;
} Node;

typedef struct {
    int size;
    struct Node *top;
} Stack;

void push(Stack *stack, int data) {
    Node *newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = stack->top;
    stack->top = newNode;
    stack->size++;
}

int pop(Stack *stack) {
    if(stack->top == NULL) {
        printf("%d\n", -1);
        return -1;
    }
    Node *top = stack->top;
    int data = top->data;
    stack->top = top->next;
    printf("%d\n", data);
    stack->size--;
    free(top); 

    return data;
}

void empty(Stack *stack) {
    printf("%d\n", stack->size == 0 ? 1 : 0);
    
}

void top(Stack *stack) {
    if(stack->top == NULL) {
        printf("%d\n", -1);
        return ;
    }
    Node *top = stack->top;
    int data = top->data;
    printf("%d\n", data);
}

int main(void) {
    int n, data;
    char command[100];
    Stack stack;
    // Stack *stack = (Stack*)malloc(sizeof(Stack));
    stack.top = NULL;
    stack.size = 0;
    scanf("%d", &n);
    while(n--) {
        scanf("%s", &command);
        
        if(strcmp(command, "push") == 0) {
            scanf("%d", &data);
            push(&stack, data); 
        } else if (strcmp(command, "pop") == 0) {
            pop(&stack);
        } else if (strcmp(command, "size") == 0) {
            printf("%d\n", stack.size);
        } else if (strcmp(command, "empty") == 0) {
            empty(&stack);
        } else if (strcmp(command, "top") == 0) {
            top(&stack);
        }
    }
    return 0;
}