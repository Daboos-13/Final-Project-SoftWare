
package software;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used to add both the PLayer, Administrator and Playground owner .
 * take name , id , email , statues and ewallet .
 * and can login and sign up for them .
 * @author كريم
 */
public class User
{

    Scanner input = new Scanner(System.in);

    public  String Name;
    public int ID;
    public String Email;
    public String Pass;
    public String Statues = null ;
    public int captian_ID   ;


    public Ewallet ewallet = new Ewallet();
    /**
     * Used to set name for user .
     * @param N it is data type string .
     */
    public  void SetName(String N)
    {
        Name = N ;
    }
    /**
     * Used to set id for user .
     * @param id it is data type int .
     */
    public  void SetID(int id)
    {
        ID = id ;
    }
    /**
     * Used to set email for user .
     * @param email it is data type String . 
     */
    public  void SetEmail(String email)
    {
        Email = email ;
    }
    /**
     * Used to set password for user .
     * @param password it is data type String .
     */
    public  void Setpassword(String password)
    {
        Pass = password ;
    }
    /**
     * Used to set Statues for user .
     * @param S it is data type String .
     */
    public  void SetStatues(String S)
    {
        Statues = S ;
    }
    /**
     * Used to get name of user .
     * @return the name of user .
     */
    public String Get_name()
    {
        return Name ;
    }
    /**
     * This method can login User if exist .
     * check all mail in user class and get the desired mail .
     * @param Users take the data form user class to login and it is data type from class User .
     * @return the user who called the method after enter his information .
     */
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
     * can SignUp User if not have an email .
     * take his statues , name , id , password and email and check the email and id if exist or not .
     * @param statues take the data from user if player , playground owner or Administrator and it is data type from class User .
     * @param Users take the data from user and save it in user class to sign up and it is data type from class User .
     * @return the user who called the method after enter his information .
     */
    public User SignUp(String statues , ArrayList<User> Users)
    {
        Scanner input = new Scanner(System.in);
        String inputs ;

        this.SetStatues(statues);

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
        System.out.print("Enter your email with declear"+ " eg: m53asa@gmail.com :");
        inputs=input.next();
        this.SetEmail(inputs);
        System.out.print("Enter your password must have letter or numbers :");
        inputs=input.next();
        this.Setpassword(inputs);


        return  this ;

    }
    /**
     * This method used to print all data from user statues , name , id , password and email .
     */
    public void print()
    {
        System.out.println(Name);
        System.out.println(ID);
        System.out.println(Email);
        System.out.println(Pass);
        System.out.println(Statues);
    }
    /**
     * This method used to check email if have '.' and '@gmail' .
     * @return true if have '.' and '@gmail' else return false .
     */
    public boolean check_email()
    {
        if (Email.contains(".") && Email.contains("@gmail"))
        {
            return true ;
        }
        System.out.print("invalid input:");

        System.out.print("Enter your email with declear" + " eg: m53asa@gmail.com :");

        return  false ;
    }

}