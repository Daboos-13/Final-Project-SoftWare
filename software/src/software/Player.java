
package software;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * He is the one Who wants to play in the playgrounds and booking them from the owners .
 * Can create profile and login and can booking a playground and create a team . 
 * @author كريم
 */
public class Player extends User  implements Login , SignUp {

    /**
     * This method is override from user class .
     * can login Player if exist .
     * check all mail in user class and get the desired mail .
     * @param Users take the data form user class to login and it is data type from class User .
     * @return the Player who called the method after enter his information .
     */
    @Override
    public User login(ArrayList<User> Users) {

        Scanner input = new Scanner(System.in);
        String inputs;
        boolean flag = false ;
        System.out.print("please enter email : ");

        inputs = input.next();

        for (int i = 0; i < Users.size(); i++) // loop for all users
        {

            if (Users.get(i).Email.equals(inputs)) // if entered email = user email
            {
                flag = true ;
                System.out.print("please enter the password : ");
                inputs = input.next();
                while (true)  // loop until correct pass
                {
                    /**
                     * if condition to check is pass is correct or not
                     */
                    if (Users.get(i).Pass.equals(inputs))
                    {

                        return Users.get(i);
                    }
                    System.out.println("__________________________");
                    System.out.println("invalid password");
                    System.out.print("please enter the  password : ");
                    inputs = input.next();

                }

            }
        }
        if( flag == false)
        {
            System.out.println("This email has not found in the system");
        }

        return this;

    }
    /**
     * can SignUp Player if not have an email .
     * take his name , id , password and email and check the email and id if exist or not .
     * @param Users take the data from user and save it in user class to sign up and it is data type from class User .
     * @return the Player who called the method after enter his information .
     */
    @Override
    public Player SignUp(ArrayList<User> Users) {
        Scanner input = new Scanner(System.in);
        String inputs;

        System.out.println("____________________");
        this.SetStatues("player");

        System.out.print("Enter your name :");
        inputs=input.nextLine();
        this.SetName(inputs);

        System.out.print("Enter your id :");
        int ids = input.nextInt();

        for (int i = 0; i < Users.size(); i++) {
            if (Users.get(i).ID == ids) {
                System.out.println("this id is repeted enter another id : ");
                ids = input.nextInt();
                i = 0;
            }
        }
        this.SetID(ids);
        System.out.print("Enter your email with declear" + " eg: m53asa@gmail.com :");

        do {

            inputs = input.next();
            this.SetEmail(inputs);

        } while (!this.check_email());
        System.out.print("Enter your password must have letter or numbers :");
        inputs = input.next();
        this.Setpassword(inputs);

        System.out.print("Enter your Ewallet balance :");

        double balance = input.nextDouble();

        this.ewallet.Set_Balance(balance);

        System.out.println("You SignUp succsesfuly ");



        return this;

    }
    /**
     * This method used to create a team like how many players in team and get players ids . 
     * @param users to check if the entered player exist in the system or not and it is data type from class User .
     */
    public void create_team( ArrayList<User> users)
    {
        this.captian_ID = 0 ;
        int number  , x;
        String inputs ;
        System.out.print("how many player do you want to add to your team : ");
        number = input.nextInt();
        for (int i = 0 ; i < number ; i++)
        {
            System.out.print("Enter the player ID :  ");
            x = input.nextInt();
            for (int j = 0 ; j < users.size() ; j++)
            {
                if ( x == users.get(j).ID )
                {
                    users.get(j).captian_ID = this.ID ;
                }
            }

        }


    }
    /**
     * This method used to book playground what a time player need and when .
     * @param playGround This parameter make to get playground who player want from main an it is data type is PlayGround .
     * @param playGroundOwner  who will earn the money from player by the ewallet code and it is data type playGroundOwner .
     */
    public void Book( PlayGround playGround  , PlayGroundOwner playGroundOwner )
    {

        boolean flag = true ;
        int number ;
        System.out.print("How many hours do you want to book : ");
        number = input.nextInt();
        for ( int j = 0 ; j < number ; j++)
        {
            do {
                String inputs;
                flag = true ;
                System.out.print(" Enter the time you want to book in form -> 00:00 : ");
                inputs = input.next();
                if (inputs.contains(":") && !inputs.contains(" "))
                {
                    Booking p = new Booking();


                    p.setTime(inputs);
                    p.setWho_booked(Get_name());
                    p.setBooked(true);

                    for (int i = 0; i < playGround.bookings.size(); i++)
                    {
                        if (playGround.bookings.get(i).time.equals(inputs))
                        {
                            System.out.println("this time is already taken ");
                            flag = false;
                            break;
                        }
                    }
                    if (flag == true)
                    {
                        if (ewallet.Balance>= playGround.priceInHour)
                        {
                            playGround.bookings.add(p);

                            this.ewallet.Withdraw(playGround.priceInHour);
                            playGroundOwner.ewallet.Deposite(playGround.priceInHour);
                        }
                        else
                        {
                            System.out.println("The booking process failed");
                            System.out.println("you don't have enough money in your Ewallet");
                        }

                    }

                }

            } while (!flag);
        }





    }
}