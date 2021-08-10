# [Day19] CH10：排序大家族——實驗

咦？怎麼還是排序呢？沒錯！經過前四天的學習，我們今天要來做一個小實驗，比較各個排序演算法在相同巨量數據下的排序速度，雖然時間複雜度相同，但他們還是有快慢之分的，究竟誰是最後的贏家呢？我們就來實際做實驗吧！

既然是實驗，那麼給定的參數值就要一樣才能比較，我們需要大量且相同的資料當作要排序的陣列元素，這時候就可以使用「隨機數字」這個方法，在 Java 中有 Math 函式庫裡的 random 方法和 java.util 裡的 Random 方法，兩種用法不太一樣，這裡要介紹的是第二種方法：

```java
//產生一個 Random 物件，並設定亂樹種子為 2
Random r = new Random(2);
```
除此之外，我們還需要能測量執行時間的方法，這裡要介紹的是 currentTimeMillis()：

```java
long start = System.currentTimeMillis();    //開始時間
//執行程式
long duration = System.currentTimeMillis() - start;  //現在時間 - 開始時間 ms
```

有了以上兩種方法，搭配前四天教的內容，大家應該可以嘗試自己寫寫看，以下示範歷程式碼：

```java
import java.util.Random;

public class SortExperiment {
    public static void main(String[] args){
        int i;
        int[] arr1 = new int[100000];
        int[] arr2 = new int[100000];
        int[] arr3 = new int[100000];
        int[] arr4 = new int[100000];

        Random r = new Random(1);   //設定亂樹種子為 1

        //給予四陣列相同的實驗數值
        for(i = 0 ; i < 100000 ; i++){
            arr1[i] = r.nextInt();
            arr2[i] = arr1[i];
            arr3[i] = arr1[i];
            arr4[i] = arr1[i];
        }

        long start, duration; //開始時間、執行時間
        start = System.currentTimeMillis();
        bubblesort(arr1);
        duration = System.currentTimeMillis() - start;  //現在時間 - 開始時間
        System.out.println("Execution time of bubble sort: " + duration + " ms");

        start = System.currentTimeMillis();
        selectionsort(arr2);
        duration = System.currentTimeMillis() - start;  //現在時間 - 開始時間
        System.out.println("Execution time of selection sort: " + duration + " ms");

        start = System.currentTimeMillis();
        insertionsort(arr3);
        duration = System.currentTimeMillis() - start;  //現在時間 - 開始時間
        System.out.println("Execution time of insertion sort: " + duration + " ms");

        start = System.currentTimeMillis();
        mergesort(arr4, 0, arr4.length-1);
        duration = System.currentTimeMillis() - start;  //現在時間 - 開始時間
        System.out.println("Execution time of merge sort: " + duration + " ms");
    }

    //Bubble Sort
    public static void bubblesort(int[] arr){
        int n = arr.length;
        for(int i = 0 ; i < n-1 ; i++){
            for(int j = 0 ; j < n-i-1 ; j++){
                if(arr[j] > arr[j+1]){  //兩數字交換
                    int t = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    //Selection Sort
    public static void selectionsort(int[] arr){
        int n = arr.length;
        for(int i = 0 ; i < n-1 ; i++){
            int min = i;
            for(int j = i+1 ; j < n ; j++){
                if(arr[min] > arr[j]){  //找最小值
                    min = j;
                }
            }
            int t = arr[i]; //兩數交換
            arr[i] = arr[min];
            arr[min] = t;
        }
    }

    //Insertion Sort
    public static void insertionsort(int[] arr){
        int n = arr.length;
        for(int i = 1 ; i < n ; i++){
            int temp = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > temp){ //持續比對是否比 temp 大
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    //Merge Sort
    public static void merge(int[] arr, int head, int mid, int tail){
        int lenA = mid - head + 1;
        int lenB = tail - (mid+1) + 1;
        int[] A = new int[lenA];    //左子數列
        int[] B = new int[lenB];    //右子數列
        int i,j;
        for(i = 0 ; i < lenA ; i++){
            A[i] = arr[head+i];
        }
        for(j = 0 ; j < lenB ; j++){
            B[j] = arr[mid+1+j];
        }
        i = 0;
        j = 0;
        int k = head;
        while(i < lenA && j < lenB){
            if(A[i] < B[j]){
                arr[k] = A[i];
                i++;
                k++;
            }
            else{
                arr[k] = B[j];
                j++;
                k++;
            }
        }
        //右子數列已經結束，將左子數列剩餘的數複製到 arr
        while(i < lenA){
            arr[k] = A[i];
            i++;
            k++;
        }
        //左子數列已經結束，將右子數列剩餘的數複製到 arr
        while(j < lenB){
            arr[k] = B[j];
            j++;
            k++;
        }
    }

    public static void mergesort(int[] arr, int head, int tail){
        if(head < tail){
            int mid = (head + tail) / 2;
            mergesort(arr, head, mid);
            mergesort(arr, mid+1, tail);
            merge(arr, head, mid, tail);    //合併
        }
    }
}
```

<br>

大家可以多執行幾次，看看平均執行時間，我的實驗結果是：merge > selection > insertion > bubble （速度），選擇排序和插入排序其實時間非常相近，合併排序的話不用說，遠遠把其他三者甩在後頭，是不是覺得很有趣呢？昨天提到的其他排序法大家也可以自己試試看哦！我們的「排序大集合」正式在五天的介紹下結束了。