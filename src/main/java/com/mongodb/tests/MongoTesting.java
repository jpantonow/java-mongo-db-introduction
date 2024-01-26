package com.mongodb.tests;
import com.mongodb.db.Create;
import com.mongodb.db.Crud;
import com.mongodb.user.Student;

import java.util.ArrayList;

public class MongoTesting {
    public static void main(String[] args){
    Student student = new Student();
    Crud crud = new Crud();
    ArrayList<Double> grades = new ArrayList<>();
    grades.add(9.8);
    grades.add(8.7);
    grades.add(10.0);

    student.setId(1);
    student.setClasses("A");
    student.setName("Jp");
    student.setGrades(grades);

    crud.create();
    crud.insert(student);

    System.out.println("Done");
    }
}
