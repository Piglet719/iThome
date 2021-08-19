# [Day28] CH13：畫出你的藏寶圖——事件處理（上）

今天我們要實作一個華氏攝氏的溫度轉換器，首先先來設計他的介面

```java
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
        label1.setBounds(70, 70, 150, 20);
        add(label1);

        textField = new JTextField("0");
        textField.setBounds(230, 70, 100, 20);
        add(textField);

        label2 = new JLabel("請輸入身高（公尺）：");
        label2.setBounds(70, 120, 150, 20);
        add(label2);

        textField2 = new JTextField("0");
        textField2.setBounds(230, 120, 100, 20);
        add(textField2);

        btn = new JButton("計算");
        btn.setBounds(70, 170, 260, 20);
        add(btn);

        label3 = new JLabel("BMI：");
        label3.setBounds(200, 2200, 100, 40);
        add(label3);
    }
}

```

```java
import javax.swing.JFrame;

public class CalculateBMI {
    public static void main(String[] args){
        BMI bmi = new BMI();
        bmi.setSize(400, 300);   //設定寬，長
        bmi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //設定預設的關閉視窗
        bmi.setVisible(true);    //視窗預設是不可見的
    }
}
```

接著我們要加入事件，事件處理機制有三部分：事件來源、事件物件和事件監聽者。

- 事件來源：與使用者互動的 GUI 元件。
- 事件物件：會封裝所發生事件的相關資訊。
- 事件監聽者：會監聽某個事件，執行他的某個方法，來回應該事件。

### 事件處理步驟（以按鈕為例）

1. 事件監聽者向按鈕註冊
2. 點擊按鈕產生事件
3. 按鈕會將「事件物件」傳遞給事件監聽者
4. 事件監聽者依據事件物件的種類把工作指派給事件處理者

### 註冊事件

每個 JComponent 都包含一個叫做 listenerList 的實體變數，指向 EventListenerList 類別的物件。每個 JComponent 子類別的物件，都會維護一個參照，指向他在 listenerList 中註冊的監聽者。

### 事件處理呼叫

每個事件型別都有一個或數個對應到的事件監聽者介面。當事件發生時， GUI 元件會收到一個獨特的事件 ID，指出事件的型別。GUI 元件就會使用這個事件 ID，判定其事件應該要分派給哪個監聽者型別，以及判定針對每個監聽者物件，應該要呼叫哪一種方法。

以下列出幾個事件類別、事件監聽者介面和監聽者介面所提供的事件處理者：

| 事件類別    | 監聽者介面                                           | 監聽者介面所提供的事件處理者                                                                                                                                                                                                           |
| :---------- | :--------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| ActionEvent | ActionListener                                       | actionPerformed(ActionEvent e)                                                                                                                                                                                                         |
| ItemEvent   | ItemListener                                         | itemStateChanged(ItemEvent e)                                                                                                                                                                                                          |
| KeyEvent    | KeyListener                                          | keyTyped(KeyEvent e)<br>keyPressed(KeyEvent e)<br>keyReleased(KeyEvent e)                                                                                                                                                              |
| MouseEvent  | <br>MouseListener<br><br><br><br>MouseMotionListener | mouseClicked(MouseEvent e)<br>mouseEntered(MouseEvent e)<br>mouseExited(MouseEvent e)<br>mousePressed(MouseEvent e)<br>mouseReleased(MouseEvent e)<br><br>mouseDragged(MouseEvente)<br>mouseMoved(MouseEvent e)                        |
| TextEvent   | TextListener                                         | textValueChanged(TextEvent e)                                                                                                                                                                                                          |
| WindowEvent | WindowListener                                       | windowActivated(WindowEvent e)<br>windowClosed(WindowEvent e)<br>windowClosing(WindowEvent e)<br>windowDeactivated(WindowEvent e)<br>windowDeiconified(WindowEvent e)<br>windowIconified(WindowEvent e)<br>windowOpened(WindowEvent e) |

以下是元件可能觸發事件類別的對應關係：

| 事件來源者 | 發生事件的類別型態                                     |
| :--------- | :----------------------------------------------------- |
| JButton    | ActionEvent                                            |
| JCheckBox  | ActionEvent<br>ItemEvent                               |
| JComponent | ComponentEvent<br>FocusEvent<br>KeyEvent<br>MouseEvent |
| MenuItem   | ActionEvent                                            |
| TextField  | ActionEvent                                            |
| Window     | WindowEvent                                            |

<br>

以上是對事件的簡單介紹，大家可以試試看在視窗上自己增加事件來完成這個程式，明天會公布我的寫法供大家參考。
