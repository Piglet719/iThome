public class SelectionSort {
    public static void main(String[] args){
        int[] arr = {41, 24, 97, 6, 19, 53, 78};
        int n = arr.length;
        for(int i = 0 ; i < n-1 ; i++){
            int min = i;
            for(int j = i+1 ; j < n ; j++){
                if(arr[min] > arr[j]){  //找最小值
                    min = j;
                }
            }
            int t = arr[i]; //兩數交換
            arr[i] = arr[min];
            arr[min] = t;
        }
        for(int i = 0 ; i < n ; i++){
            System.out.printf("%d ", arr[i]);
        }
    }
}
