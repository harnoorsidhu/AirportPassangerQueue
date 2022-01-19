package A3;

/*
 * From Data Structures and Algorithms in Java, Sixth Edition, Goodrich et al.
 */

/**
 * 3111085An interface for a tree where nodes can have an arbitrary number of children.
 */
import java.util.Iterator;

public interface Tree<E> extends Iterable<E>{

  
    
  Position<E> root();

  /**
   * Returns the Position of p's parent (or null if p is root).
   *
   * @param p    A valid Position within the tree
   * @return Position of p's parent (or null if p is root)
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  Position<E> parent(Position<E> p) throws IllegalArgumentException;

  
  
  int numChildren(Position<E> p) throws IllegalArgumentException;

  /**
   * Returns true if Position p has one or more children.
   *
   * @param p    A valid Position within the tree
   * @return true if p has at least one child, false otherwise
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  boolean isInternal(Position<E> p) throws IllegalArgumentException;

  /**
   * Returns true if Position p does not have any children.
   *
   * @param p    A valid Position within the tree
   * @return true if p has zero children, false otherwise
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  boolean isExternal(Position<E> p) throws IllegalArgumentException;

  /**
   * Returns true if Position p represents the root of the tree.
   *
   * @param p    A valid Position within the tree
   * @return true if p is the root of the tree, false otherwise
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  boolean isRoot(Position<E> p) throws IllegalArgumentException;

  /**
   * Returns the number of nodes in the tree.
   * @return number of nodes in the tree
   */
  int size();

  /**
   * Tests whether the tree is empty.
   * @return true if the tree is empty, false otherwise
   */
  boolean isEmpty();
  
  Iterator<E> iterator();
  Iterable<Position<E>> position();
  Iterable<Position<E>> children(Position<E> p);
}
