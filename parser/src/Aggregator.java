import model.HHStrategy;
import model.Provider;
import model.Strategy;

import java.util.ArrayList;
import java.util.List;

public class Aggregator{

    public static void main(String[] args) {
        List<Provider> provider = new ArrayList<>();
        provider.add(new Provider(new HHStrategy()));
        provider.add(new Provider(new HHStrategy()));
        provider.add(new Provider(new HHStrategy()));
        provider.add(new Provider(new HHStrategy()));
        provider.add(new Provider(new HHStrategy()));
        Controller controller = new Controller(provider);
        controller.scan(provider);
    }
}
