package com.example.mvcapplication.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public abstract class AbstractView<T, C> extends VBox {

    protected TableView<T> tableView;
    protected C controller;

    public AbstractView(C controller) {
        this.tableView = new TableView<>();
        this.controller = controller;
    }

    /**
     *
     * @param btnTitle
     * @param windowTitle
     * @param newWindow
     * @return
     */
    protected Button navigation(String btnTitle, String windowTitle, VBox newWindow) {
        Button button = new Button(btnTitle);
        button.setOnAction(e -> {
            Stage stage = new Stage();
            Scene scene = new Scene(newWindow, 600, 400);
            stage.setTitle(windowTitle);
            stage.setScene(scene);
            stage.show();
            closeCurrentWindowOnOpen(e);
        });
        return button;
    }

    /**
     * Helper method that closes the current window when a button gets clicked
     *
     * @param event
     */
    private void closeCurrentWindowOnOpen(ActionEvent event) {
        Stage current = (Stage) ((Button) event.getSource()).getScene().getWindow();
        current.close();
    }

    protected void createTable(List<String> colNames, List<String> properties) {
        for (int i = 0; i < properties.size(); i++) {
            TableColumn<T, C> newColumn = new TableColumn<>(colNames.get(i));
            newColumn.setCellValueFactory(new PropertyValueFactory<>(properties.get(i)));
            tableView.getColumns().addAll(newColumn);
        }
    }

    /**
     *
     * @param data
     */
    protected void bindTableData(List<T> data) {
        ObservableList<T> ol = FXCollections.observableArrayList(data);
        tableView.setItems(ol);
    }
}
