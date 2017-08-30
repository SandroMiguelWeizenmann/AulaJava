/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criaprova;

/**
 *
 * @author SandroeDinara
 */
abstract class Questao {
   private String pergunta;
   private double peso;

    /**
     * @return the pergunta
     */
    public String getPergunta() {
        return pergunta;
    }

    /**
     * @param pergunta the pergunta to set
     */
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
}
