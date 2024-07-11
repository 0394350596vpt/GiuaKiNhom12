package Temperature;

import Temperature.Observer.Publisher;

public class TemperatureModel extends Publisher {
    private double celsius;
    private double fahrenheit;

    public void C2F(double celsius) {
        this.celsius = celsius;
        this.fahrenheit = (celsius * 9 / 5) + 32;
        notifySubcribers(celsius, fahrenheit);
    }

    public void F2C(double fahrenheit) {
        this.fahrenheit = fahrenheit;
        this.celsius = (fahrenheit - 32) * 5 / 9;
        notifySubcribers(celsius, fahrenheit);
    }

    public double getCelsius() {
        return celsius;
    }
    public double getFahrenheit() {
        return fahrenheit;
    }
}
