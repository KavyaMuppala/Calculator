import java.util.*;
class FlexCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result = 0;
        boolean validFirstInput = false;
        List<Double> numbers = new ArrayList<>();
        while (!validFirstInput) {
            try {
                System.out.print("Enter the first number: ");
                result = Double.parseDouble(sc.next());
                numbers.add(result);
                validFirstInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid numeric value.");
            }
        }
        while (true) {
            System.out.print("Choose an operation (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            double nextNumber = 0;
            boolean validNextInput = false;
            while (!validNextInput) {
                try {
                    System.out.print("Enter the next number: ");
                    nextNumber = Double.parseDouble(sc.next());
                    numbers.add(nextNumber);
                    validNextInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please enter a valid numeric value.");
                }
            }
            switch (operator) {
                case '+':
                    result += nextNumber;
                    break;
                case '-':
                    result -= nextNumber;
                    break;
                case '*':
                    result *= nextNumber;
                    break;
                case '/':
                    if (nextNumber != 0) {
                        result /= nextNumber;
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                        numbers.remove(numbers.size() - 1);
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid operator. Please use +, -, *, or /.");
                    numbers.remove(numbers.size() - 1);
                    continue;
            }
            System.out.print("Do you want to enter another number? (yes/no): ");
            String response = sc.next().toLowerCase();
            if (!response.equals("yes")) {
                break;
            }
        }
        numbers.add(result);
        Collections.sort(numbers);
        List<Double> evenNumbers = new ArrayList<>();
        List<Double> oddNumbers = new ArrayList<>();
        for (double num : numbers) {
            if (num % 1 == 0) {
                if (((int) num) % 2 == 0) {
                    evenNumbers.add(num);
                } else {
                    oddNumbers.add(num);
                }
            }
        }
        System.out.println("Result: " + result);
        System.out.println("Sorted numbers including result: " + numbers);
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
        sc.close();
    }
}
