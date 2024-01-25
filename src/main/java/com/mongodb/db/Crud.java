package com.mongodb.db;

public class Crud implements crud{
    public Crud(){
        Connection connection = new Connection();
        Create create = new Create();
        Delete delete = new Delete();
        Insert insert = new Insert();
        Read read = new Read();
        Update update = new Update();
    }
    public void create(){

    }
    public void drop(){

    }
    public <T> void insert(T obj){

    }
    public <T> void update(T obj){

    }
    public <T> void view(T obj){

    }
    public <T> void delete(T obj){

    }
}
