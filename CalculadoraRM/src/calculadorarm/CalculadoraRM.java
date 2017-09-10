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
        
        Label l1 = new Label("Força 1:");
        TextField num1 = new TextField();
        Label l2 = new Label("Força 2 ou Seno 1:");
        TextField num2 = new TextField();
        Label l3 = new Label("Cosseno ou Seno 2:");
        TextField num3 = new TextField();
        Label resultado = new Label("Resultado");
        Label instrucoes = new Label ("\n\nINSTRUÇOES:");
        Label lc = new Label ("LEI DO COSSENO:\n\tInforme as forças 1 e 2 e depois o angulo do cosseno"
                + " para calcular a força resultante \natravés da lei do cosseno.");
        Label ls = new Label("\nLEI DO SENO:\n\tInforme a força 1 e o angulo seno respectivo, o seno 2"
                + " refere-se ao ângulo que \nqueremos saber a força resultante através da lei do seno.");
        
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
                double coss = Math.toRadians(num3EmDouble); 
                       coss = Math.cos(coss);
                       
                //double conta = (n1+n2-2*num1EmDouble*num2EmDouble*coss);
                double result = Math.sqrt(n1+n2-2*num1EmDouble*num2EmDouble*coss);
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
                
               double n2 = Math.toRadians(num2EmDouble);
                      n2 = Math.sin(n2);
                       
               double n3 = Math.toRadians(num3EmDouble);
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
        orquestrador.getChildren().add(instrucoes);
        orquestrador.getChildren().add(lc);
        orquestrador.getChildren().add(ls);
        
        Scene cena = new Scene(orquestrador, 500, 400);
        
        stage.setScene(cena);
        stage.setTitle("Resistência dos Materiais: Calculadora de Força Resultante");
        stage.show();
    }
    
}
