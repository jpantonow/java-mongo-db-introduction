package com.mongodb.user;
import java.util.ArrayList;
public class Student {
    protected Integer id;
    protected String classes;
    protected String name;
    protected ArrayList<Double> grades;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Double> getGrades(){
        return grades;
    }
    public void setGrades(ArrayList<Double> grades){
        this.grades = grades;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getClasses() {
        return classes;
    }
    public void setClasses(String classes) {
        this.classes = classes;
    }
}
