package com.company;
import com.company.model.BankAccount;
import com.company.model.User;



import java.util.ArrayList;
import java.util.Scanner;

public class RehmanKhadija_Main {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {


        ArrayList<User> users = new ArrayList<>();  // ArrayList of  User class collection

        User user1 = new User("Khadija" , "Rehman" , new BankAccount(101,5000),21);
        User user2 = new User("Saad" , "Rehman" , new BankAccount(102,7000),18);
        User user3 = new User("Abdullah" , "Rehman" , new BankAccount(103,6000) ,20);
        User user4 = new User("Abdul" , "Rehman" ,  new BankAccount(104,8000),18);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        welcomeMessage();
        mainMenu(users);

    }

    /**
     * @param message Show the main message of the program with its option
     * @param min     Minimum value of the menu (1)
     * @param max     Maximum value of the program (3)
     * @return Return the value of the
     */
    public static int readNum(String message, int min, int max) {

        final String RESET = "\u001B[0m";
        final String BLUE_BOLD_BRIGHT = "\033[1;94m";
        final String RED_BACKGROUND_BRIGHT = "\033[0;101m";

        Scanner read = new Scanner(System.in);
        int value = 0;
        boolean correctValue = false;
        do {
            System.out.println(BLUE_BOLD_BRIGHT + message + RESET);
            correctValue = read.hasNextInt();

            if (!correctValue) {
                read.nextLine();
                System.out.println(RED_BACKGROUND_BRIGHT + "Entered value is not Correct Type." + RESET);
            } else {
                value = read.nextInt();
                read.nextLine();
                if (value < min || value > max) {
                    System.out.println(String.format(RED_BACKGROUND_BRIGHT + "The value range is between  %d and %d", min, max ));
                    correctValue = false;
                }
            }
        } while (!correctValue);

        return value;
    }

    private static void welcomeMessage() {

        final String RESET = "\u001B[0m";
        System.out.println(
                "*-*-*-*-*-*- Welcome to the International Bank *-*-*-*-*-*-*-*\n" +
                "                                              \n" +
                "                                         ,-.  \n" +
                "  ,---,                              ,--/ /|  \n" +
                ",---.'|                      ,---, ,--. :/ |  \n" +
                "|   | :                  ,-+-. /  |:  : ' /   \n" +
                ":   : :      ,--.--.    ,--.'|'   ||  '  /    \n" +
                ":     |,-.  /       \\  |   |  ,\"' |'  |  :    \n" +
                "|   : '  | .--.  .-. | |   | /  | ||  |   \\   \n" +
                "|   |  / :  \\__\\/: . . |   | |  | |'  : |. \\  \n" +
                "'   : |: |  ,\" .--.; | |   | |  |/ |  | ' \\ \\ \n" +
                "|   | '/ : /  /  ,.  | |   | |--'  '  : |--'  \n" +
                "|   :    |;  :   .'   \\|   |/      ;  |,'     \n" +
                "/    \\  / |  ,     .-./'---'       '--'       \n" +
                "`-'----'   `--`---'                     ");

        System.out.println("*-*-*-*-*-*- Here, is the Main Menu Dashboard  *-*-*-*-*-*-*-*" + RESET);
    }

    /**
     * Main Menu of the Program with option admin and user
     *
     * @param users .
     */
    private static void mainMenu(ArrayList<User> users) {
        final String PURPLE_UNDERLINED = "\033[4;35m";
        int option = 0;
        do {
            System.out.println("Which operation you want to do:");
            option = readNum(PURPLE_UNDERLINED+
                            "1 - Admin\n" + "2 - User\n" + "3 - Exit\n",
                    1, 3);
            switch (option) {
                case 1://Admin option
                    adminMenu(users);
                    break;
                case 2: //User option
                    userMenu(users);
                    break;
                case 3: //Exit the program
                    System.out.println("Application is going to close...\nBye-Bye");
                    break;
                default:
                    System.out.println("Entered number is not mention in the Menu List");
                    break;
            }
            System.out.println();
        } while (option != 3);
    }

