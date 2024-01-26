package com.mongodb.screens;

import com.mongodb.user.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Screen {
    public Integer Operations(){
        System.out.println("What operation do you want to do?");
        System.out.println("1 - Insert");
        System.out.println("2 - Update");
        System.out.println("3 - Read");
        System.out.println("4 - Delete");
        System.out.println("5 - Drop");

        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public Integer screenFind(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the student's Id:");
        return sc.nextInt();
    }
    public Integer screenDelete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the student's Id:");
        return sc.nextInt();
    }
    public String screenDrop(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the table's name:");
        return sc.next();
    }
    public Student screenInsert(Student obj){
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("Fill the values below: ");
        System.out.println("Id: ");
        Scanner sc = new Scanner(System.in);
        obj.setId(sc.nextInt());
        System.out.println("Name: ");
        obj.setName(sc.next());
        System.out.println("Class:");
        obj.setClasses(sc.next());
        System.out.println("1st exam:");
        grades.add(sc.nextDouble());
        System.out.println("2nd exam:");
        grades.add(sc.nextDouble());
        System.out.println("3rd exam:");
        grades.add(sc.nextDouble());
        obj.setGrades(grades);
        return obj;
    }
    public Student screenUpdate(Student obj){
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("Fill the values below: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Class:");
        obj.setClasses(sc.next());
        System.out.println("1st exam:");
        grades.add(sc.nextDouble());
        System.out.println("2nd exam:");
        grades.add(sc.nextDouble());
        System.out.println("3rd exam:");
        grades.add(sc.nextDouble());
        obj.setGrades(grades);
        return obj;
    }
}
