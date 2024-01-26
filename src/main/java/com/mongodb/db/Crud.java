package com.mongodb.db;


import com.mongodb.user.Student;

public class Crud implements crud{
    protected Connection connection;
    protected Create create;
    protected Delete delete;
    protected Insert insert;
    protected Read read;
    protected Update update;

    public boolean create(){
        try {
            this.create = new Create();
            create.creation();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean drop(){
    try{
        this.delete = new Delete();
        delete.delete_all();
        return true;
    }
    catch (Exception e){
        return false;
    }
    }
    public boolean insert(Student obj){
        try{
            this.create = new Create();
            create.insert();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean update(Student obj){
        try{
            this.update = new Update();
            update.find_and_update("");
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean view(Student obj){
        try{
            this.read = new Read();
            read.read_one("");
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean delete(Student obj){
        try{
            this.delete = new Delete();
            delete.find_and_delete("");
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
