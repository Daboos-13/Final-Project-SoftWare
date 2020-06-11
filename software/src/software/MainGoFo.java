package software;
import java.util.ArrayList;
import java.util.Scanner;

public class MainGoFo {
    public static void main(String[] args) {

        ArrayList<User> Users = new ArrayList<>();
        ArrayList<PlayGround> playgrounds = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        String inputs;
        boolean Exit = true;

        User current_user = new User();

        do {

            int my_choice = 0;
            System.out.println("___________________________");
            System.out.println("1) for signUp");
            System.out.println("2) for login");
            System.out.println("3) for Exit");
            System.out.print("My choice : ");
            int number = input.nextInt();
            switch (number) {
                case 1:
                OUTER_1:
                do {
                    System.out.println("___________________________");
                    System.out.println("Enter your statues player , playgroundowner or administrator");
                    System.out.println("1) player");
                    System.out.println("2) PlayGround Owner");
                    System.out.println("3) Administrator");
                    System.out.println("4) Bake to main menu ");
                    System.out.print("My choice : ");
                    my_choice = input.nextInt();
                    switch (my_choice) {
                        case 1:
                            Player player = new Player();
                            player.SignUp(Users);
                            Users.add(player);
                            break OUTER_1;
                        case 2:
                            PlayGroundOwner playgroundowner = new PlayGroundOwner();
                            playgroundowner.SignUp(Users);
                            Users.add(playgroundowner);
                            break OUTER_1;
                        case 3:
                            Administrator administrator = new Administrator();
                            administrator.SignUp(Users);
                            Users.add(administrator);
                            break OUTER_1;
                        case 4:
                            break OUTER_1;
                        default:
                            System.out.println("___________________________");
                            System.out.println("Invalid input");
                            break;
                    }
                } while (true);
                    break;

                case 2:
                    if (!Users.isEmpty())
                    {
                        current_user = current_user.login(Users);
                        
                        if (current_user.Statues != null) {
                            switch (current_user.Statues) {
                                case "player":
                                    OUTER:
                                    do {
                                        Player p = (Player) current_user;
                                        System.out.println("_______________________________");
                                        System.out.println("1) Book playGround");
                                        System.out.println("2) create team");
                                        System.out.println("3) show my team");
                                        System.out.println("4) show my Ewallet");
                                        System.out.println("5) cancel booking");
                                        System.out.println("6) back to main menu");
                                        System.out.print("My choice : ");
                                        my_choice = input.nextInt();
                                        switch (my_choice) {
                                            case 1:
                                                System.out.println("Do you want to filter the playgrounds ");
                                                System.out.print("Enter yes or no : ");
                                                inputs = input.next();
                                                if (inputs.equals("yes")) {
                                                    System.out.println("1) filter by area");
                                                    System.out.println("2) filter by time");
                                                    System.out.println("3) filter by price");
                                                    System.out.print("My choice : ");
                                                    my_choice = input.nextInt();
                                                    switch (my_choice) {
                                                        case 1:
                                                            System.out.print("Enter the playground location : ");
                                                            inputs = input.next();
                                                            for (int i = 0; i < playgrounds.size(); i++) {
                                                                if (playgrounds.get(i).location.equals(inputs))
                                                                    if (playgrounds.get(i).Approvetion == true)
                                                                        playgrounds.get(i).print();
                                                            }   break;
                                                        case 2:
                                                            System.out.print("Enter the time :");
                                                            inputs = input.next();
                                                            for (int i = 0; i < playgrounds.size(); i++) {
                                                                
                                                                boolean flag = playgrounds.get(i).contains_time(inputs);
                                                                
                                                                if (flag)
                                                                    if (playgrounds.get(i).Approvetion == true)
                                                                        playgrounds.get(i).print();
                                                            }   break;
                                                        case 3:
                                                            System.out.print("Enter the price : ");
                                                            my_choice = input.nextInt();
                                                            for (int i = 0; i < playgrounds.size(); i++) {
                                                                if (playgrounds.get(i).priceInHour <= my_choice)
                                                                    if (playgrounds.get(i).Approvetion == true)
                                                                        playgrounds.get(i).print();
                                                            }   break;
                                                        default:
                                                            break;
                                                    }
                                                } else {
                                                    for (int i = 0; i < playgrounds.size(); i++) {
                                                        if (playgrounds.get(i).Approvetion == true)
                                                            playgrounds.get(i).print();
                                                    }
                                                }       System.out.print("Select the PlayGround name : ");
                                                inputs = input.next();
                                                for (int i = 0; i < playgrounds.size(); i++) {
                                                    if (playgrounds.get(i).name.equals(inputs)) {
                                                        if (!playgrounds.get(i).bookings.isEmpty()) {
                                                            
                                                            playgrounds.get(i).print_booked_time();
                                                            
                                                        } else {
                                                            System.out.println("______________________");
                                                            System.out.println("there is no booked time");
                                                            System.out.println("you can choice any time you want");
                                                            
                                                        }
                                                        System.out.println("Do you want to book");
                                                        System.out.print("Enter yes or no : ");
                                                        inputs = input.next();
                                                        if (inputs.equals("yes")) {
                                                            for (int j = 0; j < Users.size(); j++) {
                                                                if (Users.get(j).ID == playgrounds.get(i).id) {
                                                                    p.Book(playgrounds.get(i), (PlayGroundOwner) Users.get(j));
                                                                    
                                                                }
                                                            }
                                                        }
                                                    }
                                                    
                                                    
                                                }       break;
                                            case 2:
                                                p.create_team(Users);
                                                break;
                                            case 3:
                                                if (p.captian_ID == 0) {
                                                    for (int i = 0; i < Users.size(); i++) {
                                                        if (Users.get(i).captian_ID == p.ID) {
                                                            System.out.print(" Player : ");
                                                            System.out.println(Users.get(i).Name);
                                                        }
                                                        
                                                    }
                                                    System.out.print("Player : ");
                                                    System.out.println(p.Name);
                                                } else {
                                                    for (int i = 0; i < Users.size(); i++) {
                                                        if (p.captian_ID == Users.get(i).captian_ID || p.captian_ID == Users.get(i).ID) {
                                                            System.out.print(" Player : ");
                                                            System.out.println(Users.get(i).Name);
                                                        }
                                                        
                                                    }
                                                }       break;
                                            case 4:
                                                System.out.print("My Ewallet Balance : ");
                                                System.out.println(p.ewallet.Balance);
                                                break;
                                            case 5:
                                                for (int i = 0; i < playgrounds.size(); i++) {
                                                    for (int j = 0; j < playgrounds.get(i).bookings.size(); j++) {
                                                        if (playgrounds.get(i).bookings.get(j).who_booked == null ? p.Name == null : playgrounds.get(i).bookings.get(j).who_booked.equals(p.Name)) {
                                                            System.out.println("you had booked " + playgrounds.get(i).bookings.get(j).time + " in the " + playgrounds.get(i).name);
                                                            System.out.println("Do you want to cancel it ");
                                                            System.out.println("Enter yes or no");
                                                            inputs = input.next();
                                                            if (inputs.equals("yes")) {
                                                                playgrounds.get(i).bookings.remove(j);
                                                                j--;
                                                            }
                                                        }
                                                    }
                                                }       break;
                                            case 6:
                                                break OUTER;
                                            default:
                                                System.out.println("Invalid input");
                                                break;
                                        }
                                    } while (true);
                                    break;
                                case "playgroundowner":
                                    {
                                        PlayGroundOwner p = (PlayGroundOwner) current_user;
                                OUTER_2:
                                do {
                                    System.out.println("____________________________________");
                                    System.out.println("1) Add PlayGround");
                                    System.out.println("2) Update PlayGround");
                                    System.out.println("3) Print All your playGrounds");
                                    System.out.println("4) Show my Ewallet balance ");
                                    System.out.println("5) Logout");
                                    System.out.print("My choice : ");
                                    my_choice = input.nextInt();
                                    switch (my_choice) {
                                        case 1:
                                            p.Add_PlayGround(playgrounds);
                                            break;
                                        case 2:
                                            p.Update_PlayGround(playgrounds);
                                            break;
                                        case 3:
                                            for (int i = 0; i < playgrounds.size(); i++) {
                                                if (playgrounds.get(i).id == p.ID) {
                                                    playgrounds.get(i).print();
                                                }
                                            }
                                            break;
                                        case 4:
                                            System.out.print("My Ewallet Balance : ");
                                            System.out.println(p.ewallet.Balance);
                                            break;
                                        case 5:
                                            break OUTER_2;
                                        default:
                                            break;
                                    }
                                } while (true);
                                        break;
                                    }
                                case "administrator":
                                    {
                                        Administrator p = (Administrator) current_user;
                                OUTER_3:
                                do {
                                    System.out.println("_________________________");
                                    System.out.println("1) Approve PlayGrounds");
                                    System.out.println("2) Activate PlayGround");
                                    System.out.println("3) Suspend  playGround");
                                    System.out.println("4) Delete PlayGround");
                                    System.out.println("5) Logout");
                                    System.out.print("My choice : ");
                                    my_choice = input.nextInt();
                                    switch (my_choice) {
                                        case 1:
                                            p.approve(playgrounds);
                                            break;
                                        case 2:
                                            p.active(playgrounds);
                                            break;
                                        case 3:
                                            p.subsend(playgrounds);
                                            break;
                                        case 4:
                                            p.delete(playgrounds);
                                            break;
                                        case 5:
                                            break OUTER_3;
                                        default:
                                            System.out.println("invalid input");
                                            break;
                                    }
                                } while (true);
                                        break;
                                    }
                                default:
                                    break;
                            }
                        }
                    }else {
                        System.out.println("___________________________");
                        System.out.println("There is no users");
                        System.out.println("You should SignUp first");
                    }   break;
                case 3:
                    Exit = false ;
                    break;
                default:
                    System.out.println("invalid input");
                    System.out.println("__________________________");
                    break;
            }
            } while (Exit == true) ;


        }
    }