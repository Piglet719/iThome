# [Day11] CH08：積沙成塔——Array & ArrayList（上）

很快地已經學了十天，今天又是一個新的開始，今天要來認識「陣列」。

陣列（Array）是由同型別的相關資料項目所構成的資料結構，一旦建立後，就會保持相同的長度，若需更改則需要重新宣告新的陣列。

陣列會由陣列名稱和索引值（index）所組成：陣列名稱[索引值]

索引值指的就是這個陣列元素在陣列中的位置編號，再白話一點就把陣列想成一個排隊隊伍，索引值是他在第幾個，但…

還記得我們的 Chapter 是從 00 開始嗎？

沒錯，陣列的索引值是從 0 開始哦！假如今天你的陣列有五個元素，那索引值就是 0 到 4，是不是很神奇呢？

假設有一陣列名稱為 arr，長度為 5，則 arr[0] 就是在呼叫第零個元素。

宣告陣列：

    資料型態[] 陣列名稱 = new 資料型態[陣列長度];

宣告完的陣列在還沒初始化前都會是預設值，和宣告變數時相同。

我們也可以用這種方式，在宣告的時候直接初始化值：
```java
int[] arr= {4, 25, 13, 37, 9};
```

這種方式不需要告訴陣列的長度，Java 會由元素個數自動判斷。

看個範例程式應該就了解了：
```java
public class SumArray {
    public static void main(String[] args){
        int[] arr = {4, 25, 13, 37, 9};
        int total = 0;
        for(int i = 0 ; i < arr.length ; i++){
            total += arr[i];
        }
        System.out.printf("Total of array elements: %d%n", total);        
    }
}
```

但其實在這支程式還有一個地方可以升級，就是加強版 for 迴圈：

```java
public class SumArray2 {
    public static void main(String[] args){
        int[] arr = {4, 25, 13, 37, 9};
        int total = 0;
        for(int number : arr){
            total += number;
        }
        System.out.printf("Total of array elements: %d%n", total);        
    }
}
```

今天的內容比較短，因為接下來要介紹一個重要的觀念，讓我們明天再來揭曉吧！