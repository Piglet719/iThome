# [Day25] CH12：凡事總有例外——例外處理

還記得我們在學習條件判斷時寫過兩數相除的程式嗎？那時候遇到除數為 0 時，我們是使用 if 來判斷，但如果今天發生其他錯誤，像是輸入值不是數字那怎麼辦呢？好在 Java 提供了例外（Exception）處理機制，協助我們捕捉程式執行時的錯誤，在例外發生時，可以加入相對應的措施，使程式可以正常結束，今天我們就要很粗淺的認識例外處理。

看到之前第一個兩數相除的程式，試試看如果除數為 0 會發生什麼事。

```java
import java.util.Scanner;

public class Division3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        int quotient = num1 / num2;
        System.out.printf("Quotient: %d%n", quotient);
        sc.close();
    }
}
```

    Exception in thread "main" java.lang.ArithmeticException: / by zero
        at Division3.main(Division3.java:11)

果不其然發生錯誤了！Java 告訴你發生了 ArithmeticException，/ by zero 指出例外是因為試圖除以 0 而發生。 Java 不允許整數運算除以 0，當發生此情形時，就會拋出 ArithmeticException。但如果是浮點數的話則會出現其他答案，大家可以試試看。除此之外，我們還可以看到在第 11 行（quotient = num1 / num2;）的地方時例外的拋出點。

我們再試試看如果除數不為數字會發生什麼事。

    Exception in thread "main" java.util.InputMismatchException
        at java.base/java.util.Scanner.throwFor(Scanner.java:939)
        at java.base/java.util.Scanner.next(Scanner.java:1594)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        at Division3.main(Division3.java:10)

這次發生了 InputMismatchException，從最後一行看出發生例外的地方在第 10 行，再往上看可以發現例外是發生在 nextInt 方法。

那我們要怎麼解決呢？首先來認識例外處理的語法：

```java
try{
    //檢查是否有例外產生，若有就丟出例外
}
catch(例外類型 e){
    //處理不同例外類型，可有多個 catch 區塊
}
finally{
    //可有可無，用來善後工作，無論例外是否產生皆會執行
}
```

只要有 try 就需要有 catch，finally 則不一定要有。

我們將以上程式改成若發生例外，則持續輸入，直到成功運算為止。

```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class Division3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;    //判斷是否需要繼續讀入
        do{
            try{
                System.out.print("Enter first number: ");
                int num1 = sc.nextInt();
                System.out.print("Enter second number: ");
                int num2 = sc.nextInt();
                int quotient = num1 / num2;
                System.out.printf("Quotient: %d%n",quotient);
                flag = false;
                sc.close();
            }
            catch(InputMismatchException inputMismatchException){
                System.err.printf("%nException: %s%n", inputMismatchException);
                sc.nextLine();  //忽略錯誤的輸入
                System.out.println("Please enter integers.");
                System.out.println();
            }
            catch(ArithmeticException arithmeticException){
                System.err.printf("%nException: %s%n", arithmeticException);
                System.out.println("除數不得為 0");
                System.out.println();
            }
        }while(flag);
    }
}
```

首先將 InputMismatchException 類別匯入，ArithmeticException 類別不需要匯入。一開始宣告了 flag 判斷是否需要繼續讀入，若是發生例外則 flag 始終為 true，繼續讀入，直到輸入值為有效值為止。

由上述的例子可以看到，一個 try 能有多個 catch，在輸入不為數字時，nextInt 方法就會拋出 InputMismatchException，而當除數為 0 時，在兩數相除時就會拋出 ArithmeticException。在 catch 中，可以看到使用了 System.err 來輸出錯誤訊息，而因為 flag 為 true 程式會繼續執行。

### 內建例外

在 Java 中屬於 Throwable 類別，其子類別分為以下兩種：

- Error 類別

  專門用來處理嚴重影響程式執行的錯誤，通常不會設計程式碼去捕捉。

- Exception 類別

  包含有一般性的例外，這些例外通常在捕捉到之後便可做妥善的處理，我們將之稱為例外，這些類別則稱為例外類別，以下為常見的例外：

| 例外                           | 說明                                   |
| :----------------------------- | :------------------------------------- |
| ArithmeticException            | 算術運算式的錯誤，例如除以 0。         |
| ArrayIndexOutOfBoundsException | 陣列索引超過界限。                     |
| ArrayStoreException            | 將型態不符的物件設定為物件陣列的元素。 |
| IllegalArgumentException       | 呼叫方法時引數錯誤。                   |
| NullPointerException           | 物件值為 null 產生的例外               |

<br>

除了內建例外，我們也可以自訂例外，但這裡我們並不會繼續介紹，例外處理若要全部介紹完可能需要三天三夜 XD，不過因為時間有限，所以本教學就只介紹到這裡，讓初學者可以簡單認識例外並使用，剩下的時間我們會認識更多東西。
