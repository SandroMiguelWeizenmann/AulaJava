/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandro_miguel_weizenmann;

/**
 *
 *  @author SandroeDinara
 */
import javafx.application.Application;
import javafx.stage.Stage;

public class SisADA extends Application{

    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage palco) throws Exception {   
        DashBoardController telaPrincipal = new DashBoardController();      
        GerenciadorJanela.obterInstancia().inicializaPalco(palco, telaPrincipal);        
    }
}