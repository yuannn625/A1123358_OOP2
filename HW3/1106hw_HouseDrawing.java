import javax.swing.*;
import java.awt.*;

class hw1106_HouseDrawing extends JPanel {

    public hw1106_HouseDrawing() {
        setPreferredSize(new Dimension(800, 650));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // 讓線條比較平滑
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // 天空
        g2.setColor(new Color(135, 206, 235));
        g2.fillRect(100, 60, 600, 500);

        // 草地
        g2.setColor(new Color(75, 180, 80));
        g2.fillRect(100, 460, 600, 100);

        // 太陽
        g2.setColor(Color.YELLOW);
        g2.fillOval(570, 100, 100, 100);

        // 太陽光芒
        g2.drawLine(620, 70, 620, 95);
        g2.drawLine(620, 205, 620, 235);

        g2.drawLine(540, 150, 565, 150);
        g2.drawLine(675, 150, 700, 150);

        g2.drawLine(565, 95, 545, 75);
        g2.drawLine(675, 95, 695, 75);

        g2.drawLine(565, 205, 545, 225);
        g2.drawLine(675, 205, 695, 225);

        // 雲
        g2.setColor(Color.WHITE);
        g2.fillOval(180, 120, 100, 65);
        g2.fillOval(230, 100, 110, 85);
        g2.fillOval(290, 120, 100, 65);
        g2.fillOval(220, 135, 130, 55);

        // 房子本體
        g2.setColor(new Color(255, 222, 170));
        g2.fillRect(300, 300, 250, 200);

        // 房子外框
        g2.setColor(Color.BLACK);
        g2.drawRect(300, 300, 250, 200);

        // 屋頂
        // 不填色，只保留紅色外框，因此屋頂內部是透明的
        int[] roofX = {275, 425, 575};
        int[] roofY = {300, 185, 300};

        g2.setColor(Color.RED);
        g2.drawPolygon(roofX, roofY, 3);

        // 左邊窗戶
        g2.setColor(Color.WHITE);
        g2.fillRect(325, 340, 65, 65);

        g2.setColor(Color.BLACK);
        g2.drawRect(325, 340, 65, 65);

        // 左窗十字
        g2.drawLine(357, 340, 357, 405);
        g2.drawLine(325, 372, 390, 372);

        // 右邊窗戶
        g2.setColor(Color.WHITE);
        g2.fillRect(460, 340, 65, 65);

        g2.setColor(Color.BLACK);
        g2.drawRect(460, 340, 65, 65);

        // 右窗十字
        g2.drawLine(492, 340, 492, 405);
        g2.drawLine(460, 372, 525, 372);

        // 門
        g2.setColor(new Color(150, 75, 20));
        g2.fillRoundRect(
                395, 390,
                65, 110,
                18, 18
        );

        // 門把
        g2.setColor(Color.YELLOW);
        g2.fillOval(445, 440, 10, 10);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Home Work");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new hw1106_HouseDrawing());

        frame.pack();

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}