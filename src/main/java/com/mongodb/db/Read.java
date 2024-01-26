package com.mongodb.db;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.user.Student;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;

public class Read extends Connection {

    public void read_one(Student obj){
        try(MongoClient mongoclient = MongoClients.create(Connection.connection)){
            MongoDatabase sample = mongoclient.getDatabase("mongo_java");
            MongoCollection<Document> gradesCollection = sample.getCollection("school");

            Document student1 = gradesCollection.find(new Document("id",obj.getId())).first();
            Document student2 = gradesCollection.find(eq("id", 10000)).first();
            System.out.println("Student 1: " + student1.toJson());

        }
        catch (MongoException e){
            e.printStackTrace();
        }
    }
    public void readlist(){

    }

}
