/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandro_miguel_weizenmann;

/**
 *
 * @author marcelo
 */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public abstract class InterfaceUsuario implements Initializable {
    
    private Scene minhaCena;
    private String caminhoFxml;
    
    protected InterfaceUsuario(String caminhoFxml) {
        this.caminhoFxml = caminhoFxml;
    }

    public Scene obterCena()  {
        if(this.minhaCena != null){
            return this.minhaCena;
        }
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoFxml));
            loader.setController(this);            
            Pane elementoPrincipal = loader.load();   
            
            this.minhaCena = new Scene( elementoPrincipal, 1024, 768);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.minhaCena;
    }
    public void volteiAtualiza(){
        
    }
    public void passaIndice(){
        
    }
}

