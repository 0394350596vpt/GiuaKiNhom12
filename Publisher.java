package Temperature.Observer;

import java.util.LinkedList;
import java.util.List;

public class Publisher {
    
    private List<Subcriber> subcribers = new LinkedList<>();

    public void Subcriber(Subcriber subcriber) {
        subcribers.add(subcriber);
    }

    public void unSubcriber(Subcriber subcriber) {
        subcribers.remove(subcriber);
    }

    public void notifySubcribers(double celsius, double fahrenheit) {
        for (Subcriber subcriber : subcribers) {
            subcriber.update(celsius, fahrenheit);
        }
    }
}
