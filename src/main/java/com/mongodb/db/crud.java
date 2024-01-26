package com.mongodb.db;
import com.mongodb.user.Student;
public interface crud {
    public boolean create();
    public boolean drop();
    public boolean insert(Student obj);
    public boolean update(Student obj);
    public boolean view(Student obj);
    public boolean delete(Student obj);
}
