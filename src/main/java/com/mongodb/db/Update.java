package com.mongodb.db;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.user.Student;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

public class Update extends Connection{
    protected JsonWriterSettings prettyPrint = JsonWriterSettings.builder().indent(true).build();
    public void update_one(Student obj){
        try(MongoClient mongoclient = MongoClients.create(Connection.connection)){
            MongoDatabase sample = mongoclient.getDatabase("sample_training");
            MongoCollection<Document> gradesCollection = sample.getCollection("grades");
            Bson filter = eq("student_id", 10000);
            Bson updateop = set("comment", "You should learn MongoDB");
            UpdateResult updateres = gradesCollection.updateOne(filter,updateop);
            System.out.println("=> Updating the doc with {\"student_id\":10000}. Adding comment.");
            System.out.println(gradesCollection.find(filter).first().toJson(prettyPrint));
            System.out.println(updateres);
        }
        catch (MongoException e){
            e.printStackTrace();
        }
    }
    public void update_many(String pk){
        try(MongoClient mongoclient = MongoClients.create(Connection.connection)){
            MongoDatabase sample = mongoclient.getDatabase("sample_training");
            MongoCollection<Document> gradesCollection = sample.getCollection("grades");
            Bson filter = eq("student_id", 10000);
            Bson updateop = set("comment", "You should learn MongoDB");
            UpdateResult updateres = gradesCollection.updateMany(filter,updateop);
            System.out.println("\n=> Updating all the documents with {\"student_id\":10001}.");
            System.out.println(updateres);
        }
        catch (MongoException e){
            e.printStackTrace();
        }
    }

    public void find_and_update(String pk){
        try(MongoClient mongoclient = MongoClients.create(Connection.connection)){
            MongoDatabase sample = mongoclient.getDatabase("sample_training");
            MongoCollection<Document> gradesCollection = sample.getCollection("grades");
            Bson filter = eq("student_id", 10000);
            Bson up1 = inc("x",10);
            Bson up2 = rename("class_id","new_class_id");
            Bson up3 = mul("scores.0.score",2);
            Bson updates = combine(up1,up2,up3);

            //Old version
            Document oldversion = gradesCollection.findOneAndUpdate(filter,updates);
            System.out.println("\n=> FindOneAndUpdate operation. Printing the old version by default:");
            System.out.println(oldversion.toJson(prettyPrint));

            //New Version
            FindOneAndUpdateOptions optionsAfter = new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER);
            Document newversion = gradesCollection.findOneAndUpdate(filter,updates,optionsAfter);
            System.out.println("\n=> FindOneAndUpdate operation. But we can also ask for the new version of the doc:");
            System.out.println(newversion.toJson(prettyPrint));
        }
        catch (MongoException e){
            e.printStackTrace();
        }
    }

}
