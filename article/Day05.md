# [Day05] CH03：各式運算子（下）

接續昨天的運算子（Operator）：

* ### 等值運算子

    |Java操作|運算子|
    |:-:|:-:|
    |等於|==|
    |不等於|!=|

* ### 關係運算子

    |Java操作|運算子|
    |:-:|:-:|
    |大於|>|
    |大於或等於|>=|
    |小於|<|
    |小於或等於|<=|

    等值和關係運算子是二元運算子，判斷兩個數值之間的關係，會回傳布林值。

* ### 邏輯運算子

    |Java操作|運算子|
    |:-:|:-:|
    |邏輯和（and）|&&|
    |邏輯或（or）|\|\||

    &&（and）是全部皆要為 true，才會是 true，其餘則皆是 false。<br>
    ||（or）是只要有一個為 true，最後就是 true。

    ```java
    boolean t = true;
    boolean f = false;
    System.out.println(t && t); //true
    System.out.println(t && f); //false
    System.out.println(f && t); //false
    System.out.println(f && f); //false
    System.out.println(t || t); //true
    System.out.println(t || f); //true
    System.out.println(f || t); //true
    System.out.println(f || f); //false
    ```
    <br>

以下兩個皆會與資料儲存在記憶體有關，資料在記憶體中是以 0 和 1 的方式儲存，至於如何儲存會和二進制有關，這裡不會說明，有興趣可以自行 Google。

* ### 位元運算子

    |Java操作|運算子|
    |:-:|:-:|
    |位元補數|~|
    |位元和（and）|&|
    |位元或（or）|\||
    |位元互斥或（exclusive or）|^|

    補數的意思是 0 變 1，1 變 0。

    互斥的意思就好像麥當勞套餐配飲料，店員問你要可樂還雪碧，你只能選一個，不能都選或都不選。

    ```java
    int a = 10, b = 6;
    System.out.println(a);          // a = 00001010
    System.out.println(~a);         //~a = 11110101
    System.out.println(a & b);      // b = 00000110
                                // a & b = 00000010
    System.out.println(a | b);  // a | b = 00001110
    System.out.println(a ^ b);  // a ^ b = 00001100
    ```

* ### 位移運算子

    |Java操作|運算子|
    |:-:|:-:|
    |左移（保留正負號）|<<|
    |右移（保留正負號）|>>|

    ```java
    int a = 10;
    System.out.println(a);         // a = 00001010
    System.out.println(a<<2);   // a<<2 = 00101000
    System.out.println(a>>2);   // a>>2 = 00000010
    ```
    <br>

總結我們這兩天學到的五個運算子：指定、算術、單元、等值、關係、邏輯、位元和位移運算子，明天我們就要學以致用了，是不是很期待呢？