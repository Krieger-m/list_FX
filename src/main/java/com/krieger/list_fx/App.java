package com.krieger.list_fx;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class App extends AppController {


    @Override
    public void start(Stage stage) throws IOException {

        // creating elements for later ;)
        VBox vBox = new VBox();

        Background x = vBox.getBackground();
        Label tfLbl = new Label();
        Insets ins = new Insets(40);
        Button addBtn = new Button("Hinzufügen");
        Button viewBtn = new Button("Anzeigen");
        TextField tf1 = new TextField();
        VBox tfVBox =new VBox();
        Label inputNotification = new Label();
        HBox hBox = new HBox();
        TextArea output = new TextArea();

        ArrayList<Item> list = new ArrayList<>();


        //ColorPicker picker = new ColorPicker();

        // assembling the elements and setting attributes for \dark-mode\

        bgColorShortcutCtrl(addBtn,"#1c1c1f");
        addBtn.setTextFill(Color.web("#f0f0f0"));
        addBtn.setOnMouseEntered(actionEvent ->addBtn.setStyle("-fx-background-color: #34393c"));
        addBtn.setOnMouseExited(actionEvent ->addBtn.setStyle("-fx-background-color: #1c1c1f"));
        addBtn.setBorder(
                new Border(new BorderStroke(
                        Color.web("#f0f0f0"), BorderStrokeStyle.SOLID, new CornerRadii(2),
                        BorderWidths.DEFAULT)
                )
        );


        bgColorShortcutCtrl(viewBtn, "#1c1c1f");
        viewBtn.setTextFill(Color.web("#f0f0f0"));
        viewBtn.setOnMouseEntered(actionEvent ->viewBtn.setStyle("-fx-background-color: #34393c"));
        viewBtn.setOnMouseExited(actionEvent ->viewBtn.setStyle("-fx-background-color: #1c1c1f"));
        viewBtn.setBorder(
                new Border(new BorderStroke(
                        Color.web("#f0f0f0"), BorderStrokeStyle.SOLID, new CornerRadii(2),
                        BorderWidths.DEFAULT)
                )
        );



        tf1.setPromptText("Eintrag...");
        bgColorShortcutCtrl(tf1, "#28282b");

        tf1.setStyle("-fx-text-fill: #f0f0f0; -fx-border-color: #808080");

        output.setStyle("-fx-control-inner-background: #202226; -fx-background: #202226; -fx-text-fill: #f0f0f0; " +
                "-fx-border-color: #808080; -fx-border-width: 0.5px;");
        output.setEditable(false);

        vBox.setBackground(
                new Background(new BackgroundFill(
                        Color.web("#202226"),null,null)
                )
        );
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.setPadding(ins);

        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);

        tfLbl.setTextFill(Color.web("#f0f0f0"));
        tfLbl.setText("Eintrag:");

            //funktioniert so nicht wegen dem scrollPane subelement, über die css-ref gelöst!!!
        //bgColorShortcutCtrl(output,"#000000" );



        // elements assembly
        hBox.getChildren().add(addBtn);

        tfVBox.getChildren().addAll(tfLbl,tf1);

        vBox.getChildren().addAll(tfVBox,hBox);

        // scene & stage assembly
        Scene scene = new Scene(vBox, 420, getVSize());

        stage.setTitle("Aufgabe_0");
        stage.setScene(scene);
        stage.show();


        tf1.setOnKeyPressed(keyEvent -> {
            inputNotification.setText("");
            if(keyEvent.getCode().equals(KeyCode.ENTER)){
                removeNotification(tfVBox,inputNotification);
                addAndConfirm(tf1,inputNotification,tfVBox,list);
                addViewBtn(list,hBox,viewBtn);
            }
        });

        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                removeNotification(tfVBox,inputNotification);
                addAndConfirm(tf1,inputNotification,tfVBox,list);
                addViewBtn(list,hBox,viewBtn);
            }
        });

        viewBtn.setOnAction(actionEvent -> {
            removeNotification(tfVBox,inputNotification);

            checkAndAddChild(vBox,output);

            String str="";
            int i=1;
            for(Item item: list){
                str += "\t"+i+". "+item.getItemName()+"\n";
                output.setText(str);
                i++;
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
