import java.util.Stack;
import java.util.Scanner;

public class infixtopostfix {
    
    //precedence function
    public int prec(char c){
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1; 
    }


    public void intopost(String s){
        Stack<Character> st = new Stack<>();
        String result="";

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // if c is operand, add it to output string

            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')){
                result=result+c;
            }

            // if character is bracket, '(' then push it into the stack
            else if (c == '(')
                st.push('(');

            // if character is an ‘)’, 
            //pop and add to the output string from the stack
            // until an ‘(‘ is encountered.
            else if (c == ')') {
                while (st.peek() != '(') {
                    result=result+st.pop();
                }
                st.pop(); 
            }
            // if operator is scanned
            //if operator is stack has higher or same precedence as
            //operator, the operator from stack is popped and c is pushed
            else {
                while (!st.isEmpty() && (prec(c) < prec(st.peek()) ||
                                         prec(c) == prec(st.peek()))) {
                    result=result+st.pop();
                }
                st.push(c);
            }

        }
        // Pop all the remaining elements from the stack
        while (!st.isEmpty()) {
            result=result+st.pop();
        }

        System.out.println(result);
    }


    public static void main(String[] args){
        infixtopostfix ItoP = new infixtopostfix();

        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter the expression:");
        String exp=myObj.nextLine();

        ItoP.intopost(exp);

        myObj.close();
    }
}
