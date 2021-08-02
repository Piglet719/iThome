import java.util.Scanner;

public class Sum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        int sum = num1 + num2;  //兩數字和
        System.out.println("Sum: " + sum);
        System.out.printf("Sum: %d%n", sum);
        System.out.print("Sum: " + sum + "\n");
        sc.close();
    }
}
