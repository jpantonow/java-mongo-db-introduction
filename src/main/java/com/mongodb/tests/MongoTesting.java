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

    System.out.println(crud.approved());
    while(true){
        Integer op = screen.Operations();
        objs = screen.switchop(op,student);
        for(String i: objs.keySet()) {

            switch (op){
                case 1:
                    student = objs.get(i);
                    crud.insert(student);
                    screen.screenPrint("Operation done successfully.");
                    break;
                case 2:
                    student = objs.get(i);
                    crud.update(student);
                    screen.screenPrint("Operation done successfully.");
                    break;
                case 3:
                    student = objs.get(i);
                    screen.screenRead(crud.view(student));
                    screen.screenPrint("Operation done successfully.");
                    break;
                case 4:
                    student = objs.get(i);
                    crud.delete(student);
                    screen.screenPrint("Operation done successfully.");
                    break;
                case 5:
                    crud.drop("grades");
                    screen.screenPrint("Operation done successfully.");
                    break;
                case 6:
                    String result_set = crud.approved();
                    screen.screenApproved(result_set);
                    screen.screenPrint("Operation done successfully.");
                    break;

                case 7:
                    String result_set2 = crud.disapproved();
                    screen.screenFailed(result_set2);
                    screen.screenPrint("Operation done successfully.");
                    break;

            }
            break;
        }

    }

    }
}
