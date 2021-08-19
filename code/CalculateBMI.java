import javax.swing.JFrame;

public class CalculateBMI {
    public static void main(String[] args){
        BMI bmi = new BMI();
        bmi.setSize(400, 300);   //設定寬，長
        bmi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //設定預設的關閉視窗         
        bmi.setVisible(true);    //視窗預設是不可見的
    }
}
