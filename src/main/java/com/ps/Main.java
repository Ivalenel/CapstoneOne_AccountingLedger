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

            do{
                System.out.println("Please Enter Option");
                System.out.println("1- Display All");
                System.out.println("2- Display Deposits");
                System.out.println("3- Display Payments");
                System.out.println("4- Reports");
                System.out.println("Search By Vendor");

                System.out.println("0- Home Page");
                System.out.println("Command: ");

                subMenuCommand = commnandScanner.nextInt();

                switch(subMenuCommand){
                    case 1:
                        displayAll();
                        break;
                    case 2:
                        displayDeposits();
                        break;
                    case 3:
                        displayPayments();
                        break;
                    case 4:
                        displayReports();
                        break;
                    case 5:
                        searchByVendor();
                        break;

                }
            } while (subMenuCommand != 0);
        }
        public static void displayAll(){
            System.out.println("Display All");
        }
        public static void displayDeposits(){
            System.out.println("Display Deposits");
        }
        public static void displayPayments(){
            System.out.println("Display Payments");
        }
        public static void displayReports(){
            System.out.println("Placeholder: Reports");
        }
        public static void searchByVendor(){
            System.out.println("Search By Vendor");
        }

    }

