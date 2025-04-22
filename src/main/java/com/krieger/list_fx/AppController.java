package com.krieger.list_fx;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class AppController extends Application {

    private double vSize=340;

    public double getVSize() {
        return vSize;
    }

    public void removeNotification(Pane parent, Control child){
        parent.getChildren().remove(child);

    }

    public void bgColorShortcutCtrl(Control el, String color){

        el.setBackground(
                new Background(new BackgroundFill(
                        Color.web(color), null, null)
                )
        );
    }

    public void setVSize(double vSize) {
         this.vSize = vSize;
    }

            //
    public void checkAndAddChild(Pane parent, Node child){
        if(!(parent.getChildren().contains(child))){
            parent.getChildren().add(child);
        }
    }


            // inputNotification wird entsprechend ausgegeben
    public void addAndConfirm(TextField tf1, Label inputNotification, VBox tfVBox, ArrayList<Item> list){

        if(tf1.getText().isEmpty()){
            inputNotification.setTextFill(Color.web("#ad3232"));
            inputNotification.setText("Keine Eingabe vorhanden...");
            tfVBox.getChildren().add(inputNotification);
            tf1.clear();

        } else{
            inputNotification.setTextFill(Color.web("#2b942e"));
            inputNotification.setText("Eintrag hinzugefügt...");
            tfVBox.getChildren().add(inputNotification);
            list.add(new Item(tf1.getText()));
            tf1.clear();


        }

    }


    public void addViewBtn(ArrayList<Item> list, HBox hBox, Button viewBtn) {
        if(!list.isEmpty() ){
            checkAndAddChild(hBox,viewBtn);

        }

    }



}