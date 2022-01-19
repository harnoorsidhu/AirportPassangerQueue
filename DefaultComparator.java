package A3;


/**
 * Write a description of class DefaultComparator here.
 *
 * @author (Harnoor Singh Sidhu 3111085)
 * @version (a version number or a date)
 */
import java.util.Comparator;
public class DefaultComparator<E> implements Comparator<E>{
    public int compare(E a,E b) throws ClassCastException{
        return((Comparable<E>)a).compareTo(b);
    }
}
