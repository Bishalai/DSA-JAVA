//Write a program to insert and delete a node after some given node in a singly linked list(SLL). Implemented the code from slides in java

class Node {
    int info;
    Node next;
    
    Node(int val) {
        this.info = val;
        this.next = null;
    }
}

class SLL_node {
    private Node list = null;

    public void insertNode(Node pred, int val) {
        Node ins = new Node(val);
        if (pred == null) {
            ins.next = list;
            list = ins;
        } else {
            ins.next = pred.next;
            pred.next = ins;
        }
    }

    public void deleteNode(Node del) {
        if (del == list) {
            list = del.next;
        } else {
            Node pred = list;
            while (pred.next != del) {
                pred = pred.next;
            }
            pred.next = del.next;
        }
    }

    public void display() {
        Node temp = list;
        while (temp != null) {
            System.out.print(temp.info + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node getList() {
        return list;
    }

    public static void main(String[] args) {
        SLL_node linkedList = new SLL_node();
        linkedList.insertNode(null, 7);
        linkedList.insertNode(linkedList.getList(), 10);
        linkedList.insertNode(linkedList.getList(), 16);
        linkedList.deleteNode(linkedList.getList().next);
        linkedList.display();
    }
}
