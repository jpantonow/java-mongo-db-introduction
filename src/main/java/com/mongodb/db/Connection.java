package com.mongodb.db;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;

import java.util.ArrayList;
import java.util.List;

public class Connection {
    public static String connection = System.getenv("mongourl");

    public MongoClient initialize() {
        try (MongoClient mongoclient = MongoClients.create(connection)) {
            return mongoclient;
        } catch (MongoException e) {
            e.printStackTrace();
            return null;
        }
    }

    public MongoCollection<Document> find_table() {
        try (MongoClient mongoclient = MongoClients.create(connection)) {
            MongoDatabase sample = mongoclient.getDatabase("mongo_java");
            return sample.getCollection("school");
        } catch (MongoException e) {
            e.printStackTrace();
            return null;
        }

    }
}