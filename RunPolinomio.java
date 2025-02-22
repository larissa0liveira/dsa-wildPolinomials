import java.util.Locale;
import java.util.Scanner;

/**
 * Classe executável para testar a classe {@code LinkedPolinomio}.
 * 
 * @author Larissa Oliveira FC59830
 *
 */
public class RunPolinomio {

	public static void main(String[] args) {
		Locale.setDefault(new Locale ("en", "US"));
		String input = "2.0 -8x2 3x0 2.0x1 -8x6 -1x0 34x2 -1.0x0 8x6 4x0 -27.0x5";
		Scanner sc = new Scanner(input).useDelimiter("x|\\s");
		
		double point = sc.nextDouble();
		LinkedPolinomio myPolinomio = new LinkedPolinomio();
		while(sc.hasNext()) {
			Termo t = new Termo(sc.nextDouble(), sc.nextInt());
			myPolinomio.adicionar(t);
		}
		sc.close();
		
		System.out.println("P(x) = " + myPolinomio + "\n"+"P(" + point + ") = " + 
							String.format("%.1f", myPolinomio.avaliar(point)));
		System.out.println("O termo de maior coeficiente é: " + myPolinomio.maiorCoeficiente());
		System.out.println("O número de expoentes diferentes é: " + myPolinomio.numeroExpoentes());
	}
}
