/*
 * ASSESSMENT: BASIC PROGRAMMING CONCEPTS
 * SummativeSums
 * @author Annelyn McCormick
 */
package assessment.basic;

public class SummativeSums {
    public static void main(String[] args) {
        // Provide the integer array here!
        int[][] arrayList = {
                { 1, 90, -33, -55, 67, -16, 28, -55, 15 },
                { 999, -60, -77, 14, 160, 301 },
                { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 }
        };

        // Sum all Inner Array Values! and print result!
        sumAllArrays(arrayList, arrayList.length);
    }

    public static void sumAllArrays(int[][] arrayList, int arrayListSize){
        // Nested for loop that goes through a 2D array and summing all elements
        //  of each inner array!
        for(int arrayNumber = 0; arrayNumber < arrayListSize; arrayNumber++){
            int sumOfArrayChosen = 0;
            int arrayChosenSize = arrayList[arrayNumber].length;
            // Inner Array Calculation
            for(int arrayIndex = 0; arrayIndex < arrayChosenSize; arrayIndex++ ){
                sumOfArrayChosen += arrayList[arrayNumber][arrayIndex];
            }
            // RESULT PRINTING
            print("#"+ (arrayNumber+1)+ " Array Sum: "+sumOfArrayChosen);
        }
    }
    // Print method seemingly like Python
    public static void print(String message){
        System.out.println(message);
    }
}
