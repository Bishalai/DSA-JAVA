import java.util.Scanner;

public class GCD {
    public int rgcd(int p, int q){
        if(p%q==0){
            return q;
        }else{
            return rgcd(q, p%q);
        }
    }

    public int igcd(int p, int q){
        int temp =0;
        while(p%q!=0){
            temp = p%q;
            p=q;
            q=temp;
        }
        return q;
    }

    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        int choice, method;
        GCD gcd = new GCD();
        menu:
        while(true){
            System.out.println("Enter 0 to exit:");
            System.out.println("Enter 1 to enter numbers:");
            choice = myObj.nextInt();

            switch (choice) {
                case 0:
                    break menu;
                case 1:
                System.out.print("Enter two number: ");
                    int num1 = myObj.nextInt();
                    int num2 = myObj.nextInt();
                    System.out.println("Enter 0 to use recursion:");
                    System.out.println("Enter 1 to use iteration:");
                    method = myObj.nextInt();
                    switch (method) {
                        case 0:
                            System.out.println("Greatest Common divisor of "+num1+" and "+num2+" is "+ gcd.rgcd(num1, num2));
                            break;
                        case 1:
                            System.err.println("Greatest Common divisor of "+num1+" and "+num2+" is "+ gcd.igcd(num1, num2));
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
