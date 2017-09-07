import java.util.Scanner;
public class Exercicio3 {
	public static void main (String args[]){
		String mes [] = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
		String str = args[0];
		int i = Integer.parseInt(str);
		
		do{
			if(i<1||i>12){
				Scanner recebe = new Scanner (System.in);
				System.out.println("Digite um numero válido!");
				System.out.print("Digite um número de 1 a 12: ");
				i = recebe.nextInt();
				}
			
		}while(i<1||i>12);
		System.out.print("O mês referente é: ");
		System.out.print(mes[i-1]);
	}
}
