
/**
 * A classe {@code Termo} define um tipo cujos objetos representam termos
 * matemáticos, isto é, monómios, com base e expoente dados e imutáveis.
 * 
 * @author Larissa Oliveira FC59830
 *
 */
public class Termo implements Comparable<Termo>{

	public final double base;
	public final int expoente;
	
	/**
	 * Constrói uma instância de um termo, dados a base e o expoente
	 * @param base a base, ou coeficiente, do termo
	 * @param expoente o expoente
	 */
	public Termo(double base, int expoente) {
		this.base = base;
		this.expoente = expoente;
	}
	
	/**
	 * Representação textual deste termo.
	 * O termo é representado por um número em vírgula flutuante, o coeficiente,
	 * seguido do caracter x e terminado por um número inteiro, o expoente, com exceções:
	 * > termos com expoente 0, os quais são representado apenas pelo coeficiente
	 * > termos com expoente 1, os quais são representados com coeficiente seguido 
	 * do caracter x
	 * 
	 * @return a representação textual do termo
	 */
	public String toString() {
		if(expoente == 0)
			return Double.toString(base);
		else if(expoente == 1)
			return Double.toString(base)+"x";
		else
			return Double.toString(base)+"x"+expoente;
	}
	
	@Override
	public int compareTo(Termo o) {
		if(this.expoente > o.expoente)
			return +1;
		else if(this.expoente < o.expoente)
			return -1;
		else
			return 0;
	}
}
