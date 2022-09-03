// Tiffany Truong
// CS 1400.04-1
// Project 1 Lab 3
// April 17, 2022
package project1lab3;

import java.util.Scanner;
import java.util.Random;
public class RockPaperScissorsGame {

    public static Scanner scnr = new Scanner (System.in);
    public static void main(String[] args) { // main method to play the game and allows user to play again if he/she wants
        play();
        while (playAgain()){
            play();
        }
    }
    
    public static void play(){ // method to call the computer and user's choice and determine who wins 
        String computer = computerChoice();
        String user = userChoice();
        determineWinner(user, computer);
    }
    
    public static String userChoice(){ // method to get user's choice of rock, paper, or scissors and calls the isValidChoice method
        String user;
        String lower_case_user;
        System.out.print("Make your move! Please enter rock, paper, or scissors: "); 
        user = scnr.nextLine();
        lower_case_user = user.toLowerCase();
        while (!isValidChoice(lower_case_user)) {
            System.out.print("Invalid input!  Please enter rock, paper, or scissors: ");
            user = scnr.nextLine();
            lower_case_user = user.toLowerCase();
        }
        return lower_case_user;
    }
    
    public static boolean isValidChoice(String choice){ // method to check if the user's input is valid, if not would ask user for input again till valid
        boolean check;
        if (choice.equals("rock") || choice.equals("paper") || choice.equals("scissors")) {
            check = true;
        }
        else {
            check = false;
        }
        return check;
    }
        
    public static String computerChoice(){ // method to get computer's choice of rock, paper, scissors at random 
        Random rand = new Random(); 
        int rand_num = rand.nextInt(3) + 1; 
        String computer; 
        if (rand_num == 1) {
            computer = "rock";
        }
        else if (rand_num == 2) {
            computer = "paper";
        }
        else {
            computer = "scissors";
        }
        return computer;
    }
    
    public static boolean playAgain(){ // method to see if user would like to play again 
        System.out.print("Would you like to play again? (y/n) ");
        String userinput = scnr.nextLine();
        if (userinput.equals("y") || userinput.equals("Y") ){
            return true;
        }
        else if (userinput.equals("n") || userinput.equals("N")) {
            System.out.println("Thank you for playing the game!");
            return false;
        }
        else {
            System.out.println("Invalid input! Only enter y or n.");
            return playAgain();
        }
    }
    
    public static void determineWinner(String computer, String user) { //  method to determine who is the winner, computer or user
        System.out.println("The computer chose " + computer + "!");
        System.out.println("Your Choice: " + user);
        if (user.equals("rock") && computer.equals("paper")) {
            System.out.println("Computer wins!");
        } 
        if (user.equals("paper") && computer.equals("scissors")) {
            System.out.println("Computer wins!");
        }
        if (user.equals("scissors") && computer.equals("rock")) {
            System.out.println("Computer wins!");
        }
        if (user.equals("rock") && computer.equals("scissors")){
            System.out.println("You win!");
        }
        if (user.equals("paper") && computer.equals("rock")){
            System.out.println("You win!");
        }
        if (user.equals("scissors") && computer.equals("paper")){
            System.out.println("You win!");
        }
        else if (computer.equals(user)){ // if the user and computer ends up with the same choice, play the game again until either the user or computer wins
           System.out.println("Tie!");
           play();
        }
    }
}