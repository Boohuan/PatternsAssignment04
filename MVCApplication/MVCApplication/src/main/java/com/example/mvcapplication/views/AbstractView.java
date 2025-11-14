package com.example.mvcapplication.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.function.Supplier;

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
    protected Button navigation(String btnTitle, String windowTitle, Supplier<VBox> newWindow) {
        Button button = new Button(btnTitle);
        button.setOnAction(e -> {
            Stage stage = new Stage();
            stage.setTitle(windowTitle);
            stage.setScene(new Scene(newWindow.get(), 600, 400)); //used a supplier to delay the creation of a new window or else it would cause stack overflows. Once we set the scene from the event, then it gets called and created.
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
