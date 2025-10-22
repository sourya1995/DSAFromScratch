package DepthFIrstSearch;

public class Recursion {
    public class FactorialStack {
        public static int factorialStack(int n) {
            // Create a stack to store intermediate values
            java.util.Stack<Integer> stack = new java.util.Stack<>();

            // Push each call to the stack
            while (n > 0) {
                stack.push(n);
                n--;
            }

            int res = 1;

            // Pop and multiply until stack is empty
            while (!stack.isEmpty()) {
                res *= stack.pop();
            }

            return res;
        }

        public static void main(String[] args) {
            int n = 5;
            System.out.println("Factorial of " + n + " is: " + factorialStack(n));
        }
    }

}
