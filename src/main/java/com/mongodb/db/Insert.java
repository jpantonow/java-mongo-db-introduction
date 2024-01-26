package com.mongodb.db;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.user.Student;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
public class Insert extends Connection {
    protected void insert(Student obj){
        try {
            ArrayList<Float> grades = obj.getGrades();
            Document student = new Document("id", obj.getId());
            student.append("class", obj.getClasses());
            student.append("name", obj.getName());
            student.append("grades", List.of(
                    new Document("1", grades.get(0)),
                    new Document("2", grades.get(1)),
                    new Document("3", grades.get(2))
            ));
            MongoCollection table = find_table();
            table.insertOne(student);
        }
        catch (MongoException e){
            e.printStackTrace();
        }
    }

}
