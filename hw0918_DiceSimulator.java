import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class hw0918_DiceSimulator extends JFrame {

    static JLabel lblInfo = new JLabel(
        "已擲 0 次，總和 0，平均 0.00",
        SwingConstants.CENTER
    );

    static JLabel lblDice = new JLabel(
        "-",
        SwingConstants.CENTER
    );

    static JButton btnRoll = new JButton("擲骰子");

    static int count = 0;
    static int sum = 0;

    static Random random = new Random();

    public static void main(String[] args) {

        JFrame frm = new JFrame("骰子模擬器");

        frm.setSize(400, 320);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLayout(new BorderLayout());

        // 上方資訊
        lblInfo.setFont(
            new Font("Microsoft JhengHei", Font.PLAIN, 18)
        );

        // 中央骰子點數
        lblDice.setFont(
            new Font("Arial", Font.BOLD, 60)
        );

        // 下方按鈕
        btnRoll.setFont(
            new Font("Microsoft JhengHei", Font.PLAIN, 20)
        );

        frm.add(lblInfo, BorderLayout.NORTH);
        frm.add(lblDice, BorderLayout.CENTER);
        frm.add(btnRoll, BorderLayout.SOUTH);

        btnRoll.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // ① 產生本次骰子點數 1～6
                int dice = random.nextInt(6) + 1;

                // ② 次數 +1
                count = count + 1;

                // ③ 將「本次骰子點數」加入總和
                sum = sum + dice;

                // ④ 計算平均
                double average = (double) sum / count;

                // ⑤ 顯示本次骰子點數
                lblDice.setText(Integer.toString(dice));

                // ⑥ 設定點數顏色
                if (dice == 6) {
                    lblDice.setForeground(Color.GREEN);
                } 
                else if (dice == 1) {
                    lblDice.setForeground(Color.RED);
                } 
                else {
                    lblDice.setForeground(Color.BLACK);
                }

                // ⑦ 顯示統計資料
                lblInfo.setText(
                    String.format(
                        "已擲 %d 次，總和 %d，平均 %.2f",
                        count, sum, average
                    )
                );

                // Terminal 顯示，方便檢查
                System.out.println(
                    "本次：" + dice +
                    "  次數：" + count +
                    "  總和：" + sum
                );
            }
        });

        frm.setVisible(true);
    }
}