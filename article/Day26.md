# [Day26] 猜數字小遊戲

今天我們要用前面 25 天所學，實作一個小遊戲。大家都有玩過猜數字幾 A 幾 B 的小遊戲嗎？我們就來寫一個這樣的遊戲。

首先，要產生一個隨意的四位數字為答案，這和我們之前用的方法是不一樣的。透過 Math.random() 可以獲取隨機數，返回 [0.0, 1.0) 之間的 double 值。

```java
String ans = "";
for(int i = 0 ; i < 4 ; i++){
    ans += (int) (Math.random() * 10);
}
```

接著思考我們每次輸入一個數字時，需要如何判斷有幾 A 幾 B？我的作法是先判斷有幾個 A 把符合的標示後，再判斷有幾個 B。可以自己想想看要怎麼寫，再來參考哦！

```java
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
```

範例中使用 String 型別儲存答案和輸入值，在利用 charAt() 這個方法取得 String 中的第幾位數，若是使用整數儲存，則可以用餘數的方法來實作，大家也可以試試看。

因為在產生隨意四位數字時並未排除重複，所以在遇到有重複數字時，一個數字可能被判斷兩次，因此可以在產生數字時判斷有無重複，改良此程式。

<br>

除了判斷答案外，也會判斷使用者猜了幾次，雖然程式碼並不長，但是需要先思考它的邏輯在實作。一般在實作專案的時候，我們也都是用這種模式，大家可以想想看可以寫出什麼有趣的程式哦！
