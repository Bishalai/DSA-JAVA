import java.util.Scanner;

public class Stack {
    private int size;
    private int[] arr;
    private int top;

    // COnstructor
    public Stack(int size){
        this.size = size;
        arr = new int[size]; //initialise array
        top = -1;
    }

    public boolean isempty(){
        return (top==-1);
    }

    public boolean isfull(){
        return (top==size-1);
    }

    //peek the top data
    public int peek(){
        if(isempty()){
            System.err.println("stack is empty.");
            return 0;
        }
        else{
            System.err.println("Top element of stack is "+arr[top]);
            return arr[top];
        }
    }

    //push
    public void push(int n){
        if(!isfull()){
            arr[++top] = n;
        }else{
            System.out.println("stack is full");
        }
    }

    public int pop(){
        if(!isempty()){
            return arr[top--];
        }else{
            System.err.println("stack empty");
            return 0;
        }
        
    }
    
    public static void main(String[] args){
        Scanner myObj =  new Scanner(System.in);

        System.out.println("Enter size of stack");

        int size = myObj.nextInt();
        
        Stack stack = new Stack(size);
        
        menu:
        while(true){
            System.out.println("-------------------------");
            System.out.println("Enter 0 to exit:");
            System.out.println("Enter 1 to peek:");
            System.out.println("Enter 2 to push:");
            System.out.println("Enter 3 to pop:");
            System.out.println("Enter 4 to check if empty:");
            System.out.println("Enter 5 to check if full:");

            int choice = myObj.nextInt();

            //using switch
            switch (choice) {
                case 0:
                    break menu;
                
                case 1:
                    stack.peek();
                    break;
                
                case 2:
                    System.out.println("Enter the number to push into stack:");
                    int num = myObj.nextInt();
                    stack.push(num);
                    break;
                
                case 3:
                    System.out.println("The popped number is "+stack.pop());
                    break;
                
                case 4:
                    if(stack.isempty()){
                        System.out.println("Stack is empty.");
                    }else{
                        System.out.println("Stack is not empty.");
                    }
                    break;

                case 5:
                    if(stack.isfull()){
                        System.out.println("Stack is full.");
                    }else{
                        System.out.println("Stack is not full.");
                    }
                    break;
                default:
                System.out.println("Enter valid number!!!");
                    break;
            }
            
        }
        System.out.println("End of program.");
        myObj.close();
    }
}
