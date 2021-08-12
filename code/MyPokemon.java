public class MyPokemon {
    public static void main(String[] args) {
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

class Pokemon {
    private String name;
    private int attack;

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}