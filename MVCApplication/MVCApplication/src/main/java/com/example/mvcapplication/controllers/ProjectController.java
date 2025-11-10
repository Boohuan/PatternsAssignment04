package com.example.mvcapplication.controllers;

import com.example.mvcapplication.models.DatabaseManager;
import com.example.mvcapplication.models.Projects;
import javafx.collections.ObservableList;

public class ProjectController {

    public ProjectController(){

    }

    public ObservableList<Projects> getProjects(){
        return DatabaseManager.getAllProjects();
    }
}
