import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UnitConverter extends JFrame implements ActionListener {

    private JComboBox<String> typeBox;
    private JComboBox<String> sourceUnitBox;
    private JComboBox<String> targetUnitBox;

    private JTextField inputField;
    private JTextField resultField;

    private JButton convertButton;

    private final String[] lengthUnits = {"公尺", "公分", "英吋", "英尺"};
    private final String[] weightUnits = {"公斤", "公克", "磅", "盎司"};
    private final String[] temperatureUnits = {"攝氏", "華氏", "克氏"};

    public UnitConverter() {

        setTitle("單位換算器");
        setSize(480, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // NORTH：換算類型
        String[] types = {"長度", "重量", "溫度"};
        typeBox = new JComboBox<>(types);

        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("換算類型："));
        northPanel.add(typeBox);

        add(northPanel, BorderLayout.NORTH);

        // CENTER：兩列
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 15));
        centerPanel.setBorder(
                BorderFactory.createEmptyBorder(30, 30, 30, 30)
        );

        inputField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        sourceUnitBox = new JComboBox<>(lengthUnits);
        targetUnitBox = new JComboBox<>(lengthUnits);

        // 第一列：輸入框 + 來源單位
        centerPanel.add(inputField);
        centerPanel.add(sourceUnitBox);

        // 第二列：結果框 + 目標單位
        centerPanel.add(resultField);
        centerPanel.add(targetUnitBox);

        add(centerPanel, BorderLayout.CENTER);

        // SOUTH：換算按鈕
        convertButton = new JButton("換算");
        convertButton.addActionListener(this);

        JPanel southPanel = new JPanel();
        southPanel.add(convertButton);

        add(southPanel, BorderLayout.SOUTH);

        // 切換換算類型
        typeBox.addActionListener(e -> updateUnits());

        setVisible(true);
    }

    private void updateUnits() {

        String type = (String) typeBox.getSelectedItem();

        sourceUnitBox.removeAllItems();
        targetUnitBox.removeAllItems();

        String[] units;

        if (type.equals("長度")) {
            units = lengthUnits;
        } else if (type.equals("重量")) {
            units = weightUnits;
        } else {
            units = temperatureUnits;
        }

        for (String unit : units) {
            sourceUnitBox.addItem(unit);
            targetUnitBox.addItem(unit);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            double value = Double.parseDouble(inputField.getText());

            String type = (String) typeBox.getSelectedItem();
            String source = (String) sourceUnitBox.getSelectedItem();
            String target = (String) targetUnitBox.getSelectedItem();

            double result;

            if (type.equals("長度")) {
                result = convertLength(value, source, target);
            } else if (type.equals("重量")) {
                result = convertWeight(value, source, target);
            } else {
                result = convertTemperature(value, source, target);
            }

            resultField.setText(String.format("%.2f", result));

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "請輸入正確的數字",
                    "輸入錯誤",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private double convertLength(double value, String source, String target) {

        double meter;

        switch (source) {
            case "公尺":
                meter = value;
                break;
            case "公分":
                meter = value / 100;
                break;
            case "英吋":
                meter = value * 0.0254;
                break;
            default:
                meter = value * 0.3048;
        }

        switch (target) {
            case "公尺":
                return meter;
            case "公分":
                return meter * 100;
            case "英吋":
                return meter / 0.0254;
            default:
                return meter / 0.3048;
        }
    }

    private double convertWeight(double value, String source, String target) {

        double kilogram;

        switch (source) {
            case "公斤":
                kilogram = value;
                break;
            case "公克":
                kilogram = value / 1000;
                break;
            case "磅":
                kilogram = value * 0.453592;
                break;
            default:
                kilogram = value * 0.0283495;
        }

        switch (target) {
            case "公斤":
                return kilogram;
            case "公克":
                return kilogram * 1000;
            case "磅":
                return kilogram / 0.453592;
            default:
                return kilogram / 0.0283495;
        }
    }

    private double convertTemperature(
            double value,
            String source,
            String target) {

        double celsius;

        if (source.equals("攝氏")) {
            celsius = value;
        } else if (source.equals("華氏")) {
            celsius = (value - 32) * 5 / 9;
        } else {
            celsius = value - 273.15;
        }

        if (target.equals("攝氏")) {
            return celsius;
        } else if (target.equals("華氏")) {
            return celsius * 9 / 5 + 32;
        } else {
            return celsius + 273.15;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UnitConverter());
    }
}