package com.example.mvcapplication.models;

import com.mysql.cj.conf.StringProperty;
import javafx.beans.property.IntegerProperty;

public class Projects {
    private final IntegerProperty id;
    private final StringProperty projectName;
    private final StringProperty description;
    private final IntegerProperty departmentId;

    public Projects(IntegerProperty id, StringProperty projectName, StringProperty description, IntegerProperty departmentId) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.departmentId = departmentId;
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
