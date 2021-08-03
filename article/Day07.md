# [Day07] CH05：如果我有一座新冰箱——if/else條件判斷

昨天的練習題有做出來嗎？是不是有遇到什麼問題呢？

第一個問題應該是兩數相除完呈現整數，這時候我們需要「強制轉型」。因為整數與整數相除完得到的答案還會是整數，這時候為了讓他變成小數我們需要在前面加一個 float，將他強制轉型為浮點數。

```java
float quotient = (float) num1 / num2;
```

第二個問題應該是要怎麼印出兩位小數，在印出浮點數的時候，是使用「%f」，而要印出兩位小數，則是加上小數點和小數點後幾位，如下圖所示：

```java
System.out.printf("Sum: %.2f%n", quotient);
```

全部的程式碼如下，有沒有成功做出來呢？記得寫程式最重要的就是自己動手做哦！

```java
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
```

不知道你有沒有想到一個問題，就是如果除數為 0 怎麼辦呢？這時候我們就需要「if/else」來判斷，語法如下：

    if(條件式1){
	    System.out.println(“條件式1成立”);
    }

如果條件式1成立，就會執行括號內程式。這時候如果不成立，我們還可以多加一個 else：

    if(條件式1){
        System.out.println(“條件式1成立”);
    }
    else{
        System.out.println(“條件式1不成立”);
    }

如果條件式1不成立，就不會執行 if 括號內的程式，而是會執行 else 括號內的程式。如果我們不只一個條件呢？那麼我們還可以加入 else if()：

    if(條件式1){
        System.out.println(“條件式1成立”);
    }
    else if(條件式2){
        System.out.println(“條件式2成立”);
    }
    else{
        System.out.println(“條件式1、條件式2不成立”);
    }

如果條件式1不成立，就不會執行 if 括號內的程式，而是會繼續判斷條件式2是否成立，若成立就會印出「條件式2成立」，否則會執行 else 括號內的程式。BTW，else if 可以不只一個，if 裡面也可以有 if。

回到昨天的程式，若除數為 0 時，則兩數不相除，而是印出「除數不得為 0」，更改後的程式碼如下：

```java
import java.util.Scanner;

public class Division2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        if(num2 == 0){
            System.out.println("除數不得為 0");
        }
        else{
            float quotient = (float) num1 / num2;
            System.out.printf("Sum: %.2f%n", quotient);
        }
        sc.close();
    }
}
```

<br>

完成了這個程式是不是想學更多呢？那我們一起期待明天會學到什麼更有趣的內容吧！