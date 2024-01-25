package com.mongodb.db;

public interface crud {
    public void create();
    public void drop();
    public <T> void insert(T obj);
    public <T> void update(T obj);
    public <T> void view(T obj);
    public <T> void delete(T obj);
}
