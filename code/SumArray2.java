public class SumArray2 {
    public static void main(String[] args){
        int[] arr = {4, 25, 13, 37, 9};
        int total = 0;
        for(int number : arr){
            total += number;
        }
        System.out.printf("Total of array elements: %d%n", total);        
    }
}
