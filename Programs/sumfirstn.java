import java.util.Scanner;

public class SumFirstn {
    public int rsum(int num){
        if(num==0){
            return 0;
        }else{
            return num+rsum(num-1);
        }
    }

    public int isum(int num){
        int res=0;
        for(int i= num; i>=0;i--){
            res += i;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        int choice, method;
        SumFirstn sum = new SumFirstn();
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
                            System.out.println("The sum of first " + num+" numbers is "+sum.rsum(num));
                            break;
                        case 1:
                            System.err.println("The sum of first " + num+" numbers is "+sum.isum(num));
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
