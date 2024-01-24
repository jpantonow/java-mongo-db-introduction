package com.mongodb.quickstart;
import com.mongodb.db.Connection;
import com.mongodb.db.Create;

public class HelloMongoDb {
    public static void main(String[] args){
    Create.create();
    System.out.println("Done");
    }
}
