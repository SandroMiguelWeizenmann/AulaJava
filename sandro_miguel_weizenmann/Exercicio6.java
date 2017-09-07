import java.util.Scanner;
public class Exercicio6{
	public static void main (String args[]){
		Scanner recebe = new Scanner (System.in);
		float vetor[]= new float[12];
		float maior = 0;
		float menor = 0;
		float soma = 0;
		for(int i=0;i<10;i++){
			System.out.print("\nDigite o " + (i+1) + "º numero do vetor: ");
			vetor[i] = recebe.nextFloat();
			soma = soma + vetor[i];
			if(i==0){
				maior = vetor[0];
				menor = vetor[0];
				}
			if(maior<vetor[i]){
				maior = vetor[i];
				}
			if(menor>vetor[i]){
				menor = vetor[i];
				}
			}
		System.out.println ("Soma: "+soma);
		System.out.println ("Média: "+(soma/10));
		System.out.println ("Maior: "+maior);
		System.out.println ("Menor: "+menor);
	}
}
		