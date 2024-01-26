package interviewBit;

import java.util.Stack;

public class RedundantBraces {
    /**
     * Follow the steps mentioned below to implement the approach:
     *
     * We iterate through the given expression and for each character in the expression
     * if the character is an open parenthesis ‘(‘ or any of the operators or operands, we push it to the stack.
     * If the character is close parenthesis ‘)’, then pop characters from the stack till matching open parenthesis ‘(‘ is found.
     * Now for redundancy two conditions will arise while popping.
     * If immediate pop hits an open parenthesis ‘(‘, then we have found a duplicate parenthesis. For example, (((a+b))+c) has duplicate brackets around a+b. When we reach the second “)” after a+b, we have “((” in the stack. Since the top of the stack is an opening bracket, we conclude that there are duplicate brackets.
     * If immediate pop doesn’t hit any operand(‘*’, ‘+’, ‘/’, ‘-‘) then it indicates the presence of unwanted brackets surrounded by expression. For instance, (a)+b contains unwanted () around a thus it is redundant.
     * @param A
     * @return
     */
    public int braces(String A) {
        Stack<Character> st = new Stack<>();
        char[] str = A.toCharArray();
        // Iterate through the given expression
        for (char ch : str) {

            // if current character is close parenthesis ')'
            if (ch == ')') {
                char top = st.pop();

                // If immediate pop have open parenthesis '('
                // duplicate brackets found
                boolean flag = true;

                while (top != '(') {

                    // Check for operators in expression
                    if (top == '+' || top == '-'
                            || top == '*' || top == '/') {
                        flag = false;
                    }

                    // Fetch top element of stack
                    top = st.pop();
                }

                // If operators not found
                if (flag == true) {
                    return 1;
                }
            } else {
                st.push(ch); // push open parenthesis '(',
            }                // operators and operands to stack
        }
        return 0;
    }

    public static void main(String [] args) {
        System.out.println(new RedundantBraces().braces("(a+((b*c)+c))"));
    }
}
