# [Day10] CH07：站在巨人的肩膀上——方法

先來公布一下昨天的解答吧，應該畫一下圖就知道為什麼要這樣了，這裡就不再說明，因為今天要講解一個新的概念。

```java
import java.util.Scanner;

public class Triangle {
    public static void main(String[] argvs){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the height of triangle.");
        int n = sc.nextInt();
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n-i ; j++){
                System.out.print(" ");
            }
            for(int j = 1 ; j <= (2*i-1) ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
```

<br>

在處裡一個大問題時，我們會將大問題切割成一個個小問題依依解決，這個做法稱為 Divide and Conquer。在撰寫程式的時候也是如此，我們會將程式包裝成一個個「方法」（method），幫助我們模組化程式，這有助於我們設計和維護大型程式。

不知道你有沒有想過，為什麼寫程式前一定要打這兩行呢：

```java
public class CodeName {
    public static void main(String[] argvs){
    }
}
```

今天會讓大家了解第二行代表的意思，第一行則還需要再等等。

main 是一個方法，從名字可知他是一個主要的方法，每一個程式一定都會有一個 main 方法。當你用 Java 命令執行 Java 虛擬機器（JVM）時，JVM 會試著呼叫你所指定之類別的 main 方法。

除了 main 方法，我們還可以自己寫很多方法，寫法如下：

    存取敘述 static 傳回值型態 方法名稱(參數列){
        statement;
        return 運算式;
    }

* 存取敘述：
    * public（公開）：可以在任何地方呼叫
    * private（私人）：只可以在同一個類別下使用

* static 這我們之後會再詳細說明。

* 傳回值型態：就如同之前介紹過的資料型態，你想要你的方法回傳是什麼型態，若不需回傳則傳回值型態為 void。

* 方法名稱：就會我們取變數名稱一樣，要取可讀性高的名字。

* 參數列：此方法的傳入值，可以不只一個，若無則為空。

* return 運算式：此方法要回傳的值，void 沒有此項。

<br>

看完上面的說明，你可能還是霧沙沙，那我們直接來看範例吧！

```java
public class Maximum {
    public static void main(String[] args){
        int num1 = 5;
        int num2 = 7;
        int num3 = 4;
        myPrint();
        System.out.println(maxNum(num1, num2, num3));
    }

    public static void myPrint(){
        System.out.print("The maximum number is: ");
    }
    public static int maxNum(int a, int b, int c){
        if(a > b){
            if(a > c){
                return a;
            }
            else{
                return c;
            }
        }
        else{
            if(b > c){
                return b;
            }
            else{
                return c;
            }
        }
    }
}
```

先看到第一個方法 myPrint()，他沒有參數列，且他是一個回傳值為空的方法，所以使用 void，且不需要 return。第二個方法是 maxNum()，他有三個傳入值，且他的回傳型態是 int，傳回三數的最大值。

若我們今天呼叫的方法在別的類別裡，就需要在方法前加上類別名稱：**類別名稱.方法名稱**。像是之前有使用過的 sc.nextInt()，就是使用 Scanner 類別裡的 nextInt() 方法，其實你早就認識他了，還有很多方法都很常使用，多多了解可以站在巨人的肩膀上寫出更厲害的程式。

### 方法多載（method overloading）

同一個類別中可以宣告多個同名的方法，只要這些參數列不同即可，以剛剛的例子來說，我可以宣告一個同名的 maxNum()，但因為參數列只有兩個，所以程式還是可以判斷你呼叫的是哪一個方法。

```java
public class Maximum {
    public static void main(String[] args){
        int num1 = 5;
        int num2 = 7;
        int num3 = 4;
        myPrint();
        System.out.println(maxNum(num1, num2, num3));
        System.out.println(maxNum(num1, maxNum(num2, num3)));
    }

    public static void myPrint(){
        System.out.print("The maximum number is: ");
    }
    public static int maxNum(int a, int b, int c){
        if(a > b){
            if(a > c){
                return a;
            }
            else{
                return c;
            }
        }
        else{
            if(b > c){
                return b;
            }
            else{
                return c;
            }
        }
    }

    public static int maxNum(int a, int b){
        if(a > b){
            return a;
        }
        else{
            return b;
        }
    }
}
```

<br>

今天的東西比較抽象一點，但這還只是個開始（什麼！？），我們快要踏進物件導向的魔爪裡了，大家加油！