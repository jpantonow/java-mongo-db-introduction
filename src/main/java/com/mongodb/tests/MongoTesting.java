package com.mongodb.tests;
import com.mongodb.db.Create;
import com.mongodb.db.Crud;
import com.mongodb.user.Student;
import com.mongodb.screens.Screen;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MongoTesting {
    public static void main(String[] args){
    Screen screen = new Screen();
    Integer op = screen.Operations();

    Student student = new Student();
    student = screen.screenInsert(student);

    Crud crud = new Crud();

    //crud.create();
    crud.insert(student);
    //crud.update(student);
    System.out.println("Done");
    }
}
