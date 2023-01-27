package sdf;
// import java.util.Scanner;
import java.util.Scanner;

// Create a class called Task02
public class Task02{
    // Create a main method
    public  void CALCULATOR() {
        try {
            // Create a boolean variable called islast this determines if the last result is
            // present or not
            boolean islast = false;
            // last result will store the last result
            double last_result = 0;
            // Create a scanner object
            Scanner scanner = new Scanner(System.in);
            // Create a while loop
            while (true) {
                // Print "> "
                System.out.print("> ");
                // Create a string variable called input and store the user input
                String input = scanner.nextLine();
                // If the input is "exit" then print "Bye bye" and break the loop
                if (input.equals("exit")) {
                    System.out.println("Bye bye");
                    break;
                }
                // checking if there is a last result
                if (islast) {
                    // if there is a last result then replace $last with the last result
                    // replace $last with the last result2 + 5
                    input = input.replace("$last", String.valueOf(last_result));
                }
                // split the input three parts
                String[] parts = input.split(" ");
                // if the length of the parts is not 3 then print "Please enter a valid input"
                if (parts.length != 3) {
                    System.out.println(
                            "Please enter a valid input e-g 2 + 3, there must be a space between each number and operator");
                    continue;
                }
                // Create two double variables called num1 and num2 and store the first and
                // second number entered
                double num1 = 0, num2 = 0;
                // if the first part is $last then set num1 to the last result
                if (parts[0].equals("$last")) {
                    if (islast == false) {
                        System.out.println(
                                "the calculator does not have a last result, please enter a valid input e-g 2 + 3, there must be a space between each number and operator");
                        continue;
                    }
                    num1 = last_result;
                }
                // else set num1 to the first part
                else {
                    num1 = Double.parseDouble(parts[0]);
                }
                // if the second part is $last then set num2 to the last result
                if (parts[2].equals("$last")) {
                    if (islast == false) {
                        System.out.println(
                                "the calculator does not have a last result, please enter a valid input e-g 2 + 3, there must be a space between each number and operator");
                        continue;
                    }
                    num2 = last_result;
                }
                // else set num2 to the second part
                else {
                    num2 = Double.parseDouble(parts[2]);
                }
                // Create a string variable called operator and store the operator
                String operator = parts[1];
                // Create a double variable called result and store the result of the operation
                double result = 0;
                // Create a switch case for the operator
                switch (operator) {
                    // if the operator is + then add num1 and num2 and store the result in result
                    case "+":
                        result = num1 + num2;
                        break;
                    // if the operator is - then subtract num1 and num2 and store the result in
                    // result variable
                    case "-":
                        result = num1 - num2;
                        break;
                    // if the operator is * then multiply num1 and num2 and store the result in
                    // result variable
                    case "*":
                        result = num1 * num2;
                        break;
                    // if the operator is / then divide num1 and num2 and store the result in result
                    case "/":
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("Please enter a valid operator.");
                        continue;
                }
                // set the last result to the result
                last_result = result;
                // set islast to true
                islast = true;

                System.out.format("Result: %.2f", result);
                // insert a new line
                System.out.println();
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(
                    "Please enter a valid input e-g 2 + 3, there must be a space between each number and operator.");
            System.out.println("If you want to use the last result write $last.");
            //CALL CALCULATOR
            CALCULATOR();
        }
    }
    public static void main(String[] args) {
        Task02 t = new Task02();
        System.out.println("Welcome.");
        t.CALCULATOR();
    }
}