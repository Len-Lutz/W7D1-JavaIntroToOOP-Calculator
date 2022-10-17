package w7d1calc;

/*
 * Calculator class provides math routines for simple calculator
 *
 * @author Len Lutz
 * created 15 October 2022
 */
public class Calculator {
    public static int add (int num1, int num2) {
        return num1 + num2;
    }
    
    public static int subtract (int num1, int num2) {
        return num1 - num2;
    }
    
    public static int multiply (int num1, int num2) {
        return num1 * num2;
    }
    
    public static int divide (int num1, int num2) {
        if (num2 == 0) {
            System.out.println("Cannot divide by 0!");
            return 0;
        }
        return num1 / num2;
    }

    public static int square (int num) {
        return num * num;
    }
}
