# [Day06] CH04：我已讀你的已讀——認識 Scanner

今天我們要來實作一道題目，是不是很期待呢？

#### Question：輸入兩個數字，印出兩數字的和

看到「和」是不是想到前兩天學過的算術運算子？沒錯，我們今天就來使用他。

要取得輸入的數字，可以使用 Scanner 類別中的 nextInt() 方法：

Scanner 類別被放在 java.util 套件中，所以我們要先 import

```java
import java.util.Scanner;
```

接著要初始化 Scanner 物件，Scanner 讓程式可以讀入資料，以在程式中使用。其中我們要使用的是標準輸入物件「System.in」，讓應用程式可以讀取使用者輸入的資訊位元組。

```java
Scanner sc = new Scanner(System.in);
```

我們用 new 來新建一個 Scanner 物件，取名為 sc，他可以幫助我們從標準輸入流拿資料進來。

那要怎麼使用呢？ Scanner 可以透過各種 next 的方法，轉換成我們需要的資料型態並回傳。

今天我們要讀取的是數字，所以使用 nextInt() 方法

```java
int num = sc.nextInt();
```

利用 Scanner 物件 sc 的 nextInt 方法，取得使用者輸入的數字存入 num。

將輸入的兩個數字分別存入變數後，再將兩者相加並印出，就成功得到兩數的和了。

印出的時候，通常有「println」、「printf」和「print」三種。print 和 println 的差別在於 println 會自動換行，printf 可以印出變數，因為我們要印出的是 Interger 的數字，所以要使用「printf(“%d”)」，加上變數名稱，因為 printf 不會自換行，加上「%n」就可以換行。

最後養成良好的程式習慣，最後要記得將 Scanner 關閉。完整的程式碼如下：

```java
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
```

    Enter first number: 27
    Enter second number: 14
    Sum: 41
    Sum: 41
    Sum: 41

<br>

補充說明：
在程式中我們會使用註解來增加程式的可讀性，註解有分為單行與多行註解，程式不會執行已註解之文字。

* 單行註解

    如上圖是使用「//」，就可以將斜線後的文字註解。

* 多行註解
    
    使用「/\*」與「*/」將要註解的文字至於兩個符號中。

<br>

是不是覺得很容易理解呢？那我們今天留下一道題，明天再來公布答案吧！

<br>

>### 牛刀小試
> 輸入兩個數字，印出第一個數除以第二個數的結果。（取到小數第二位）