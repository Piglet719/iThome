import java.util.Scanner;

public class BinarySearch{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = {6, 19, 21, 24, 41, 53, 62, 78, 97};
        System.out.print("I want to find: ");
        int findNum = sc.nextInt();
        int position;
        if((position = binarysearch(arr, findNum)) != -1){  //把回傳值用 position 接收，再比對是否為 -1
            System.out.printf("%d is in the %d position.%n", findNum, position);
        }
        else{
            System.out.printf("%d isn't in the array.%n", findNum);
        }
        sc.close();
    }

    public static int binarysearch(int[] arr, int num){
        int result = -1;    //預設 -1 為沒找到
        int start = 0;
        int end = arr.length - 1;   //長度 - 1 為最後一個索引值

        while(start <= end){
            int mid = start + (end - start) / 2;    //end - start 是為了防止溢位
            if(arr[mid] > num){ //要找的值小於中間值
                end = mid - 1;  //陣列最後一個設為中間值前一個數字
            }
            else if(arr[mid] < num){    //要找的值大於中間值
                start = mid + 1;    //陣列第一個設為中間值後一個數字
            }
            else{   //要找的值等於中間值
                result = mid;
                break;
            }
        }
        return result;
    }
}