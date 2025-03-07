import java.util.Scanner;

public class factorial {

    public long rfact(int num){
        if(num==0){
            return 1;
        }else{
            return num*rfact(num-1);
        }
    }

    public long ifact(int num){
        long res=1;
        for(int i= num; i>0;i--){
            res *= i;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        int choice, method;
        factorial fact = new factorial();
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
                            System.out.println(num+"!= "+fact.rfact(num));
                            break;
                        case 1:
                            System.err.println(num+"!= "+fact.ifact(num));
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

