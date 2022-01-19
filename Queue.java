package A3;


/**
 * Write a description of class Queue here.
 *
 * @author (Harnoor SIngh Sidhu 3111085)
 * @version (a version number or a date)
 */

   public interface Queue<E> {

    int size();

    boolean isEmpty();

    void enqueue(E e);

    E first();

    E dequeue();
}
