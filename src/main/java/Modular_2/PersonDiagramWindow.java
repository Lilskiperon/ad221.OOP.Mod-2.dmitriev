package Modular_2;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PersonDiagramWindow {
    public static void newWindow(String title, ObservableList<Person> personList ) {
        if (!personList.isEmpty()) {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(createPieChart(personList));
            window.setScene(scene);
            window.setResizable(false);
            window.setTitle(title);
            window.showAndWait();
        }
        else {
            Warnings.showError("Введите данные!");
        }
    }
    public static  PieChart createPieChart(ObservableList<Person> personList) {
        int countMen = 0;
        int countWomen = 0;
        for (Person person : personList) {
            if (person.getGender() == "Мужчина") {
                countMen++;
            } else {
                countWomen++;
            }
        }
        double percentMen = ((double) (countMen) / (countWomen + countMen)) * 100;
        double percentWomen = 100-percentMen;
        PieChart.Data slice1 = new PieChart.Data("Женщин", percentWomen);
        PieChart.Data slice2 = new PieChart.Data("Мужчин", percentMen);

        PieChart pieChart = new PieChart();
        pieChart.getData().addAll(slice1, slice2);
        setPercentageLabel(slice1);
        setPercentageLabel(slice2);

        pieChart.setTitle("Процентное соотношение");
        return pieChart;
    }
    private static void setPercentageLabel(PieChart.Data data) {
        StringProperty percentageLabel = new SimpleStringProperty();
        percentageLabel.bind(Bindings.when(data.pieValueProperty().isNotEqualTo(0))
                .then(Bindings.concat(String.format("%.1f", data.getPieValue()), "% ", data.getName()))
                .otherwise(data.getName()));

        data.nameProperty().bind(percentageLabel);
    }
}
