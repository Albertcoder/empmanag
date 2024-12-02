package com.example.empmanag;

import javafx.beans.property.*;

public class EmployeeModel {
    private final StringProperty name;
    private final StringProperty type;
    private final DoubleProperty salary;

    public EmployeeModel(String name, String type, double salary) {
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.salary = new SimpleDoubleProperty(salary);
    }

    // Getters and Property Methods
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public StringProperty typeProperty() {
        return type;
    }

    public double getSalary() {
        return salary.get();
    }

    public void setSalary(double salary) {
        this.salary.set(salary);
    }

    public DoubleProperty salaryProperty() {
        return salary;
    }
}