    /**
     * This is the submenu of admin with following operations:
     *
     * @param users .
     */
    private static void adminMenu(ArrayList<User> users) {
        final String PURPLE_UNDERLINED = "\033[4;35m";
        int subMenu = 0;
        do {
            System.out.println("You are the Admin of the Bank.\nWhich operation you want to do with the User Information\nPress Option...\n");
            subMenu = readNum(PURPLE_UNDERLINED +
                    "1-To See all User Information\n" + "2-To Insert a User Information\n" +
                    "3-To Search User Information\n" +  "4-Back to the Main Menu", 1, 4);
            switch (subMenu) {
                case 1: {
                    allUser(users);
                    break;
                }
                case 2: {
                    insertUser(users);
                    allUser(users);
                    break;
                }
                case 3: {
                    searchUser(users);
                    break;
                }
                case 4: {
                    System.out.println("Going back to the Main Menu Option....");
                    break;
                }
                default:
                    System.out.println("Entered number is not mention in the Menu List");
                    break;
            }
            System.out.println();
        } while (subMenu != 4);
    }

    /**
     *    u indicates user
     * @param users To see all User Information List That contains in the Bank DataBase
     */
    private static void allUser(ArrayList<User> users) {
        final String GREEN_BACKGROUND = "\033[42m";
        final String RESET = "\u001B[0m";
        headerprint();
        System.out.println();
        for (User u : users) {
            System.out.println(String.format(GREEN_BACKGROUND+"%1$15s%2$15s%3$15s%4$15s%5$15s", u.getName(), u.getSurname(), u.getAccountNum(), u.getAge(), u.getBalance()) + RESET );
        }
    }

    /**
     *  Here in this method you can Insert New User in the list.
     * @param users .
     */
    private static void insertUser(ArrayList<User> users) {

        System.out.println("-----Insert User in the List ------");
        System.out.println("Name of the User:");
        String name = read.nextLine();
        System.out.println("Surname of the User");
        String surname = read.nextLine();

        int accNo = readNum("Account Number of the User(It can be from 105 - 200 ):", 100, 200);
        int balance =  readNum("Enter the balance of the User:" , 100 , 500000);

        int age = readNum("Age of the User:", 18, 85);
        User insertUser = new User(name,surname,new BankAccount(accNo, balance),age);
    }

    /**
     *      This method will be for searching different thing of User
     * @param users To search user by their name and account number
     */
    private static void searchUser(ArrayList<User> users) {
        final String PURPLE_UNDERLINED = "\033[4;35m";
        int subsubMenu = 0;
        do {
            System.out.println("How you want to Search User");
            subsubMenu = readNum( PURPLE_UNDERLINED+
                    "1-Search By Name\n" + "2-Search By Account Number\n"
                    + "3-Back to the Main Menu", 1, 3);
            switch (subsubMenu) {
                case 1: {
                    searchName(users);
                    break;
                }
                case 2: {
                    searchAccNum(users);
                    break;
                }
                case 3: {
                    System.out.println("Going back to the Main Menu Option....");
                    break;
                }
                default:
                    System.out.println("Entered number is not mention in the Menu List");
                    break;
            }
            System.out.println();
        } while (subsubMenu != 3);
    }

    /**
     * This method will search user by their name
     * @param users ArrayList User
     */
    private static void searchName(ArrayList<User> users) {
        final String CYAN = "\033[36m";
        final String RESET = "\u001B[0m";
        final String PURPLE_BACKGROUND = "\033[45m";
        System.out.println(CYAN +"Enter a name to Search");
        String name = read.nextLine();

        headerprint();
        System.out.println();

        for (User u: users) {
            if (name.equalsIgnoreCase(u.getName())){

                if (u.getName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(String.format(PURPLE_BACKGROUND+"%1$15s%2$15s%3$15s%4$15s%5$15s", u.getName(),u.getSurname(),u.getAccountNum(),u.getAge() , u.getBalance()) + RESET);
                }
            }
        }
    }


