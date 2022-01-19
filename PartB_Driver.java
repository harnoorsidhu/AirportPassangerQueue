package A3;


/**
 * Write a description of class PartB_Driver here.
 *
 * @author (Harnoor Singh Sidhu 3111085)
 * @version (a version number or a date)
 */
public class PartB_Driver {

    public static void main(String[] args) {
        LinkedHeapPriorityQueue<AirportPassenger, AirportPassenger> heap = new LinkedHeapPriorityQueue<>(new AirportPassengerComparator());
        AirportPassenger p = new AirportPassenger(134, "Harry Potter Jatt", 1);
        heap.insert(p, p);
        p = new AirportPassenger(115, "JattSoorma", 2);
        heap.insert(p, p);
        p = new AirportPassenger(266, "Voldemort Jatt", 1);
        heap.insert(p, p);
        p = new AirportPassenger(664, "Ron Jatt", 3);
        heap.insert(p, p);
        p = new AirportPassenger(515, "Dumbeldore Jatt", 2 );
        heap.insert(p, p);
        p = new AirportPassenger(224, "Jattu Engineer", 1);
        heap.insert(p, p);
        System.out.println(heap);
        System.out.println("Next up is: " + heap.removeMin());
        System.out.println(heap);
        System.out.println("Next up is: " + heap.removeMin());
        System.out.println(heap);
        System.out.println("Next up is: " + heap.removeMin());
        System.out.println(heap);
    }
}