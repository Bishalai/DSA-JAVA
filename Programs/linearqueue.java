import java.util.Scanner;

public class linearqueue {
    private final int MAX;
    private int[] intArray;
    private int front;
    private int rear;
    
    public linearqueue(int max){
        MAX =max;
        intArray = new int[MAX];
        front = rear = -1;
    }

    public boolean isempty(){
        return (rear==-1);
    }

    public boolean isfull(){
        return (rear==MAX-1);
    }

    public void enqueue(int data){
        if(isfull()){
            System.out.println("Queue is full");
        }else{
            if(isempty()){
                rear=front=0;
                intArray[0]=data;
            }
            else{
                intArray[++rear]=data;
            }
        }
    }

    public int dequeue(){
        int data;
        if(isempty()){
            System.out.println("Queue is empty");
            return 0;
        }else{
            data = intArray[front++];
            if (front>rear){
                front = rear=-1;
            }
            return data;
        }
    }

    public int peek(){
        if(isempty()){
            System.out.println("queue is empty");
            return 0;
        }
        else{
            return intArray[front];
        }
    }

    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter size of queue");

        int size = myObj.nextInt();
        
        linearqueue queue = new linearqueue(size);
        
        menu:
        while(true){
            System.out.println("-------------------------");
            System.out.println("Enter 0 to exit:");
            System.out.println("Enter 1 to peek:");
            System.out.println("Enter 2 to enqueue:");
            System.out.println("Enter 3 to dequeue:");
            System.out.println("Enter 4 to check if empty:");
            System.out.println("Enter 5 to check if full:");

            int choice = myObj.nextInt();

            //using switch
            switch (choice) {
                case 0:
                    break menu;
                
                case 1:
                    queue.peek();
                    break;
                
                case 2:
                    System.out.println("Enter the number to enqueue:");
                    int num = myObj.nextInt();
                    queue.enqueue(num);
                    break;
                
                case 3:
                    System.out.println("The dequeued number is "+queue.dequeue());
                    break;
                
                case 4:
                    if(queue.isempty()){
                        System.out.println("queue is empty.");
                    }else{
                        System.out.println("queue is not empty.");
                    }
                    break;

                case 5:
                    if(queue.isfull()){
                        System.out.println("queue is full.");
                    }else{
                        System.out.println("queue is not full.");
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
