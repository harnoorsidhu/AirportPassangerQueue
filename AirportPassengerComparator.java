package A3;


/**
 * Write a description of class AirportPassangerComparator here.
 *
 * @author (Harnoor Singh Sidhu)
 * @version (a version number or a date)
 */
import java.util.Comparator;
public class AirportPassengerComparator implements Comparator<AirportPassenger>
{
    public int compare(AirportPassenger Ap1, AirportPassenger Ap2) {
       
        if (Ap1.getPriority() > Ap2.getPriority()) {
            return -1;
        } else {
            
            if (Ap1.getPassengerNumber() > (Ap2.getPassengerNumber())) {
                return 1;
            }
             if (Ap1.getPassengerNumber() < (Ap2.getPassengerNumber())) {
                return -1;
            }
        }
        
          if (Ap1.getPriority() < Ap2.getPriority()) {
            return 1;
        }
        return 0;
    }
}