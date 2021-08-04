import java.util.Scanner;

public class GradeClassification {
    public static void main(String[] args){
        int A = 0;  //90-100
        int B = 0;  //80-89
        int C = 0;  //70-79
        int D = 0;  //60-69
        int F = 0;  //0-59
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the grades: "); //Windows按下 Ctrl+z 終止，其他作業系統按下 Ctrl+d 終止
        while(sc.hasNext()){
            int grade = sc.nextInt();
            switch(grade / 10){
                case 9: //90-99
                case 10:    //100
                    A++;
                    break;  //exits switch

                case 8: //80-89
                    B++;
                    break;
                
                case 7: //70-79
                    C++;
                    break;

                case 6: //60-69
                    D++;
                    break;

                default:    //0-59
                    F++;
                    break;
            }
        }
        System.out.printf("A: %d%nB: %d%nC: %d%nD: %d%nF: %d%n", A, B, C, D, F);
        sc.close();
    }
}
