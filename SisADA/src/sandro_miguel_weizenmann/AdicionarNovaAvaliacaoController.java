/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandro_miguel_weizenmann;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author SandroeDinara
 */
public class AdicionarNovaAvaliacaoController extends InterfaceUsuario{

    public AdicionarNovaAvaliacaoController() {
        super("AdicionarNovaAvaliacao.fxml");
    }
    
    private ObservableList<String> disciplinas, medias;
    
    @FXML
    private ComboBox<String> comboBoxDisciplina, comboBoxMedias;
    
    @FXML
    private TextField textNomeProva, textPesoProva;
    
    
    
    private boolean verificaCondicao(){
        if("".equals(textNomeProva.getText())){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Erro");
            aviso.setHeaderText("Campo Vazio");
            aviso.setContentText("É necessário preencher o campo NOME");
            aviso.showAndWait();
        return false;
        }        
        if("".equals(textPesoProva.getText())){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Erro");
            aviso.setHeaderText("Campo Vazio");
            aviso.setContentText("É necessário preencher o campo PESO");
            aviso.showAndWait();
        return false;
        }
        if(comboBoxDisciplina.getSelectionModel().getSelectedItem() == null){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Erro");
            aviso.setHeaderText("Disciplina não selecionada");
            aviso.setContentText("Selecione uma disciplina");
            aviso.showAndWait();
        return false;
        }
        if(comboBoxMedias.getSelectionModel().getSelectedItem()== null){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Erro");
            aviso.setHeaderText("Média não selecionada");
            aviso.setContentText("Selecione uma média");
            aviso.showAndWait();
        return false;
        }
        return true;
    }
    
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) { 
        try {
            carregaListaDisciplinasMedias();
        } catch (IOException ex) {
            Logger.getLogger(AdicionarNovaAvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void carregaListaDisciplinasMedias() throws IOException{
        
        Path path = Paths.get("Disciplinas.csv");
        List<String> linhas = Files.readAllLines(path);

        disciplinas = FXCollections.observableArrayList(linhas);
        comboBoxDisciplina.setItems(disciplinas);
        medias = FXCollections.observableArrayList("M1","M2","M3");
        comboBoxMedias.setItems(medias);
    }
    
    
    
    @FXML
    public void onClickBotaoSalvarNotaAvaliacao() throws IOException{
        if(verificaCondicao()){
        Avaliacao novaProva = new Avaliacao();
        
        novaProva.setNome(textNomeProva.getText());
        novaProva.setDisciplina(comboBoxDisciplina.getSelectionModel().getSelectedItem());
        novaProva.setMedia(comboBoxMedias.getSelectionModel().getSelectedItem().toCharArray());
        novaProva.setPeso(Double.parseDouble(textPesoProva.getText()));
        
        novaProva.Salvar();
        }
    }    
    
    @FXML
    public void onClickVoltaBotaoMinhasAvaliacoes(){
        GerenciadorJanela.obterInstancia().voltar();
    }
}  
