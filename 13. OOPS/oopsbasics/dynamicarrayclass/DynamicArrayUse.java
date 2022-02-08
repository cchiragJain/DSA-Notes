package oopsbasics.dynamicarrayclass;

public class DynamicArrayUse {
    public static void main(String[] args) {
        DynamicArray dArray = new DynamicArray();
        System.out.println(dArray.isEmpty());

        dArray.add(10);
        dArray.add(20);
        dArray.add(30);
        dArray.add(40);
        dArray.add(50);
        dArray.add(60);

        dArray.print();

        System.out.println(dArray.get(3));
        System.out.println(dArray.getSize());
        System.out.println(dArray.isEmpty());

        dArray.set(1, 12131);
        dArray.print();

        dArray.removeLast();
        dArray.print();
    }
}
