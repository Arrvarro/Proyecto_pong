/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
     
     // velocidad pelota en X y en Y
     double velocidadPelotaX = 5;
     double velocidadPelotaY = 5;
     
     // velocidad paleta en Y
     double velocidadPaleta1Y = 5;
     double velocidadPaleta2Y = 5;
     
    
    @Override
    public void start(Stage primaryStage) {
        // Creamos la escena
        Group root = new Group();
        Scene scene = new Scene(root, Ancho_Mundo, Alto_Mundo, Color.BLACK);
        primaryStage.setTitle("Basic Invaders FX");
        primaryStage.setScene(scene);
        primaryStage.show();   
        
        // creamos la pelota
        Circle pelota = new Circle(250, 10, 5);
        pelota.setFill(Color.WHITE);
        root.getChildren().add(pelota);
        
        // creamos las paletas
        Rectangle paleta1 = new Rectangle(15, 60, Color.WHITE);
        paleta1.setTranslateX(0);
        paleta1.setTranslateY(170);
        root.getChildren().add(paleta1);
        
        Rectangle paleta2 = new Rectangle(15, 60, Color.WHITE);
        paleta2.setTranslateX(485);
        paleta2.setTranslateY(170);
        root.getChildren().add(paleta2);
        
        // creamos la red
        Rectangle red = new Rectangle(5, 400, Color.WHITE);
        root.getChildren().add(red);
        red.setTranslateX(250);
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                // limites de movimiento de la pelota en el eje X
                double posXpelota = pelota.getTranslateX();
                pelota.setTranslateX(posXpelota + velocidadPelotaX);     
                if(posXpelota>= 245){
                    velocidadPelotaX = -5;
                }
                if(posXpelota<= -245){
                    velocidadPelotaX = +5;
                }
                // limites movimiento de la pelota en el eje Y
                double posYpelota = pelota.getTranslateY();
                pelota.setTranslateY(posYpelota + velocidadPelotaY);
                if(posYpelota>=385){
                    velocidadPelotaY = -5;
                }
                if(posYpelota<=0){
                    velocidadPelotaY = 5;
                }
                
                // limite movimiento paleta 1 en el eje Y
                double posYpaleta1 = paleta1.getTranslateY();
                paleta1.setTranslateY(posYpaleta1 + velocidadPaleta1Y);
                if(posYpaleta1<0){
                    velocidadPaleta1Y = 0;
                    paleta1.setTranslateY(0);
                }
                if(posYpaleta1>340){
                    velocidadPaleta1Y = 0;
                    paleta1.setTranslateY(340);
                }
                // limite movimiento paleta 2 en el eje Y
                double posYpaleta2 = paleta2.getTranslateY();
                paleta2.setTranslateY(posYpaleta2 + velocidadPaleta2Y);
                if(posYpaleta2<0){
                    velocidadPaleta2Y = 0;
                    paleta2.setTranslateY(0);                            
                }
                if(posYpaleta2>340){
                    velocidadPaleta2Y = 0;
                    paleta2.setTranslateY(340);
                }
            }
            
            }.start();
                scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        velocidadPaleta2Y = -5;               
                        break;
                    case DOWN:
                        velocidadPaleta2Y = +5;
                        break;
                    case A:
                        velocidadPaleta1Y = -5;
                        break;
                    case Z:
                        velocidadPaleta1Y = +5;
                        break;
                        
                }
            }
        }); 
    }
    
    
    /**
     * @param args the command line arguments
     */    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
