package A3;


/**
 * Write a description of class AbstractTree here.
 *
 * @author (3111085)
 * @version (a version number or a date)
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public abstract class AbstractTree<E> implements Tree<E> {

   

     private class ElementIterator implements Iterator<E> {

        Iterator<Position<E>> posIterator = position().iterator();

        public boolean hasNext() {
            return posIterator.hasNext();
        }

        public E next() {
            return posIterator.next().getElement();
        }

        public void remove() {
            posIterator.remove();
        }
    }
    
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        
        if (!isEmpty()) {
            
            Queue<Position<E>> fringe = new ArrayQueue<>();
            
            fringe.enqueue(root());
            
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue();
                
                snapshot.add(p);
                
                
                for (Position<E> c : children(p)) {
                    
                    fringe.enqueue(c);
                }
            }
        }
        return snapshot;
    }

   

   
}