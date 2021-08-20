# [Day29] CH13：畫出你的藏寶圖——事件處理（下）

接續昨天的程式，增加事件監聽者至 BMI 類別。

```java
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class BMI2 extends JFrame{
    private final JLabel label1, label2, label3;
    private final JTextField textField, textField2;
    private final JButton btn;

    public BMI2(){
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

        ButtonHandler handler = new ButtonHandler();
        btn.addActionListener(handler);

        label3 = new JLabel("BMI：");
        label3.setBounds(150, 200, 100, 20);
        add(label3);
    }

    private class ButtonHandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent event){
            double weight = 0, height = 0, bmi = 0;
            try{
                weight = Double.parseDouble(textField.getText());   //取得文字框文字
                height = Double.parseDouble(textField2.getText());
                bmi = weight / (height * height);
                label3.setText("BMI：" + bmi);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "請輸入數字", "輸入錯誤", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
```

```java
import javax.swing.JFrame;

public class CalculateBMI2 {
    public static void main(String[] args){
        BMI2 bmi = new BMI2();
        bmi.setSize(400, 300);   //設定寬，長
        bmi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //設定預設的關閉視窗         
        bmi.setVisible(true);    //視窗預設是不可見的
    }
}
```

我們可以看到 JButton 會產生任何 ActionListener 物件能夠處裡的 ActionEvent。建立一個 private 內層類別 ButtonHandler 的物件，再使用 addActionListener 將之註冊為每個 JButton 的事件處理常式。 ButtonHandler 類別宣告了 actionPerformed，取得兩個 JTextField 的文字，經過運算後將 BMI 呈現出來。若是輸入不為數字，則跳出警告框提示。

<br>

除了 JButton 外，昨天還有提到像是 JCheckBox、JComboBox、JList 等都可以做為事件來源者，還記得我們前幾天寫的猜數字遊戲嗎？也可以試試看把它變成可以互動的遊戲視窗，似乎看起來就更專業了！

用了三天的時間簡單介紹了圖形使用者介面，相關的內容還有非常多，鼓勵大家可以多多嘗試，對 Swing 多加了解。

這是這 30 天教學的最後一個單元了，不知道大家是不是對 Java 有一定的了解了，明天最後一天，一起來回顧學到了些什麼吧！