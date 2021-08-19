import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BMI extends JFrame{
    private final JLabel label1, label2, label3;
    private final JTextField textField, textField2;
    private final JButton btn;

    public BMI(){
        super("計算 BMI");
        super.setLayout(null);

        label1 = new JLabel("請輸入體重（公斤）：");
        label1.setBounds(70, 50, 150, 20);
        add(label1);

        textField = new JTextField("0");
        textField.setBounds(230, 50, 100, 20);
        add(textField);

        label2 = new JLabel("請輸入身高（公尺）：");
        label2.setBounds(70, 100, 150, 20);
        add(label2);

        textField2 = new JTextField("0");
        textField2.setBounds(230, 100, 100, 20);
        add(textField2);

        btn = new JButton("計算");
        btn.setBounds(70, 150, 260, 20);
        add(btn);

        label3 = new JLabel("BMI：");
        label3.setBounds(150, 200, 100, 20);
        add(label3);
    }
}
