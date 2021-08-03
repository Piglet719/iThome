# [Day08] CH06：重複的力量——迴圈（上）

有時候同樣一個程式需要執行多次，那我們總不可能把同樣的一段程式碼複製貼上吧？這樣未免太沒效率，也會使得程式雜亂不堪。這時候就會需要使用到「迴圈」！

* ### for 迴圈

    假設今天我們需要印出 1 到 10 的數字，那我們會需要一個計數器（counter）來控制現在到第幾個迴圈了。

    ```java
    for(int counter = 1; counter <= 10 ; counter++){
        System.out.printf("%d ", counter);
    }
    ```

    for 迴圈開始執行時，會先宣告一個變數 counter 當作計數器（也可以在 for 迴圈外宣告），並將它初始化為 1，接著用分號分隔，程式會檢查 for 迴圈中間的條件（counter <= 10）是否為真，若為真則會執行迴圈內的程式，也就是印出 counter。執行完程式後，會執行第二個分號後的 couter++，將 counter 加 1，此時會再次判斷 counter 是否小於等於10，若成立則繼續執行，一直到 counter 超過 10，迴圈便終止，不再執行迴圈內程式，離開迴圈。

    標準寫法：

        for(初始化變數 ; 條件式 ; 遞增/遞減){
            statement;
        }

<br>

那如果我們今天不知道要執行幾次呢？

* ### while迴圈

    假設今天我們要判斷輸入的數字是否為正數，若否則一直輸入到大於 0，我們就無法得知需要執行幾次。

    ```java
    int inputNum = sc.nextInt();
    while(inputNum < 0){
        System.out.println("Please enter a positive number.");
        inputNum = sc.nextInt();
    }
    ```

    程式一開始會先判斷條件 (inputNum < 0) 是否成立，若成立則執行迴圈內程式，繼續讀入下一個數字，執行完後，又會再次判斷條件是否成立，一直到不成立時，則會跳出迴圈。

    標準寫法：

        while(條件式){
            statement;
        }
    
    當然我們也可以用while迴圈執行印出 1 到 10 的程式：

    ```java
    int counter = 1;
    while(counter <= 10){
        System.out.printf("%d ", counter);
        counter++;
    }
    ```

<br>

那如果今天在進入迴圈前，我們想先執行一段程式怎麼辦呢？（哪那麼多如果 XD）

* ### do…while 迴圈

    以上兩個程式變成先執行後判斷：

    ```java
    int counter = 1;
    do{
        System.out.printf("%d ", counter);
        counter++;
    } while(counter <= 10);
    ```
    ```java
    int inputNum;
    do{
        System.out.println("Please enter a positive number.");
        inputNum = sc.nextInt();
    } while(inputNum < 0);
    ```

    首先會執行 do 迴圈內之程式，才會判斷 while 條件是否成立，若成立則繼續執行，否則離開迴圈。

    標準寫法：

        do{
            statement;
        } while(條件式);

<br>

這是三個不同迴圈的使用方式，是不是覺得很神奇呢？以上的語法都建議大家自己實做看看哦，那今天再來一題小試身手吧！

<br>

>### 小試身手
>印出 1 到 100 中所有的偶數。