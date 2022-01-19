package A3;


/**
 * Write a description of class PriorityQueue here.
 *
 * @author (3111085)
 * @version (a version number or a date)
 */
public interface PriorityQueue<K,V> {
  Entry<K,V> removeMin();
  boolean isEmpty();
  int size();
  Entry<K,V> insert(K key, V value) throws IllegalArgumentException;
  Entry<K,V> min();
  
}