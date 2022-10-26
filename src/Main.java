import java.util.Scanner;

/*
 * Main class for "Week 7 Lecture Day 1 Homework - Java Calculator"
 * created 15 October 2022
 *
 * @author Len Lutz
 */
public class Main {
    // set up scanner to gather information from user
    static Scanner scanner = new Scanner(System.in);

    /**
     * Method: getNumInput
     *
     * Purpose: Processes numeric input.  If number has not been
     *          entered, or if number is invalid, it keeps asking.
     *
     * @param prompt - String describing what information is being asked for 
     *
     * @return Returns validated number
     *
    */
    public static int getNumInput(String prompt) {
        // create local variables
        int result = 0;
        String userInput;

        // keeps asking for number until valid number has been entered
        while (result == 0) {
            // prompt for input
            System.out.println(prompt);

            // read in line from console
            userInput = scanner.nextLine();
            // if nothing is entered, the following "if" will not execute and
            //  the while loop will start over
            if (!userInput.isEmpty()) {
                // invalid number will throw exception, so we check for that here
                try {
                    // if number was entered, store it in result
                    result = Integer.parseInt(userInput);
                } catch (Exception e) {
                    // if what was entered cannot be parsed to a number, 
                    //  ask for VALID number and stay in while loop
                    System.out.println("Please enter a valid number.");
                }
            }
        }
        return result;
    }

    /**
     * method: main - routine that starts the program
     *
     * @param args - Array of String entered as command line arguments
     *     No arguments are expected or checked for in this program
     */
    public static void main(String[] args) {
        String prompt;
        int menuChoice;
        int result;
        int num1;
        int num2;

        // run this code until told to stop!
        while (true) {
            // display menu
            System.out.println("\nWhat type of math would you like to do?");
            System.out.println("\t1 - Add");
            System.out.println("\t2 - Subtract");
            System.out.println("\t3 - Multiply");
            System.out.println("\t4 - Divide");
            System.out.println("\t5 - Square");
            System.out.println("\t6 - Quit Program");

            // get user's choice
            menuChoice = getNumInput("\nPlease enter the number of your menuChoice:");
            if (menuChoice == 6) {
                return; // ends program
            }

            // if menuChoice is not valid, redisplay menu and try again
            if ((menuChoice < 1) || (menuChoice > 5)) {
                System.out.println(" Invalid menuChoice.");
                continue;
            }

            //  if squaring, ask for "a" number, otherwise ask for "first" number
            prompt = String.format("Please enter %s number:",
                    menuChoice < 5 ? "first" : "a");

            // get number
            num1 = getNumInput(prompt);

            // if squaring, we only need one number, so we can use what we have,
            //  call the square method, display the result, and repeat the process
            //  (continue returns to beginning of while loop)
            if (menuChoice == 5) {
                result = Calculator.square(num1);
                System.out.printf("%d squared = %d\n", num1, result);
                continue;
            }

            // store first part of prompt...
            prompt = "Please enter number to ";

            // append end of prompt based on math routine selected 
            switch (menuChoice) {
                case 1 -> prompt += "add:";
                case 2 -> prompt += "subtract:";
                case 3 -> prompt += "multiply by:";
                default -> prompt += "divide by:";
            }

            // get second number...
            num2 = getNumInput(prompt);

            // call selected routine and display result
            switch (menuChoice) {
                case 1: result = Calculator.add(num1, num2);
                        System.out.printf("%d plus %d equals %d.\n", num1, num2, result);
                    break;
                case 2: result = Calculator.subtract(num1, num2);
                    System.out.printf("%d minus %d equals %d.\n", num1, num2, result);
                    break;
                case 3: result = Calculator.multiply(num1, num2);
                    System.out.printf("%d multiplied by %d equals %d.\n", num1, num2, result);
                    break;
                default: result = Calculator.divide(num1, num2);
                    System.out.printf("%d divided by %d equals %d.\n", num1, num2, result);
                    if ((num1 % num2) != 0) {
                        System.out.println("Remainder: " + (num1 % num2));
                    }
                    break;
            }
            // stay in while loop to start over
        }
    }
}
