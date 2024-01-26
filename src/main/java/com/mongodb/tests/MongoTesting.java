package com.mongodb.tests;
import com.mongodb.db.Create;
import com.mongodb.db.Crud;
import com.mongodb.user.Student;

import java.util.ArrayList;

public class MongoTesting {
    public static void main(String[] args){
    System.out.println("What operation do you want to do?");
    System.out.println("1 - Insert");
    System.out.println("2 - Update");
    Student student = new Student();
    Crud crud = new Crud();
    ArrayList<Double> grades = new ArrayList<>();
    grades.add(4.2);
    grades.add(3.7);
    grades.add(6.0);

    student.setId(1);
    student.setClasses("C");
    student.setGrades(grades);

    //crud.create();
    //crud.insert(student);
    crud.update(student);
    System.out.println("Done");
    }
}
