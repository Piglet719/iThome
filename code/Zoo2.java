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