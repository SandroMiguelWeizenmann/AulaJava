/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorarm;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author SandroeDinara
 */
public class CalculadoraRM extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         launch(args);
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Tudo OK!");
        
        //viewgroup
        
        VBox orquestrador = new VBox();
        
        Label l1 = new Label("Valor 1:");
        TextField num1 = new TextField();
        Label l2 = new Label("Valor 2 ou angulo Seno 1:");
        TextField num2 = new TextField();
        Label l3 = new Label("Seno 2 ou Cosseno:");
        TextField num3 = new TextField();
        Label resultado = new Label("Resultado");
        
        HBox grupo = new HBox();
        
        Button cosseno = new Button ("Lei do Cosseno");
        cosseno.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String valorNum1 = num1.getText();
                String valorNum2 = num2.getText();
                String valorNum3 = num3.getText();
                double num1EmDouble = Double.parseDouble(valorNum1);
                double num2EmDouble = Double.parseDouble(valorNum2);
                double num3EmDouble = Double.parseDouble(valorNum3);
                double n1 = Math.pow(num1EmDouble, 2);
                double n2 = Math.pow(num2EmDouble, 2);
                double coss = Math.toDegrees(num3EmDouble); 
                       coss = Math.cos(coss);
                       
                double conta = (n1+n2-2*num1EmDouble*num2EmDouble*coss);//////verificar/////
                double result = Math.sqrt(conta);
                resultado.setText("A força é: "+result+" N.");
            }
        } );
        
        Button seno = new Button("Lei do seno");
        seno.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String valorNum1 = num1.getText();
                String valorNum2 = num2.getText();
                String valorNum3 = num3.getText();
                double num1EmDouble = Double.parseDouble(valorNum1);
                double num2EmDouble = Double.parseDouble(valorNum2);
                double num3EmDouble = Double.parseDouble(valorNum3);
                
                double n2 = Math.toDegrees(num2EmDouble);
                       n2 = Math.sin(n2);
                       
                double n3 = Math.toDegrees(num3EmDouble);
                       n3 = Math.sin(n3);
                double n4 = num1EmDouble * n3 / n2;
                resultado.setText("A força é: "+n4+" N.");
            }
        });
        //adicionando os views
        orquestrador.getChildren().add(l1);
        orquestrador.getChildren().add(num1);
        orquestrador.getChildren().add(l2);
        orquestrador.getChildren().add(num2);
        orquestrador.getChildren().add(l3);
        orquestrador.getChildren().add(num3);
        grupo.getChildren().add(cosseno);
        grupo.getChildren().add(seno);
        orquestrador.getChildren().add(grupo);
        orquestrador.getChildren().add(resultado);
        
        Scene cena = new Scene(orquestrador, 500, 300);
        
        stage.setScene(cena);
        stage.setTitle("Resistência dos Materiais:");
        stage.show();
    }
    
}
