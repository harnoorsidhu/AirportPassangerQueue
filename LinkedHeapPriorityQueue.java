package A3;


/**
 * Write a description of class LinkedHeapPriorityQueue here.
 *
 * @author (Harnoor Singh Sidhu 3111085)
 * @version (a version number or a date)
 */
import java.util.Comparator;
import java.util.Stack;
public class LinkedHeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>
{
   protected LinkedBinaryTree<Entry<K,V>> heap = new LinkedBinaryTree<>();
   public LinkedHeapPriorityQueue(Comparator<K> compare){
       super(compare);
}
protected void upheap(Position<Entry<K, V>> up){
    while(heap.parent(up) != null){
        
        Position<Entry<K, V>> location =heap.parent(up);
        
        if(compare(up.getElement(), location.getElement()) >=0){
            break;
        }
        
        swap(up,location);
        up=location;
    }
}

protected void downheap(Position<Entry<K, V>> down){
    while(heap.left(down) != null) {
         Position<Entry<K, V>> ChildL= heap.left(down);
         Position<Entry<K, V>> smallChild=ChildL;
      
        
         if (heap.right(down) != null) {
             
                Position<Entry<K, V>> childR= heap.right(down);
                
                if (compare(ChildL.getElement(), childR.getElement()) > 0) {
                    
                    smallChild = childR;
                }
            }
            if (compare(smallChild.getElement(), down.getElement()) >= 0) {
                break;
            }
            
            swap(down, smallChild);
            
            down = smallChild;

        }
    }
      protected void swap(Position<Entry<K, V>> a, Position<Entry<K, V>> b) {
        Entry<K, V> temp = a.getElement();
        heap.set(a, b.getElement());
        heap.set(b, temp);
    }

    public Entry<K, V> min() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.root().getElement();
    }
 public int size() {
        return heap.size();
    }
public Entry<K, V> insert(K kkey, V value) throws IllegalArgumentException {
       
    checkKey(kkey);
        
        Entry<K, V> newer = new PCEntry<>(kkey, value);
        
        Position<Entry<K, V>> Null = null;
        if (heap.isEmpty()) {
           
            
            heap.addRoot(newer);

        } else {
            int i = heap.size() + 1; String binary = Integer.toBinaryString(i);
            
           
            Null = heap.root();
            for (int j = 1; j < binary.length() - 1; j++) {
                
                if (binary.charAt(j) == '0') {
                    Null = heap.left(Null);
                }
                if (binary.charAt(j) == '1') {
                    Null = heap.right(Null);
                }
            }
            
            if (binary.charAt(binary.length() - 1) == '0') {
                Null = heap.addLeft(Null, newer);
            }
           
            if (binary.charAt(binary.length() - 1) == '1') {
                Null = heap.addRight(Null, newer);
            }
            
            upheap(Null);
        }
        return newer;
    }

 public Entry<K, V> removeMin() {
        if (heap.isEmpty()) {
            return null;
            
        }
        Entry<K, V> ans = heap.root().getElement();
        int j = heap.size();
        String Binary = Integer.toBinaryString(j);
        Position<Entry<K, V>> k = heap.root();
        for (int i = 1; i < Binary.length(); i++) {
            if (Binary.charAt(i) == '0') {
                k = heap.left(k);
            }
            if (Binary.charAt(i) == '1') {
                k = heap.right(k);
            }
        }
        
        swap(heap.root(), k);
        
        
        heap.remove(k);
        
        downheap(heap.root());
        
        return ans;
    }
    public String toString() {
        StringBuilder End = new StringBuilder();
        End.append("P.Q: { ");
        for (Position<Entry<K, V>> R : heap.breadthfirst()) {
            End.append(R.getElement() + ", ");
        }
        End.append(" }");
        return End.toString();
    }
}





