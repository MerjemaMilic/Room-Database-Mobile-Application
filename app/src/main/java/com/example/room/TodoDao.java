package com.example.room;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TodoDao {
    @Insert
    void add(Todo todo);
    @Query("SELECT * FROM todos")
    List<Todo> getAll();

    @Query("SELECT * FROM todos WHERE id = :id LIMIT 1")
    Todo getTodoById(long id);

    @Delete
    public void deleteAll(Todo todo);

    @Update
    public void updateTodo(Todo todo);


}
