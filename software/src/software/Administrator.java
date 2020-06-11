
package software;

import java.util.ArrayList;
import java.util.Scanner;
import javax.sound.sampled.Line;

/**
 * This class is very important because the Administrator who is control in program .
 * Can create a profile for Administrator and login . 
 * Who can activated , suspended and deleted the PlayGround . 
 * @author كريم
 */
public class Administrator  extends User {

    /**
     * This method is override from user class .
     * can login Administrator if exist .
     * check all mail in user class and get the desired mail .
     * @param Users take the data form user class to login and it is data type from class User .
     * @return the Administrator who called the method after enter his information .
     */
    @Override
    public User login(ArrayList<User> Users)
    {
        boolean flag = false ;
        Scanner input = new Scanner(System.in);
        String inputs;
        System.out.print("please enter email : ");

        inputs = input.next();

        for (int i = 0; i < Users.size(); i++) // loop for all users
        {

            if (Users.get(i).Email.equals(inputs)) // if entered email = user email
            {
                flag = true ;
                int temp = i; // save user index in temp
                System.out.print(" please enter the password : ");
                inputs = input.next();
                while (true)  // loop until correct pass
                {
                    /**
                     * if condition to check is pass is correct or not
                     */
                    if (Users.get(i).Pass.equals(inputs)) {

                        return  Users.get(i);
                    }
                    System.out.println("invalid password");
                    System.out.print("please enter the vaild password");
                    inputs = input.next();
                }

            }
        }
        if (flag == false)
        {
            System.out.println("This email has not found in the system ");
        }

        return this ;

    }
    /**
     * can SignUp Administrator if not have an email .
     * take his name , id , password and email and check the email if exist or not . 
     * @param Users take the data from user and save it in user class to sign up and it is data type from class User .
     * @return the Administrator who called the method after enter his information .
     */
    public User SignUp( ArrayList<User> Users)
    {
        Scanner input = new Scanner(System.in);
        String inputs ;
        
        System.out.println("____________________");
        
        this.SetStatues("administrator");

        System.out.print("Enter your name :");
        inputs=input.nextLine();
        this.SetName(inputs);

        System.out.print("Enter your id :");
        int ids=input.nextInt();

        for(int i=0;i<Users.size();i++)
        {
            if(Users.get(i).ID == ids)
            {
                System.out.println("this id is repeted enter another id : ");
                ids=input.nextInt();
                i=0;
            }
        }
        this.SetID(ids);

        System.out.print("Enter your email with declear" + " eg: m53asa@gmail.com :");

        do {

            inputs = input.next();
            this.SetEmail(inputs);


           }while (!check_email());

        System.out.print("Enter your password must have letter or numbers :");
        inputs=input.next();
        this.Setpassword(inputs);
        System.out.println("You SignUp succsefully ");


        return  this ;

    }
    /**
     * This method used to approve playground to activate .
     * and Administrator can activate the playground or not .
     * @param playgrounds All playgrounds to select the wanted playground to approve it or not and it is data type PLayGround .
     */
    
    public void approve( ArrayList<PlayGround> playgrounds )
    {
        for( int i = 0 ; i < playgrounds.size() ; i++)
        {
                if (playgrounds.get(i).Approvetion == true)
                {
                    continue;
                }
                else
                    {
                    System.out.println(playgrounds.get(i).name + "playground is waited to activate");
                    System.out.println("the play ground id : " + playgrounds.get(i).getId());
                    System.out.println("the play ground location : " + playgrounds.get(i).getLocation());
                    System.out.println("the play ground owner name: " + playgrounds.get(i).getPlayGroundOwnerName());
                    System.out.println("the play ground price in hours: " + playgrounds.get(i).getPriceInHour());
                    System.out.println("the play ground position: " + playgrounds.get(i).getPosition());

                    System.out.println("Enter true to activate or false for not ");
                    boolean flag;
                    flag = input.nextBoolean();
                    playgrounds.get(i).set_approvation(flag);

                }

        }
    }
    /**
     * This method used to suspend playground from activate .
     * because this playground make a mistake or something wrong .
     * @param playgrounds All playgrounds to select the wanted playground to suspend it or not and it is data type PLayGround .
     */
    public void subsend(ArrayList<PlayGround> playgrounds)
    {
        System.out.println("Enter the playground id ");
        int id = input.nextInt();

        System.out.println("Enter the playground name");
        String inputs = input.next();

        for ( int i = 0 ; i < playgrounds.size(); i ++)
        {
            if ( id == playgrounds.get(i).id && inputs.equals( playgrounds.get(i).name ) )
            {
                playgrounds.get(i).set_activation( false );
            }
        }
    }
    /**
     * This method used to active playground directly .
     * @param playgrounds All playgrounds to select the wanted playground to activate it or not and it is data type PLayGround .
     */
    public void active (ArrayList<PlayGround> playgrounds)
    {
        System.out.println("Enter the playground id ");
        int id = input.nextInt();

        System.out.println("Enter the playground name");
        String inputs = input.next();

        for ( int i = 0 ; i < playgrounds.size(); i ++)
        {
            if ( id == playgrounds.get(i).id && inputs.equals( playgrounds.get(i).name ) )
            {
                playgrounds.get(i).set_activation( true );
            }
        }
    }
    /**
     * This method is used to delete playground .
     * when playground is not exist .
     * and delete it from playground class . 
     * @param playgrounds All playgrounds to select the wanted playground to delete it or not and it is data type PLayGround .
     */
    public void delete( ArrayList<PlayGround> playgrounds )
    {
        System.out.println("Enter the playground id ");
        int id = input.nextInt();
        System.out.println("Enter the playground name");
        String inputs = input.next();

        for ( int i = 0 ; i < playgrounds.size(); i ++)
        {
            if ( id == playgrounds.get(i).id && inputs.equals( playgrounds.get(i).name ))
            {
                playgrounds.remove(i);
            }
        }
    }


}