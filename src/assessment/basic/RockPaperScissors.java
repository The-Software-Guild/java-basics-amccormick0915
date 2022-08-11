/*
 * ASSESSMENT: BASIC PROGRAMMING CONCEPTS
 * ROCK PAPER SCISSORS GAME
 * @author Annelyn McCormick
 */
package assessment.basic;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        boolean decision;
        do{
            // get the number of rounds from user
            int rounds = getRoundsFromUser();

            //The game begins
            rockPaperScissorsStart(rounds);

            decision = askToPlayAgain();
        } while(decision);
    }

    //Start the process of RPS!
    public static void rockPaperScissorsStart(int rounds){
        String userRPSchoice;
        int ties, userWins, computerWins;
        ties = userWins = computerWins = 0;

        //Start counting the rounds and the wins of both user and computer!
        for (int round = 0; round < rounds; round++){
            print("\n \n----- ROUND " + (round+1) + " ------");
            userRPSchoice = getUserChoiceInput("Choose: 1 - Rock, 2 - Paper, 3- Scissors");
            int computerChoice = ((new Random()).nextInt(3))+ 1;
            int result = battle(Integer.parseInt(userRPSchoice), computerChoice);
            // choose the winner based on RESULT!
            if(result == 0){
                ties++;
            }else if (result == 1){
                userWins++;
            }else{
                computerWins++;
            }
        }
        //Printing the results!
        declaringTheWinner(ties, userWins, computerWins, rounds);
    }

    // Print out all the results!
    public static void declaringTheWinner(int ties, int userWins, int computerWins, int rounds){
        print("\nOut of the " + rounds + " rounds of Rock, Paper, Scissors. the winner is: ");
        if(userWins > computerWins){
            print("0o0o0o0o0o0o0o THE PLAYER! o0o0o0o0o0o0o0");
        } else if (computerWins > userWins){
            print("0o0o0o0o0o0o0o THE COMPUTER! o0o0o0o0o0o0o0");
        } else {
            print("Both PLAYER and COMPUTER are winners! (a Draw)");
        }
        print("\n---------------- SCORE BOARD -------------------- " +
                "\nTIES: " + ties +
                "\nPlayerWins: " + userWins +
                "\nComputerWins: " + computerWins+
                "\n--------------------------------------------------" );
    }

    // Determine the winner!
    public static int battle(int userRPCchoice, int computerChoice){
        if(userRPCchoice == computerChoice){
            print(" IT'S A TIE");
            return 0;
        } else if (
                (userRPCchoice == 2 && computerChoice == 1) ||
                        (userRPCchoice == 3 && computerChoice == 2) ||
                        (userRPCchoice == 1 && computerChoice == 3)){
            print("---> PLAYER WINS");
            return 1;
        } else{
            print("---> COMPUTER WINS");
            return 2;
        }
    }

    public static boolean askToPlayAgain(){
        String decision = getUserStringInput("Would you like to play again? (yes/no)");
        boolean valid = false;
        boolean finalDecision = false;
        do{
            if(decision.equalsIgnoreCase("no")){
                valid = true;
            } else if (decision.equalsIgnoreCase("yes")){
                finalDecision = true;
                valid = true;
            } else {
                decision =  getUserStringInput("Invalid answer. Would you like to play again?");
            }
        } while(!valid);
        return  finalDecision;
    }

    public static int getRoundsFromUser(){
        final int MAX_ROUNDS = 10;
        final int MIN_ROUNDS = 1;
        int userRounds = getUserIntInput("How many rounds of Rock, Paper, and Scissors do you want to have?");
        roundChecking(MAX_ROUNDS, MIN_ROUNDS, userRounds);
        return userRounds;
    }

    // Checks if the NUMBER OF ROUNDS chosen by the user fits the range!
    public static void  roundChecking(int max, int min, int userRounds){
            if((userRounds > max) || (userRounds < min)){
                print("Invalid Input. System closing");
                System.exit(0);
            }
    }

    public static int getUserIntInput(String message){
        print(message);
        Scanner getUserInput = new Scanner(System.in);
        String userStringInput = getUserInput.nextLine();
        boolean valid = false;
        do{
            try{
                Integer.parseInt(userStringInput);
                valid = true;
            } catch (Exception error){
                print("Invalid Input. Please try again!");
                print(message);
                userStringInput = getUserInput.nextLine();
            }
        } while(!valid);
        return Integer.parseInt(userStringInput);
    }

    public static String getUserChoiceInput(String message){
        print(message);
        String userChoice = new Scanner(System.in).nextLine();
        boolean valid = false;
        do{
            if(userChoice.isEmpty()){
                print("A choice must be made. Please try again");
                userChoice = new Scanner(System.in).nextLine();
            } else if (!(userChoice.equals("1") || userChoice.equals("2") || userChoice.equals("3"))){
                print("Invalid choice. Please choose between 1 to 3. (1 - Rock, 2 - Paper, 3- Scissors)");
                userChoice = new Scanner(System.in).nextLine();
            } else{
                valid = true;
            }
        }while(!valid);
        return userChoice;
    }

    public static String getUserStringInput(String message){
        print(message);
        String userChoice = new Scanner(System.in).nextLine();
        boolean valid = false;
        do{
            if(userChoice.isEmpty()){
                print("A choice must be made. Please try again");
                userChoice = new Scanner(System.in).nextLine();
            } else{
                valid = true;
            }
        }while(!valid);
        return userChoice;
    }

    public static void print(String message){
        System.out.println(message);
    }
}
