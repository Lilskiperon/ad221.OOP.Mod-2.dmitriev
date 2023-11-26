package Modular_2;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PersonTableWindow {
    public static void newWindow(String title,ObservableList<Person> personList ) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(createTableView(personList));
        window.setScene(scene);
        window.setResizable(false);
        window.setTitle(title);
        window.showAndWait();
    }
    public static TableView<Person> createTableView(ObservableList<Person> personList) {
        TableView<Person> tableView = new TableView<>();

        TableColumn<Person, String> genderCol = new TableColumn<>("Стать");
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));

        TableColumn<Person, Integer> ageCol = new TableColumn<>("Возраст");
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Person, Integer> heightCol = new TableColumn<>("Рост");
        heightCol.setCellValueFactory(new PropertyValueFactory<>("height"));

        TableColumn<Person, Integer> weightCol = new TableColumn<>("Вес");
        weightCol.setCellValueFactory(new PropertyValueFactory<>("weight"));

        TableColumn<Person, String> activityCol = new TableColumn<>("Уровень активности");
        activityCol.setCellValueFactory(new PropertyValueFactory<>("activity"));

        TableColumn<Person, String> goalCol = new TableColumn<>("Цель");
        goalCol.setCellValueFactory(new PropertyValueFactory<>("goal"));

        TableColumn<Person, Double> metabolismCol = new TableColumn<>("Метаболизм");
        metabolismCol.setCellValueFactory(new PropertyValueFactory<>("metabolism"));

        TableColumn<Person, Double> dailyNormCol = new TableColumn<>("Суточная норма калорий");
        dailyNormCol.setCellValueFactory(new PropertyValueFactory<>("dailyNorm"));

        TableColumn<Person, Double> weightCaloriesCol = new TableColumn<>("Необходимые калории для цели");
        weightCaloriesCol.setCellValueFactory(new PropertyValueFactory<>("weightCalories"));


        tableView.getColumns().addAll(genderCol, ageCol, heightCol, weightCol, activityCol, goalCol, metabolismCol, dailyNormCol, weightCaloriesCol);
        tableView.setItems(personList);
        return tableView;
    }
}