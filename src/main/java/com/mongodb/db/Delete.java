package com.mongodb.db;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;

public class Delete {
    public void delete(String doc){
        try(MongoClient mongoclient = MongoClients.create(Connection.connection)){
            MongoDatabase sample = mongoclient.getDatabase("sample_training");
            MongoCollection<Document> gradesCollection = sample.getCollection("grades");

            Bson filter = eq("student_id",10000);
            DeleteResult result = gradesCollection.deleteOne(filter);
        }
        catch(MongoException e){
            e.printStackTrace();
        }
    }
    public void find_and_delete(String doc){
        try(MongoClient mongoclient = MongoClients.create(Connection.connection)){
            MongoDatabase samples = mongoclient.getDatabase("sample_training");
            MongoCollection<Document> gradesCollection = samples.getCollection("grades");

            Bson filter = eq("student_id",10000);
            Document document = gradesCollection.findOneAndDelete(filter);
            System.out.println(document.toJson(JsonWriterSettings.builder().indent(true).build()));

        }
        catch (MongoException e){
            e.printStackTrace();
        }
    }
    public void delete_many(String doc){
        try(MongoClient mongoclient = MongoClients.create(Connection.connection)){
            MongoDatabase sample = mongoclient.getDatabase("sample_training");
            MongoCollection<Document> gradesCollection = sample.getCollection("grades");

            Bson filter = gte("student_id",10000);
            DeleteResult result = gradesCollection.deleteMany(filter);
            System.out.println(result);
        }
        catch(MongoException e){
            e.printStackTrace();
        }
    }
    public void delete_all(){
        try(MongoClient mongoclient = MongoClients.create(Connection.connection)){
            MongoDatabase sample = mongoclient.getDatabase("sample_training");
            MongoCollection<Document> gradesCollection = sample.getCollection("grades");
            gradesCollection.drop();
        }
        catch(MongoException e){
            e.printStackTrace();
        }
    }
}
