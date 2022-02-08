package generics;

public class PairTwo<T, V> {
    private T first;
    private V second;

    public PairTwo(T first, V second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    public T getFirst() {
        return this.first;
    }

    public V getSecond() {
        return this.second;
    }
}
