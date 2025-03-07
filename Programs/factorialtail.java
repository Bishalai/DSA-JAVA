import java.util.Scanner;

public class factorialtail {

    public long fact(int num, long res){
        if(num==0){
            return res;
        }else{
            return fact(num-1, res*num);
        }
    }
    
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        factorialtail factt = new factorialtail();

        System.out.println("Enter number:");
        int num = myObj.nextInt();

        System.out.println(num+"!= "+ factt.fact(num, 1));

        myObj.close();

    }
}
