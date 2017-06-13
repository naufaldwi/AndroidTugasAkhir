package id.sch.smktelkom_mlg.privateassignment.xirpl523.tugaspribadi.model;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl327.tugaspribadi.database.Task;


public interface MyDataBase {


    void addTask(Task task);

    ArrayList<Task> getAllTasks(String status);

    int editTask(Task task);

    void deleteTask(Task task);

    void deleteAll();

    void delAllInStatus(String status);


}
