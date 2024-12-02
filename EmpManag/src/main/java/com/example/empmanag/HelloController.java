package com.example.empmanag;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TableView<EmployeeModel> employeeTable;

    @FXML
    private TableColumn<EmployeeModel, String> nameColumn;

    @FXML
    private TableColumn<EmployeeModel, String> typeColumn;

    @FXML
    private TableColumn<EmployeeModel, Double> salaryColumn;

    @FXML
    private TextField nameField;

    @FXML
    private ComboBox<String> typeDropdown;

    @FXML
    private TextField salaryField;

    private final ObservableList<EmployeeModel> employeeList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind columns to EmployeeModel properties
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        salaryColumn.setCellValueFactory(cellData -> cellData.getValue().salaryProperty().asObject());

        // Populate the ComboBox
        typeDropdown.setItems(FXCollections.observableArrayList("Full-time", "Part-time", "Contractor"));

        // Set the table data
        employeeTable.setItems(employeeList);
    }

    @FXML
    private void onAddEmployee() {
        String name = nameField.getText();
        String type = typeDropdown.getValue();
        String salaryText = salaryField.getText();

        if (name.isEmpty() || type == null || salaryText.isEmpty()) {
            showAlert("Error", "All fields must be filled out!");
            return;
        }

        try {
            double salary = Double.parseDouble(salaryText);
            if (salary < 0) {
                showAlert("Error", "Salary must be a positive number!");
                return;
            }

            EmployeeModel employee = new EmployeeModel(name, type, salary);
            employeeList.add(employee);

            // Clear fields
            nameField.clear();
            typeDropdown.getSelectionModel().clearSelection();
            salaryField.clear();

        } catch (NumberFormatException e) {
            showAlert("Error", "Salary must be a valid number!");
        }
    }

    @FXML
    private void onRemoveEmployee() {
        EmployeeModel selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            employeeList.remove(selectedEmployee);
        } else {
            showAlert("Error", "No employee selected!");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
