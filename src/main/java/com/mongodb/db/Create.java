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
    protected Document insert(){
        Random rand = new Random();
        Document student = new Document("_id", new ObjectId());
        student.append("student_id",10000d)
                .append("class_id",1d)
                .append("scores", List.of(new Document("type","exam").append("score",rand.nextDouble()*100),
                        new Document("type","quiz").append("score",rand.nextDouble()*100),
                        new Document("type","homework").append("score",rand.nextDouble()*100),
                        new Document("type","homework").append("score",rand.nextDouble()*100),
                        new Document("type", "joaozinho").append("score",100),
                        new Document("type", "miguelzinho").append("score",90),
                        new Document("type","gabi").append("score",87)));
        return student;
    }
    public void creation(){
        try(MongoClient mongoclient = MongoClients.create(Create.connection)) {
            MongoDatabase sample = mongoclient.getDatabase("sample_training");
            MongoCollection<Document> gradesCollection = sample.getCollection("grades");
            Document student = insert();
            gradesCollection.insertOne(student);
        }
        catch (MongoException e){
            e.printStackTrace();
        }

    }
}
