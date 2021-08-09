public class MergeSort{
    public static void main(String[] args){
        int[] arr = {41, 24, 97, 6, 19, 53, 78};
        int n = arr.length;
        mergesort(arr, 0, n - 1);
        for(int i = 0 ; i < n ; i++){
            System.out.printf("%d ", arr[i]);
        }
    }

    public static void merge(int[] arr, int head, int mid, int tail){
        int lenA = mid - head + 1;
        int lenB = tail - (mid+1) + 1;
        int[] A = new int[lenA];    //左子數列
        int[] B = new int[lenB];    //右子數列
        int i,j;
        for(i = 0 ; i < lenA ; i++){
            A[i] = arr[head+i];
        }
        for(j = 0 ; j < lenB ; j++){
            B[j] = arr[mid+1+j];
        }
        i = 0;
        j = 0;
        int k = head;
        while(i < lenA && j < lenB){
            if(A[i] < B[j]){
                arr[k] = A[i];
                i++;
                k++;
            }
            else{
                arr[k] = B[j];
                j++;
                k++;
            }
        }
        //右子數列已經結束，將左子數列剩餘的數複製到 arr
        while(i < lenA){
            arr[k] = A[i];
            i++;
            k++;
        }
        //左子數列已經結束，將右子數列剩餘的數複製到 arr
        while(j < lenB){
            arr[k] = B[j];
            j++;
            k++;
        }
    }

    public static void mergesort(int[] arr, int head, int tail){
        if(head < tail){
            int mid = (head + tail) / 2;
            mergesort(arr, head, mid);
            mergesort(arr, mid+1, tail);
            merge(arr, head, mid, tail);    //合併
        }
    }
}