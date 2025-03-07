import java.util.Scanner;
public class Balanced_brackets {
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter the expression");
        String exp=myObj.nextLine();
        char[] charexp = exp.toCharArray();

        Stack bracket = new Stack(exp.length());
        // we have int stack so we can code brackets as int
        //[=1, ]=2, {=3. }=4, (=5, )=6

        for(char i:charexp){
            switch(i){
                case '[':
                    bracket.push(1);
                    break;
                case '{':
                    bracket.push(3);
                    break;
                case '(':
                    bracket.push(5);
                    break;
                case ']':
                    if(bracket.peek()==1){
                        // matching brackets so pop
                        bracket.pop();
                    }
                    break;
                case '}':
                    if(bracket.peek()==3){
                        // matching brackets so pop
                        bracket.pop();
                    }
                    break;
                case ')':
                    if(bracket.peek()==5){
                        // matching brackets so pop
                        bracket.pop();
                    }
                    break;
                default:
                    break;

            }
        }

        if (bracket.isempty()){
            System.out.println("The brackets are balanced.");
        }else{
            System.out.println("Th brackets are not balanced.");
        }

        myObj.close();
    }
}
