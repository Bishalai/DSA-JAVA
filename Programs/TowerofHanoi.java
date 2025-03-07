import java.util.Scanner;

public class TowerofHanoi {

    public long steps = 0;
    // move n disks from A to C using B as auxiliary
    public void tower(int n ,char from, char to, char aux){
        if(n==1){
            steps += 1;
            System.out.println("Move disk 1 from peg "+from+" to peg "+to);
            return;
        }
        //move top n-1 disks from A to B using C as auxiliary
        tower(n-1, from, aux, to);
        // move the nth disk from A to C
        steps+=1;
        System.out.println("Move disk "+n+" from peg "+from+ " to peg "+to);
        // move remiaing n-1 disks from B to C using A as auxiliary
        tower(n-1,aux,to,from);
    }

    public static void main(){
        TowerofHanoi toh =  new TowerofHanoi();

        Scanner myObj =  new Scanner(System.in);

        System.out.print("Enter the number of disks:");
        int num = myObj.nextInt();

        toh.tower(num, 'A', 'B', 'C');

        System.out.println("The total number of steps taken is:"+toh.steps);
        myObj.close();
    }


}
