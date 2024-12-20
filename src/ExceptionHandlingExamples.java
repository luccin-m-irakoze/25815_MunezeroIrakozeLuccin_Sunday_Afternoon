import java.io.*;
import java.sql.*;
import java.util.*;

public class ExceptionHandlingExamples {

    public static void main(String[] args) {
// Call each method to demonstrate exception handling
        handleIOException();
        handleFileNotFoundException();
        handleEOFException();
        handleSQLException();
        handleClassNotFoundException();

        handleArithmeticException();
        handleNullPointerException();
        handleArrayIndexOutOfBoundsException();
        handleClassCastException();
        handleIllegalArgumentException();
        handleNumberFormatException();
    }

    // 1. IOException Example
    private static void handleIOException() {
        System.out.println("1. Handling IOException:");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("nonexistent.txt"));
            reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException caught: File could not be read.");
        }
    }

    // 2. FileNotFoundException Example
    private static void handleFileNotFoundException() {
        System.out.println("\n2. Handling FileNotFoundException:");
        try {
            FileInputStream file = new FileInputStream("nonexistent.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: File does not exist.");
        }
    }

    // 3. EOFException Example
    private static void handleEOFException() {
        System.out.println("\n3. Handling EOFException:");
        try (DataInputStream dis = new DataInputStream(new FileInputStream("test.txt"))) {
            while (true) {
                dis.readByte(); // Reading beyond EOF causes EOFException
            }
        } catch (EOFException e) {
            System.out.println("EOFException caught: End of file reached.");
        } catch (IOException e) {
            System.out.println("IOException caught: Error reading file.");
        }
    }

    // 4. SQLException Example
    private static void handleSQLException() {
        System.out.println("\n4. Handling SQLException:");
        try {
            Connection connection = DriverManager.getConnection("jdbc:invalid_url", "user", "password");
        } catch (SQLException e) {
            System.out.println("SQLException caught: Database connection failed.");
        }
    }

    // 5. ClassNotFoundException Example
    private static void handleClassNotFoundException() {
        System.out.println("\n5. Handling ClassNotFoundException:");
        try {
            Class.forName("com.nonexistent.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: Class not found at runtime.");
        }
    }

    // 6. ArithmeticException Example
    private static void handleArithmeticException() {
        System.out.println("\n6. Handling ArithmeticException:");
        try {
            int result = 10 / 0; // Division by zero
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: Cannot divide by zero.");
        }
    }

    // 7. NullPointerException Example
    private static void handleNullPointerException() {
        System.out.println("\n7. Handling NullPointerException:");
        try {
            String str = null;
            System.out.println(str.length()); // Accessing null reference
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: Null reference access.");
        }
    }

    // 8. ArrayIndexOutOfBoundsException Example
    private static void handleArrayIndexOutOfBoundsException() {
        System.out.println("\n8. Handling ArrayIndexOutOfBoundsException:");
        try {
            int[] arr = new int[3];
            System.out.println(arr[5]); // Invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: Invalid array index.");
        }
    }

    // 9. ClassCastException Example
    private static void handleClassCastException() {
        System.out.println("\n9. Handling ClassCastException:");
        try {
            Object obj = new String("Test");
            Integer num = (Integer) obj; // Invalid type casting
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: Invalid type cast.");
        }
    }

    // 10. IllegalArgumentException Example
    private static void handleIllegalArgumentException() {
        System.out.println("\n10. Handling IllegalArgumentException:");
        try {
            setAge(-5); // Invalid argument
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }

    private static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
    }

    // 11. NumberFormatException Example
    private static void handleNumberFormatException() {
        System.out.println("\n11. Handling NumberFormatException:");
        try {
            int number = Integer.parseInt("InvalidNumber");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: Invalid number format.");
        }
    }
}

