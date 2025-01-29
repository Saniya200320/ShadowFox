/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basictasks;

import java.util.Scanner;

public class EnhancedCalculator {

    // Function to perform basic arithmetic operations
    public static void basicOperations(Scanner scanner) {
        System.out.println("Choose operation: +, -, *, /");
        char operation = scanner.next().charAt(0);
        
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        switch (operation) {
            case '+':
                System.out.println("Result: " + (num1 + num2));
                break;
            case '-':
                System.out.println("Result: " + (num1 - num2));
                break;
            case '*':
                System.out.println("Result: " + (num1 * num2));
                break;
            case '/':
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid operation!");
        }
    }

    // Function for scientific calculations
    public static void scientificCalculations(Scanner scanner) {
        System.out.println("Choose operation: 1) Square Root  2) Exponentiation");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            System.out.print("Enter the number: ");
            double num = scanner.nextDouble();
            System.out.println("Square Root: " + Math.sqrt(num));
        } else if (choice == 2) {
            System.out.print("Enter the base: ");
            double base = scanner.nextDouble();
            System.out.print("Enter the exponent: ");
            double exponent = scanner.nextDouble();
            System.out.println("Result: " + Math.pow(base, exponent));
        } else {
            System.out.println("Invalid choice!");
        }
    }

    // Function for unit conversions
    public static void unitConversions(Scanner scanner) {
        System.out.println("Choose conversion: 1) Temperature  2) Currency");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            System.out.println("Convert: 1) Celsius to Fahrenheit  2) Fahrenheit to Celsius");
            int tempChoice = scanner.nextInt();
            
            System.out.print("Enter the temperature: ");
            double temp = scanner.nextDouble();
            
            if (tempChoice == 1) {
                System.out.println("Result: " + ((temp * 9 / 5) + 32) + " °F");
            } else if (tempChoice == 2) {
                System.out.println("Result: " + ((temp - 32) * 5 / 9) + " °C");
            } else {
                System.out.println("Invalid choice!");
            }
        } else if (choice == 2) {
            System.out.println("Convert: 1) USD to INR  2) INR to USD");
            int currencyChoice = scanner.nextInt();
            
            System.out.print("Enter the amount: ");
            double amount = scanner.nextDouble();
            
            if (currencyChoice == 1) {
                System.out.println("Result: ₹" + (amount * 74.85));  // Example rate: 1 USD = 74.85 INR
            } else if (currencyChoice == 2) {
                System.out.println("Result: $" + (amount / 74.85));
            } else {
                System.out.println("Invalid choice!");
            }
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nEnhanced Calculator");
            System.out.println("1) Basic Operations");
            System.out.println("2) Scientific Calculations");
            System.out.println("3) Unit Conversions");
            System.out.println("4) Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    basicOperations(scanner);
                    break;
                case 2:
                    scientificCalculations(scanner);
                    break;
                case 3:
                    unitConversions(scanner);
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        
        scanner.close();
    }
}
