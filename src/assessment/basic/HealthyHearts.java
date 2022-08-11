/*
 * ASSESSMENT: BASIC PROGRAMMING CONCEPTS
 * HealthyHearts
 * @author Annelyn McCormick
 */
package assessment.basic;

import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        int age = getUserIntInput("What is your age?");
        heartAgeCalculation(age);
    }

    // Simple heart rate calculation!
    public static void heartAgeCalculation(int userAge){
        int maximumHeartRate = 220 - userAge;
        int minimumTargetZone = (int)(maximumHeartRate*0.5);
        int maximumTargetZone = (int)(maximumHeartRate*0.85);
        print("Your maximum heart rate should be " + maximumHeartRate+" beats per minute\n" +
                "Your target HR Zone is " + minimumTargetZone+ " - " +maximumTargetZone +" beats per minute");
    }

    // Gets a valid integer from user! A whole positive number will be returned!
    // 0 is also not accepted
    public static int getUserIntInput(String message){
        print(message);
        Scanner getUserInput = new Scanner(System.in);
        String userStringInput = getUserInput.nextLine();
        boolean valid = false;
        do{
            try{
                Integer.parseInt(userStringInput);
                if(Integer.parseInt(userStringInput) < 1){
                    print("Invalid Input. Only Positive Whole numbers are accepted. Please try again!");
                    userStringInput = getUserInput.nextLine();
                    valid = false;
                } else {
                    valid = true;
                }
            } catch (Exception error){
                print("Invalid Input. Please try again!");
                print(message);
                userStringInput = getUserInput.nextLine();
            }
        } while(!valid);
        return Integer.parseInt(userStringInput);
    }

    public static void print(String message){
        System.out.println(message);
    }
}
