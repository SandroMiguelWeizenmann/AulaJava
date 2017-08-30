/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criaprova;

import java.util.Scanner;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;

/**
 *
 * @author SandroeDinara
 */
public class CriaProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Prova p1 = new Prova();//Instancia de Objeto. Em outras palavras cria-se o objeto  
        Scanner recebe = new Scanner(System.in);
        System.out.print("Nome da Disciplina: "); 
        p1.setNomeDisciplina(recebe.nextLine());
        System.out.print("Local da aplicação: ");
        p1.setLocal(recebe.nextLine());
        System.out.print("Data: ");
        p1.setData(recebe.nextLine());
        System.out.print("Peso: ");
        p1.setPeso(recebe.nextInt());
        
        int qtdDisc;
        do{
            System.out.print("Quantidade de questões discursivas:");
            qtdDisc = recebe.nextInt();
            if(qtdDisc<0){
                System.out.println("Valor inválido! Digite um valor maior que zero.");
            }
        }while(qtdDisc<0);
        
        Discursiva questaoD [] = new Discursiva[qtdDisc];
        
        for(int i=0;i<qtdDisc;i++){
            questaoD[i] = new Discursiva();
            System.out.print("Digite a "+(i+1)+"ª pergunta: ");
            questaoD[i].setPergunta(recebe.next());   
            System.out.println("Critério de Avaliação: ");
            questaoD[i].setCriteriosCorrecao(recebe.next());
            System.out.print("Peso: ");
            questaoD[i].setPeso(recebe.nextDouble());
            System.out.println("--------------------------------------");
        }
        
        int qtdO;
        do{
            System.out.print("Quantidade de questões objetivas: ");
            qtdO = recebe.nextInt();
            if(qtdO<0){
                System.out.println("Valor inválido. Digite um valor maior que zero!");
            }
        }while(qtdO<0);
        
        Objetiva questaoO [] = new Objetiva[qtdO];
        String [] c = new String[5];
        for(int i=0;i<qtdO;i++){
            questaoO[i]= new Objetiva();
            System.out.print("Digite a "+(i+1)+"ª pergunta: ");
            questaoO[i].setPergunta(recebe.next()); 
            System.out.print("Peso: ");
            questaoO[i].setPeso(recebe.nextDouble());
            System.out.println("Digite as alternativas:");
            for(int j=0;j<5;j++){
                System.out.print((j+1)+"ª alternativa: ");
                c[j]=recebe.next();
            }
            questaoO[i].setOpcoes(c);
            int alternativa;
            do{
                System.out.print("Qual é a alternativa correta? ");
                alternativa = recebe.nextInt();
            }while(alternativa<0 || alternativa>6);
            questaoO[i].setRespostaCorreta(alternativa-1);
            
            
        }
        p1.setObjetivas(];///continuar apartir daqui!
    
       // System.out.println(p1.obtemDetalhes());
       // JOptionPane.showMessageDialog(null,p1.obtemDetalhes());
        JOptionPane.showMessageDialog(null, p1);
        
                
                
        
                
    }
    
}
