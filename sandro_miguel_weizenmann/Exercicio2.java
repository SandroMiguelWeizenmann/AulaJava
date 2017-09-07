import java.util.Scanner;
public class Exercicio2 {
	public static void main (String args[]){
		String dia_semana[] = {"Domingo","Segunda-feira","Terça-feira","Quarta-feira","Quinta-feira","Sexta-feira","Sabado"};
		String str = args[0];
		int i = Integer.parseInt(str);
		
		do{
			if(i<1||i>7){
				Scanner recebe = new Scanner (System.in);
				System.out.println("Digite um numero válido!");
				System.out.print("Digite um número de 1 a 7: ");
				i = recebe.nextInt();
				}
		}while(i<1||i>7);
		System.out.println(dia_semana[i-1]);
	}
}
