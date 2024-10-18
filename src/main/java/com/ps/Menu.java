package com.ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    public class Menu {

        static Scanner commnandScanner = new Scanner(System.in);
        static Scanner inputScanner = new Scanner(System.in);
        static ArrayList<Transaction> allTransactions = new ArrayList<>();

        public static void main(String[] args) {
            allReports();

            int mainMenuCommand;

            do {
                System.out.println("Please Select Option");
                System.out.println("1- Add Deposit");
                System.out.println("2- Make Payment");
                System.out.println("3- Ledger");

                System.out.println("0-Exit");
                System.out.println("Command: ");

                try {
                    mainMenuCommand = commnandScanner.nextInt();
                } catch (InputMismatchException ime) {
                    mainMenuCommand = 0;
                }
                switch (mainMenuCommand) {
                    case 1:
                        addDeposit();
                        break;
                    case 2:
                        makePayment();
                        break;
                    case 3:
                        displaySubMenu();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Command not found, please try again");
                }
            } while (mainMenuCommand != 0);
        }

        public static void allReports() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("transactions.csv"));
                String firstLine = bufferedReader.readLine();
                String input;
                while ((input = bufferedReader.readLine()) != null) {
                    String[] transactionsArr = input.split("\\|");

                    String dateOfArrival = transactionsArr[0];
                    String timeOfArrival = transactionsArr[1];
                    String description = transactionsArr[2];
                    String vendor = transactionsArr[3];
                    String amount = transactionsArr[4];
                    allTransactions.add(new Transaction(dateOfArrival, timeOfArrival, description, vendor, amount));
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void addDeposit() {
            System.out.println("Add Deposit");
            System.out.println("Please enter deposit details...");

            System.out.print("Date: ");
            String date = inputScanner.nextLine();

            System.out.println("Time: ");
            String time = inputScanner.nextLine();

            System.out.println("Descripton: ");
            String description = inputScanner.nextLine();

            System.out.println("Vendor: ");
            String vendor = inputScanner.nextLine();

            System.out.println("Amount: ");
            String amount = inputScanner.nextLine();

            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");

            String formattedDate = currentDateTime.format(dateFormatter);
            String formattedTime = currentDateTime.format(timeFormatter);
            Transaction transaction = new Transaction(formattedDate, formattedTime, description, vendor, amount);
            allTransactions.add(transaction);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transactions.csv", true));
                bufferedWriter.write(String.format("\n%s|%s|%s|%s|%s",
                        formattedDate,
                        formattedTime,
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount()
                ));
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public static void makePayment() {
            System.out.println("Make Payment");
            System.out.println("Please enter payment details...");

            System.out.print("Date: ");
            String date = inputScanner.nextLine();

            System.out.println("Time: ");
            String time = inputScanner.nextLine();

            System.out.println("Descripton: ");
            String description = inputScanner.nextLine();

            System.out.println("Vendor: ");
            String vendor = inputScanner.nextLine();

            System.out.println("Amount: ");
            String amount = inputScanner.nextLine();

            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");

            String formattedDate = currentDateTime.format(dateFormatter);
            String formattedTime = currentDateTime.format(timeFormatter);
            Transaction transaction = new Transaction(formattedDate, formattedTime, description, vendor, amount);
            allTransactions.add(transaction);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transactions.csv", true));
                bufferedWriter.write(String.format("\n%s|%s|%s|%s|%s",
                        formattedDate,
                        formattedTime,
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount()
                ));
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        public static void displaySubMenu() {
            int subMenuCommand;

            do {
                System.out.println("Please Enter Option");
                System.out.println("1- Display All");
                System.out.println("2- Display Deposits");
                System.out.println("3- Display Payments");
                System.out.println("4- Reports");
                System.out.println("5-Search By Vendor");

                System.out.println("0- Home Page");
                System.out.println("Command: ");


                subMenuCommand = commnandScanner.nextInt();

                switch (subMenuCommand) {
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
                        displayVendors();
                        break;

                }
            } while (subMenuCommand != 0);
        }

        private static void displayVendors() {
            System.out.println("Search By Vendor");

            System.out.println("Please provide the vendor name you're looking for...");
            System.out.print("Name: ");
            String nameToSearch = inputScanner.nextLine();

            for (int i = 0; i < allTransactions.size(); i++) {
                Transaction currentTransaction = allTransactions.get(i);
                if (currentTransaction.getVendor().equalsIgnoreCase(nameToSearch)) {
                    System.out.println(currentTransaction);
                }
            }
        }

        public static void displayAll() {
            for (int i = allTransactions.size() - 1; i >= 0; i--) {
                Transaction transaction = allTransactions.get(i);
                System.out.println(transaction);
            }
        }

        public static void displayDeposits() {
            for (int i = allTransactions.size() - 1; i >= 0; i--) {
                Transaction transaction = allTransactions.get(i);
                if (transaction != null) {
                    try {
                        double amount = Double.parseDouble(transaction.getAmount());
                        if (amount < 0) {
                            System.out.println(transaction);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount: " + transaction.getAmount());
                    }
                }
            }

        }

        public static void displayPayments() {
            for (int i = allTransactions.size() - 1; i >= 0; i--) {
                Transaction transaction = allTransactions.get(i);
                if (transaction != null) {
                    try {
                        double amount = Double.parseDouble(transaction.getAmount());
                        if (amount > 0) {
                            System.out.println(transaction);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount: " + transaction.getAmount());
                    }
                }
            }

        }


        public static void displayReports() {
            int reportMenuCommand = 0;

            do {
                System.out.println("Please Select Report");
                System.out.println("1- Month to Date");
                System.out.println("2- Year to Date");
                System.out.println("0- Back");
                System.out.println("Command: ");

                switch (reportMenuCommand) {
                    case 1:
                        monthToDate();
                        break;
                    case 2:
                        yearToDate();
                        break;
                }
            } while (reportMenuCommand != 0);

        }

        private static void yearToDate() {
        }

        public static void monthToDate() {
            //          LocalDate today = LocalDate.now();
            //int currentMonth = today.getMonthValue();
            //int currentYear = today.getYear();

            //for (int i = 0; i < allTransactions.size(); i++) {
            //    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //    String tranDate = allTransactions.get(i).getDate();
            //  LocalDate localDate = LocalDate.parse(tranDate, dateFormatter);
            //int transMonth = localDate.getMonthValue();
            //int year = localDate.getYear();
            //if (currentMonth == transMonth && currentYear == year) {
            //        System.out.println(allTransactions.get(i));
                }
            }

