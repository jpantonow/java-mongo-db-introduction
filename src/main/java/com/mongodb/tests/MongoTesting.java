package com.mongodb.tests;
import com.mongodb.db.Create;
import com.mongodb.db.Crud;
import com.mongodb.user.Student;
import com.mongodb.screens.Screen;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MongoTesting {
    public static void main(String[] args){
    Screen screen = new Screen();
    //Integer op = screen.Operations();

    Student student = new Student();
    //student = screen.screenInsert(student);

    Crud crud = new Crud();

    Map<String,Student> objs = new HashMap<>();


    while(true){
        Integer op = screen.Operations();
        objs = screen.switchop(op,student);
        for(String i: objs.keySet()) {
            if (objs.get(i) == null) {
                crud.drop(i);
                break;
            }
            student = objs.get(i);
            switch (op){
                case 1:
                    crud.insert(student);
                    screen.screenPrint("Operation done successfully.");
                    break;
                case 2:
                    crud.update(student);
                    screen.screenPrint("Operation done successfully.");
                    break;
                case 3:
                    screen.screenRead(crud.view(student));
                    screen.screenPrint("Operation done successfully.");
                    break;
                case 4:
                    crud.delete(student);
                    screen.screenPrint("Operation done successfully.");
                    break;
            }
            break;
        }

    }

    }
}
