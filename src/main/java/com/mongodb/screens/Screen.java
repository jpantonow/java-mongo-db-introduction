package com.mongodb.screens;

import com.mongodb.user.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Screen {
    public Integer Operations() {
        System.out.println("What operation do you want to do?");
        System.out.println("1 - Insert");
        System.out.println("2 - Update");
        System.out.println("3 - Read");
        System.out.println("4 - Delete");
        System.out.println("5 - Drop");
        System.out.println("6 - Approved");
        System.out.println("7 - Failed ");

        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public Map<String, Student> switchop(Integer op, Student obj) {
        String name = "";
        switch (op) {
            case 1:
                name += 1;
                obj = screenInsert(obj);
                break;
            case 2:
                name += 2;
                obj = screenUpdate(obj);
                break;
            case 3:
                name += 3;
                obj = screenFind();
                break;
            case 4:
                name += 4;
                obj = screenDelete();
                break;
            case 5:
                obj = null;
                name = screenDrop();
                break;
            case 6:
                obj = null;
                name = "Y";
                break;
            case 7:
                obj = null;
                name = "N";
        }

        Map<String, Student> ret = new HashMap<>();
        ret.put(name, obj);
        return ret;
    }

    public Student screenFind() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the student's Id:");
        Student student = new Student();
        student.setId(sc.nextInt());
        return student;
    }

    public Student screenDelete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the student's Id:");
        Student student = new Student();
        student.setId(sc.nextInt());
        return student;
    }

    public String screenDrop() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the table's name:");
        return sc.next();
    }

    public Student screenInsert(Student obj) {
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

    public void screenRead(Student obj) {
        System.out.println("\nShowing results:");
        System.out.println("ID:" + obj.getId());
        System.out.println("Name:" + obj.getName());
        System.out.println("Class:" + obj.getClasses());
        System.out.println("Grades:" + obj.getGrades());

    }

    public void screenPrint(String msg) {
        String greenColorCode = "\u001B[32m";
        String resetColorCode = "\u001B[0m";
        System.out.println(greenColorCode + msg + resetColorCode);
    }

    public Student screenUpdate(Student obj) {
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("Fill the values below: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("ID:");
        obj.setId(sc.nextInt());
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

    public void screenApproved(String results) {
        try {
            System.out.println("Showing approved students:");
            System.out.println(results);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void screenFailed(String results) {
        try {
            System.out.println("Showing students who failed:");
            System.out.println(results);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
