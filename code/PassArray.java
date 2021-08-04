public class PassArray {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("Original array:");
        for(int number : arr){
            System.out.printf(" %d", number);
        }
        System.out.println();
        
        doubleArray(arr);
        System.out.print("After double array:");
        for(int number : arr){
            System.out.printf(" %d", number);
        }
        System.out.println();
        
        System.out.printf("Original 3rd element: %d%n", arr[2]);
        doubleElement(arr[2]);
        System.out.printf("After double 3rd element: %d%n", arr[2]);
    }

    public static void doubleArray(int[] array){
        for(int i = 0 ; i < array.length ; i++){
            array[i] *= 2;
        }
    }

    public static void doubleElement(int element){
        element *= 2;
    }
}
