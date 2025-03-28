//Write a program to search an element in a singly linked list.

class SLL_search {
    private Node list = null;

    public void insertAtPosition(int val, int position) {
        Node newNode = new Node(val);
        if (position == 0) {
            newNode.next = list;
            list = newNode;
            return;
        }
        Node temp = list;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteAtPosition(int position) {
        if (list == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 0) {
            list = list.next;
            return;
        }
        Node temp = list;
        for (int i = 0; temp.next != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        temp.next = temp.next.next;
    }

    public boolean search(int val) {
        Node temp = list;
        while (temp != null) {
            if (temp.info == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void display() {
        Node temp = list;
        while (temp != null) {
            System.out.print(temp.info + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SLL_search linkedList = new SLL_search();
        linkedList.insertAtPosition(7, 0);
        linkedList.insertAtPosition(10, 1);
        linkedList.insertAtPosition(16, 1);
        linkedList.insertAtPosition(9, 3);
        linkedList.display();
        linkedList.deleteAtPosition(1);
        linkedList.display();
        System.out.println("Search 10: " + linkedList.search(10));
        System.out.println("Search 16: " + linkedList.search(16));
    }
}
