# [Day14] CH09：尋尋覓覓——二元搜尋法

接下來的這幾天，會瘋狂運用到上個單元教的陣列，也會碰觸一些演算法的概念，而今天要來介紹的是二元搜尋法（Binary Search）。

假若今天給你 n 個數字，要你從中找出其中一個數字，那麼你會怎麼找呢？一個一個找，這樣最差的結果就需要找完整個陣列，也就是個 n 個數字，此時時間複雜度就會是 O(n)，這樣未免太沒效率了。

### 二元搜尋法

又稱二分搜尋法，在已排序好的陣列中，每次會找中間值，將陣列分成比中間值小之元素組成之陣列，和比中間值大之元素組成之陣列，再判斷要找的數是大於或小於或等於中間值，若等於則已找到，若小於則從比中間值小之元素組成之陣列尋找，大於則比中間值大之元素組成之陣列尋找，接下來繼續將當前陣列一分為二，直到找完或找到。此方法因為每次都將陣列切成一半，因此時間複雜度最差為 O(logn)。


假設已有一個排序好的陣列：

    索引值  0,  1,  2,  3,  4,  5,  6,  7,  8
    陣列    6, 19, 21, 24, 41, 53, 62, 78, 97

我們要尋找 53，首先看陣列長度為 9，中間值為 41，53 > 41 因此找 5 到 8 元素之陣列。

    索引值   5,  6,  7,  8
    陣列    53, 62, 78, 97

此時中間值為 62 和 78 中間，隨意取 62 或 78，這裡我們取 62，53 < 62，所以找第5個元素，剛好剩下最後一個，這樣一來就找到了，以下為程式碼範例：

```java
import java.util.Scanner;

public class BinarySearch{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = {6, 19, 21, 24, 41, 53, 62, 78, 97};
        System.out.print("I want to find: ");
        int findNum = sc.nextInt();
        int position;
        if((position = binarysearch(arr, findNum)) != -1){  //把回傳值用 position 接收，再比對是否為 -1
            System.out.printf("%d is in the %d position.%n", findNum, position);
        }
        else{
            System.out.printf("%d isn't in the array.%n", findNum);
        }
        sc.close();
    }

    public static int binarysearch(int[] arr, int num){
        int result = -1;    //預設 -1 為沒找到
        int start = 0;
        int end = arr.length - 1;   //長度 - 1 為最後一個索引值

        while(start <= end){
            int mid = start + (end - start) / 2;    //end - start 是為了防止溢位
            if(arr[mid] > num){ //要找的值小於中間值
                end = mid - 1;  //陣列最後一個設為中間值前一個數字
            }
            else if(arr[mid] < num){    //要找的值大於中間值
                start = mid + 1;    //陣列第一個設為中間值後一個數字
            }
            else{   //要找的值等於中間值
                result = mid;
                break;
            }
        }
        return result;
    }
}
```
<br>

除了 while 的寫法，還有 for 迴圈的寫法，大家回家可以試試看，那麼今天就到這裡啦！