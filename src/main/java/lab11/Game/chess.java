package lab11.Game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.MenuBar;

public class chess extends Application {

    private static final int BOARD_SIZE = 8;
    private static final String[] imageUrlsBlack = {
            "src\\main\\java\\lab11\\Game\\img\\Chess_rdt45.svg.png",//Ладья ч
            "src\\main\\java\\lab11\\Game\\img\\Chess_ndt45.svg.png",//Конь ч
            "src\\main\\java\\lab11\\Game\\img\\Chess_bdt45.svg.png",//Слон ч
            "src\\main\\java\\lab11\\Game\\img\\Chess_qdt45.svg.png",//Ферза ч
            "src\\main\\java\\lab11\\Game\\img\\Chess_kdt45.svg.png",//Король ч
            "src\\main\\java\\lab11\\Game\\img\\Chess_pdt45.svg.png", //пешка ч
    };
    private static final String[] imageUrlsWhite = {
            "src\\main\\java\\lab11\\Game\\img\\Chess_rlt45.svg.png",//Ладья б
            "src\\main\\java\\lab11\\Game\\img\\Chess_nlt45.svg.png",//Конь б
            "src\\main\\java\\lab11\\Game\\img\\Chess_blt45.svg.png",//Слон б
            "src\\main\\java\\lab11\\Game\\img\\Chess_qlt45.svg.png",//Ферза б
            "src\\main\\java\\lab11\\Game\\img\\Chess_klt45.svg.png",//Король б
            "src\\main\\java\\lab11\\Game\\img\\Chess_plt45.svg.png", //пешка б

    };
    private static final String[] imageUrlBackground = {
            "src\\main\\java\\lab11\\Game\\img\\Снимок экрана 2023-11-30 022714.png",//
            "src\\main\\java\\lab11\\Game\\img\\Снимок экрана 2023-11-30 022803.png",//
    };

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        primaryStage.setTitle("Chess Game");

        Scene scene = new Scene(root);
        HBox box = new HBox();
        VBox pane =new VBox();
        box.getChildren().addAll(initializeChessBoard(),configureScore());
        VBox.setMargin(box, new Insets(5, 5, 5, 5));
        root.getChildren().addAll(configureMenu(),box);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private GridPane initializeChessBoard() {
        GridPane grid = new GridPane();
        //виводе цифри
        for (int i = 1; i < BOARD_SIZE + 1; i++) {

            Label topLabel = new Label(String.valueOf(i));
            grid.add(topLabel, 0, i);


            Label bottomLabel = new Label(String.valueOf(i));
            grid.add(bottomLabel, 9, i);
        }
        //виводе букви
        String[] letters = { "      a", "     b", "      c", "       d", "      e", "       f", "       g", "     h"};
        for (int i = 1; i < BOARD_SIZE + 1; i++) {
            Label leftLabel = new Label(letters[i - 1]);  // Corrected index
            grid.add(leftLabel, i, 0);

            Label rightLabel = new Label(letters[i - 1]);  // Corrected index
            grid.add(rightLabel, i, 9);
        }


        for (int row = 1; row < BOARD_SIZE + 1; row++) {
            for (int col = 1; col < BOARD_SIZE + 1; col++) {
                ImageView square = new ImageView();
                square.setFitWidth(50);
                square.setFitHeight(50);
                if ((row + col) % 2 == 0) {
                    square.setImage(new Image("file:" + imageUrlBackground[0]));
                } else {
                    square.setImage(new Image("file:" + imageUrlBackground[1]));
                }
                grid.add(square, col, row);
            }
        }


        for (int i=1,y=2;i<BOARD_SIZE+1;i++){
            ImageView square = new ImageView();
            square.setFitWidth(50);
            square.setFitHeight(50);
            if(i<6){
                square.setImage(new Image("file:" + imageUrlsBlack[i-1]));
            }
            else{
                square.setImage(new Image("file:" + imageUrlsBlack[y]));
                y--;
            }
            grid.add(square, i, 1);
        }

        for (int i=1;i<BOARD_SIZE+1;i++){
            ImageView square = new ImageView();
            square.setFitWidth(50);
            square.setFitHeight(50);
            square.setImage(new Image("file:" + imageUrlsBlack[5]));
            grid.add(square, i, 2);
        }

        for (int i=1;i<BOARD_SIZE+1;i++){
            ImageView square = new ImageView();
            square.setFitWidth(50);
            square.setFitHeight(50);
            square.setImage(new Image("file:" + imageUrlsWhite[5]));
            grid.add(square, i, 7);
        }

        for (int i=1,y=2;i<BOARD_SIZE+1;i++){
            ImageView square = new ImageView();
            square.setFitWidth(50);
            square.setFitHeight(50);
            if(i<6){
                square.setImage(new Image("file:" + imageUrlsWhite[i-1]));
            }
            else{
                square.setImage(new Image("file:" + imageUrlsWhite[y]));
                y--;
            }
            grid.add(square, i, 8);
        }

        return grid;
    }
    private VBox configureScore(){
        VBox vbox=new VBox();
        String[][]data={
                {"cba","abc"},
                {"00:00","00:00"}
        };
        for (String[] row : data) {
            HBox box=new HBox();
            for (String cell : row){
                HBox hbox=new HBox();
                Text text = new Text(String.valueOf(cell));
                text.setFont(new Font(15));
                hbox.getChildren().add(text);
                hbox.setStyle("-fx-border-width:1;" +
                        "-fx-border-color:black");
                box.getChildren().add(hbox);
                hbox.setMaxWidth(Double.MAX_VALUE);
                box.setMaxWidth(Double.MAX_VALUE);
            }
            vbox.getChildren().add(box);
        }

        return vbox;
    }
    private VBox historyList(){
        VBox box =new VBox();
        return box;
    }

    private Label myLabel(String s){
        Label label = new Label(s);
        label.setStyle("-fx-border-width:1;" +
                "-fx-border-color:black");
        label.setAlignment(Pos.CENTER);
        return label;
    }

    private static MenuBar configureMenu() {
        MenuBar bar = new MenuBar();

        Menu file = new Menu("_File");
        Menu game = new Menu("_Game");
        Menu options = new Menu("_Options");
        Menu help = new Menu("_Help");

        bar.getMenus().addAll(file, game,options, help);

        return bar;
    }


}
