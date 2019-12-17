package model;

import vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {


    private static final String URL_FORMAT;

    static {
        String s = "http://hh.ua/search/vacancy?text=java+Москва&page=3";
        URL_FORMAT = s;
    }

    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        Vacancy vacancy = new Vacancy();
        vacancy.setCity("Москва");
        vacancy.setCompanyName("Performance_lab");
        vacancy.setSalary("50000");
        vacancy.setTitle("Intership");
        vacancy.setUrl(URL_FORMAT);
        vacancy.setSiteName("head");
        vacancies.add(vacancy);
        return vacancies;
    }
}
