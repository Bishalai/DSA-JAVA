import java.util.Scanner;

class dll_node {
    int info;
    dll_node next, prev;
    
    dll_node(int val) {
        this.info = val;
        this.next = null;
        this.prev = null;
    }
}

class DLL {
    private dll_node head = null;

    public void insertAtPosition(int val, int position) {
        dll_node newdll_node = new dll_node(val);
        if (position == 0) {
            newdll_node.next = head;
            if (head != null) {
                head.prev = newdll_node;
            }
            head = newdll_node;
            return;
        }
        dll_node temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newdll_node.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newdll_node;
        }
        temp.next = newdll_node;
        newdll_node.prev = temp;
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }
        dll_node temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        temp.next = temp.next.next;
        if (temp.next != null) {
            temp.next.prev = temp;
        }
    }

    public boolean search(int val) {
        dll_node temp = head;
        while (temp != null) {
            if (temp.info == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void display() {
        dll_node temp = head;
        while (temp != null) {
            System.out.print(temp.info + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DLL dll = new DLL();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at position");
            System.out.println("2. Delete at position");
            System.out.println("3. Search element");
            System.out.println("4. Display list");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int val = scanner.nextInt();
                    System.out.print("Enter position: ");
                    int pos = scanner.nextInt();
                    dll.insertAtPosition(val, pos);
                    break;
                case 2:
                    System.out.print("Enter position: ");
                    pos = scanner.nextInt();
                    dll.deleteAtPosition(pos);
                    break;
                case 3:
                    System.out.print("Enter value to search: ");
                    val = scanner.nextInt();
                    System.out.println("Element found: " + dll.search(val));
                    break;
                case 4:
                    dll.display();
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
