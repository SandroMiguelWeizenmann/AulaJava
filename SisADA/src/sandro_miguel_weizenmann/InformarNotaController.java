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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author SandroeDinara
 */
public class InformarNotaController extends InterfaceUsuario {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField textNotaProva;

    @FXML
    private Label labelNomeProva, labelDisc, labelMedia;
    
    private Avaliacao avDaVez;

    public InformarNotaController() {
        super("InformarNota.fxml");
    }
    
    public void setavDaVez(Avaliacao avDaVez){
        this.avDaVez = avDaVez;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
            labelNomeProva.setText("Nome : "+this.avDaVez.getNome());
            labelDisc.setText("Disciplina : "+this.avDaVez.getDisciplina());
            labelMedia.setText("Média : "+this.avDaVez.getMediaString());
    }
    
    @FXML
    public void onClickVoltaMinhasAvaliacoes(){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    @FXML
    public void onClickBtSalvar() throws IOException{
        if("".equals(textNotaProva.getText())){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Erro");
            aviso.setHeaderText("Campo vazio");
            aviso.setContentText("Por favor, informe a nota");
            aviso.showAndWait();
        }else{
            avDaVez.setNota(Double.parseDouble(textNotaProva.getText()));
            avDaVez.atualizar();
        }     
    } 
    
}
