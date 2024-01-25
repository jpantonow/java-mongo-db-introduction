package com.mongodb.db;

public interface crud {
    public boolean create();
    public boolean drop();
    public <T> boolean insert(T obj);
    public <T> boolean update(T obj);
    public <T> boolean view(T obj);
    public <T> boolean delete(T obj);
}
