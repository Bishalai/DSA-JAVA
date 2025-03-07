import java.util.Stack;
import java.util.Scanner;

public class Postfixeval{
    private Stack<Integer> stack = new Stack<>();
    private String input;

    public Postfixeval(String postfixExpression){
        input = postfixExpression;
     }
     


    public int evalute(){
        char ch;
        int firstOperand;
        int secondOperand;
        int tempResult;
        
        // loop for each character in input
        for(int i=0;i<input.length();i++){
            ch = input.charAt(i);
            // if char is number, then change the char into number and push it onto stack
            if(ch >= '0' && ch <= '9'){
               stack.push(Character.getNumericValue(ch));
            }else{
                // we will have two operands if it is in postfic; 
               firstOperand = stack.pop();
               secondOperand = stack.pop();

               // do the operation on top two operands of stack and then 
               switch(ch){
                    case '+':
                        tempResult = firstOperand + secondOperand;
                        break;
                    case '-':
                        tempResult = firstOperand - secondOperand;
                        break;
                    case '*':
                        tempResult = firstOperand * secondOperand;
                        break;
                    case '/':
                        tempResult = firstOperand / secondOperand;
                        break;
                    case '^':
                        tempResult = firstOperand ^ secondOperand;
                    default:
                        tempResult = 0;
               }
               stack.push(tempResult);
            }
         }
         // the top ovalue is our result so we return it
         return stack.pop();

    }

    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter the expression:");
        String exp=myObj.nextLine();
        
        Postfixeval parser = new Postfixeval(exp);

        System.out.println("The result is "+parser.evalute());


        myObj.close();
    }
}