import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to Udacity Hotel! \n");

        int initialInput;

        do{
            initialInput = getInitialCommand();
            if(initialInput < 1 || initialInput > 5){
                System.out.println("Please enter a valid command.");
            }
        } while(initialInput < 1 || initialInput > 5);
        System.out.println("You have chosen: " + initialInput);

    }

    private static int getInitialCommand(){

        int initialInput;
        System.out.println("Please enter a command: ");
        System.out.print( "1. Find and reserve a room\n"
                + "2. See my reservations\n"
                + "3. Create an account\n"
                + "4. Admin (open the admin menu described below)\n"
                + "5. Exit (exit the application)\n"
        );

        String input = scanner.nextLine();

        try{
            initialInput = Integer.parseInt(input);
        }catch (NumberFormatException e){
            System.out.print("Error: ");
            System.out.print(e.getMessage());
            System.out.println(" There is an error in your input. Please try again.\n");
            initialInput = -1;
        }
        return initialInput;
    }

}