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
import javafx.scene.text.Text;
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
     double velocidadPelotaX = 2;
     double velocidadPelotaY = 2;
     
     // velocidad paleta en Y
     double velocidadPaleta1Y = 5;
     double velocidadPaleta2Y = 5;
     
     // posicion pelota
     double posXpelota = 0;
     double posYpelota = 0;
     
     // marcador j1
     int  punto1 = 0;
     String puntoj1 = String.valueOf(punto1);
     
     // marcador j2
     int punto2 = 0;
     String puntoj2 = String.valueOf(punto2);
    
    @Override
    public void start(Stage primaryStage) {
        // Creamos la escena
        Group root = new Group();
        Scene scene = new Scene(root, Ancho_Mundo, Alto_Mundo, Color.BLACK);
        primaryStage.setTitle("Basic Invaders FX");
        primaryStage.setScene(scene);
        primaryStage.show();   
        
        // creamos la pelota
        Circle pelota = new Circle(5);
        pelota.setTranslateX(250);        
        pelota.setFill(Color.WHITE);
        root.getChildren().add(pelota);
        
        // creamos las paletas
        Rectangle paleta1 = new Rectangle(15, 60, Color.WHITE);
        paleta1.setTranslateX(10);
        paleta1.setTranslateY(170);
        root.getChildren().add(paleta1);
        
        Rectangle paleta2 = new Rectangle(15, 60, Color.WHITE);
        paleta2.setTranslateX(475);
        paleta2.setTranslateY(170);
        root.getChildren().add(paleta2);
        
        // creamos la red
        Rectangle red = new Rectangle(5, 400, Color.WHITE);
        root.getChildren().add(red);
        red.setTranslateX(250);
        
        // creamos el marcador
        Text marcadorJugador1 = new Text();
        marcadorJugador1.setX(230);
        marcadorJugador1.setY(15);
        marcadorJugador1.setFill(Color.WHITE);        
        marcadorJugador1.setText(puntoj1);
        root.getChildren().add(marcadorJugador1);
              
        Text marcadorJugador2 = new Text(); 
        marcadorJugador2.setX(280);
        marcadorJugador2.setY(15);
        marcadorJugador2.setFill(Color.WHITE);
        marcadorJugador2.setText(puntoj2);
        root.getChildren().add(marcadorJugador2);
        
        // cojemos posicionX paleta
        double posXpaleta2 = paleta2.getTranslateX();
        double posXpaleta1 = paleta1.getTranslateX();
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                
                // limites de movimiento de la pelota en el eje X
                double posXpelota = pelota.getTranslateX();
                pelota.setTranslateX(posXpelota + velocidadPelotaX);     
                if(posXpelota<= 7){
                    root.getChildren().remove(pelota);
                    root.getChildren().add(pelota);
                    pelota.setTranslateX(250); 
                    pelota.setTranslateY(200);
                    // condiciones marcador
                    punto2++;
                    String puntoj2 = String.valueOf(punto2);
                    marcadorJugador2.setText(puntoj2);                    
                }
                if(posXpelota>= 493){
                    root.getChildren().remove(pelota);
                    root.getChildren().add(pelota);
                    pelota.setTranslateX(250); 
                    pelota.setTranslateY(200);
                    // condiciones marcador                    
                    punto1++;
                    String puntoj1 = String.valueOf(punto1);
                    marcadorJugador1.setText(puntoj1);
                }
                // limites movimiento de la pelota en el eje Y
                double posYpelota = pelota.getTranslateY();
                pelota.setTranslateY(posYpelota + velocidadPelotaY);
                if(posYpelota>=385){
                    velocidadPelotaY = -2;
                }
                if(posYpelota<=0){
                    velocidadPelotaY = 2;
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
                
                // hacemos que la pelota revote con las palas
                if (posXpelota <= posXpaleta1 + 22){
                    if (posYpelota >= posYpaleta1 && posYpelota <= posYpaleta1+15){ 
                        velocidadPelotaY = -2;
                        velocidadPelotaX = +2;
                    }
                    if (posYpelota >= posYpaleta1+16 && posYpelota <= posYpaleta1+30){
                        velocidadPelotaY = -2;
                        velocidadPelotaX = 2;
                    }
                    if (posYpelota >= posYpaleta1+31 && posYpelota <= posYpaleta1+45){
                        velocidadPelotaY = 2;
                        velocidadPelotaX = 2;
                    }
                    if (posYpelota >= posYpaleta1+46 && posYpelota <= posYpaleta1+60){
                        velocidadPelotaY = 2;
                        velocidadPelotaX = 2;
                    }
                }
                if(posXpelota >= posXpaleta2 -7){
                                       
                    if (posYpelota >= posYpaleta2 && posYpelota <= posYpaleta2+15){
                        velocidadPelotaX = -2;
                        velocidadPelotaY = -2;
                    }
                    if (posYpelota >= posYpaleta2+16 && posYpelota <= posYpaleta2+30){
                        velocidadPelotaX = -2;
                        velocidadPelotaY = -2;
                    }
                    if (posYpelota >= posYpaleta2+31 && posYpelota <= posYpaleta2+45){
                        velocidadPelotaX = -2;
                        velocidadPelotaY = 2;
                    }
                    if (posYpelota >= posYpaleta2+46 && posYpelota <= posYpaleta2+60){
                        velocidadPelotaX = -2;
                        velocidadPelotaY = 2 ;
                    }
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
                case SPACE:
                    root.getChildren().remove(pelota);
                    root.getChildren().add(pelota);
                    pelota.setTranslateX(250); 
                    pelota.setTranslateY(200);
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
