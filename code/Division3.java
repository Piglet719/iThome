import java.util.InputMismatchException;
import java.util.Scanner;

public class Division3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true; // 判斷是否需要繼續讀入
        do {
            try {
                System.out.print("Enter first number: ");
                int num1 = sc.nextInt();
                System.out.print("Enter second number: ");
                int num2 = sc.nextInt();
                int quotient = num1 / num2;
                System.out.printf("Quotient: %d%n", quotient);
                flag = false;
                sc.close();
            } catch (InputMismatchException inputMismatchException) {
                System.err.printf("%nException: %s%n", inputMismatchException);
                sc.nextLine(); // 忽略錯誤的輸入
                System.out.println("Please enter integers.");
                System.out.println();
            } catch (ArithmeticException arithmeticException) {
                System.err.printf("%nException: %s%n", arithmeticException);
                System.out.println("除數不得為 0");
                System.out.println();
            }
        } while (flag);
    }
}
