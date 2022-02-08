package oopsbasics.dynamicarrayclass;

public class DynamicArray {
    private int[] data;
    private int nextElementIndex;

    public DynamicArray() {
        this.data = new int[5];
        this.nextElementIndex = 0;
    }

    public void add(int num) {
        if (this.nextElementIndex == this.data.length) {
            doubleCapacity();
        }
        this.data[this.nextElementIndex] = num;
        this.nextElementIndex++;
    }

    public void set(int i, int num) {
        if (i >= nextElementIndex) {
            return;
        }
        this.data[i] = num;
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }

        this.data[this.nextElementIndex--] = 0;
    }

    private void doubleCapacity() {
        int[] temp = this.data;
        this.data = new int[2 * this.data.length];
        for (int i = 0; i < temp.length; i++) {
            this.data[i] = temp[i];
        }
    }

    public int get(int i) {
        if (i >= nextElementIndex) {
            // should throw an error
            return -1;
        }
        return data[i];
    }

    public int getSize() {
        return nextElementIndex;
    }

    public boolean isEmpty() {
        return nextElementIndex == 0;
    }

    public void print() {
        for (int i = 0; i < nextElementIndex; i++) {
            System.out.println(this.data[i]);
        }
    }
}
