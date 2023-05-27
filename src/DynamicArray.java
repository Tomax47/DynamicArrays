import java.util.Arrays;

public class DynamicArray<T> {
    private static final int MAX_CAPACITY = 10000;
    private Object[] elements;
    private int size;

    public DynamicArray() {
        elements = new Object[MAX_CAPACITY];
        size = 0;
    }

    public void add(T element) {
        if (size >= MAX_CAPACITY) {
            System.out.println("Array capacity exceeded!");
            return;
        }
        elements[size] = element;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return null;
        }
        return (T) elements[index];
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }
        elements[index] = element;
    }

    public T getMax() {
        if (size == 0) {
            System.out.println("Array is empty!");
            return null;
        }
        T max = (T) elements[0];
        for (int i = 1; i < size; i++) {
            T element = (T) elements[i];
            if (element instanceof Comparable && ((Comparable<T>) element).compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public T getSecondMax() {
        if (size < 2) {
            System.out.println("Array contains less than 2 elements!");
            return null;
        }
        T max = (T) elements[0];
        T secondMax = (T) elements[1];
        if (max instanceof Comparable && secondMax instanceof Comparable) {
            if (((Comparable<T>) secondMax).compareTo(max) > 0) {
                T temp = max;
                max = secondMax;
                secondMax = temp;
            }
            for (int i = 2; i < size; i++) {
                T element = (T) elements[i];
                if (element instanceof Comparable) {
                    if (((Comparable<T>) element).compareTo(max) > 0) {
                        secondMax = max;
                        max = element;
                    } else if (((Comparable<T>) element).compareTo(secondMax) > 0) {
                        secondMax = element;
                    }
                }
            }
        }
        return secondMax;
    }

    public boolean isOverflow() {
        return size >= MAX_CAPACITY;
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }

    public int getSize() {
        return size;
    }
}
