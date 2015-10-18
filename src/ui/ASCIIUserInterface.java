package ui;

import controller.Controller;
import domain.execution.ToyExecutionException;
import domain.expressions.ArithmeticExpression;
import domain.expressions.ConstantExpression;
import domain.expressions.Expression;
import domain.expressions.VariableExpression;
import domain.statements.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

/**
 * ASCII user interface for the interpreter.
 */
public class ASCIIUserInterface {

    private final boolean fromFile;
    private Controller controller;
    private Scanner keyboard;

    /**
     * Creates a ASCIIUserInterface for a controller.
     *
     * @param controller reference to a Controller.
     */
    public ASCIIUserInterface(Controller controller) {
        this.controller = controller;
        keyboard = new Scanner(System.in);
        fromFile = false;
    }

    /**
     * Creates a ASCIIUserInterface for a controller. It will get the input from a file.
     *
     * @param controller reference to a Controller.
     * @param fileName   name of the input file.
     * @throws FileNotFoundException when a file with the fileName given is not found.
     */
    public ASCIIUserInterface(Controller controller, String fileName) throws FileNotFoundException {
        this.controller = controller;
        File inputFile = new File(fileName);
        keyboard = new Scanner(inputFile);
        fromFile = true;
    }

    /**
     * Launches the user interface.
     */
    public void run() {
        while (true) {
            printMainMenu();
            System.out.print("Menu entry: ");
            try {
                int choice = keyboard.nextInt();
                keyboard.nextLine();
                if (fromFile)
                    System.out.println(Integer.toString(choice));
                switch (choice) {
                    case 0:
                        return;
                    case 1:
                        loadProgram();
                        break;
                    case 2:
                        executeProgram();
                        break;
                    case 3:
                        toggleDebugFlag();
                        break;
                    default:
                        throw new InvalidInputException("Choice " + Integer.toString(choice) + " is invalid");
                }
            } catch (InvalidInputException e) {
                System.out.println("InvalidInputException: " + e.getMessage());
            }
        }
    }

    private void toggleDebugFlag() {
        System.out.println("Debug flag is set to " + Boolean.toString(controller.isDebug()));
        while (true) {
            System.out.print("New value (true, false): ");
            try {
                String choice = keyboard.nextLine();
                if (Objects.equals(choice, "true")) {
                    controller.setDebug(true);
                    System.out.println("Debug flag is set to true.");
                    return;
                }
                if (Objects.equals(choice, "false")) {
                    controller.setDebug(false);
                    System.out.println("Debug flag is set to false.");
                    return;
                }
                throw new InvalidInputException("Enter 'true' or 'false'!");
            } catch (InvalidInputException e) {
                System.out.println("InvalidInputException: " + e.getMessage());
            }
        }
    }

    private void executeProgram() {
        try {
            //noinspection InfiniteLoopStatement
            while (true) {
                controller.execute();
                System.out.println(controller.getCurrentProgram());
            }
        } catch (ToyExecutionException e) {
            System.out.println("ToyExecutionException: " + e.getMessage());
        }
    }

    private void loadProgram() {
        IStatement program = newStatement();
        controller.loadProgram(program);
    }

    private IStatement newStatement() {
        while (true) {
            printStatementMenu();
            System.out.print("Enter choice: ");
            try {
                int choice = keyboard.nextInt();
                keyboard.nextLine();
                if (fromFile)
                    System.out.println(Integer.toString(choice));
                if (choice == 1) {
                    System.out.println("First Statement:");
                    IStatement first = newStatement();
                    System.out.println("Second Statement:");
                    IStatement second = newStatement();
                    return new CompoundStatement(first, second);
                }
                if (choice == 2) {
                    System.out.print("Variable name: ");
                    String name = keyboard.nextLine();
                    if (fromFile)
                        System.out.println(name);
                    System.out.println("Assigned value: ");
                    Expression value = newExpression();
                    return new AssignStatement(name, value);
                }
                if (choice == 3) {
                    System.out.println("Expression: ");
                    Expression expression = newExpression();
                    return new PrintStatement(expression);
                }
                if (choice == 4) {
                    System.out.println("Condition: ");
                    Expression condition = newExpression();
                    System.out.println("Then branch: ");
                    IStatement thenStatement = newStatement();
                    System.out.println("Else branch: ");
                    IStatement elseStatement = newStatement();
                    return new IfStatement(condition, thenStatement, elseStatement);
                }
                throw new InvalidInputException("Choice " + Integer.toString(choice) + " is invalid!");
            } catch (InvalidInputException e) {
                System.out.println("InvalidInputException: " + e.getMessage());
            }
        }
    }

    private Expression newExpression() {
        while (true) {
            printExpressionMenu();
            System.out.print("Enter choice: ");
            try {
                int choice = keyboard.nextInt();
                keyboard.nextLine();
                if (fromFile)
                    System.out.println(Integer.toString(choice));
                if (choice == 1) {
                    System.out.print("Enter operator (+, -, *): ");
                    String operator = keyboard.nextLine();
                    if (fromFile)
                        System.out.println(operator);
                    System.out.println("Left Expression: ");
                    Expression left = newExpression();
                    System.out.println("Right Expression: ");
                    Expression right = newExpression();
                    return new ArithmeticExpression(left, right, operator);
                }
                if (choice == 2) {
                    System.out.print("Enter constant value: ");
                    int value = keyboard.nextInt();
                    keyboard.nextLine();
                    if (fromFile)
                        System.out.println(Integer.toString(value));
                    return new ConstantExpression(value);
                }
                if (choice == 3) {
                    System.out.print("Enter variable name: ");
                    String name = keyboard.nextLine();
                    if (fromFile)
                        System.out.println(name);
                    return new VariableExpression(name);
                }
                throw new InvalidInputException("Choice " + Integer.toString(choice) + " is invalid!");
            } catch (InvalidInputException e) {
                System.out.println("InvalidInputException: " + e.getMessage());
            }
        }
    }

    private void printExpressionMenu() {
        System.out.println("1. Arithmetic Expression\n" +
                "2. Constant Expression\n" +
                "3. Variable Expression\n");
    }

    private void printStatementMenu() {
        System.out.println("1. Compound Statement\n" +
                "2. Assign Statement\n" +
                "3. Print Statement\n" +
                "4. If Statement\n");
    }

    private void printMainMenu() {
        System.out.println("1. Load Program\n" +
                "2. Execute Program\n" +
                "3. Toggle debug flag\n" +
                "0. Exit\n");
    }
}
