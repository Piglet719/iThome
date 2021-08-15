public class Zoo4{
    public static void main(String[] args){
        Grow obj = new Sheep2();
        obj.toGrow();
    }
}

class Sheep2 implements Grow{
    public void toGrow(){
        System.out.println("生長" + Grow.height + "公分");
    }
}