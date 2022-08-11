package javaBasicsExercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Factorizer {
    public static void main(String[] args) {
        int userInputInitial = getUserInputInt("Please enter a whole number to factor");
        getFactors(userInputInitial);
    }

    public static void getFactors(int userInput){
        if (userInput == 0){
            println("0 has no factors!");
            return;
        }
        ArrayList<Integer> factorsArray = new ArrayList<Integer>();
        factorsArray.add(1);
        int factor = 2;
        while(factor < (userInput/2) && ((!factorsArray.contains(factor)))){
            if(userInput%factor == 0){
                factorsArray.add(factor);
                if(factor !=(userInput/factor) ){
                    factorsArray.add((userInput/factor));
                }
            }
            factor++;
        }
        int sumOfAllFactors = factorsArray.stream().mapToInt(i -> i).sum();

        println("the factors of " + userInput + " are:");
        for(int i = 0; i < factorsArray.size(); i++){
            System.out.print(factorsArray.get(i) + " ");
        }
        System.out.println(userInput);

        println(userInput + " has " + (factorsArray.size()+1) + " factors");
        if(sumOfAllFactors == userInput){
            println(userInput + " is a perfect number");
        }
        if(factorsArray.size()>1){
            println(userInput + " is not a prime number");
        }


    }

    public static int getUserInputInt(String question){
        String userInput = getUserInput(question);
        int valueInt;
        boolean verifiedInt = false;
        do {
            try {
                Integer.parseInt(userInput);
                verifiedInt = true;
            } catch (Exception error) {
                println("Couldn't parse input, please try again");
                userInput = getUserInput(question);
            }
        } while (!verifiedInt);
        return Integer.parseInt(userInput);
    }

    public static String getUserInput(String message){
        println(message);
        String userIntInputInitial = new Scanner(System.in).nextLine();
        return userIntInputInitial;
    }
    public static void println(String message){
        System.out.println(message);
    }
}
