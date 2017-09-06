public class Exercicio5{
	public static void main (String args[]){
		String inteiro = args[0];
		String real = args[1];
		int dias = Integer.parseInt(inteiro);
		float salario = Float.parseFloat(real);
		salario = salario/22*dias;
		System.out.println("\nO salário é: "+salario);
		}
}