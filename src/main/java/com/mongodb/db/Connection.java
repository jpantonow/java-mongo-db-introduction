package com.mongodb.db;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;

import java.util.ArrayList;
import java.util.List;

public class Connection {
    protected static String connection = "mongodb+srv://juventus:realmadridpai@cluster0.sju0aha.mongodb.net/";

    public static MongoClient initialize(){
        try(MongoClient mongoclient = MongoClients.create(connection)){
            return mongoclient;
        }
        catch (MongoException e) {
            e.printStackTrace();
            return null;
        }
    }
    static boolean preFlightChecks(MongoClient mongoClient){
        Document pingCommand = new Document("ping", 1);
        Document response = mongoClient.getDatabase("juventus").runCommand(pingCommand);
        response.toJson(JsonWriterSettings.builder().indent(true).build());
        return response.getDouble("ok").equals(1.0);
    }
}
