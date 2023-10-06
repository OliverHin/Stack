package stackyyy;

public class StackyRunner {

    public static void main(String[] args) {

        IntStacky stacky = new IntStacky();

        stacky.push(11);
        stacky.push(1);
        stacky.push(3);
        stacky.push(5);
        stacky.push(7);
        stacky.push(2);
        stacky.push(9);
        stacky.push(4);

        stacky.printStacky();

        stacky.pop();


        stacky.printStacky();

        stacky.pop(3);

        stacky.printStacky();
        stacky.peek();




    }
}
