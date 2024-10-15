package com.ps;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner commnandScanner = new Scanner(System.in);
    static Scanner inputScanner = new Scanner(System.in);
    public static void main(String[] args) {
     int mainMenuCommand;

     ///***** Home ******
        //        //Add deposit
        //        //Make Payment
        //        //Lerger
        //        //Exit
        //        //Leger
     do{
         System.out.println("Please Select Option");
         System.out.println("1- Add Deposit");
         System.out.println("2- Make Payment");
         System.out.println("3-Ledger");
         System.out.println("0-Exit");
         System.out.println("Command");

         try {
           mainMenuCommand = commnandScanner.nextInt();
         } catch(InputMismatchException ime){
             mainMenuCommand = 0;
         }
        switch (mainMenuCommand){
             case 1:
                 addDeposit();
                 break;
            case 2:
                makePayment();
                break;
            case 3:
                displaySubMenu();
                break;
            default:
                System.out.println("Command not found, please try again");
        }
     }while(mainMenuCommand !=0);


    }
}