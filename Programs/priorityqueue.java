import java.util.Scanner;

public class priorityqueue {
    private final int MAX;
    private int[] intArray;
    private int itemCount;

    public priorityqueue(int size){
        MAX = size;
        intArray = new int[MAX];     
        itemCount = 0;
    }

    public void enqueue(int data){
        int i =0;

        if(!isfull()){
            // if queue is empty, insert the data 
            if(itemCount == 0){
                intArray[itemCount++] = data;        
            }else{
                // start from the right end of the queue
                compare: 
                for(i = itemCount - 1; i >= 0; i-- ){
                // if data is larger, shift existing item to right end 
                    if(data > intArray[i]){
                        intArray[i+1] = intArray[i];
                    }else{
                        // break out if the element to left is not smaller... 
                        //since queu gets sorted each entry no need for more comparisons
                        break compare;
                    }            
                }   
                // insert the data 
                intArray[i+1] = data;
                itemCount++;
            }
        }
    }

    public int dequeue(){
        if(!isempty()){
            return intArray[--itemCount];
        }else{
            System.err.println("queue is empty");
            return 0;
        }
    }

    public int peek(){
        return intArray[itemCount - 1];
    }

    public boolean isempty(){
        return itemCount == 0;
    }

    public boolean isfull(){
        return itemCount == MAX;
    }

    public int size(){
        return itemCount;
    }

    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter size of queue");

        int size = myObj.nextInt();
        
        priorityqueue queue = new priorityqueue(size);
        
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

