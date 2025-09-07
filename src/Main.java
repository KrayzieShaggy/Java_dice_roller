// Importing Libraries

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initializing variables and boolean
        Scanner in = new Scanner(System.in);
        Random roll = new Random();
        boolean tryAgain = true;

        // Creating while loop for user to try rolling again after rolling dice
        while(tryAgain) {

            int sides = 0;

            //Loop until user enters valid number of side die
            while(true) {

                // Asking user what sided die they would like to roll and storing into sides variable
                System.out.println("What number sided die would you like to roll?");
                String numOfSides = in.nextLine();

                //Try loop to detect if user input was a number or not
                try{
                    sides = Integer.parseInt(numOfSides);

                    //check if user input a number less than 1
                    if (sides <1) {
                        System.out.println("Please enter a number great than 0");
                        //Ask again if number is invalid
                        continue;
                    }
                    // Break once valid input is entered
                    break;

                    // Catch any invalid inputs (letters, symbols, ect.)
                } catch (NumberFormatException e){
                    System.out.println("Invalid input! Please enter a positive whole number");
                }
            }

            int diceCount = 0;

            // Loop until user enters valid number of dice
            while(true){

                // Asking user how many of dice they would like to roll and storing into diceCount variable
                System.out.printf("How many %s sided die would you like to roll?\n", sides);
                String numOfDice = in.nextLine();

                //Try loop to detect if user input was a number or not
                try{
                    diceCount = Integer.parseInt(numOfDice);

                    //check if user input a number less than 1
                    if(diceCount < 1) {
                        System.out.print("Please enter a number great than 0");
                        //Ask again if number is invalid
                        continue;
                    }
                    // Break once valid input is entered
                    break;

                    // Catch any invalid inputs (letters, symbols, ect.)
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input! Please enter a positive whole number\n");
                }
            }

            // Create an array to store dice rolls
            int[] results = new int[diceCount];
            System.out.printf("Rolling %s number of die with %s sides each\n", diceCount, sides);

            // Roll the number of dice and store into the results array
            for(int i = 0; i < results.length; ++i) {
                results[i] = roll.nextInt(sides) + 1;
            }

            // Check to see if one or more dice is rolled, for correct tense.
            if (diceCount == 1){
                System.out.printf("You rolled a %s\n", results[0]);
            } else {
                System.out.print("Your rolls are: ");

                // loop through array. print a comma after each number until it
                //reaches last number
                for(int i = 0; i < results.length; ++i) {
                    System.out.print(results[i]);
                    if(i < results.length -1){
                        System.out.print(",");
                    }
                }
                //Asking user to see sum of the total rolls from array. Storing in showSum variable
                System.out.println("\nWould you like to see the sum of your rolls?");
                String showSum = in.nextLine().trim().toLowerCase();

                //Check if yes or y is entered
                if (showSum.equals("yes") || showSum.equals("y")){
                    // Initializing total variable to store total
                    int total = 0;
                    // Loop through each number and add each to get total
                    for(int num: results){
                        total+= num;
                    }
                    System.out.printf("The total sum of your rolls is: %s\n", total);
                }


            }
            System.out.print("Would you like to roll again?\n");
            String reRoll = in.nextLine().trim().toLowerCase();
            if(!reRoll.equals("yes") && !reRoll.equals("y")){
                tryAgain = false;
                System.out.println("Thanks for trying out my dice roller!");
            }
        }

    }

}