    /**
     * This method will search user by their Account Number
     * @param users ArrayList User
     */
    private static void searchAccNum(ArrayList<User> users) {
        final String CYAN = "\033[36m";
        final String PURPLE_BACKGROUND = "\033[45m";
        final String RESET = "\u001B[0m";

        int accNo ;
        accNo = readNum(CYAN+"Enter a Account Number to Search" , 100 ,200 );
        headerprint();
        System.out.println();
        for (User u: users) {
            if (accNo == (u.getAccountNum())){

                System.out.println(String.format(PURPLE_BACKGROUND+"%1$15s%2$15s%3$15s%4$15s%5$15s", u.getName(),u.getSurname(),u.getAccountNum(),u.getAge() , u.getBalance()) + RESET);
            }
        }
    }


    /**
     * In this Method , All User Menu Will be display and then user can proceed more.
     * @param users .
     */
    private static void userMenu(ArrayList<User> users) {
        final String PURPLE_UNDERLINED = "\033[4;35m";
        int subMenus = 0;
        do {
            System.out.println("You are the User of the Bank\nWhich operation you want to do \nPress Option...\n");
            subMenus = readNum( PURPLE_UNDERLINED +
                    "1-To See your Account Information\n" + "2-To Deposit Money in your Account\n" +
                    "3-To WithDrawl Money from Account\n" + "4-Back to the Main Menu", 1, 4);
            switch (subMenus) {
                case 1: {
                    searchAccNum(users);
                    break;
                }
                case 2: {
                    Deposit(users);
                    break;
                }
                case 3: {
                    withDrawal(users);
                    break;
                }
                case 4: {
                    System.out.println("Going back to the Main Menu Option....");
                    break;
                }
                default:
                    System.out.println("Entered number is not mention in the Menu List");
                    break;
            }
            System.out.println();
        } while (subMenus != 4);

    }

    /**
     *  WithDrawal method is to withdraw amount in any account by the user choice
     * @param users .
     */
    private static void withDrawal(ArrayList <User> users) {
        int accNo;
        accNo = readNum("Enter Account Number:" , 100 , 200);
        double withDrawl ;
        withDrawl = inputAmount("Enter the amount of withdraw: ");

        for (User user : users) {
            if (user.getAccountNum() == accNo) {
                user.withdraw(withDrawl);
            }
        }
    }

    /**
     * This method will print the header of the User Data
     */
    private static void headerprint() {
        final String BLACK = "\033[30m";
        String[] header = {"NAME", "SURNAME", "ACCOUNT NUMBER", "AGE", "BALANCE"};
        for (String s : header) {
            System.out.print(String.format(BLACK + "%1$15s", s));
        }
    }

    /**
     * This method will help user t deposit money from their account
     * @param users .
     */
    private static void Deposit(ArrayList<User> users){
        int accNo;
        accNo = readNum("Enter Account Number:" , 100 , 200);
        double da ;
        da = inputAmount("Enter the amount of Deposit: ");

        for (User user : users) {
            if (user.getAccountNum() == accNo) {
                user.deposit(da);
            }
        }
        System.out.println("Deposit completed of " + da + " to account nº " + accNo);
    }

    /**
     * This method is for specially deposit and withdraw money where user can enter any amount but can't enter alphabet
     * @param message Output message
     * @return integar will return
     */
    public static int inputAmount(String message) {


        final String RESET = "\u001B[0m";
        final String BLUE_BOLD_BRIGHT = "\033[1;94m";
        final String RED_BACKGROUND_BRIGHT = "\033[0;101m";

        Scanner read = new Scanner(System.in);
        int value = 0;
        boolean correctValue = false;
        do {
            System.out.println(BLUE_BOLD_BRIGHT + message + RESET);
            correctValue = read.hasNextInt();

            if (!correctValue) {
                read.nextLine();
                System.out.println(RED_BACKGROUND_BRIGHT + "Entered value is not Correct Type." + RESET);
            } else {
                value = read.nextInt();
                read.nextLine();

            }
        } while (!correctValue);

        return value;
    }
}
