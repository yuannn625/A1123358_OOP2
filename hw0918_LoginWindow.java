import javax.swing.*;
import java.awt.*;

public class hw0918_LoginWindow extends JFrame {

    public hw0918_LoginWindow() {
        setTitle("登入");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 建立元件
        JLabel accountLabel = new JLabel("帳號：");
        JTextField accountField = new JTextField(15);

        JLabel passwordLabel = new JLabel("密碼：");
        JPasswordField passwordField = new JPasswordField(15);

        JButton loginButton = new JButton("登入");

        // 建立面板
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        panel.add(accountLabel);
        panel.add(accountField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(new JLabel(""));
        panel.add(loginButton);

        add(panel);

        // 按下登入按鈕
        loginButton.addActionListener(e -> {

            String account = accountField.getText();
            String password = new String(passwordField.getPassword());

            if (account.equals("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(
                        this,
                        "登入成功！"
                );
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "帳號或密碼錯誤！"
                );
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new hw0918_LoginWindow();
    }
}