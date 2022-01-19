package A3;


/**
 * Write a description ox class ArrayQueue here.
 *
 * @author (3111085)
 * @version (a version number or a date)
 */
public class ArrayQueue<E> implements Queue<E> {

    private static final int CAPACITY = 1000;
    private E[] Data;
    private int x = 0;
    private int sizee= 0;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int capacity) {
        Data = (E[]) new Object[capacity];
    }

    public int size() {
        return sizee;
    }

    public boolean isEmpty() {
        return sizee == 0;
    }

    public void enqueue(E e) throws IllegalStateException {
        if (sizee == Data.length) {
            throw new IllegalStateException("Queue is xull");
        }
        int avail = (x + sizee) % Data.length;
        Data[avail] = e;
        sizee++;
    }

    public E first() {
        if(isEmpty()) {
            return null;
        }
        return Data[x];
    }

    public E dequeue() {
        if(isEmpty()) {
            return null;
        }
        E answer = Data[x];
        Data[x] = null;
        x = (x + 1) % Data.length;
        sizee--;
        return answer;
    }
}
