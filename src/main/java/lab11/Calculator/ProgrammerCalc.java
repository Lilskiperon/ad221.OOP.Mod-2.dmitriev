package lab11.Calculator;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProgrammerCalc {
    static Stage programmerCalcStage = new Stage();
    public static void openWindow(Stage primaryStage){
        VBox newRoot = new VBox();
        newRoot.setStyle("-fx-background-color: #EDF0F2");
        VBox menuLeft=new VBox();
        Scene newScene = new Scene(newRoot);

        // Добавляем меню
        newRoot.getChildren().add(Calc.configureMenu(primaryStage));

        // Получаем HBox с текстовым полем внутри
        HBox box = Calc.configureResultView();
        // Добавляем HBox в root-вершину
        menuLeft.getChildren().add(box);
        // Устанавливаем отступы для HBox
        VBox.setMargin(box, new Insets(20, 10, 2, 10));

        menuLeft.getChildren().add(configureResultMenu());
        menuLeft.getChildren().add(ProgrammerCalc.configureButtons());

        HBox menuCalc=new HBox();
        VBox menuRight=configureRightMenu();
        VBox.setMargin(menuRight, new Insets(20, 10, 20, 10));
        menuCalc.getChildren().addAll(menuLeft,menuRight);
        newRoot.getChildren().add(menuCalc);
        programmerCalcStage.setTitle("My calc");
        programmerCalcStage.setResizable(false);
        programmerCalcStage.setScene(newScene);
        programmerCalcStage.show();
    }
    private static GridPane configureButtons() {
        GridPane pane = new GridPane();

        // 1ый ряд
        VBox boxTop = new VBox();
        RadioButton hex =new RadioButton("Hex");
        RadioButton dec =new RadioButton("Dec");
        RadioButton oct =new RadioButton("Oct");
        RadioButton bin =new RadioButton("Bin");
        ToggleGroup groupTop = new ToggleGroup();
        hex.setToggleGroup(groupTop);
        dec.setToggleGroup(groupTop);
        oct.setToggleGroup(groupTop);
        bin.setToggleGroup(groupTop);
        boxTop.setMaxHeight(Double.MAX_VALUE);
        boxTop.setSpacing(5);
        boxTop.getChildren().addAll(hex,dec,oct,bin);
        boxTop.setStyle( "-fx-border-width: 1;" +
                "-fx-border-radius: 3;" +
                "-fx-border-color: gray;" +
                "-fx-padding: 4 4 4 4;");
        pane.add(boxTop,0,0,2,3);

        pane.add(new Calc.MyButton(""), 2, 0);
        pane.add(new Calc.MyButton("Mod"), 3, 0);
        pane.add(new Calc.MyButton("A"), 4, 0);
        pane.add(new Calc.MyButton("MC"), 5, 0);
        pane.add(new Calc.MyButton("MR"), 6, 0);
        pane.add(new Calc.MyButton("MS"), 7, 0);
        pane.add(new Calc.MyButton("M+"), 8, 0);
        pane.add(new Calc.MyButton("M-"), 9, 0);

        // 2ой ряд
        pane.add(new Calc.MyButton("("), 2, 1);
        pane.add(new Calc.MyButton(")"), 3, 1);
        pane.add(new Calc.MyButton("B"), 4, 1);
        pane.add(new Calc.MyButton("<-"), 5, 1);
        pane.add(new Calc.MyButton("CE"), 6, 1);
        pane.add(new Calc.MyButton("C"),  7, 1);
        pane.add(new Calc.MyButton("±"),  8, 1);
        pane.add(new Calc.MyButton("√"),  9, 1);

        // 3ий ряд
        pane.add(new Calc.MyButton("RoL"), 2, 2);
        pane.add(new Calc.MyButton("RoR"), 3, 2);
        pane.add(new Calc.MyButton("C"), 4, 2);
        pane.add(new Calc.MyButton("7"), 5, 2);
        pane.add(new Calc.MyButton("8"), 6, 2);
        pane.add(new Calc.MyButton("9"), 7, 2);
        pane.add(new Calc.MyButton("/"), 8, 2);
        pane.add(new Calc.MyButton("%"), 9, 2);

        // 4ый ряд
        VBox boxBottom = new VBox();
        RadioButton eightBytes =new RadioButton("8 байт");
        RadioButton fourBytes =new RadioButton("4 байт");
        RadioButton twoBytes =new RadioButton("2 байт");
        RadioButton oneBytes =new RadioButton("1 байт");
        ToggleGroup groupBottom = new ToggleGroup();
        eightBytes.setToggleGroup(groupBottom);
        fourBytes.setToggleGroup(groupBottom);
        twoBytes.setToggleGroup(groupBottom);
        oneBytes.setToggleGroup(groupBottom);
        boxBottom.setSpacing(5);
        boxBottom.setMaxHeight(Double.MAX_VALUE);
        boxBottom.getChildren().addAll(eightBytes,fourBytes,twoBytes,oneBytes);
        boxBottom.setStyle( "-fx-border-width: 1;" +
                "-fx-border-radius: 3;" +
                "-fx-border-color: gray;" +
                "-fx-padding: 4 4 4 4;");
        pane.add(boxBottom,0,3,2,3);

        pane.add(new Calc.MyButton("OR"), 2, 3);
        pane.add(new Calc.MyButton("Xor"), 3, 3);
        pane.add(new Calc.MyButton("D"), 4, 3);
        pane.add(new Calc.MyButton("4"),  5, 3);
        pane.add(new Calc.MyButton("5"),  6, 3);
        pane.add(new Calc.MyButton("6"),  7, 3);
        pane.add(new Calc.MyButton("*"),  8, 3);
        pane.add(new Calc.MyButton("1/х"),9, 3);

        // 5ый ряд
        pane.add(new Calc.MyButton("Lsh"), 2, 4);
        pane.add(new Calc.MyButton("Rsh"), 3, 4);
        pane.add(new Calc.MyButton("E"), 4, 4);
        pane.add(new Calc.MyButton("1"), 5, 4);
        pane.add(new Calc.MyButton("2"), 6, 4);
        pane.add(new Calc.MyButton("3"), 7, 4);
        pane.add(new Calc.MyButton("-"), 8, 4);
        pane.add(new Calc.MyButton("="), 9, 4, 1, 2);

        // 6ой ряд
        pane.add(new Calc.MyButton("Not"), 2, 5);
        pane.add(new Calc.MyButton("And"), 3, 5);
        pane.add(new Calc.MyButton("F"), 4, 5);
        pane.add(new Calc.MyButton("0"), 5, 5, 2, 1);
        pane.add(new Calc.MyButton(","), 7, 5);
        pane.add(new Calc.MyButton("+"), 8, 5);

        // Свойства колонок
        for (int i = 0; i <= 9; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setPercentWidth(300.0 / 9); // Равномерное распределение на 4 колонки
            pane.getColumnConstraints().add(colConstraints);
        }


        pane.setStyle("-fx-padding: 2 10 4 10");
        pane.setHgap(6);
        pane.setVgap(6);
        return pane;
    }
    private static VBox configureResultMenu() {
        VBox vbox = new VBox();
        vbox.setSpacing(1);
        String[][] data = {
                {"0000", "0000", "0000", "0000", "0000","0000", "0000","0000"},
                {"63", "47", "32"},
                {"0000", "0000", "0000", "0000", "0000","0000", "0000","0000"},
                {"31", "15", "0"}
                // Добавьте больше строк данных, если нужно
        };

        // Для каждой строки данных создаем HBox
        for (String[] row : data) {
            HBox hbox = new HBox();
            hbox.setAlignment(Pos.CENTER);
            for (int i=0;i < row.length;i++) {
                Region spacer = new Region();
                HBox.setHgrow(spacer, Priority.ALWAYS);
                Text text = new Text(String.valueOf(row[i]));
                text.setFont(new Font(15));
                hbox.getChildren().add(text);
                if(i<row.length-1){
                    hbox.getChildren().add(spacer);
                }
            }
            vbox.getChildren().add(hbox);
        }
        vbox.setStyle("-fx-padding: 1 4 1 4;" +
                    "-fx-border-width: 1;" +
                    "-fx-border-radius: 3;" +
                    "-fx-border-color: gray;");
        VBox.setMargin(vbox, new Insets(2, 10, 2, 10));
        return vbox;
    }
    private static VBox configureRightMenu(){
        VBox box = new VBox();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(1);
        // Создаем элементы управления
        Label label = new Label("Выберите значение для вычисления");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Регулярный платеж",
                "Стоимость аренды"
        );
        comboBox.setValue("Регулярный платеж");

        // Добавляем поля ввода
        TextField rentalCostField = new TextField();
        TextField rentalPeriodField = new TextField();
        TextField annualPaymentsField = new TextField();
        TextField residualValueField = new TextField();
        TextField interestRateField = new TextField();

        // Кнопка для вычисления
        Button calculateButton = new Button("Вычислить");

        // Добавляем элементы в сетку
        grid.add(label, 9, 0, 2, 1);
        grid.add(comboBox, 9, 1, 2, 1);
        grid.add(new Label("Стоимость аренды"), 9, 2);
        grid.add(rentalCostField, 10, 2);
        grid.add(new Label("Срок аренды"), 9, 3);
        grid.add(rentalPeriodField, 10, 3);
        grid.add(new Label("Годовые выплаты"), 9, 4);
        grid.add(annualPaymentsField, 10, 4);
        grid.add(new Label("Остаточная стоимость"), 9, 5);
        grid.add(residualValueField, 10, 5);
        grid.add(new Label("Процентная ставка (%)"), 9, 6);
        grid.add(interestRateField, 10, 6);
        grid.add(calculateButton, 9, 7);
        box.getChildren().add(grid);
        grid.setStyle("-fx-border-width: 1;" +
                "-fx-border-radius: 3;" +
                "-fx-border-color: gray;" +
                "-fx-padding: 8 8 100 8;");
        box.setStyle("-fx-padding: 20 10 10 5;");
        return box;
    }
    public static void closeProgrammerCalc(){
        programmerCalcStage.close();
    }
}
