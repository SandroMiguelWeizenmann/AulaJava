/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandro_miguel_weizenmann;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Double.isNaN;
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
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author SandroeDinara
 */
public class MeuDesempenhoController extends InterfaceUsuario{

    public MeuDesempenhoController() {
        super("MeuDesempenho.fxml");
    }
    
    private ObservableList<String> disciplinas;

    @FXML
    private ComboBox<String> comboBoxDisciplina;
    
    
    @FXML
    private BarChart<?,?> barChart;
    

    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        barChart.setAnimated(false);
        try {
            carregaListaDisciplinasMedias();
        } catch (IOException ex) {
            Logger.getLogger(MeuDesempenhoController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void carregaListaDisciplinasMedias() throws IOException{
        Path path = Paths.get("Disciplinas.csv");
        List<String> linhas = Files.readAllLines(path);

        disciplinas = FXCollections.observableArrayList(linhas);
        comboBoxDisciplina.setItems(disciplinas);
    }

    @FXML
    public void onClickBotaoAdicionar() throws FileNotFoundException, IOException{
        
        XYChart.Series series = new XYChart.Series<>();
        
        double MF = 0.0;
        double media;
        series.setName(comboBoxDisciplina.getSelectionModel().getSelectedItem());
        barChart.setLegendSide(Side.BOTTOM);
        
        media = Avaliacao.calculaMediaDisciplina( comboBoxDisciplina.getSelectionModel().getSelectedItem() , "M1");
        
        //System.out.println("MEDIA 1 : " + media);
        
        if(media== -1 ){
            Alert aviso = new Alert(Alert.AlertType.INFORMATION);
            aviso.setTitle("Erro");
            aviso.setHeaderText("DISCIPLINA "+ comboBoxDisciplina.getSelectionModel().getSelectedItem() +" NÃO ENCONTRADA");
            aviso.setContentText("A disciplina selecionada não foi encontrada no banco de dados.");
            aviso.showAndWait();
        }else{
            if(isNaN(media) == true){
                Alert aviso = new Alert(Alert.AlertType.INFORMATION);
                aviso.setTitle("Erro");
                aviso.setHeaderText("NA DISCIPLINA "+ comboBoxDisciplina.getSelectionModel().getSelectedItem());
                aviso.setContentText( "NÃO FOI ENCONTRADA A M1 ");
                aviso.showAndWait();
                MF+= 0;
                series.getData().add(new XYChart.Data("M1" ,0)); 
            }else{
                MF+= media;
                series.getData().add(new XYChart.Data("M1" , media));
            }
            
        media = Avaliacao.calculaMediaDisciplina( comboBoxDisciplina.getSelectionModel().getSelectedItem() , "M2");
        //System.out.println("MEDIA 2 : " + media);
        if(isNaN(media) == true){
                Alert aviso = new Alert(Alert.AlertType.INFORMATION);
                aviso.setTitle("Erro");
                aviso.setHeaderText("NA DISCIPLINA "+ comboBoxDisciplina.getSelectionModel().getSelectedItem());
                aviso.setContentText( "Não foi encontrada a M2 ");
                aviso.showAndWait();
                MF+= 0;
                series.getData().add(new XYChart.Data("M2" , 0)); 
            }else{
                MF+= media;
                series.getData().add(new XYChart.Data("M2" , media));
        }   
        media = Avaliacao.calculaMediaDisciplina( comboBoxDisciplina.getSelectionModel().getSelectedItem() , "M3");
        //System.out.println("MEDIA 3 : " + media);
        if(isNaN(media) == true){
                Alert aviso = new Alert(Alert.AlertType.INFORMATION);
                aviso.setTitle("Erro");
                aviso.setHeaderText("NA DISCIPLINA "+ comboBoxDisciplina.getSelectionModel().getSelectedItem());
                aviso.setContentText( "Não foi encontrada a M3 ");
                aviso.showAndWait();
                MF+= 0;
                series.getData().add(new XYChart.Data("M3" , 0)); 
            }else{
                MF+= media;
                series.getData().add(new XYChart.Data("M3" , media));
        }

        series.getData().add(new XYChart.Data("MF" ,MF/3));
        
        barChart.getData().addAll(series);
        }
    }
    
    @FXML
    public void onClickBotaoVoltaPrincipal(){
        GerenciadorJanela.obterInstancia().voltar();
    }
}