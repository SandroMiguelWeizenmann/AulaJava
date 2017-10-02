/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandro_miguel_weizenmann;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author SandroeDinara
 */
public class MinhasAvaliacoesController extends InterfaceUsuario {
    
    FileOutputStream arquivo;
    public MinhasAvaliacoesController() throws IOException {
        super("MinhasAvaliacoes.fxml");
    }   

     
     
    @FXML
    private TableView<Avaliacao> tabelaAvaliacoes;
    
    @FXML
    private TableColumn<Avaliacao, String> tabelaColunaNomeProva;
    
    @FXML
    private TableColumn<Avaliacao , String> tabelaColunaMedia;

    @FXML
    private TableColumn<Avaliacao, String> tabelaColunaPeso;
    
    @FXML
    private TableColumn<Avaliacao , String> tabelaColunaNota;
    
    @FXML
    private TableColumn<Avaliacao , String> tabelaColunaDisciplina;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {
            carregaTabelaAvaliacoes();
            
        } catch (IOException ex) {
            Logger.getLogger(MinhasAvaliacoesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
    private ObservableList<Avaliacao> observableListaAvaliacoes;

    public void carregaTabelaAvaliacoes() throws FileNotFoundException, IOException{
        
        tabelaColunaNomeProva.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelaColunaMedia.setCellValueFactory(new PropertyValueFactory<>("mediaString"));
        tabelaColunaDisciplina.setCellValueFactory(new PropertyValueFactory<>("disciplina"));
        tabelaColunaPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        tabelaColunaNota.setCellValueFactory(new PropertyValueFactory<>("nota"));
        
        observableListaAvaliacoes = FXCollections.observableArrayList(Avaliacao.obterListaAvaliacoes());
        tabelaAvaliacoes.setItems(observableListaAvaliacoes);
                
    }
    
    
    @FXML
    public void onClickBotaoVoltaPrincipal(){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    @FXML
    public void onClickBtInformarNota(){
            if(tabelaAvaliacoes.getSelectionModel().getSelectedItem() == null ){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Erro");
            aviso.setHeaderText("ITEM NÃO SELECIONADO");
            aviso.setContentText("É NECESSARIO SELECIONAR UMA PROVA PARA ADICIONAR UMA NOTA ");
            aviso.showAndWait();
        }else{
        Avaliacao itemSelecionada = (Avaliacao) tabelaAvaliacoes.getSelectionModel().getSelectedItem();
        InformarNotaController telaInformaNota = new InformarNotaController();
        telaInformaNota.setavDaVez(itemSelecionada);
                
        GerenciadorJanela.obterInstancia().abreJanela(telaInformaNota);
        }

    }
     
    @FXML
    public void onClickBtAdicionarNovaAvaliacao() throws FileNotFoundException{
        GerenciadorJanela.obterInstancia().abreJanela(new AdicionarNovaAvaliacaoController());
    }  
}

