import java.util.*;
interface Operation {
    double apply(double a, double b);
}
class cal2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Simple Calculator");
        while (true) 
		{
            double num1 = 0, num2 = 0;
            char operator;
            Operation op = null;
            while (true) {
                try {
                    System.out.print("Enter first number: ");
                    num1 = sc.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.next();
                }
            }
            while (true) {
                try {
                    System.out.print("Enter second number: ");
                    num2 = sc.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.next();
                }
            }
            while (true) {
                System.out.print("Enter an operator (+, -, *, /): ");
                String input = sc.next();
                if (input.length() == 1) {
                    operator = input.charAt(0);
                    break;
                } else {
                    System.out.println("Invalid operator. Try again.");
                }
            }
            switch (operator) {
                case '+' -> op = (a, b) -> a + b;
                case '-' -> op = (a, b) -> a - b;
                case '*' -> op = (a, b) -> a * b;
                case '/' -> {
                    if (num2 == 0) {
                        System.out.println("Error: Cannot divide by zero.");
                        continue;
                    }
                    op = (a, b) -> a / b;
                }
                default -> {
                    System.out.println("Invalid operator.");
                    continue;
                }
            }
            if (op != null) {
                double result = op.apply(num1, num2);
                System.out.println("Result: " + result);
            }
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String choice = sc.next().toLowerCase();
            if (!choice.equals("yes") && !choice.equals("y")) {
                System.out.println("Exit");
                break;
            }
        }
        sc.close();
    }
}