package A3;

/**
 * Write a description of class AbstractBinaryTree here.
 *
 * @author (3111085)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    public Position<E> sibling(Position<E> p) {
        
        Position<E> parent = parent(p);
        
        if (parent == null) {
            
            return null;
        }
        if (p == left(parent)) {
            
            return right(parent);
        } else {
            return left(parent);
        }

    }

    public int numChildren(Position<E> p) {
        int c = 0;
        if (left(p) != null) {
            c++;
        }
        if (right(p) != null) {
            
            c++;
        }
        return c;
    }

    public Iterable<Position<E>> children(Position<E> p) {
        
        List<Position<E>> snapShot = new ArrayList<>(2);
        
        if (left(p) != null) {
            snapShot.add(left(p));
        }
        if (right(p) != null) {
            snapShot.add(right(p));
        }
        return snapShot;
    }
}
