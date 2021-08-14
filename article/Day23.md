# [Day23] CH11：劉姥姥逛物件導向的世界——多型

今天要來接續昨天沒介紹完的物件導向的第三個特性——多型。

## 多型（Polymorphism）

父類別可透過子類別衍伸成多種型態，而父類別為子類別的通用型態，再透過子類別可覆寫父類別的方法來達到多型的效果，也就是同樣的方法名稱會有多種行為。由昨天的範例來看：

```java
public class Zoo2{
    public static void main(String[] args){
        Animal s1 = new Sheep("綿羊1號","黑色");
        Animal s2 = new Sheep();
        s2.setName("綿羊2號");
        //s2.setWoolColor("白色"); 錯誤
        System.out.println(s1.getName() + s1.move(10)); //s1.getWoolColor() 錯誤
        System.out.println(s2.getName() + s2.move(5));   //s2.getWoolColor() 錯誤
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

    綿羊1號跑10步
    綿羊2號跑5步

我們看到在 main() 中， s1 與 s2 的型態是 Animal，這個動作就是「多型」，但是與昨天不同的是，如此一來 Sheep 類別中的方法就無法使用（如註解所示）。

<br>

還有最後兩個「抽象」和「介面」的概念，但為了怕大家一天吸收太多，今天就先到這裡就好，明天我們就要結束這回合了，敬請期待~