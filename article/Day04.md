# [Day04] CH03：各式運算子（上）

今天要介紹的是運算子（Operator），在程式語言中有分為：

* ### 指定運算子

    「=」可以把右側的東西指定到左邊，和數學上的等於是不一樣的喔！

    ```java
    int number;
    number = 5;
    ```

    第一行是昨天學的宣告 number 為整數變數，第二行指的是指定 5 給 number 這個變數（記得要從右邊看到左邊）。

* ### 算術運算子

    |Java操作|運算子|
    |:-:|:-:|
    |加法|+|
    |減法|-|
    |乘法|*|
    |除法|/|
    |餘數|%|

    以上的算術運算子都是二元運算子，因為他們都用了兩個運算元，例如：a + b 包含了二元運算子「+」和兩個運算元 a 和 b。

    其中**整數除法**會得到整數的商數，例如：11 ÷ 3 會得到 3，小數部分會無條件捨去。

    餘數運算子會產生除法的餘數，例如：11 % 3 會得到 2。

    在程式中和數學的四則運算一樣，會有「運算子優先權規則」。乘、除、餘數會先進行，接著才會執行加法和減法的運算。同樣，也會利用括弧將運算式分組，例如：(7 + 3) * 5，括號優先計算。

* ### 算數 + 指定運算子
    
    （什麼！？竟然還可以加起來）

    沒錯~算術和指定運算子是可以合併的，也就是說下面兩行是相等的。

    ```java
    a = a + 3;
    a += 3;
    ```

    其餘的算術運算子也都可以和指定運算子合併，這裡就不一一列出。

* ### 單元運算子（一元運算子）

    單元的意思是用來處理「單個」運算元。

    |Java操作|運算子|
    |:-:|:-:|
    |正號|+|
    |負號|-|
    |遞增|++|
    |遞減|--|
    |布林反向|!|

    布林反向運算子的意思是將 true 變成 false，false 變為 true。

    #### 遞增/遞減運算子的 prefix & postfix

    ++ 和 -- 分別就是讓數值加一與減一，所以我們可以將 a++ 與 a+=1 畫上等號。同時 ++a 也是代表 a 加一的意思，但是 a++ 和 ++a 實際上卻是不一樣的。

    postfix：a++，存取完 a 值後，加一。<br>
    prefix：++a，將 a 加一後，在存取。

    ```java
    int a = 7;
    System.out.println(a++);    //印出 a 的值(7)後才 ++，執行完後 a = 8
    System.out.println(a);      //印出 a 的值(8)
    System.out.println(++a);    //先把 a++(a = 9)，再印出
    System.out.println(a);      //印出 a 的值(9)
    ```
    <br>

今天的內容都是寫程式時很常用的，但是運算子我們還沒介紹完，明天會繼續介紹剩餘的部分。熬過前面的理論，後面就可以動手做了，加油！