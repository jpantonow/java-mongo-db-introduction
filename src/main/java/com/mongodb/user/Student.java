package com.mongodb.user;
import java.util.ArrayList;
public class Student {
    protected Integer id;
    protected String name;
    protected ArrayList<Float> grades;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Float> getGrades(){
        return grades;
    }
    public void setGrades(ArrayList<Float> grades){
        this.grades = grades;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
