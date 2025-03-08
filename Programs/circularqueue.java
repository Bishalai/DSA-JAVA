import java.util.Scanner;

public class Circularqueue {
    private int[] queue;
    private final int MAX;
    private int front;
    private int rear;

    public Circularqueue(int max){
        queue = new int[max];
        MAX = max;
        front=rear=-1;
    }

    public boolean isempty(){
        return(rear==-1);
    }

    public boolean isfull(){
        return ((rear+1)%MAX == front);
    }

    public void enqueue(int data){
        if (isfull()){
            System.out.println("queue is full");
        }else{
            if(isempty()){
                rear=front=0;
                queue[0]=data;
            }else{
                rear=(rear+1)%MAX;
                queue[rear]=data;
            }
        }
    }

    public int dequeue(){
        int data;
        if(isempty()){
            System.out.println("queue is empty");
            return 0;
        }else{
            data=queue[front];
            if(front==rear){
                front=rear=-1;
            }else{
                front=(front+1)%MAX;
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
            return queue[front];
        }
    }

    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter size of queue");

        int size = myObj.nextInt();
        
        Circularqueue queue = new Circularqueue(size);
        
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
