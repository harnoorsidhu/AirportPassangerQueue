package A3;


/**
 * Write a description of class LinkedBinaryTree here.
 *
 * @author (your name)3111085
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E>  implements BinaryTree<E>
{
    protected static class Node<E> implements Position<E>{
        
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        
        public Node( E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
            
            element=e;
            parent=above;
            left=leftChild;
            right=rightChild;
            
        }
        public E getElement(){ 
            return element;
        }
        public Node<E> getParent(){
            return parent;
        }
        public Node<E> getLeft(){ 
            return left;
        }
        public Node<E> getRight(){
            return right;
        }
        public void setElement(E e){ 
            element=e;
        }
        public void setParent(Node<E> parentNode){
            parent=parentNode;
        }
        public void setLeft(Node<E> leftchild){ 
            left= leftchild;
            
        }
        public void setRight(Node<E> rightchild){ 
            
            right=rightchild;
        }
        
       
    }
    private class PositionIterator implements Iterator<Position<E>>{
           private Position<E> recent = null;
           
        private Position<E> cursor = root();
        
        public boolean hasNext(){
            
            return (cursor != null);
        }
            public Position<E> next() {
                
                if(cursor==null) 
                System.out.println("empty");
                
                recent=cursor;
                
                cursor=sibling(cursor);
                
                return recent;
            }
            public void remove() throws IllegalStateException{
                
                if(recent==null)
                
                throw new IllegalStateException("nothig to remove");
                
                
                LinkedBinaryTree.this.remove(recent);
                recent=null;
            }
        }
        private class PositionIterable implements Iterable<Position<E>>{
            
            public Iterator<Position<E>> iterator(){
                
                return new PositionIterator();
            }
            }
            public Iterable<Position<E>> position(){
                return new PositionIterable();
            }
    private class ElementIterator implements Iterator<E>{
        Iterator<Position<E>> posIterator= new PositionIterator();
        
        public boolean hasNext(){
            return posIterator.hasNext()
            ;
        }
            public E next() {
                return posIterator.next().getElement();
            }
            public void remove()
            {
                posIterator.remove();
            }
            }
            public Iterator<E> iterator(){
                return new ElementIterator();
            }
    public Position<E> left(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return node.getLeft();
    }
    public Position<E> right(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return node.getRight();
    }
    public Position<E> parent(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return node.getParent();
    }
    public Position<E> sibling(Position<E> p){
        Position<E> parent = parent(p);
        
        if(parent==null) return null;
        if(p==left(parent)) return (parent);
        else 
        return left(parent);
    }
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Node))
        throw new IllegalArgumentException("Not valid position type");
        
        Node<E> node =(Node<E>) p;
        
        if(node.getParent()==node)
        throw new IllegalArgumentException("p is no longer in the tree");
        
        return node;
    }
         protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right)
         {
        return new Node<E>(e, parent, left, right);
    }

    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {
    }

   

    public int size() {
        return size;
    }

    public Position<E> root() {
        return root;
    }


   
    

    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree is not empty");
        }
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e)
            throws IllegalArgumentException {
                
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) {
            
            throw new IllegalArgumentException("p already has a left child");
        }
        Node<E> child = createNode(e, parent, null, null);
        
        parent.setLeft(child);
        size++;
        return child;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) {
            
            throw new IllegalArgumentException("p already has a right child");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

      public E set(Position<E> p, E e) 
      throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2) {
            throw new IllegalArgumentException("p has two children");
        }
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null) {
            child.setParent(node.getParent());
        }
        if (node == root) {
            root = child;
        } else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return temp;
    }
    
      public String toString() 
      { String snapshot = ""; 
          
          if (!isEmpty()) {
      snapshot+= root().getElement(); 
      
      snapshot = helpToString(root(), snapshot,0);
    } 
    return snapshot; 
}
     
      private String helpToString(Position<E> p, String snapshot, int indent) 
      {
      Node<E> n = validate(p);
      Node<E> l = n.getLeft();
      
      if(l != null){
      snapshot+="\n";
      for(int i=0; i<=indent;i++){ 
          snapshot+="\t";
        } 
        snapshot+= l.getElement();
        
        snapshot = helpToString(l,snapshot,indent+1); 
    }
      Node<E> r = n.getRight();
      
      if(r != null){ snapshot+="\n"; 
          for(int i=0; i<=indent;i++)
          { 
              snapshot+="\t"; 
            } snapshot += r.getElement();
            snapshot = helpToString(r,snapshot,indent+1); 
        } 
        return snapshot;
    }
     
   
}

       
        
    
    
   

