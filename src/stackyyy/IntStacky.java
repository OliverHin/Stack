package stackyyy;

public class IntStacky {

    private StackyMethods stacky;

    public IntStacky(){

        stacky = new StackyMethods();

    }

    public void push(int data) {
        stacky.insertFirst(data);
    }

    public int size () {
        return stacky.getSize();
    }

    public int pop () {
        if (stacky.getSize() == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        int last = stacky.getSize()-1;

        int reItem = stacky.get(last);
        System.out.println("The deleted item is: " + reItem);
        System.out.println();
        stacky.remove(last);

        return last;

    }

    public int peek () {
        int last = stacky.get(size()-1);
        System.out.println("The last Element is " + last);
        return last;
    }

    public int[] pop (int n) {
        int last = 0;
        for (int i = 0; i < n; i++) {
            last = stacky.getSize()-1;
            pop();
        }
        return new int[]{last};
    }

    public void printStacky() {
        stacky.print();
        System.out.println("Amount of Elements: " + size());
        System.out.println();
    }
}
