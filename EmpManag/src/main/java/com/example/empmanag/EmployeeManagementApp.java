package com.example.empmanag;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmployeeManagementApp extends Application {

    private TableView<EmployeeModel> table;
    private ObservableList<EmployeeModel> employees;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        employees = FXCollections.observableArrayList();

        // TableView setup
        table = new TableView<>();
        TableColumn<EmployeeModel, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<EmployeeModel, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<EmployeeModel, Double> salaryColumn = new TableColumn<>("Salary");
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

        table.getColumns().addAll(nameColumn, typeColumn, salaryColumn);

        // Input fields
        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        ComboBox<String> typeDropdown = new ComboBox<>();
        typeDropdown.getItems().addAll("Full-time", "Part-time", "Contractor");

        TextField hourlyRateField = new TextField();
        hourlyRateField.setPromptText("Hourly Rate");

        TextField hoursField = new TextField();
        hoursField.setPromptText("Hours Worked / Max Hours");

        Button addButton = new Button("Add Employee");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String type = typeDropdown.getValue();
            double hourlyRate = Double.parseDouble(hourlyRateField.getText());
            int hours = Integer.parseInt(hoursField.getText());

            Employee employee = null;
            switch (type) {
                case "Full-time":
                    employee = new FullTimeEmployee(name, hourlyRate); // assuming annual salary here
                    break;
                case "Part-time":
                    employee = new PartTimeEmployee(name, hourlyRate, hours);
                    break;
                case "Contractor":
                    employee = new Contractor(name, hourlyRate, hours);
                    break;
            }

            if (employee != null) {
                employees.add(new EmployeeModel(name, type, employee.calculateSalary()));
                table.setItems(employees);
            }

            // Clear inputs
            nameField.clear();
            typeDropdown.setValue(null);
            hourlyRateField.clear();
            hoursField.clear();
        });

        Button removeButton = new Button("Remove Selected");
        removeButton.setOnAction(e -> {
            EmployeeModel selected = table.getSelectionModel().getSelectedItem();
            employees.remove(selected);
        });

        VBox layout = new VBox(10, table, nameField, typeDropdown, hourlyRateField, hoursField, addButton, removeButton);
        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Employee Management");
        primaryStage.show();
    }
}

