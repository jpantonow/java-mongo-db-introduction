package com.mongodb.db;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.print.Doc;
import java.util.Random;
import java.util.List;

public class Create extends Connection{
    public void creation(){
        try(MongoClient mongoclient = MongoClients.create(Create.connection)) {
            MongoDatabase sample = mongoclient.getDatabase("mongo_java");
            MongoCollection<Document> gradesCollection = sample.getCollection("school");
        }
        catch (MongoException e){
            e.printStackTrace();
        }

    }
}
