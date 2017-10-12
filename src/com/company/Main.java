package com.company;

/* Program RainFallCalculator
*  Zoubeida Triki,
*  October 12th, 2017
*/

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String userInput = "";

        do {

            //get the roof width and length from the user
            double length = 0.0;
            double width = 0.0;
            System.out.println("Enter the dimension of the footprint of the roof.");
            System.out.println("Enter the width of the roof (in feet): ");
            width = keyboard.nextDouble();
            keyboard.nextLine();

            System.out.println("Enter the length of the roof (in feet): ");
            length = keyboard.nextDouble();
            keyboard.nextLine();

            //get the rainfall from the user
            System.out.println("Enter the rainfall amount: ");
            double rainfall = keyboard.nextDouble();
            keyboard.nextLine();

            //convert the dimensions of the footprint to inches: multiply length by 12 and width by 12
            double widthInInches = width * 12;
            double lengthInInches = length * 12;
            double RoofFootprint = getArea(widthInInches, lengthInInches);

            //multiply the roof dimensions by the inches of rain fall
            //multiply length* width* rainfall store in ranoffInInches
            double ranoffInInches = RoofFootprint * rainfall;

            //divide the ranoffInInches by 231 to get runoffInGallons:
            double runoffInGallons = convertInchestoGallons(ranoffInInches);
            // rount the result
            runoffInGallons = Math.round(runoffInGallons * 100.0) / 100.0;

            //display the results to the user
            System.out.println("The ranoff is: " + runoffInGallons + " gallons");

            // ask the user if he wants to continue
            System.out.println("\nDo you want to want to perform another calculation (Y/N)?");
             userInput = keyboard.next();
             if((userInput.equalsIgnoreCase("n")) == false && (userInput.equalsIgnoreCase("Y") == false)){
                 System.out.println("Invalid option. quiting the program.");
                 userInput = "n";
             }
        }while (!userInput.equalsIgnoreCase("n"));


   }

   public static double getArea(double length, double width) {
        return length * width;
    }

    public static double convertInchestoGallons(double valueInInches){
        return valueInInches/231;
    }
}
