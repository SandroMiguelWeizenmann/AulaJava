public class Exercicio4{
	public static void main (String args[]){

	String inteiro = args[0];
	String real = args[1];
	int peso = Integer.parseInt(inteiro);
	float altura = Float.parseFloat(real);
	float IMC=peso/(altura*altura);
	System.out.print( "O IMC é: "+IMC);
	}
}