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