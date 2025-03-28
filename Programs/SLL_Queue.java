import java.util.Scanner;

class SLL_Queue {
    private Node front = null, rear = null;

    public void enqueue(int val) {
        Node newNode = new Node(val);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Dequeued: " + front.info);
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    public boolean search(int val) {
        Node temp = front;
        while (temp != null) {
            if (temp.info == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void display() {
        Node temp = front;
        if (temp == null) {
            System.out.println("Queue is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.info + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SLL_Queue queue = new SLL_Queue();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Search element");
            System.out.println("4. Display queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int val = scanner.nextInt();
                    queue.enqueue(val);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.print("Enter value to search: ");
                    val = scanner.nextInt();
                    System.out.println("Element found: " + queue.search(val));
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
