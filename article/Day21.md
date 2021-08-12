# [Day21] CH11：劉姥姥逛物件導向的世界——類別與物件

今天開始，我們要進入物件導向的世界了，先前已經簡單提過了，物件導向程式設計是一種以物件觀念來設計程式的程式設計技巧，透過物件的方法產生互動以完成程式要求。在開始前，先來介紹一些名詞解釋：

### 物件（Object）

真實世界中所有具體或抽象的事物，都可以將之視為一個「物件」。例如：橡皮擦、眼鏡、腳踏車等等。

### 類別（Class）

類別裡定義了<b>屬性（Property）</b>與<b>方法（Method）</b>，一個類別當中可以有很多物件，他們都具有同樣的屬性與方法。屬性就像是一個事物擁有的特性，而方法則是事物可以用來操作的動作。例如：定義一個汽車類別，他們有不同的顏色、品牌，且都可以前進和後退，顏色、品牌就是他們的屬性，而前進、後退就是他們的方法。

透過範例來看更清楚：

```java
public class MyPokemon{
    public static void main(String[] args){
        Pokemon p1 = new Pokemon();
        p1.setName("Pikachu");
        p1.setAttack(24);
        Pokemon p2 = new Pokemon();
        p2.setName("Squirtle");
        p2.setAttack(18);
        System.out.println("I'm " + p1.getName() + ". I can attack " + p1.getAttack());
        System.out.println("I'm " + p2.getName() + ". I can attack " + p2.getAttack());
    }
}

class Pokemon{
    private String name;
    private int attack;
    public String getName(){
        return name;
    }
    public int getAttack(){
        return attack;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
}
```

如範例，只要建立一個神奇寶貝（物件）後，每次都需要輸入屬性，那如果今天我有 100 隻神奇寶貝，不就很麻煩嗎？因此可以在類別裡使用<b>建構子（constructor）</b>，就可以一次賦予所有屬性。

前面在介紹方法得時候有提到「多載」，在建構子這裡也同樣適用。

```java
public class MyPokemon2{
    public static void main(String[] args){
        Pokemon2 p1 = new Pokemon2("Pikachu", 24);
        Pokemon2 p2 = new Pokemon2("Squirtle", 18);
        System.out.println("I'm " + p1.getName() + ". I can attack " + p1.getAttack());
        System.out.println("I'm " + p2.getName() + ". I can attack " + p2.getAttack());
    }
}

class Pokemon2{
    private String name;
    private int attack;

    //定義建構子
    public Pokemon2(String name, int attack){
        this.name = name;
        this.attack = attack;
    }
    public String getName(){
        return name;
    }
    public int getAttack(){
        return attack;
    }
}
```

兩個範例中我們都可以看到有使用 this，每個物件都可以利用關鍵字 this，來存取指向自己的參照。以上述範例來看，若我們將 setName() 的參數改命名為 n，則我們就不需要 this 來告訴 Java name 是指哪一個，但若是兩者皆命名為 name，便需要 this.name 指向自己。

```java
class Pokemon{
    private String name;
    private int attack;
    public String getName(){
        return name;
    }
    public int getAttack(){
        return attack;
    }
    public void setName(String n){
        name = n;
    }
    public void setAttack(int a){
        attack = a;
    }
}
```

明天我們會介紹為什麼物件導向程式設計的特性，為什麼會適合用來開發、管理大型程式，看似有點抽象，但理解後就不會那麼覺得了！
