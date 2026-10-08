import javax.swing.*;

public class hw0918_LoginWindow extends JFrame {

    public hw0918_LoginWindow() {

        setTitle("登入");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel l1 = new JLabel("帳號:");
        JTextField t1 = new JTextField();

        JLabel l2 = new JLabel("密碼:");
        JPasswordField t2 = new JPasswordField();

        JButton btn = new JButton("登入");

        // 設定元件位置
        l1.setBounds(40, 30, 60, 25);
        t1.setBounds(100, 30, 130, 25);

        l2.setBounds(40, 70, 60, 25);
        t2.setBounds(100, 70, 130, 25);

        btn.setBounds(100, 110, 80, 30);

        // 加入視窗
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(btn);

        // 登入按鈕事件
        btn.addActionListener(e -> {

            String account = t1.getText();
            String password = new String(t2.getPassword());

            if (account.equals("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(this, "登入成功");
            } else {
                JOptionPane.showMessageDialog(this, "帳號或密碼錯誤");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new hw0918_LoginWindow();
    }
}