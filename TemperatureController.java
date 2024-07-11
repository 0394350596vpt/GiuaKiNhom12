package Temperature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureController implements ActionListener {
    private TemperatureModel model;
    private TemperatureView view;

    public TemperatureController(TemperatureView view, TemperatureModel model) {
        this.view = view;
        this.model = model;
    }

  
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Object source = e.getSource();
        //Xử lí các Button và Menu
        if (command.equals("C2F")) {
            double celsius = Double.parseDouble(view.getJTextFieldCelsius().getText());
            model.C2F(celsius);
        } 
        else if (command.equals("F2C")) {
            double fahrenheit = Double.parseDouble(view.getJTextFieldFahrenheit().getText());
            model.F2C(fahrenheit);
        } 
        else if (command.equals("Exit")) {
            System.exit(0);
        }

        //Xử lí khi nhấn Enter
        if (source == view.getJTextFieldCelsius()) {
            double celsius = Double.parseDouble(view.getJTextFieldCelsius().getText());
            model.C2F(celsius);
        } 
        else if (source == view.getJTextFieldFahrenheit()) {
            double fahrenheit = Double.parseDouble(view.getJTextFieldFahrenheit().getText());
            model.F2C(fahrenheit);
        }
    }
}


