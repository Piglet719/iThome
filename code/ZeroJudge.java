import java.util.Scanner;
public class ZeroJudge{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count;
        for(int i = 2; i <= num ; i++){
            count = 0;
            while(num % i == 0){
                num /= i;
                count++;
            }
            if(count > 1){
                System.out.print(i + "^" + count);
                if(num != 1){
                    System.out.print(" * ");
                }
            }
            else if(count == 1){
                System.out.print(i);
                if(num != 1){
                    System.out.print(" * ");
                }
            }
        }
        sc.close();
    }
}

