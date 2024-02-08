package com.mongodb.db;
import com.mongodb.user.Student;
public interface crud {
    public boolean create();
    public boolean drop(String str);
    public boolean insert(Student obj);
    public boolean update(Student obj);
    public Student view(Student obj);
    public boolean delete(Student obj);
    public String approved();
}
