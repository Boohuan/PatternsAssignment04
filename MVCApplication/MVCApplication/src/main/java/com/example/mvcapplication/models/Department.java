package com.example.mvcapplication.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Department {
    private final IntegerProperty id;
    private final StringProperty departmentName;

    public Department(IntegerProperty id, StringProperty departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public IntegerProperty idProperty(){
        return id;
    }

    public StringProperty departmentName(){
        return departmentName;
    }


}
