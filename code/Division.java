import java.util.Scanner;

public class Division {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        float quotient = (float) num1 / num2;
        System.out.printf("Sum: %.2f%n", quotient);
        sc.close();
    }
}
