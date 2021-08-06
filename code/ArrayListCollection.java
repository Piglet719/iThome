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
