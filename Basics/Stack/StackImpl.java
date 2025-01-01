package Basics.Stack;

public class StackImpl {
    public static void main(String[] args) {
        Stacker stacker = new Stacker(5);

        //pushing some elements
        stacker.push(10);
        stacker.push(20);
        stacker.push(30);
        stacker.push(40);

        //display stack contents
        stacker.display();

        //peek the top element
        System.out.println("The top element is: " + stacker.peek());

        //pop elements from stack
        System.out.println("popped element is: " + stacker.pop());
        System.out.println("popped element is: " + stacker.pop());
        System.out.println("popped element is: " + stacker.pop());

        //display stack contents
        stacker.display();

        //Check if stack is empty
        System.out.println("Stack is empty: " + stacker.isEmpty());
    }
}
