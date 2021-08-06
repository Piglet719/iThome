# [Day13] CH08：積沙成塔——Array & ArrayList（下）

還記得前兩天我們在介紹陣列的時候，有說到需要給他固定的長度，若超過就需要宣告一個新的更大的陣列嗎？那有什麼辦法讓他可以動態改變大小呢？這時候就要介紹集合類別 ArrayList。

宣告方式：
    
    ArrayList<元素型別> ArrayList名稱 = new ArrayList<元素型別>();

元素型別類似於宣告陣列時需要定他的資料型態，但這裡只能使用非資本型態，像是 String。不過很幸運的是，Java提供「裝箱」的服務，若我們要宣告一個儲存 integer 的 ArrayList 來儲存整數，將整數值放置到 ArrayList<Integer> 當中，就會被包裝為整數物件，以下是各個基本型態轉換成包裝類別（Wrapper Class）：

|基本型態|包裝類別|
|:-:|:-:|
|byte|Byte|
|boolean|Boolean|
|char|Character|
|double|Double|
|float|Float|
|int|Integer|
|long|Long|
|short|Short|

那 ArrayList 要怎麼運用呢？以下是一些常見的方法：

|方法|說明|
|:-|:-|
|add|在 ArrayList 最後加一筆元素|
|clear|移除 ArrayList 所有元素|
|contains|如果 ArrayList 含有指定的元素回傳 true，否為 false|
|get|傳回位於指定索引值的元素|
|indexof|傳回指定元素在 ArrayList 第一次出現的索引值|
|remove|會移除第一次出現指定值的元素，或是指定索引值的元素|
|size|傳回 ArrayList 中儲存元素的數量|
|trimToSize|將 ArrayList 容量縮減至目前元素數量|

<br>

以下就從範例中觀看個方法如何使用：
```java
import java.util.ArrayList;

public class ArrayListCollection {
    public static void main(String[] args){
        ArrayList<String> Students = new ArrayList<String>();

        Students.add("Betty");
        Students.add(0, "Alan");

        System.out.print("First student list:");
        for(String student : Students){
            System.out.printf(" %s", student);
        }
        System.out.println();

        Students.add("Jane");
        Students.add("Betty");

        System.out.print("Second student list:");
        for(String student : Students){
            System.out.printf(" %s", student);
        }
        System.out.println();

        Students.remove("Betty");

        System.out.print("Third student list:");
        for(int i = 0 ; i < Students.size() ; i++){
            System.out.printf(" %s", Students.get(i));
        }
        System.out.println();

        Students.remove(1);

        System.out.print("Forth student list:");
        for(int i = 0 ; i < Students.size() ; i++){
            System.out.printf(" %s", Students.get(i));
        }
        System.out.println();

        if(Students.contains("Jane")){
            System.out.println("Contain Jane.");
        }
        else{
            System.out.println("Not contain Jane.");
        }
    }    
}
```

    First student list: Alan Betty
    Second student list: Alan Betty Jane Betty
    Third student list: Alan Jane Betty
    Forth student list: Alan Betty
    Not contain Jane.

<br>

實做完應該就發現他其實不難（應該啦！），這三天我們學了很多關於陣列的基本概念，接下來幾天我們就要來實際應用他了！