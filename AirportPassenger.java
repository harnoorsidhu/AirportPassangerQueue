package A3;


/**
 * Write a description of class AirportPassenger here.
 *
 * @author (3111085)
 * @version (a version number or a date)
 */
public class AirportPassenger
{
    private String name;
    private int priority;
    private int PassengerNumber;
    

    public AirportPassenger(int PNumber, String name, int priority) {
        PassengerNumber = PNumber;
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPassengerNumber() {
        return PassengerNumber;
    }

    public int getPriority() {
        return priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassengerNumber(int i) {
        PassengerNumber = i;
    }

    public void setPriority(int i) {
        priority = i;
    }

    public String toString() {
        return PassengerNumber +" "+ name;
    }
}
