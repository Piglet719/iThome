# [Day22] CH11：劉姥姥逛物件導向的世界——封裝性、繼承性

今天要來介紹物件導向的三大特性：封裝性、繼承性、多型性

## 封裝性（Encapsulation）

可以將物件區分為可被外界使用的特性或受保護的內部特性，也就是說外部程式無法改變物件內的資料，這樣一來就可以達到封裝保護資料的特性。

舉個例來說，今天你要開車，你只需要知道如何轉動方向盤、打檔，不需要知道引擎如何運作。

先前已經介紹過 public（公開）和 private（私人），其實還有第三種 protected（保護）

* public（公開）：允許任何程式碼使用
* private（私人）：只允許相同類別內的程式碼使用
* protected（保護）：只允許相同類別及子類別的程式碼使用

這就好像一個公司裡，有全公司員工都知道的公司規定（public），有只有管理員知道的機密（private），也有同一個部門和他的上級主管才知道的資訊（protected）。

## 繼承性（Inheritance）

是一種將軟體再利用的形式，會在建立新類別時吸收現有類別的成員，再新增或修改功能。透過繼承可以節省程式開發的時間，也可以提升有效實作及維護系統的可能性。

在建立類別時，可以指定新類別（子類別）去繼承現有類別（父類別）的成員，每個子類別也有可能成為未來其他人的父類別，彼此是相對的關係。

Java 中的每個類別都繼承自 Object，要注意的是 <b>Java 只支援「單向繼承」</b>，意思是說一個子類別只可以有一個父類別，但一個父類別可以被多個子類別繼承。

假設今天你是動物園管理員，要統整各動物的特性。這時候先以 Animal 當作父類別，Sheep 透過（extends）繼承了 Animal，但除了 Aniaml 的 name 以外，還多了 woolColor 的屬性，除此之外，也覆寫（override）了 move 方法。

```java
public class Zoo{
    public static void main(String[] args){
        Sheep s1 = new Sheep("綿羊1號","黑色");
        Sheep s2 = new Sheep();
        s2.setName("綿羊2號");
        s2.setWoolColor("白色");
        System.out.println(s1.getWoolColor() + s1.getName() + s1.move(10));
        System.out.println(s2.getWoolColor() + s2.getName() + s2.move(5));
    }
}

class Animal{
    private String name;
    
    public Animal(){

    } 
    
    public Animal(String name){
        this.name = name;
    }

    public String move(int units){
        return "移動" + units + "步";
    }

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

    黑色綿羊1號跑10步
    白色綿羊2號跑5步

我們可以看到呼叫 super() 會用來建構父類別，但其實如果不寫的話 Java 也會自動呼叫，但是若是有帶參數（像是 super(name)）就必須自行撰寫。

若我們今天將 Animal 裡的方法從 public 改為 protected，則那些方法一樣可以被 Sheep 存取，但是與 Animal 無關的類別（假設有另一個類別為 Vehicle）則無法存取。

### 覆寫（Override）

還記得我們介紹過的「多載」嗎？不記得的話可以回去看 Day10，接著要介紹的是英文名字和多載很像的「覆寫」，上面的範例就是覆寫的應用，但是覆寫時必須滿足幾個限制：

1. 父類別方法不能用 final 修飾

    有些值（像是 Pi），宣告完不需要再修改，為了防止遭到更動，在宣告時他的實體變數就是 final，例如：

    ```java
    public final int PI;
    ```

2. 子類別的方法名稱、回傳型態、參數個數需相同

方法名稱和回傳型態如果不同的話，那就不是覆寫了！參數個數不同的話那就是多載了！

3. 子類別覆寫的方法，其開放權限不可小於父類別的方法

存取修飾子的開放權限：public > protected > private

<br>

今天就先到這裡，是不是覺得這些特性很實用呢？尤其當你的程式非常大或是由多人撰寫而成時，最後的多型性就留到明天了，可以再試著想想看生活中有哪些東西有繼承的關係哦！