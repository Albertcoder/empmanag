Employee Management System
Overview
The Employee Management System is a JavaFX-based desktop application designed to manage employees and their salaries. It supports adding, viewing, and removing employees while categorizing them by type (Full-time, Part-time, or Contractor) and calculating their salaries accordingly.

Features
View employees in a table with their name, type, and salary.
Add new employees with details:
Name
Employee Type (Full-time, Part-time, Contractor)
Salary
Remove selected employees from the table.
Validations to ensure data integrity.
Technologies Used
JavaFX for the GUI.
Java for backend logic.
Maven (or standalone JavaFX SDK) for dependency management and packaging.
Prerequisites
Java Development Kit (JDK): Version 11 or later.
JavaFX SDK: If using JDK 11+ (JavaFX is not bundled).
Maven: For dependency management and project building.
Installation and Running the Project
Step 1: Clone the Repository
bash
Копировать код
git clone https://github.com/yourusername/employee-management.git
cd employee-management
Step 2: Setup JavaFX
If using JavaFX SDK manually:

Download the JavaFX SDK from OpenJFX.
Extract the SDK and note the path to its lib folder.
Step 3: Run the Project
Using Maven
Run the application with the following Maven command:

bash
Копировать код
mvn clean javafx:run
Using IntelliJ IDEA
Open the project in IntelliJ IDEA.

Go to Run > Edit Configurations and add the following VM options:

css
Копировать код
--module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml
Replace /path/to/javafx-sdk/lib with the actual path to your JavaFX SDK.

Click Run to start the application.

Screenshots
Main Application Window
![Снимок экрана 2024-12-03 013826](https://github.com/user-attachments/assets/d4f0cb5b-a161-4acb-96d6-742cd7334527)

Add Employee Form
![Снимок экрана 2024-12-03 013849](https://github.com/user-attachments/assets/bc40f9c8-6082-43c7-af93-d0dac1ca745e)

Future Enhancements
Add salary calculation logic specific to employee types.
Implement file persistence to save and load employee data.
Enhance the UI with more advanced JavaFX components.
