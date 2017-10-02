/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandro_miguel_weizenmann;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;



/**
 * FXML Controller class
 *
 * @author SandroeDinara
 */
public class DashBoardController extends InterfaceUsuario {
    public DashBoardController() {
        super("DashBoard.fxml");
    }

    /**
     * Initializes the controller class.
     */
       
        @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    @FXML
    public void onClickBotaoMinhasAvaliacoes() throws IOException{
            GerenciadorJanela.obterInstancia().abreJanela(new MinhasAvaliacoesController());
    }
    
    @FXML
    public void onClickBotaoMeuDesempenho(){
        GerenciadorJanela.obterInstancia().abreJanela(new MeuDesempenhoController());
    }
}
