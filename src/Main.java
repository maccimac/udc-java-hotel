import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Welcome to Udacity Hotel");
        mainMenuFlow();



    }

    public static void mainMenuFlow(){
        System.out.println("Welcome to the main menu!\n");
        int initialInput;

        do{
            initialInput = getInitialCommand();
            if(initialInput < 1 || initialInput > 5){
                System.out.println("Please enter a valid command.");
            }
        } while(initialInput < 1 || initialInput > 5);
        System.out.println("You have chosen: " + initialInput);
        System.out.println("---\n\n");


        if(initialInput == 4){
            adminFlow();
        }

    }

    public static int getInitialCommand(){

        int input;
        System.out.println("Please enter a command: ");
        System.out.print( "1. Find and reserve a room\n"
                + "2. See my reservations\n"
                + "3. Create an account\n"
                + "4. Admin (open the admin menu described below)\n"
                + "5. Exit (exit the application)\n\n"
        );

        System.out.print("I choose: ");
        String scannerInput = scanner.nextLine();
        System.out.println("---\n");

        try{
            input = Integer.parseInt(scannerInput);
        }catch (NumberFormatException e){
            System.out.print("Error: ");
            System.out.print(e.getMessage());
            System.out.println(" There is an error in your input. Please try again.\n");
            input = -1;
        }
        return input;
    }

    public static void adminFlow(){

        System.out.println("Welcome, admin!\n");
        int input;

        do{
            input = printAdminMenu();
            if(input < 1 || input > 5){
                System.out.println("Please enter a valid command.");
            }
        } while(input < 1 || input > 5);
        System.out.println("You have chosen: " + input);
        System.out.println("---\n");

        if(input == 5){
            mainMenuFlow();
        }

    }

    public static int printAdminMenu(){
        int input;
        System.out.println("Please enter a command: ");
        System.out.print(
                "1. See all customers\n"
                + "2. See all rooms\n"
                + "3. See all reservations\n"
                + "4. Add a room\n"
                + "5. Back to main menu\n\n"
        );

        System.out.print("I choose: ");
        String scannerInput = scanner.nextLine();
        System.out.println("---\n");

        try{
            input = Integer.parseInt(scannerInput);
        }catch (NumberFormatException e){
            System.out.print("Error: ");
            System.out.print(e.getMessage());
            System.out.println(" There is an error in your input. Please try again.\n");
            input = -1;
        }
        return input;
    }



}