import java.util.Scanner;
public class Exercicio7 {
	public static void main (String args[]){
		Scanner recebe = new Scanner (System.in);	
		double media = 0;
		System.out.print("Digite o nome do aluno: ");
		String nome = recebe.nextLine();
		for(int i=0;i<3;i++){
			System.out.print("Digite a " +(i+1)+ " �nota: ");
			double notas = recebe.nextDouble();    // n�o foi pedido para armazenar a nota!
			media = media + notas;
			}

		media = media/3;
		System.out.println ("Nome do aluno: " + nome + "\nM�dia: " + media);
			if(media>=6){
				System.out.println("Situa��o: Aprovado");
				}else{
				System.out.println("Situa��o: Reprovado");
			}
	}
}
		