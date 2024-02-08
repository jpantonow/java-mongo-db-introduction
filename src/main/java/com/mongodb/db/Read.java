package com.mongodb.db;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.user.Student;
import org.bson.BsonDocument;
import org.bson.Document;

import javax.print.Doc;
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
    private boolean check_null(List doc, Integer pos){
        return Integer.parseInt(doc.get(pos).toString()) == 0;
    }
//    private ArrayList<Double> fill_arr(ArrayList<Double> g, List doc){
//        //for(String i: )
//    }
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
            ArrayList<Double> grades = new ArrayList<>();
            Document results = found.iterator().next();
            String name = results.get("name").toString();
            String classes = results.get("class").toString();
            List grades_rcv = (List)results.get("grades");
            if(!check_null(grades_rcv,0)) {

                String grade1 = grades_rcv.get(0).toString().substring(grades_rcv.get(0).toString().indexOf("=") + 1, grades_rcv.get(0).toString().indexOf("}"));
                String grade2 = grades_rcv.get(1).toString().substring(grades_rcv.get(1).toString().indexOf("=") + 1, grades_rcv.get(1).toString().indexOf("}"));
                String grade3 = grades_rcv.get(2).toString().substring(grades_rcv.get(2).toString().indexOf("=") + 1, grades_rcv.get(2).toString().indexOf("}"));

                grades.add(Double.parseDouble(grade1));
                grades.add(Double.parseDouble(grade2));
                grades.add(Double.parseDouble(grade3));
            }
            //obj.setId(id);
            obj.setName(name.substring(1,name.length()-1));
            //obj.setName(grades.substring(1,grades.length()-1));
            obj.setClasses(classes.substring(1,classes.length()-1));
            obj.setGrades(grades);

            return obj;
        }
        catch (MongoException e){
            e.printStackTrace();
            return null;
        }
    }
    public String read_approved(){
        try(MongoClient mongoclient = MongoClients.create(Connection.connection)){
            MongoDatabase sample = mongoclient.getDatabase("mongo_java");
            MongoCollection<Document> gradesCollection = sample.getCollection("school");
            String[] gradesFields = {"$grades.1", "$grades.2", "$grades.3"};

            AggregateIterable<Document> approved = gradesCollection.aggregate(
                    Arrays.asList(
                            Aggregates.unwind("$grades"),
                            Aggregates.group("$id",
                                    Accumulators.addToSet("name", "$name"),
                                    Accumulators.avg("averageGrade1", "$grades.1"),
                                    Accumulators.avg("averageGrade2", "$grades.2"),
                                    Accumulators.avg("averageGrade3", "$grades.3")
                            ),
                            Aggregates.project(
                                    Projections.fields(
                                            Projections.excludeId(),
                                            Projections.include("name", "grades"),
                                            Projections.computed("avg",
                                                    new Document("$round",
                                                            Arrays.asList(
                                                                    new Document("$avg",
                                                                            Arrays.asList("$averageGrade1", "$averageGrade2", "$averageGrade3")
                                                                    ),
                                                                    2
                                                            )
                                                    )
                                            )
                                    )
                            ),
                            Aggregates.match(Filters.gte("avg", 5.0))
                    )
            );

            String results = null;
            for(Document doc: approved){
                results += "name:" + doc.get("name").toString() + ",avg:" + doc.get("avg").toString() + "\n";
            }

            return results;
        }
        catch (MongoException e){
            e.printStackTrace();
            return null;
        }
    }
    public String read_failed(){
        try(MongoClient mongoclient = MongoClients.create(Connection.connection)){
            MongoDatabase sample = mongoclient.getDatabase("mongo_java");
            MongoCollection<Document> gradesCollection = sample.getCollection("school");
            String[] gradesFields = {"$grades.1", "$grades.2", "$grades.3"};

            AggregateIterable<Document> disapproved = gradesCollection.aggregate(
                    Arrays.asList(
                            Aggregates.unwind("$grades"),
                            Aggregates.group("$id",
                                    Accumulators.addToSet("name", "$name"),
                                    Accumulators.avg("averageGrade1", "$grades.1"),
                                    Accumulators.avg("averageGrade2", "$grades.2"),
                                    Accumulators.avg("averageGrade3", "$grades.3")
                            ),
                            Aggregates.project(
                                    Projections.fields(
                                            Projections.excludeId(),
                                            Projections.include("name", "grades"),
                                            Projections.computed("avg",
                                                    new Document("$round",
                                                            Arrays.asList(
                                                                    new Document("$avg",
                                                                            Arrays.asList("$averageGrade1", "$averageGrade2", "$averageGrade3")
                                                                    ),
                                                                    2
                                                            )
                                                    )
                                            )
                                    )
                            ),
                            Aggregates.match(Filters.lt("avg", 5.0))
                    )
            );

            String results = null;
            for(Document doc: disapproved){
                results += "name:" + doc.get("name").toString() + ",avg:" + doc.get("avg").toString() + "\n";
            }

            return results;
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
                            Accumulators.avg("averageGrade1", "$grades.1"),
                            Accumulators.avg("averageGrade2", "$grades.2"),
                            Accumulators.avg("averageGrade3", "$grades.3")
                            ),
                            Aggregates.project(
                                    Projections.fields(
                                            Projections.excludeId(),
                                            Projections.include("name", "grades"),
                                            Projections.computed("avg",
                                                    new Document("$round",
                                                            Arrays.asList(
                                                                    new Document("$avg",
                                                                            Arrays.asList("$averageGrade1", "$averageGrade2", "$averageGrade3")
                                                                    ),
                                                                    2
                                                            )
                                                    )
                                            )
                                    )
                            )
                            ));

            Document doc_average = avg.iterator().next();
            String average = doc_average.get("average").toString();
            return parseDouble(average);

        }
        catch (MongoException e){
            e.printStackTrace();
            return null;
        }
    }
    }

