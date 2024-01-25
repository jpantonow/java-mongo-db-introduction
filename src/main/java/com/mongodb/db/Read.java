package com.mongodb.db;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;

public class Read extends Connection {

    public void read_one(String doc){
        try(MongoClient mongoclient = MongoClients.create(Connection.connection)){
            MongoDatabase sample = mongoclient.getDatabase("sample_training");
            MongoCollection<Document> gradesCollection = sample.getCollection("grades");

            Document student1 = gradesCollection.find(new Document("student_id",10000)).first();
            Document student2 = gradesCollection.find(eq("student_id", 10000)).first();
            System.out.println("Student 1: " + student1.toJson());
            System.out.println("Student 2: " + student2.toJson());

        }
        catch (MongoException e){
            e.printStackTrace();
        }
    }
    public void readlist(){

    }

}
