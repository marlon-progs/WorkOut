package com.example.workout;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// creating a table for the room database
@Entity(tableName = "note_table")
public class Note {

    //column creation (id, title, description, priority)
    // unique identifier
    @PrimaryKey(autoGenerate = true)
    private int id;

    // info: to change column name type @ColumnInfo(name= "new_name")
    private String title;

    private String description;

    private int priority;

    // using "generate" android studio function to automatically generate code
    // right click in code (or ALT+Einf) click generate ...


    // Constructor automatically build with generate function
    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    //setter method
    public void setId(int id) {
        this.id = id;
    }


    // Getter Methods: for id title description and priority
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
