
package software;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * They are the owner of the playgrounds and they are the ones who offer it to the system in order to make money from it .
 * He can create a profile if he doesn't have it, or he can log in if he has one .
 * He can add stadiums and everything related to them, and he can also do updates for them .
 * @author كريم
 */
public class PlayGroundOwner extends User
{
    /**
     * This method is override from user class .
     * can login Player if exist .
     * check all mail in user class and get the desired mail .
     * @param Users take the data form user class to login and it is data type from class User .
     * @return the PlayGroundOwner who called the method after enter his information .
     */
    @Override
    public User login(ArrayList<User> Users)
    {

        Scanner input = new Scanner(System.in);
        String inputs;
        System.out.print("please enter email : ");

        inputs = input.next();

        for (int i = 0; i < Users.size(); i++) // loop for all users
        {

            if (Users.get(i).Email.equals(inputs)) // if entered email = user email
            {
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

        return this ;

    }
    /**
     * can SignUp Player if not have an email .
     * take his name , id , password and email and check the email and id if exist or not . 
     * @param Users take the data from user and save it in user class to sign up and it is data type from class User .
     * @return the PlayGroundOwner who called the method after enter his information .
     */
    public User SignUp(ArrayList<User> Users)
    {
        Scanner input = new Scanner(System.in);
        String inputs ;



        this.SetStatues("playgroundowner");

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

        System.out.print("Enter your email with declear" + " eg: m53asa@gmail.com :");

        this.SetID(ids);
        do {

            inputs = input.next();
            this.SetEmail(inputs);

        }while (!check_email());

        System.out.print("Enter your password must have letter or numbers :");
        inputs=input.next();
        this.Setpassword(inputs);

        System.out.print("Enter your Ewallet balance :");
        double balance = input.nextDouble();
        this.ewallet.Set_Balance(balance);


        return  this ;

    }
    /**
     * This method can add playground by playground owner .
     * and he can enter the name , location and price in hour .
     * @param playgrounds take all data and save it in playground array list and it is data type PLayGround .
     */
    public void Add_PlayGround(ArrayList<PlayGround> playgrounds)
    {
        PlayGround object=new PlayGround();

        Scanner input = new Scanner(System.in);

        String inputs ;

            System.out.println("do the instructions to register playground");
            System.out.print("enter the playground name :");
            inputs=input.next();

            object.setName(inputs);

            object.setId(this.ID);
            System.out.print("enter the playground location :");
            inputs=input.next();
            object.setLocation(inputs);

            System.out.print("enter the price in hour :");
            float num1=input.nextFloat();
            object.setPriceInHour(num1);

            object.setPlayGroundOwnerName(Get_name());
            inputs="susbend";
            object.setPosition(inputs);
            playgrounds.add(object);
            System.out.println("Done!");



    }
    /**
     * This method can update playground by playground owner .
     * can change the name , location and price in hour .
     * @param playgrounds take all playgrounds data and save the new playground in the playgrounds array list and it is data type PLayGround .
     */
    public void Update_PlayGround(ArrayList<PlayGround> playgrounds)
    {
        String  inputs ;
        System.out.println("Enter the playground name ");

        inputs = input.next();
        for(int i = 0 ; i < playgrounds.size(); i++)
        {
            if( this.ID == playgrounds.get(i).id )
            {

            if( inputs.equals(playgrounds.get(i).name))
            {
                System.out.println("do the instructions to Update playground");
                System.out.print("enter the playground name :");
                inputs=input.next();
                playgrounds.get(i).setName(inputs);

                System.out.print("enter the playground location :");
                inputs=input.next();
                playgrounds.get(i).setLocation(inputs);

                System.out.print("enter the price in hour :");
                float num1=input.nextFloat();
                playgrounds.get(i).setPriceInHour(num1);

                playgrounds.get(i).setPlayGroundOwnerName(Get_name());
                System.out.println("Done!");

            }
        }
        }


    }



}