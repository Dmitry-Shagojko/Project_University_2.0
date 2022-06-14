package repository;

import model.Methodist;

import java.util.ArrayList;

public class MethodistRepository {

    public ArrayList<Methodist> methodists;

    public MethodistRepository(){
        this.methodists = new ArrayList<>();
    }
    public void addMethodist (Methodist methodist){
        methodists.add(methodist);
    }
    public void deleteMethodist (Methodist methodist){
        methodists.remove(methodist);
    }
    public void setMethodists (int pos, Methodist methodist){
        methodists.set(pos, methodist);
    }
}
