import java.util.Scanner;

class SLL_Stack {
    private Node top = null;

    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        if (top == null) {
            System.out.println("SLL_Stack is empty");
            return;
        }
        System.out.println("Popped: " + top.info);
        top = top.next;
    }

    public boolean search(int val) {
        Node temp = top;
        while (temp != null) {
            if (temp.info == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void display() {
        Node temp = top;
        if (temp == null) {
            System.out.println("SLL_Stack is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.info + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SLL_Stack SLL_Stack = new SLL_Stack();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Search element");
            System.out.println("4. Display SLL_Stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int val = scanner.nextInt();
                    SLL_Stack.push(val);
                    break;
                case 2:
                    SLL_Stack.pop();
                    break;
                case 3:
                    System.out.print("Enter value to search: ");
                    val = scanner.nextInt();
                    System.out.println("Element found: " + SLL_Stack.search(val));
                    break;
                case 4:
                    SLL_Stack.display();
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
