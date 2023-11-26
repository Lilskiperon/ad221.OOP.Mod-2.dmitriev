package Modular_2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;


public class Calc extends Application {
    private String gender = new String();
    private TextField ageField = new TextField();
    private TextField heightField = new TextField();
    private TextField weightField = new TextField();
    private MenuButton activityField = new MenuButton();
    private MenuButton goalField = new MenuButton();
    private Label item1 = new Label();
    private Label item2 = new Label();
    private Label item3 = new Label();
    private static ObservableList<Person> personList = FXCollections.observableArrayList();
    Stage primaryStage;
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        Scene scene = new Scene(root);
        root.setStyle(  "-fx-padding: 0 25 0 25;" +
                        "-fx-background-color:#d7d7d7;" +
                        "-fx-font-size:15px;");
        root.getChildren().addAll(configureTitle(),configureGender(),configureAge(),configureHeight(),configureWeight(),configureActivity(),configureGoal(),calculateCalories(),showResult());
        primaryStage.setTitle("Спорт");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox configureTitle() throws FileNotFoundException {
        HBox box =new HBox();
        Label title = new Label("Калькулятор калорий");
        title.setStyle("-fx-font-size:25;" +
                       "-fx-font-weight:bold;" +
                "-fx-padding: 0 20 0 0");
        title.setAlignment(Pos.TOP_LEFT);
        Image table = new Image(new FileInputStream("src\\main\\java\\Modular_2\\img\\tables.png"));
        ImageView iv1 = new ImageView(table);
        iv1.setFitHeight(35);
        iv1.setFitWidth(28);
        iv1.setOnMouseClicked(event -> PersonTableWindow.newWindow("Таблица",personList) );
        Image fileResult = new Image(new FileInputStream("src\\main\\java\\Modular_2\\img\\txt.png"));
        ImageView iv2 = new ImageView(fileResult);
        iv2.setFitHeight(35);
        iv2.setFitWidth(30);
        iv2.setOnMouseClicked(event -> saveResultsToFile(primaryStage) );
        Image diagram = new Image(new FileInputStream("src\\main\\java\\Modular_2\\img\\diagram.png"));
        ImageView iv3 = new ImageView(diagram);
        iv3.setFitHeight(35);
        iv3.setFitWidth(28);
        iv3.setOnMouseClicked(event -> PersonDiagramWindow.newWindow("Диаграмма",personList));
        box.getChildren().addAll(title,iv1,iv2,iv3);
        box.setSpacing(15);
        return box;
    }

