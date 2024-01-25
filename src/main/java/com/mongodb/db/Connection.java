package com.mongodb.db;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;

import java.util.ArrayList;
import java.util.List;

public class Connection {
    protected static String connection = System.getenv("mongourl");
    public MongoClient initialize(){
        try(MongoClient mongoclient = MongoClients.create(connection)){
            return mongoclient;
        }
        catch (MongoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
