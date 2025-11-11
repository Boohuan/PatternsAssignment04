package com.example.mvcapplication.models;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Projects {
    private final IntegerProperty id;
    private final StringProperty projectName;
    private final StringProperty description;
    private final IntegerProperty departmentId;

    public Projects(int id, String projectName, String description, int departmentId) {
        this.id = new SimpleIntegerProperty(id);
        this.projectName = new SimpleStringProperty(projectName);
        this.description = new SimpleStringProperty(description);
        this.departmentId = new SimpleIntegerProperty(departmentId);
    }

    public IntegerProperty idProperty(){
        return id;
    }

    public StringProperty projectNameProperty(){
        return projectName;
    }

    public StringProperty descriptionProperty(){
        return description;
    }

    public IntegerProperty departmentIdProperty(){
        return departmentId;
    }
}
