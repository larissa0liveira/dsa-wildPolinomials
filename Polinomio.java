
/**
 * Interface para um polinomio: uma colecção de {@code Termo} que representa
 * uma expressão algébrica, isto é, a soma de termos, a formar um polinomio.
 * Termos podem ser adicionados ao polinomio e pode ser calculado o valor do 
 * polinomio num certo ponto.
 * 
 * @author Larissa Oliveira FC59830
 *
 */
public interface Polinomio extends Iterable<Termo>{
	
	/**
	 * Adiciona o termo dado ao polinomio. O termo é adicionado na posição correta, 
	 * para manter o polinomio ordenado e com no máximo um termo por expoente. 
	 * 
	 * Se já existir um termo no polinomio de expoente igual ao do termo dado:
	 * Caso a soma dos coeficientes destes termos resulte zero, o termo já existente é
	 * deletado do polinomio. Caso contrário, o coeficiente do termo dado é somado ao 
	 * coeficiente do termo existente.
	 *
	 * @param termo o termo a ser adicionado
	 */
	public void adicionar(Termo termo);
	
	/**
	 * Calcula o valor do polinomio no ponto dado.
	 * 
	 * @param ponto o ponto a ser calculado
	 * @return o resultado do polinomio neste ponto
	 */
	public double avaliar(double ponto);
	
	/**
	 * Representação textual deste polinomio no formato "8.0 + 1x + 2.0x3 + 7x5 + 5x6" 
	 * 
	 * @return representação textual do polinomio
	 */
	public String toString();
	
}
