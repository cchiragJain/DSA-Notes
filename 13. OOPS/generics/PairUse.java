package generics;

public class PairUse {
    public static void main(String[] args) {
        // Pair String type ka banega
        // T ki jagah har jagah String ho jaaega
        Pair<String> ps = new Pair<String>("ab", "bc");
        // Pair<String> ps = new Pair<>("ab", "bc"); not mentioning it also works

        ps.setFirst("cd");
        System.out.println(ps.getFirst());

        // Can't create generic objects of primitive data types
        // Only objects are allowed
        // Pair<int> pi = new Pair<int>(1, 2);

        // BUT can use wrapper classes like Integer,Character etc.
        Pair<Integer> pi = new Pair<>(1, 2);
        Pair<Character> pc = new Pair<>('a', 'b');
        char a = pc.getFirst();
        System.out.println(a);

        PairTwo<Integer, String> pTwo = new PairTwo<>(1, "abc");

        PairTwo<Integer, Integer> internalPair = new PairTwo<>(10, 20);

        // Pair inside Pair
        PairTwo<PairTwo<Integer, Integer>, Integer> p3 = new PairTwo<>(internalPair, 30);

        System.out.println(p3.getSecond()); // 30
        System.out.println(p3.getFirst().getFirst()); // 10
        System.out.println(p3.getFirst().getSecond()); // 20
    }
}
