package Temperature;

import Temperature.Observer.Subcriber;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TemperatureView extends JFrame implements Subcriber {
    private JPanel jPanel;
    private JLabel jLabelCelsius, jLabelFahrenheit;
    private JTextField jTextFieldCelsius, jTextFieldFahrenheit;
    private JButton buttonC2F, buttonF2C, buttonExit;
    private JMenuBar menuBarRemote;

    private TemperatureModel temperatureModelRemote;
    private TemperatureController temperatureControllerRemote;

    public JTextField getJTextFieldCelsius() {
        return jTextFieldCelsius;
    }

    public JTextField getJTextFieldFahrenheit() {
        return jTextFieldFahrenheit;
    }

    public JLabel getLabelCelsius() {
        return jLabelCelsius;
    }

    public JLabel getLabelFahrenheit() {
        return jLabelFahrenheit;
    }

    public TemperatureView() {
        temperatureModelRemote = new TemperatureModel();
        temperatureModelRemote.Subcriber(this);

        temperatureControllerRemote = new TemperatureController(this, temperatureModelRemote);

        buildPanel();
        buildMenu();

        setSize(400, 200);
        setTitle("Temperature Converter");
        setJMenuBar(menuBarRemote);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(jPanel);
    }

    public void buildPanel() {
        jPanel = new JPanel();

        jLabelCelsius = new JLabel("Celsius:");
        jPanel.add(jLabelCelsius);

        jTextFieldCelsius = new JTextField(10);
        jTextFieldCelsius.addActionListener(temperatureControllerRemote);
        jPanel.add(jTextFieldCelsius);

        jLabelFahrenheit = new JLabel("Fahrenheit:");
        jPanel.add(jLabelFahrenheit);

        jTextFieldFahrenheit = new JTextField(10);
        jTextFieldFahrenheit.addActionListener(temperatureControllerRemote);
        jPanel.add(jTextFieldFahrenheit);

        buttonC2F = new JButton("C2F");
        buttonC2F.addActionListener(temperatureControllerRemote);
        jPanel.add(buttonC2F);

        buttonF2C = new JButton("F2C");
        buttonF2C.addActionListener(temperatureControllerRemote);
        jPanel.add(buttonF2C);

        buttonExit = new JButton("Exit");
        buttonExit.addActionListener(temperatureControllerRemote);
        jPanel.add(buttonExit);
    }

    public void buildMenu() {
        menuBarRemote = new JMenuBar();
        JMenu temMenuRemote = new JMenu("Temperature");
        menuBarRemote.add(temMenuRemote);

        JMenuItem c2fMenuItemRemote = new JMenuItem("C2F");
        c2fMenuItemRemote.addActionListener(temperatureControllerRemote);
        temMenuRemote.add(c2fMenuItemRemote);

        JMenuItem f2cMenuItemRemote = new JMenuItem("F2C");
        f2cMenuItemRemote.addActionListener(temperatureControllerRemote);
        temMenuRemote.add(f2cMenuItemRemote);

        JMenuItem exitMenuItemRemote = new JMenuItem("Exit");
        exitMenuItemRemote.addActionListener(temperatureControllerRemote);
        temMenuRemote.add(exitMenuItemRemote);
    }

    @Override
    public void update(double celsius, double fahrenheit) {
        jTextFieldCelsius.setText(String.valueOf(celsius));
        jTextFieldFahrenheit.setText(String.valueOf(fahrenheit));
    }
}