package stackyyy;

public class StackyMethods {


    Node head = null;
    Node tail = null;
    int size;

    public void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        if (tail == null) {
            tail = node;
        }
        head = node;
        size++;
    }

    public void insertLast(int data) {
        Node node = new Node(data);

        if (tail != null) {
            tail.next = node;
            node.prev = tail;
        }
        if (tail == null) {
            head = node;
        }
        tail = node;
        size++;
    }

    public void insertAt(int index, int data) {

        if (index == 0) {
            insertFirst(data);
            return;
        }

        if (index == size) {
            insertLast(data);
            return;
        }

        Node n = head;
        for (int i = 0; i < index - 1; i++) {
            n = n.next;
        }
        Node node = new Node(data, n.next, n);
        n.next.prev = node; // the previous number of the next number
        n.next = node;
        size++;

    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        //System.out.println("The Index you have searched for is: " + current.data);
        return current.data;

    }

    public Node findValue(int data) {
        Node node = head;
        while (node != null) {
            if (node.data == data) {
                System.out.println("The element is: " + node.data);
                return node;
            }
            node = node.next;

        }
        return null;
    }

    public void insertAfterValue(int after, int data) {
        Node p = findValue(after);

        if (p == null) {
            System.out.println("Not existing");
            return;
        }

        Node node = new Node(data);
        node.next = p.next;
        p.next = node;
        node.prev = p;

        if (node.next != null) {
            node.next.prev = node;
        }
        size++;
    }


    /*public String toString() {
        stackyyy.Node node = head;
        stackyyy.Node last = null;
        String str = "";
        while (node != null) {
            str += node.data + "---->";
            node = node.next;
        }
        str += "END";

        return str;
    }*/

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            Node current = head;
            for (int i = 0; i < index && current.next != null; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            System.out.println("The deleted Element is: " + current.data);
        }
        size--;
    }


    /*public String toStringRev() {
        stackyyy.Node node = head;
        stackyyy.Node last = null;
        String strR = "";

        while (node != null) {
            last = node;
            node = node.next;
        }

        while (last != null) {
            strR += last.data + "---->";
            last = last.prev;
        }
        strR += "START";

        return strR;
    }*/

    public String toString() {
        Node current = head;
        String str = "";
        while (current != null) {
            str += current.data + "--->";
            current = current.next;
        }
        str += "END";
        return str;
    }

    public String toRevString() {
        Node current = tail;
        String str = "";
        while (current != null) {
            str += current.data + "--->";
            current = current.prev;
        }
        str += "START";
        return str;
    }

    public int getSize(){
        return size;
    }

    public void deleteLast ()
    {
        if (head == null)
        {
            return;
        }
        else
        {
            if (head != null)
            {
                Node temp = head;

                while (temp.next != null)
                    temp = temp.next;
                temp = temp.prev;
                temp.next = null;

            }
            else
            {
                head = null;
            }
        }
        size--;
    }


    public void print() {
        System.out.println("Normal print");
        System.out.println(toString());
        //System.out.println();
        //System.out.println("Reverse print");
        //System.out.println(toRevString());
        //System.out.println("Amount of Elements: " + getSize());


    }
}

