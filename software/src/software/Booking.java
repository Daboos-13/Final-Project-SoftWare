
package software;
/**
 * This class is used to book stadiums and shows who made the reservation and what time the stadium was booked.
 * @author كريم
 */
public class Booking
{
    public String time ;
    public String who_booked ;
    public boolean booked = false;
    /**
     * Used to set the time the PlayGround booked .
     * @param time and its data type is String .
     */
    public void setTime(String time) {
        this.time = time;
    }
    /**
     * Used to set the booked if is there or not .
     * @param booked and its data type is Boolean .
     */

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
    /**
     * Used to set the who is booked PlayGround .
     * @param who_booked and its data type is Boolean .
     */
    public void setWho_booked(String who_booked)
    {
        this.who_booked = who_booked;
    }
}