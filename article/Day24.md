# [Day24] CH11：劉姥姥逛物件導向的世界——抽象、介面

今天要來介紹這個主題最後一個單元了，廢話不多說就直接進入正題吧！

## 抽象（Abstract）類別與方法

在介紹「介面」前，要先介紹「抽象」這個概念。在現實生活中，有 Sheep、 Fish 等動物這個實體，但是卻沒有一種動物叫做 Animal，他就好像是一種概念，是抽象的
，並不實際存在。

在定義類別時，可以只宣告方法名稱而不實作（Implements），這樣的方法稱之為「抽象方法」（Abstract method），若類別中包括了抽象方法，則該類別稱之為「抽象類別」（Abstract class），抽象類別是擁有未實作方法的類別，所以不能被用來生成物件，只能被繼承擴充，並於繼承後實作未完成的抽象方法，所以可以把抽象類別理解成他就是用來被繼承的，如下所示：

```java
public class Zoo3{
    public static void main(String[] args){
        Animal a = new Animal();
    }
}

abstract class Animal{
    private String name;
    
    protected Animal(){

    } 
    
    protected Animal(String name){
        this.name = name;
    }

    public abstract String move(int units);

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}

class Sheep extends Animal{
    private String woolColor;

    public Sheep(){
        super();
    }

    public Sheep(String name, String woolColor){
        super(name);
        this.woolColor = woolColor;
    }

    public void setWoolColor(String woolColor){
        this.woolColor = woolColor;
    }

    public String getWoolColor(){
        return woolColor;
    }

    @Override
    public String move(int units){
        return "跑" + units + "步";
    }
}
```

執行後會出現以下錯誤：

    Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
        Cannot instantiate the type Animal

另外將 move() 改為抽象方法，只定義原形，再在 Sheep 去覆寫，這樣的寫法又更簡潔了，因此我們也可以把抽象方法理解為他就是用來被覆寫的。

## 介面（Interface）

當無關的類別需要共用共通的方法及常數時，通常會使用介面。舉例來說：我們前幾天提到的 Animal 類別和植物（Plant）類別都具有生長（toGrow）這個方法，但 Animal 和 Plant 沒有什麼關聯，而且 Java 只能繼承一個類別，所以 Sheep 繼承了 Animal，就不能再繼承 Grow 這個類別，這時就可以把 Grow 定義為介面，讓 Sheep 和 Tree 都可以實作這個介面。

在介面中定義的欄位、方法都有規定好的修飾子，可以寫也可以不寫，但不能衝突。

```java
public interface Grow{
    int height = 5;  //編譯完會自行在執行檔中加上 public static final
    void toGrow();    //編譯完會自行在執行檔加上 public abstract
}
```

實作時，必須實作所有該介面宣告的方法，否則會編譯錯誤。要使用介面中的變數（height）的話，透過「**介面名稱.欄位名稱**」就可以呼叫。

```java
public class Zoo4{
    public static void main(String[] args){
        Grow obj = new Sheep();
        obj.toGrow();
    }
}

class Sheep implements Grow{
    public void toGrow(){
        System.out.println("生長" + Grow.height + "公分");
    }
}
```

    生長5公分

除此之外，Java 規定最多只能繼承一個類別，但卻可以實作多個介面，只要在 implements 後面用逗號分隔就可。特別的是，在介面中可以多重繼承，如下所示：

```java
interface 介面名稱 extends 介面1, 介面2, ..., 介面n{

}
```

認識完介面，讓我們來比較抽象類別和介面吧！

|抽象類別|介面|
|:-|:-|
|用於被繼承，子類別要實作定義的抽象方法。|用於被實作，子類別要實作定義的方法。|
|可以定義完整的方法，也可只定義方法原型。|只能定義方法原型。|
|定義完整的資料欄位供繼承類別使用。|定義的資料欄位用於作為常數使用。|

當沒有預設的實作要繼承時（沒有欄位，也不需要預設的方法實作時），通常會使用介面來代替抽象類別。

<br>

物件導向的精華全部都在這四天所介紹的內容裡了，當然物件導向還有非常多的概念，但我們就先理解這些就好了。今天已經是第 24 天了，感覺這一路走來非常的充實呢！剩下的幾天，我們一起走完吧！