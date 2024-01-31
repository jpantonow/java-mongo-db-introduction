package com.mongodb.db;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.user.Student;
import org.bson.BsonDocument;
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

    public Student read_one(Student obj){
        try(MongoClient mongoclient = MongoClients.create(Connection.connection)){
            MongoDatabase sample = mongoclient.getDatabase("mongo_java");
            MongoCollection<Document> gradesCollection = sample.getCollection("school");

            AggregateIterable<Document> found = gradesCollection.aggregate(
                    Arrays.asList(Aggregates.match(
                            Filters.eq("id",obj.getId())),
                            Aggregates.unwind("$grades"),
                            Aggregates.group("$id",
                                    Accumulators.addToSet("name","$name"),
                                    Accumulators.addToSet("class", "$class"),
                                    Accumulators.push("grades","$grades")
            )));

            Document results = found.iterator().next();
            //Integer id = Integer.parseInt(results.get("id").toString());
            String name = results.get("name").toString();
            String classes = results.get("class").toString();
            String grades = results.get("grades").toString();


            //obj.setId(id);
            obj.setName(name.substring(1,name.length()-1));
            //obj.setName(grades.substring(1,grades.length()-1));
            obj.setClasses(classes.substring(1,classes.length()-1));

            return obj;
        }
        catch (MongoException e){
            e.printStackTrace();
            return null;
        }
    }
    public Double readavg(Student obj){
        try(MongoClient mongoclient = MongoClients.create(Connection.connection)){
            MongoDatabase sample = mongoclient.getDatabase("mongo_java");
            MongoCollection<Document> gradesCollection = sample.getCollection("school");

            AggregateIterable<Document> avg = gradesCollection.aggregate(
                    Arrays.asList(Aggregates.match(
                            Filters.eq("id",obj.getId())),
                    Aggregates.unwind("$grades"),
                    Aggregates.group("$id",
                            Accumulators.avg("average","$grades"))
                            ));

            String average = avg.iterator().next().get("average").toString();
            return parseDouble(average);
            //return parseDouble(avg.iterator().next().get("average"));
        }
        catch (MongoException e){
            e.printStackTrace();
            return null;
        }
    }
    }

