public class Maximum {
    public static void main(String[] args){
        int num1 = 5;
        int num2 = 7;
        int num3 = 4;
        myPrint();
        System.out.println(maxNum(num1, num2, num3));
        System.out.println(maxNum(num1, maxNum(num2, num3)));
    }

    public static void myPrint(){
        System.out.print("The maximum number is: ");
    }
    public static int maxNum(int a, int b, int c){
        if(a > b){
            if(a > c){
                return a;
            }
            else{
                return c;
            }
        }
        else{
            if(b > c){
                return b;
            }
            else{
                return c;
            }
        }
    }

    public static int maxNum(int a, int b){
        if(a > b){
            return a;
        }
        else{
            return b;
        }
    }
}
