public class SumArray {
    public static void main(String[] args){
        int[] arr = {4, 25, 13, 37, 9};
        int total = 0;
        for(int i = 0 ; i < arr.length ; i++){
            total += arr[i];
        }
        System.out.printf("Total of array elements: %d%n", total);        
    }
}
