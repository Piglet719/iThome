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