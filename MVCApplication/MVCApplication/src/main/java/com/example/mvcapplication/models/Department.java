package com.example.mvcapplication.models;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Department {
    private final IntegerProperty id;
    private final StringProperty departmentName;

    public Department(int id, String departmentName) {
        this.id = new SimpleIntegerProperty(id);
        this.departmentName = new SimpleStringProperty(departmentName);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty departmentNameProperty() {
        return departmentName;
    }


}
