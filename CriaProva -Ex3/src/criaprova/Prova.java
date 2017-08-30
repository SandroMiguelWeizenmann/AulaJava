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
public class Prova {
  private String nomeDisciplina;
  private int peso;
  private String local;
  private String data;
  
  private Discursiva[] discursiva;
  private Objetiva[] objetivas;
  
  public Prova(){
     
  }
   
  public String obtemDetalhes(){
       String retorno = "Universidade do vale do Itajaí\n";
       retorno += "==============================\n";
       retorno+= "Nome:______________________   Peso: "+this.getPeso();
       retorno+= "\nDisciplina: "+this.getNomeDisciplina();
       retorno+= "\nLocal: "+this.getLocal()+"  Data: "+this.getData();
       return retorno;
   }

  public String obtemProvaImpressao(){
      String retorno = obtemDetalhes()+"\n_____________________________\n";
      String questao = "";
      String questao2 = "";
      int i, j;
      for(i=0;i<this.discursiva.length;i++){
          questao += ("\n"+(i+1)+"("+this.discursiva[i].getPeso()+") - ");
          questao += (this.discursiva[i].getPergunta()+"\n\n\n");         
      }
      retorno += questao;
      for(j=0;j< this.objetivas.length;j++){
          questao2 += ("\n"+(i+1+j)+"("+this.objetivas[j].getPeso()+") - ");
          questao2 += (this.objetivas[j].getPergunta()+"\n");
          String[] opcoes = this.objetivas[j].getOpcoes();
          for(int k=0;k<5;k++){
              questao2 += ((k+1)+") "+opcoes[k]+"\n");
          }
      }
      retorno += questao2;
      return retorno;
  }
    /**
     * @return the nomeDisciplina
     */
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    /**
     * @param nomeDisciplina the nomeDisciplina to set
     */
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the discursiva
     */
    public Discursiva[] getDiscursiva() {
        return discursiva;
    }

    /**
     * @param discursiva the discursiva to set
     */
    public void setDiscursiva(Discursiva[] discursiva) {
        this.discursiva = discursiva;
    }

    /**
     * @return the objetivas
     */
    public Objetiva[] getObjetivas() {
        return objetivas;
    }

    /**
     * @param objetivas the objetivas to set
     */
    public void setObjetivas(Objetiva[] objetivas) {
        this.objetivas = objetivas;
    }
    
}
