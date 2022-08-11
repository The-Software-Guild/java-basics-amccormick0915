/*
 * ASSESSMENT: BASIC PROGRAMMING CONCEPTS
 * DogGenetics
 * @author Annelyn McCormick
 */
package assessment.basic;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    public static void main(String[] args) {
        String dogName = getUserStringInput(
                "What is your dog's name?",
                "Invalid Input, an empty name is not allowed. Please try again");

        print("Well then, I have this highly reliable report on " +
                dogName + "'s prestigious background right here. \n\n" +
                dogName + " is:\n");

        // Dog Breed Analysis Begins!
        randomiseBreed();
        print("Wow, that's QUITE the dog! ");
    }

    //Randomises dog breed
    public static void randomiseBreed(){
        final int MAXIMUM_DOGBREEDS = 5;
        int dogBreedPercentage = 100;
        // A dog breed list that can be populated!
        // and 5 unique dog breeds will be chosen from this list!
        String[] dogBreedsList = {
                "Bulldog",
                "Pomeranian",
                "Pug",
                "Great Dane",
                "French Bulldog",
                "Poodle",
                "Siberian Husky",
                "Golden Retriever",
                "Yorkshire Terrier",
                "Chihuahua",
                "Border Collie",
                "Doberman",
                "Boxer",
                "Afghan Hound",
                "Chow Chow"
        };

        // ArrayList for checking which dog breeds have been
        // randomly chosen and printed for in the report
        ArrayList<String> chosenDogBreeds = new ArrayList<>();
        int randomDogBreedPercentage;
        String randomDogBreed;

        for(int round = 0; round <  MAXIMUM_DOGBREEDS; round++){

            // Get a random percentage from 1-100%
            // if the remaining percentage of a dog's DNA analysis is 0,
            // We CANNOT USE RANDOM  so set the Dog Breed Percentage as 0 instead of randomising!
            randomDogBreedPercentage =  (dogBreedPercentage != 0) ? ((new Random()).nextInt(dogBreedPercentage)+1)
                    : 0;

            // if it's the last round (Dog Breed Chosen), and we have yet to achieve 100% in
            // analysing the USER'S DOG'S DNA, then use the remaining
            // percentage for the last breed chosen
            if(round == (MAXIMUM_DOGBREEDS - 1)){
                randomDogBreedPercentage = dogBreedPercentage;
            }

            // Get a random dog breed from the DogBreeds list!
            randomDogBreed = dogBreedsList[((new Random()).nextInt(dogBreedsList.length))];

            // iIf the breed HAS been chosen previously, then randomise dog breed again
            while(chosenDogBreeds.contains(randomDogBreed) ){
                randomDogBreed = dogBreedsList[((new Random()).nextInt(dogBreedsList.length))];
            }
            // Add the new dog breed into the ALREADY CHOSEN dog breeds list
            chosenDogBreeds.add(randomDogBreed);

            print("" + randomDogBreedPercentage + "% " + randomDogBreed );

            // Recalculate remaining percentage of USER'S DOG'S ancestry!
            dogBreedPercentage = dogBreedPercentage - randomDogBreedPercentage;
        }

    }

    // Get a validated string from user
    public static String getUserStringInput(String question, String invalidMessage){
        print(question);
        String userInitialInput = (new Scanner(System.in)).nextLine();
        // Asks for user String input until the String is NOT EMPTY!
        while(userInitialInput.isEmpty() || userInitialInput.isBlank() ){
            print(invalidMessage);
            userInitialInput = (new Scanner(System.in)).nextLine();
        }
        return userInitialInput;
    }

    public static void print(String message){
        System.out.println(message);
    }
}
