package Basics.Stack;

class Stacker {
  int[] stack;
  int top;
  int capacity;

    //constructor
    public Stacker(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    //push
    void push(int data){
        if(top == capacity - 1){
            System.out.println("Stack Overflow");
            return;
        }

        stack[++top] = data;
        System.out.println(data + " pushed to stack");
    }

    //pop
    int pop(){
        if(isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }
        return stack[top--];
    }

    //peek
    int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }

        return stack[top];
    }

    //isEmpty()
    boolean isEmpty(){
        return top == -1;
    }

    //display stack contents
    void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }

        for (int i = top; i >= 0 ; i--) {
            System.out.print(stack[i] + " ");

        }
        System.out.println();
    }


}
