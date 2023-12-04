package lab11.Calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Calc extends Application {

    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox();
        root.setStyle("-fx-background-color: #EDF0F2");

        Scene scene = new Scene(root);

        // Добавляем меню
        root.getChildren().add(configureMenu(primaryStage));

        // Получаем HBox с текстовым полем внутри
        HBox box = configureResultView();
        // Добавляем HBox в root-вершину
        root.getChildren().add(box);
        // Устанавливаем отступы для HBox
        VBox.setMargin(box, new Insets(20, 10, 2, 10));

        root.getChildren().add(configureButtons());

        primaryStage.setTitle("My calc");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class MyButton extends Button {
        MyButton(String text) {
            super(text);
            this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        }
    }

    public static GridPane configureButtons() {
        GridPane pane = new GridPane();

        // 1ый ряд
        pane.add(new MyButton("MC"), 0, 0);
        pane.add(new MyButton("MR"), 1, 0);
        pane.add(new MyButton("MS"), 2, 0);
        pane.add(new MyButton("M+"), 3, 0);
        pane.add(new MyButton("M-"), 4, 0);

        // 2ой ряд
        pane.add(new MyButton("<-"), 0, 1);
        pane.add(new MyButton("CE"), 1, 1);
        pane.add(new MyButton("C"), 2, 1);
        pane.add(new MyButton("±"), 3, 1);
        pane.add(new MyButton("√"), 4, 1);

        // 3ий ряд
        pane.add(new MyButton("7"), 0, 2);
        pane.add(new MyButton("8"), 1, 2);
        pane.add(new MyButton("9"), 2, 2);
        pane.add(new MyButton("/"), 3, 2);
        pane.add(new MyButton("%"), 4, 2);

        // 4ый ряд
        pane.add(new MyButton("4"), 0, 3);
        pane.add(new MyButton("5"), 1, 3);
        pane.add(new MyButton("6"), 2, 3);
        pane.add(new MyButton("*"), 3, 3);
        pane.add(new MyButton("1/х"), 4, 3);

        // 5ый ряд
        pane.add(new MyButton("1"), 0, 4);
        pane.add(new MyButton("2"), 1, 4);
        pane.add(new MyButton("3"), 2, 4);
        pane.add(new MyButton("-"), 3, 4);
        pane.add(new MyButton("="), 4, 4, 1, 2);

        // 6ой ряд
        pane.add(new MyButton("0"), 0, 5, 2, 1);
        pane.add(new MyButton(","), 2, 5);
        pane.add(new MyButton("+"), 3, 5);

        // Свойства колонок
        ColumnConstraints cc = new ColumnConstraints();
        cc.setFillWidth(true);
        cc.setHgrow(Priority.ALWAYS);
        pane.getColumnConstraints().addAll(cc,cc,cc,cc,cc);

        pane.setStyle("-fx-padding: 2 10 4 10");
        pane.setHgap(6);
        pane.setVgap(6);
        return pane;
    }

    public static HBox configureResultView() {

        // Создаем менеджер HBox, куда
        // мы поместим текстовое поле
        HBox box = new HBox();

        // Устанавливаем нужный стиль для менеджера
        box.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 1;" +
                "-fx-border-radius: 3;" +
                "-fx-border-color: gray;" +
                "-fx-padding: 25 2 6 30;" +
                "-fx-background-color: linear-gradient(to bottom," +
                " #d3eefb 0%,#f4f8f9 59%);");

        // Создаем текстовое поле
        Text text = new Text("11111111111111111");
        text.setTextAlignment(TextAlignment.RIGHT);
        text.setFont(new Font(40));

        // Добавяем текстовое поле в менеджер HBox
        // устанавливаем выравнивание
        box.getChildren().add(text);
        box.setAlignment(Pos.BOTTOM_RIGHT);

        return box;
    }

    public static MenuBar configureMenu(Stage primaryStage) {
        MenuBar bar = new MenuBar();

        Menu view = new Menu("_Вид");
        Menu edit = new Menu("_Правка");
        Menu help = new Menu("_Справка");
        MenuItem ordinaryСalc = new MenuItem("Обычный");
        ordinaryСalc.setOnAction(event ->{
            if(!primaryStage.isShowing()) {
                primaryStage.show();
                ProgrammerCalc.closeProgrammerCalc();
                EngineeringCalc.closeEngineeringCalc();
            }
        });
        MenuItem engineerCalc = new MenuItem("Инженерный");
        engineerCalc.setOnAction(event -> {
                EngineeringCalc.openWindow(primaryStage);
                primaryStage.hide();
                ProgrammerCalc.closeProgrammerCalc();

        });
        Menu sheets = new Menu("Листы");
        MenuItem autoLeasing = new MenuItem("Автолизинг");
        autoLeasing.setOnAction(event ->{
                ProgrammerCalc.openWindow(primaryStage);
                primaryStage.hide();
                EngineeringCalc.closeEngineeringCalc();
        });
        sheets.getItems().add(autoLeasing);
        view.getItems().addAll(ordinaryСalc,engineerCalc,sheets);

        bar.getMenus().addAll(view, edit, help);

        return bar;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
