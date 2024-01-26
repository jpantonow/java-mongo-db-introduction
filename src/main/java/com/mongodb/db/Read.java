package com.mongodb.db;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.user.Student;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;
import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;

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
    public Double readavg(Student obj){
        try(MongoClient mongoclient = MongoClients.create(Connection.connection)){
            MongoDatabase sample = mongoclient.getDatabase("mongo_java");
            MongoCollection<Document> gradesCollection = sample.getCollection("school");

            Document student1 = gradesCollection.find(new Document("id",obj.getId())).first();
            DBObject group = new BasicDBObject("id",obj.getId());
            group.put("avg", new BasicDBObject("$avg","$pop"));
            DBObject grades = new BasicDBObject("$group", group);
            AggregateIterable<Document> avg = gradesCollection.aggregate(Arrays.asList(
                    Aggregates.group(Filters.eq("id",obj.getId()),
                            Accumulators.avg("average","$grades"))));
            return parseDouble(avg.iterator().next().toJson());
        }
        catch (MongoException e){
            e.printStackTrace();
            return null;
        }
    }
    }

