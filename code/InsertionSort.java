public class InsertionSort {
    public static void main(String[] args){
        int[] arr = {41, 24, 97, 6, 19, 53, 78};
        int n = arr.length;
        for(int i = 1 ; i < n ; i++){
            int temp = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > temp){ //持續比對是否比 temp 大
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        for(int i = 0 ; i < n ; i++){
            System.out.printf("%d ", arr[i]);
        }
    }
}
