package services;

import base.People;
import model.Methodist;
import repository.MethodistRepository;

import java.util.function.Function;

public class MethodistServices {

    public MethodistRepository methodistRepository;

    public MethodistServices() {
        this.methodistRepository = new MethodistRepository();
    }

    public void addMethodist(Methodist methodist) {
        methodistRepository.addMethodist(methodist);
    }

    public void deleteMethodist(Methodist methodist) {
        methodistRepository.deleteMethodist(methodist);
    }

    public void setMethodist(int pos, Methodist methodist) {
        methodistRepository.setMethodists(pos, methodist);
    }

    public void conversionClass(People people) {
        Function<People, Methodist> converter = t -> new Methodist(t.getName(), t.getFamilyName(),
                t.getAge(), t.getGender(), t.getAddress());
        addMethodist(converter.apply(people));

    }
}
