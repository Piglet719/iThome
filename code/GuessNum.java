import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args) {
        int A = 0, cnt = 0;
        String ans = "";
        Scanner sc = new Scanner(System.in);

        // 產生隨機四位數
        for (int i = 0; i < 4; i++) {
            ans += (int) (Math.random() * 10);
        }

        // 輸入數字
        System.out.print("This is a guess number game. Please enter four digits: ");
        while (A != 4) {
            A = 0;
            int B = 0;
            boolean checked[] = new boolean[4];
            for (int i = 0; i < 4; i++) {
                checked[i] = false;
            }

            // 讀取輸入
            String guessNum = sc.next();
            cnt++;

            // 判斷有多少A
            for (int i = 0; i < 4; i++) {
                if (guessNum.charAt(i) == ans.charAt(i)) {
                    A++;
                    checked[i] = true;
                }
            }

            // 判斷有多少B
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (!checked[j] && (guessNum.charAt(j) == ans.charAt(i))) {
                        B++;
                        checked[j] = true;
                        break;
                    }
                }
            }
            System.out.println(A + "A" + B + "B");
        }
        System.out.println("You try " + cnt + " times.");
        System.out.println("Answer is " + ans);
        sc.close();
    }
}
