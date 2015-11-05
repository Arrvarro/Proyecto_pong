/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author 1DAW17
 */
public class Pong extends Application {
    // tamaño de la aplicacion
     double Ancho_Mundo = 500;
     double Alto_Mundo = 400;
    
    @Override
    public void start(Stage primaryStage) {
        // Creamos la escena
        Group root = new Group();
        Scene scene = new Scene(root, Ancho_Mundo, Alto_Mundo, Color.BLACK);
        primaryStage.setTitle("Basic Invaders FX");
        primaryStage.setScene(scene);
        primaryStage.show();   
        
        // import javafx.scena.shape.Rectangle
        Rectangle marciano1 = new Rectangle(200, 10, 30, 20);
        marciano1.setFill(Color.WHITE);
        root.getChildren().add(marciano1);
                
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                double posX = marciano1.getTranslateX();
                posX--;
                marciano1.setTranslateX(posX);     
                
            }                            
        }.start();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
