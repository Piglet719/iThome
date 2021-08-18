# [Day27] CH13：畫出你的藏寶圖——圖形使用者介面

終於來到我們最後一個主題了，今天我們要介紹的是圖形使用者介面（graphical user interface, GUI），不知道大家有沒有聽過，但大家一定都用過，他就是一種與應用程式互動的友善操作機制，Windows 作業系統本身就是一個常見的例子。

Java GUI 的元件有 Swing 和 AWT 兩組，在早期的 Java 中，GUI 透過 java.awt 套件中的 Abstract Window Toolkit（AWT）的元件來建構。AWT 設計的視窗圖形程式會跟作業系統原本的視窗風格一致， Swing 則是完全用 Java 來撰寫、操作與顯示，因此在各平台間並無外觀上的差異。接下來，我們會著重在 Swing 的介紹：

## Swing 元件

Java 的圖形化介面由各式各樣的「元素」組成，像是視窗、按鈕、對話框等等，這些元素統一被稱為元件（Component），依照不同功能，可分為頂層容器、中間容器、基本元件：

### 頂層容器

屬於視窗類別元件，繼承自 java.awt.Window，可以獨立顯示。

| 元件    | 說明                                                                  |
| :------ | :-------------------------------------------------------------------- |
| JFrame  | 一個普通的視窗（大多數 Swing GUI 元件的視窗使用 JFrame 作為頂層容器） |
| JDialog | 對話方塊                                                              |

### 中間容器

中間容器當作基本元件的載體，不能獨立顯示，繼承自 javax.swing.JComponent，可以添加多個基本元件，對容器內的組件進行管理。

| 元件         | 說明                                             |
| :----------- | :----------------------------------------------- |
| JPanel       | 一般輕量級面板容器元件，可以放置及編排元件的區域 |
| JScrollPane  | 帶滾動條的，可以水平和垂直滾動的面板元件         |
| JSplitPane   | 分隔面板                                         |
| JTabbedPane  | 選項卡面板                                       |
| JLayeredPane | 層級面板                                         |

### 基本元件

繼承自 javax.swing.JComponent。

| 元件           | 說明                                                                 |
| :------------- | :------------------------------------------------------------------- |
| JLabel         | 標籤，用來顯示不可編輯的文字或圖示                                   |
| JButton        | 按鈕，滑鼠點擊時會觸發事件                                           |
| JRadioButton   | 單選按鈕                                                             |
| JCheckBox      | 複選框，用來指定可選取或未選取的選項                                 |
| JToggleButton  | 開關按鈕                                                             |
| JTextField     | 文字框，通常用來接收使用者的輸入                                     |
| JPasswordField | 密碼框，通常用在密碼的輸入                                           |
| JTextArea      | 文字區域，用來呈現文字內容                                           |
| JComboBox      | 下拉式選單，使用者可以從中選擇項目                                   |
| JList          | 項目清單，使用者可以點擊其中任何一者來進行選擇，也可同時選擇多個項目 |
| JProgressBar   | 進度條                                                               |
| JSlider        | 滑動條                                                               |

<br>

由於應用程式的 GUI 基本上屬於應用程式，所以大部分的例子都會包含兩個類別，一個 JFrame 子類別幫助展示新的 GUI 概念，另一個應用程式類別，其中的 main 方法會建立並顯示應用程式的主要視窗。接著就來建立一個簡單的視窗和元件：

```java
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Frame extends JFrame{
    private final JLabel label;
    private final JButton button;
    private final JTextField textField;

    public Frame(){
        super("Hello Swing");   //建立標題名稱
        super.setLayout(null);

        label = new JLabel("Enter your name:");
        label.setBounds(140, 50, 100, 30);  //設定x，y，寬，高
        add(label);

        button = new JButton("Click me!");
        button.setBounds(125, 200, 150, 25);
        add(button);

        textField = new JTextField(10); //設定10列
        textField.setBounds(140, 100, 120, 30);
        add(textField);
    }
}
```

```java
import javax.swing.JFrame;

public class TestFrame {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(400, 300);   //設定寬，長
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //設定預設的關閉視窗
        frame.setVisible(true);    //視窗預設是不可見的
    }
}
```

在使用每一個元件的時候，要記的先 import。在範例中可以看到有按鈕，但是按下去卻沒有任何反應，這是當然的啦！因為我們還沒告訴他要做什麼反應。當使用者與 GUI 元件互動時，此互動稱為「事件」（Event），會驅動程式去執行任務。

<br>

明天我們就要針對這部分進行更詳盡的說明，也會製作出一個小小的互動事件，在設計個過程中，也會增加你們對設計程式的能力，準備好要大顯身手了嗎？那我們明天再見囉！
