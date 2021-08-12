import java.util.Scanner;

public class Division2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        if (num2 == 0) {
            System.out.println("除數不得為 0");
        } else {
            float quotient = (float) num1 / num2;
            System.out.printf("Quotient: %.2f%n", quotient);
        }
        sc.close();
    }
}
