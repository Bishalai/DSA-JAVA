import java.util.Scanner;

public class fibonacci {
    
    public int rfib(int num){
        if(num==1){
            return 0;
        }else if(num==2){
            return 1;
        }
        else{
            return rfib(num-1)+rfib(num-2);
        }
    }

    public int ifib(int num){
        if(num==1){return 0;}
        if(num==2){return 1;}
        int n1=0;
        int n2=1;
        int temp;
        // assum it starts with 1, so 1st=0, 2nd =1, 3rd =1, 4th =2
        for(int i= 3; i<=num;i++){

            // n1, n2, temp=n1+n2, n1= n2, n2=temp
            temp=n1+n2;
            n1=n2;
            n2=temp;
        }
        return n2;
    }

    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        int choice, method;
        fibonacci fib = new fibonacci();
        menu:
        while(true){
            System.out.println("Enter 0 to exit:");
            System.out.println("Enter 1 to enter number:");
            choice = myObj.nextInt();

            switch (choice) {
                case 0:
                    break menu;
                case 1:
                System.out.print("Enter number: ");
                    int num = myObj.nextInt();
                    System.out.println("Enter 0 to use recursion:");
                    System.out.println("Enter 1 to use iteration:");
                    method = myObj.nextInt();
                    switch (method) {
                        case 0:
                            System.out.println("The fibonacci number in "+num+" position is "+fib.ifib(num));
                            break;
                        case 1:
                            System.err.println("The fibonacci number in "+num+" position is "+fib.rfib(num));
                            break;
                        default:
                            System.out.println("Enter valid method");
                            break;
                    }
                    break;
                default:
                    System.out.println("Enter Valid number!");
                    break;
            }
        }

        myObj.close();
    }
}
