package com.ps;

import java.util.InputMismatchException;
import java.util.Scanner;

    public class Main {

        static Scanner commnandScanner = new Scanner(System.in);
        static Scanner inputScanner = new Scanner(System.in);
        public static void main(String[] args) {
            int mainMenuCommand;

            do{
                System.out.println("Please Select Option");
                System.out.println("1- Add Deposit");
                System.out.println("2- Make Payment");
                System.out.println("3- Ledger");

                System.out.println("0-Exit");
                System.out.println("Command: ");

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
        public static void addDeposit(){
            System.out.println("Command for Adding Deposit");
        }
        public static void displaySubMenu(){
            int subMenuCommand;

            //All
            //Deposits
            //Payments
            //Reports - custom search
            //Back

            do{
                System.out.println("Please Enter Option");
                System.out.println("1- Display All");
                System.out.println("2- Display Deposits");
                System.out.println("3- Display Payments");
                System.out.println("4- Display Reports");

                System.out.println("0- Back");
                System.out.println("Command: ");

                subMenuCommand = commnandScanner.nextInt();




            } while (subMenuCommand != 0);
        }
    }

