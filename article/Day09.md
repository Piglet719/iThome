# [Day09] CH06：重複的力量——迴圈（下）

昨天的小試身手大家寫得如何呢？沒有寫出來也不要氣餒哦，我們一起來看解答吧！

寫法1：

```java
public class SelectEven {
    public static void main(String[] args){
        for(int i = 1 ; i <= 100 ; i++){
            if(i % 2 == 0){
                System.out.printf("%d ", i);
            }
        }
    }
}
```

寫法2：
```java
public class SelectEven2 {
    public static void main(String[] args){
        for(int i = 2 ; i <= 100 ; i+=2){
            System.out.printf("%d ", i);
        }
    }
}
```

第一種寫法是用到前幾天教過的 if 判斷式，判斷是否為偶數，再將符合的印出。第二種寫法是直接從 2 開始，每次加 2 印出偶數，你寫的是哪一種呢？

昨天介紹了三種不同的迴圈，有時候我們每一次迴圈都需要判斷多個條件哪一個成立，打個比方來說就像是老師改完一大堆考卷，需要統計級距人數時，就會遇到，這時候 switch 就會是很好用的工具。

```java
import java.util.Scanner;

public class GradeClassification {
    public static void main(String[] args){
        int A = 0;  //90-100
        int B = 0;  //80-89
        int C = 0;  //70-79
        int D = 0;  //60-69
        int F = 0;  //0-59
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the grades: "); //Windows按下 Ctrl+z 終止，其他作業系統按下 Ctrl+d 終止
        while(sc.hasNext()){
            int grade = sc.nextInt();
            switch(grade / 10){
                case 9: //90-99
                case 10:    //100
                    A++;
                    break;  //exits switch

                case 8: //80-89
                    B++;
                    break;
                
                case 7: //70-79
                    C++;
                    break;

                case 6: //60-69
                    D++;
                    break;

                default:    //0-59
                    F++;
                    break;
            }
        }
        System.out.printf("A: %d%nB: %d%nC: %d%nD: %d%nF: %d%n", A, B, C, D, F);
        sc.close();
    }
}
```

首先我們從程式最開始看起，先初始化各個級距的個數為 0，接著讀取輸入直到按下終止鍵，這個終止鍵是在告訴電腦已經結束輸入。我們使用 Scanner 中的 hasNext 方法，判斷是否還有輸入值，若還有就會回傳 boolean 值 true，否則為 false（讀到終止鍵）。

當我們讀入成績後，switch 會搭配 case 將成績分類，switch 後面的括號會先執行，成績除以 10 後的結果會落在 0 到 10 之間，再依照結果進入不同 case。若 case 為 9 或 10 就會執行 A++，下一行的 break 表示離開這一次的 switch，也就是會回到 switch 上一行的 while，因為若成績介於 90 到 100 之間，就不可能進入其他 case，可以提早離開，判斷下一個分數，若是沒有 break，則執行完 A++ 後，會繼續比對其他的 case 是否成立，雖然在這個程式結果一樣，但其他程式可能就會導致答案錯誤。若分數低於 60 分，則逐一判斷 case 皆不符合，就會落入最後的 default，執行 F++，再回到 while 迴圈。

讓我們再詳細認識一下 break 和他的好朋友 continue。若我們今天印出 1 到 10 的數字，如果遇到 7 就表示找到幸運號碼不用印出，break 和 continue 分別會有兩種結果：

* ### break
```java
public class LuckyNum {
    public static void main(String[] args){
        for(int i = 1 ; i <= 10 ; i++){
            if(i == 7){
                break;
            }
            System.out.printf("%d ", i);
        }
    }
}
```

    1 2 3 4 5 6

* ### continue
```java
public class LuckyNum2 {
    public static void main(String[] args){
        for(int i = 1 ; i <= 10 ; i++){
            if(i == 7){
                continue;
            }
            System.out.printf("%d ", i);
        }
    }
}
```

    1 2 3 4 5 6 8 9 10

<br>

你發現差別了嗎？ break 執行後會直接離開迴圈，後面的 8、9、10 都不會印出，但是 continue 執行完不會印出數字，只會回到 for 迴圈的一開始，所以後面的數字還是會印出來。

今天的程式碼比較多，還是建議大家可以自己打打看，迴圈的介紹我們花了兩天學習，這是程式中很重要的一部分，所以最後我們再來埋頭苦幹一下。

<br>

>### 埋頭苦幹
>輸入一個正整數，印出該高的正三角形。