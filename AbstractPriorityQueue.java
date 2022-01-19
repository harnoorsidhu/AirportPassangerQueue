package A3;


/**
 * Write a description of class AbstractPriorityQueue here.
 *
 * @author (Harnoor Singh Sidhu)
 * @version (a version number or a date)
 */
import java.util.Comparator;
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V>
{
    protected static class PCEntry<K, V> implements Entry<K, V> {

        private K key;
        private V value;

        public PCEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }
        public String toString(){
            return key.toString();
        }
    }
    private Comparator<K> Compare;

  
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }
  protected AbstractPriorityQueue(Comparator<K> comp) {
        Compare = comp;
    }

    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return Compare.compare(a.getKey(), b.getKey());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (Compare.compare(key, key) == 0);

        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatiblekey");
        }
    }
    public boolean isEmpty(){
        return size() == 0;
    }
}

   