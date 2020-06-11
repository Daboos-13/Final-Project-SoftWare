
package software;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class is used to add stadiums and know the times, prices, places and everything related to them . 
 * @author كريم
 */

public class PlayGround {

    Scanner in=new Scanner(System.in);

    public String name;
    public int id;
    String location;
    public float priceInHour;
    private String playGroundOwnerName;
    public String position;
    public  boolean Approvetion = false;
    public  boolean active = false ;
    public  ArrayList<Booking> bookings = new ArrayList<Booking>();
    
    /**
     * Used to get identity for PlayGround .
     * @return the id for PlayGround and its data type is int .
     */
    public int getId() {
        return id;
    }
    /**
     * Used to set an identity for PlayGround .
     * @param id and its data type is int .
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Used to get the price of the PlayGround for an hour .
     * @return the price for the PlayGround for an hour and its data type is float .
     */
    public float getPriceInHour() {
        return priceInHour;
    }
    /**
     * Used to set the price of the PlayGround for one hour .
     * @param priceInHour and its data type is float .
     */
    public void setPriceInHour(float priceInHour) {
        this.priceInHour = priceInHour;
    }
    /**
     * Used to get the name of the PlayGround .
     * @return the name for PlayGround and its data type is string .
     */
    public String getName() {
        return name;
    }
    /**
     * Used to set the name of the PlayGround .

     * @param name  and its data type is string .
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Used to get the location of the PlayGround .
     * @return the location for PlayGround and its data type is string .
     */
    public String getLocation() {
        return location;
    }
    /**
     * Used to set the location of the PlayGround .
     * @param loction and its data type is string .
     */
    public void setLocation(String loction) {
        this.location = loction;
    }
    /**
     * Used to get the PlayGround Owner Name .
     * @return the PlayGround Owner Name for PlayGround and its data type is string .
     */
    public String getPlayGroundOwnerName() {
        return playGroundOwnerName;
    }
    /**
     * Used to set the PlayGround Owner Name .
     * @param playGroundOwnerName and its data type is string .     
     */
    public void setPlayGroundOwnerName(String playGroundOwnerName) {
        this.playGroundOwnerName = playGroundOwnerName;
    }
    /**
     *  Used to get the PlayGround position .
     * @return the position for PlayGround and its data type is string .
     */
    public String getPosition() {
        return position;
    }
    /**
     * Used to set the PlayGround position .
     * @param position and its data type is string .
     */
    public void setPosition(String position) {
        this.position = position;
    }
    /**
     * It is used to set to approval for the stadium if it is approved or not .
     * @param flag and its data type is Boolean .
     */

    public  void set_approvation( boolean flag)
    {
        Approvetion = flag ;
    }
    /**
     * It is used to set activation the stadium if it is activated or not .
     * @param flag and its data type is Boolean .
     */
    public  void set_activation( boolean flag)
    {
        active = flag ;
    }
    /**
     * This method is used for print playground .
     * name , id , location and price hour .
     * and PlayGround is approved and activated or not .
     */
    public void print()
    {
        System.out.println("The PlayGround Name : " + name);
        System.out.println("The PlayGround ID: " + id);
        System.out.println("The PlayGround Location: " + location);
        System.out.println("The Price in Hour: " + priceInHour);
        if(Approvetion)
        System.out.println("The PlatGround is approved");
        else
            System.out.println("The PlayGround is unapproved");
        if (active)
            System.out.println("The playGround is active");
        else
            System.out.println("The playGround is suspend");

        System.out.println("___________________________________");
    }
    /**
     * This method is used to print all booking in playground .
     * Show time of booking .
     */
    public void print_booked_time()
    {
        if (!bookings.isEmpty())
        {
            System.out.println("the booked time :");
            for (int i = 0; i < bookings.size(); i++)
            {

                System.out.print("from : ");
                System.out.println(bookings.get(i).time);

            }
            System.out.println(" any another time is available ");
        }
        else
            System.out.println(" there is no booked time ");
    }
    /**
     * Check the booking time player is exist or not . 
     * @param time the time want player to booking it .
     * @return return false if time is exist else return true .
     */
    public boolean contains_time( String time )
    {
        for (int i = 0 ; i < this.bookings.size() ; i++)
        {
            if (this.bookings.get(i).time.equals(time))
            {
                return false ;
            }
        }
        return true ;
    }

}