    private VBox configureGender() {
        VBox box = new VBox();
        ToggleGroup group = new ToggleGroup();
        Label sex = new Label("Стать:");
        RadioButton men= new RadioButton("Мужчина");
        RadioButton women = new RadioButton("Женщина");
        men.setToggleGroup(group);
        women.setToggleGroup(group);
        box.getChildren().addAll(sex,
                men,
                women);
        propertiesBox(box);
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (group.getSelectedToggle() != null) {
                RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
                gender = selectedRadioButton.getText();
            }
        });

        return box;
    }

    private VBox configureAge(){
        VBox box = new VBox();
        Label text = new Label("Возраст:");
        ageField = new TextField ("");
        checkText(ageField);
        box.getChildren().addAll(text,ageField);
        propertiesBox(box);
        return box;
    }

    private VBox configureHeight(){
        VBox box = new VBox();
        Label text = new Label("Рост, см:");
        heightField = new TextField ("");
        checkText(heightField);
        box.getChildren().addAll(text,heightField);
        propertiesBox(box);
        return box;
    }

    private VBox configureWeight(){
        VBox box = new VBox();
        Label text = new Label("Вес, кг:");
        weightField = new TextField ("");
        checkText(weightField);
        box.getChildren().addAll(text,weightField);
        propertiesBox(box);
        return box;
    }

    private VBox configureActivity(){
        VBox box = new VBox();
        Label text = new Label("Уровень активности:");
        activityField = new MenuButton("Низкий");
        MenuItem item1 = myItem("Низкий",activityField);
        MenuItem item2 = myItem("Средний",activityField);
        MenuItem item3 = myItem("Высокий",activityField);
        activityField.getItems().addAll(item1,item2,item3);
        HBox items = new HBox(activityField);
        HBox.setHgrow(activityField, Priority.ALWAYS);
        activityField.setMaxWidth(Double.MAX_VALUE);
        activityField.setAlignment(Pos.TOP_LEFT);
        items.setAlignment(Pos.CENTER);
        box.getChildren().addAll(text,items);
        propertiesBox(box);
        return box;
    }
    private VBox configureGoal(){
        VBox box = new VBox();
        Label text = new Label("Цель:");
        goalField = new MenuButton("Ничего");
        MenuItem item1 = myItem("Похудеть на 2 кг за неделю",goalField);
        MenuItem item2 = myItem("Похудеть на 1.5 кг за неделю",goalField);
        MenuItem item3 = myItem("Похудеть на 1 кг за неделю",goalField);
        MenuItem item4 = myItem("Похудеть на 0.5 кг за неделю",goalField);
        MenuItem item5 = myItem("Ничего",goalField);
        MenuItem item6 = myItem("Набрать 0.5 кг за неделю",goalField);
        MenuItem item7 = myItem("Набрать 1 кг за неделю",goalField);
        MenuItem item8 = myItem("Набрать 1.5 кг за неделю",goalField);
        MenuItem item9 = myItem("Набрать 2 кг за неделю",goalField);
        goalField.getItems().addAll(item1,item2,item3,item4,item5,item6,item7,item8,item9);
        HBox items = new HBox(goalField);
        HBox.setHgrow(goalField, Priority.ALWAYS);
        goalField.setMaxWidth(Double.MAX_VALUE);
        goalField.setAlignment(Pos.TOP_LEFT);
        items.setAlignment(Pos.CENTER);
        box.getChildren().addAll(text,items);
        propertiesBox(box);
        return box;
    }
    private Label myLabel(String s){
        Label label = new Label(s);
        label.setStyle("-fx-background-color:#d7d7d7;" +
                "-fx-padding: 10;" +
                "-fx-border-width: 1;");
        DropShadow ds1 = new DropShadow(0.1, 1.5, 1.5, Color.BLACK);
        ds1.setRadius(3);
        label.setEffect(ds1);
        return label;
    }
    private MenuItem myItem(String s,MenuButton field){
        MenuItem item = new MenuItem(s);
        item.setOnAction(actionEvent -> {
            field.setText(s);
        });
        return item;
    }

    private HBox calculateCalories(){
        HBox box = new HBox();
        Button calculate = new Button("Рассчитать");
        calculate.setOnAction(event -> handleSubmitButton());
        HBox.setHgrow(calculate, Priority.ALWAYS);
        box.setStyle("-fx-border-width: 1;"+
                     "-fx-border-radius: 3;" +
                     "-fx-color: green;" +
                    "-fx-padding: 5;" +
                "-fx-font-weight:bold;");
        calculate.setMaxWidth(Double.MAX_VALUE);
        box.setAlignment(Pos.CENTER);
        box.getChildren().add(calculate);
        return box;
    }

    private VBox showResult(){
        VBox box = new VBox();
        HBox pane = new HBox();
        Label text = new Label("Результаты:");
        text.setFont(new Font(25));
        FlowPane flowpane = new FlowPane();
        item1 = myLabel("Ваш базовый метаболизм:  ккал.");
        item2 = myLabel("Ваша суточная норма калорий:  ккал.");
        item3 = myLabel("Для цели вам необходимо потреблять примерно   калорий в день.\n" +
                "Будьте осторожны и следите за своим здоровьем, употребляя достаточное количество необходимых питательных веществ, а не просто \"пустые\" калории.");
        flowpane.setStyle("-fx-padding: 10");
        flowpane.setVgap(10);
        flowpane.setHgap(50);
        flowpane.getChildren().addAll(item1,item2,item3);
        pane.getChildren().add(flowpane);
        box.getChildren().addAll(text,pane);
        propertiesBox(box);
        return box;
    }

    private boolean isValidNum(String text)
    {
        return text.matches("-?\\d*\\.?\\d*") && text.indexOf('.') == -1;
    }

    private void checkText(TextField text){
        text.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue && !text.getText().isEmpty()) {
                text.setStyle("-fx-border-color: null");
            }
        });
        text.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!isValidNum(newValue) || newValue.startsWith("0") || newValue.startsWith("-") ){
                text.setText(oldValue);
                text.setStyle("-fx-border-color:#d78b89;" +
                              "-fx-border-radius:3; ");
            } else {
                text.setStyle("-fx-border-color: null");
            }
        });
    }
    private boolean isDataEmpty(){
        return gender.isEmpty() || ageField.getText().isEmpty() || heightField.getText().isEmpty() || weightField.getText().isEmpty();
    }
    private void setTextResults(Person person){
        item1.setText("Ваш базовый метаболизм: "+ (int) person.getMetabolism()+" ккал.");
        item2.setText("Ваша суточная норма калорий: "+ (int) person.getDailyNorm()+" ккал.");
        item3.setText("Для цели вам необходимо потреблять примерно "+ (int) person.getWeightCalories()+" ккал в день.\n" +
                "Будьте осторожны и следите за своим здоровьем, употребляя достаточное количество необходимых питательных веществ, а не просто \"пустые\" калории.");
    }
    private void handleSubmitButton(){
        if(!isDataEmpty()){
            int age = Integer.parseInt(ageField.getText());
            int height = Integer.parseInt(heightField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String activity = activityField.getText();
            String goal = goalField.getText();
            Person person = new Person(gender, age, height, weight, activity, goal,0,0,0);

            person.calculateCalories();
            personList.add(person);
            setTextResults(person);
        }
        else{
            Warnings.showError("Заполните поля!");
        }
    }

    private void saveResultsToFile(Stage primaryStage) {
        String projectDirectory = System.getProperty("user.dir");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Виберите файл для сохранения");
        fileChooser.setInitialDirectory(new File(projectDirectory));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Текстовые файлы (*.txt)", "*.txt"));
        File file = fileChooser.showSaveDialog(primaryStage);

        if (file != null) {
            try (FileWriter fileWriter = new FileWriter(file)) {
                for (Person person : personList) {
                    fileWriter.write((person.getGender()+" "+person.getAge()+" "+person.getHeight()+" "+person.getWeight()+" "+person.getGoal()+" "+person.getMetabolism()+" "+person.getDailyNorm()+" "+person.getWeightCalories()+"\n"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void propertiesBox(VBox box){

        box.setStyle("-fx-padding: 5;" +
                     "-fx-border-radius:3;");
        box.setSpacing(5);
    }
    public static void main(String[] args) {
        launch(args);
    }

}
