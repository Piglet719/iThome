# [Day12] CH08：積沙成塔——Array & ArrayList（中）

還記得我們前兩天學的方法嗎？結合昨天學的陣列，陣列也可以用在方法裡傳遞嗎？

當然可以囉！我們就先來看個例子：
```java
public class PassArray {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("Original array:");
        for(int number : arr){
            System.out.printf(" %d", number);
        }
        System.out.println();
        
        doubleArray(arr);
        System.out.print("After double array:");
        for(int number : arr){
            System.out.printf(" %d", number);
        }
        System.out.println();
        
        System.out.printf("Original 3rd element: %d%n", arr[2]);
        doubleElement(arr[2]);
        System.out.printf("After double 3rd element: %d%n", arr[2]);
    }

    public static void doubleArray(int[] array){
        for(int i = 0 ; i < array.length ; i++){
            array[i] *= 2;
        }
    }

    public static void doubleElement(int element){
        element *= 2;
    }
}
```

我們可以看到，在 doubleArray() 這個方法中，參數列是一個整數陣列，main 程式中的陣列經過這個方法後，印出來的陣列變成 2 倍。此時陣列變成 2、4、6、8、10，因此可以得知，我們在 doubleArray() 修改陣列值，在 main 程式的值也被更新了。

你覺得很合理嗎？那麼接著我們往下看，我們再將陣列元素第三個也就是索引值為 2 的元素 double，前後印出的結果竟然都是 6，double 完應該要是 12 不是嗎？

在許多程式語言中，方法在傳遞引數有分為傳值呼叫（pass-by-value/call-by-value）和傳址呼叫（pass-by-reference/call-by-reference）。傳值呼叫就像是 doubleElement() 所表現的，在 main 中我傳遞 arr[2] 的「值」，也就是 6 給 doubleElement() 裡的 element，此時 element 是 arr[2] 的副本，他們具有同樣的值，但不是同一個東西，所以 element 乘 2 時會變成 12，但是 arr[2] 中的元素並不會被更改到值。

<font color="red">**Java 所有的引數都是傳值呼叫。**</font>雖然在 doubleArray() 中看起來和前面的不一樣，好像應該是傳址呼叫，但這是 Java 與其他程式語言不同的地方。陣列是一個物件（詳細的物件介紹之後會說明），為了增進效能（不然每一個陣列元素都必須建立一個副本），main 中的 arr 和 doubleArray() 中的 array 會指向同一塊記憶體。因此在修改 doubleArray() 中的 array 元素時，main 中的 arr 也會因為參考到同一塊記憶體，而取得同樣的值，最後再次強調 Java 所有的引數都是傳值呼叫。

<br>

為了讓大家可以消化，最後在講一個平易近人的「多維陣列」就好

目前為止介紹的都是一維陣列，也就是一般常見的排隊排成一列，但看電影可以有音效和豐富的劇情，甚至可以是 3D 的，陣列當然也可以 XD。

### 二維陣列
```java
int[][] arr = new int[2][3];	//2 個 row，每個 row 3 個 elements
```

當然也可以直接給值，且不同長度：
```java
int[][] arr = {{1, 2} , {3, 4, 5}}
```

<br>

今天的東西有點玄，但還是希望大家能吸收，所以就把剩下的東西留到明天了，繼續加油吧！