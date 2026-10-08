import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class hw0918_DiceSimulator extends JFrame implements ActionListener {

    private JLabel statusLabel;
    private JLabel diceLabel;
    private JButton rollButton;

    private int count = 0;
    private int total = 0;

    private final Random random = new Random();

    public hw0918_DiceSimulator() {

        // 視窗設定
        setTitle("骰子模擬器");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // 上方統計資料
        statusLabel = new JLabel(
                "已擲 0 次，總和 0，平均 0.00",
                SwingConstants.CENTER
        );
        statusLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 18));
        add(statusLabel, BorderLayout.NORTH);

        // 中央骰子點數
        diceLabel = new JLabel("－", SwingConstants.CENTER);
        diceLabel.setFont(new Font("Arial", Font.BOLD, 60));
        diceLabel.setForeground(Color.BLACK);
        add(diceLabel, BorderLayout.CENTER);

        // 下方按鈕
        rollButton = new JButton("擲骰子");
        rollButton.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
        rollButton.addActionListener(this);
        add(rollButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // 隨機產生 1～6
        int number = random.nextInt(6) + 1;

        count++;
        total += number;

        // 顯示目前點數
        diceLabel.setText(String.valueOf(number));

        // 改變點數顏色
        if (number == 6) {
            diceLabel.setForeground(Color.GREEN);
        } else if (number == 1) {
            diceLabel.setForeground(Color.RED);
        } else {
            diceLabel.setForeground(Color.BLACK);
        }

        // 計算平均
        double average = (double) total / count;

        // 更新統計資料
        statusLabel.setText(
                String.format(
                        "已擲 %d 次，總和 %d，平均 %.2f",
                        count, total, average
                )
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new hw0918_DiceSimulator();
        });
    }
}
