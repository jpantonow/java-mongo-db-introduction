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
    public boolean drop(String str){
    try{
        this.delete = new Delete();
        //delete.delete_all();
        delete.delete_all(str);
        return true;
    }
    catch (Exception e){
        return false;
    }
    }
    public boolean insert(Student obj){
        try{
            this.insert = new Insert();
            insert.insert(obj);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean update(Student obj){
        try{
            this.update = new Update();
            update.find_and_update(obj);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public Student view(Student obj){
        try{
            this.read = new Read();
            return read.read_one(obj);
        }
        catch (Exception e){
            return null;
        }
    }
    public double avg(Student obj){
        this.read = new Read();
        return read.readavg(obj);
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
