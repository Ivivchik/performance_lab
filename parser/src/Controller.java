import model.Provider;

import java.util.List;

public class Controller {

    private List<Provider> providers;

    public Controller(List<Provider> providers) {
        if (providers == null)
            throw new IllegalArgumentException();
        else
            this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + providers +
                '}';
    }

    public void scan(List<Provider> provider) {
        for (Provider provider1 : provider) {
            System.out.println(provider1.getJavaVacancies("h"));
        }
    }
}
