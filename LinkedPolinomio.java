import java.util.Iterator;

/**
 * Um polinomio implementado com uma Linked List.
 * 
 * @author Larissa Oliveira FC59830
 *
 */
public class LinkedPolinomio implements Polinomio{
	
	private Node first;
	private int size;
	
	private class Node{
		Termo item;
		Node next;
	}
	
	private class polinomioIterator implements Iterator<Termo>{
		private Node atual = first;
		public boolean hasNext() {	return atual != null;	}
		public Termo next() {
			Termo next = atual.item;
			atual = atual.next;
			return next;
		}
	}

	@Override
	public Iterator<Termo> iterator() {
		return new polinomioIterator();
	}

	/**
	 * Complexidade temporal: O(n)
	 * Justificação: seja n o número de termos no polinomio neste momento. No pior caso,
	 * em que o termo dado possui expoente maior que todos os termos do polinomio, o 
	 * método faz n comparações, pelo que corre em O(n).
	 */
	public void adicionar(Termo termo) {
		if(first == null) {
			first = new Node();
			first.item = termo;
			size++;
		} else {
			if(termo.compareTo(first.item) < 0) {
				Node newNode = new Node();
				newNode.item = termo;
				newNode.next = first;
				first = newNode;
				size++;
			} else if(termo.compareTo(first.item) == 0) {
				if(termo.base+first.item.base == 0) {
					first = first.next;
					size--;
				} else {
					Termo newTermo = new Termo(termo.base+first.item.base, termo.expoente);
					first.item = newTermo;
				}
			} else {
				setPosition(termo);
			}
		}
	}
	
	/**
	 * Método auxiliar para {@code adicionar(Termo termo)} que busca a posição do termo
	 * dado no polinomio e faz as alterações necessárias
	 * 
	 * @param termo o termo dado
	 */
	private void setPosition(Termo termo) {
		Node newNode = new Node();
		newNode.item = termo;
		
		Node current = first;
		boolean found = false;
		
		while(!found && current.next != null) {
			if(termo.compareTo(current.next.item) < 0) {
				found = true;
				newNode.next = current.next;
				current.next = newNode;
				size++;
			} else if(termo.compareTo(current.next.item) == 0) {
				found = true;
				setEqual(termo, current);
			} else
				current = current.next;
		}
		if(!found) {
			current.next = newNode;
			size++;
		}
	}
	
	/**
	 * Método auxiliar para {@code setPosition(Termo termo} que faz as alterações 
	 * necessárias caso o termo dado tenha expoente igual a outro termo presente
	 * no polinomio.
	 * 
	 * @param termo o termo dado
	 * @param node o nó anterior ao nó que possui o termo com expoente igual ao expoente 
	 * do termo dado
	 */
	private void setEqual(Termo termo, Node node) {
		double newBase = termo.base+node.next.item.base;
		if(newBase == 0) {
			node.next = node.next.next;
			size--;
		} else {
			Termo newTermo = new Termo(newBase, termo.expoente);
			node.next.item = newTermo;
		}
	} 
	

	/**
	 * Complexidade temporal: O(n)
	 * Justificação: seja n o número de termos no polinomio neste momento. O método 
	 * faz o cálculo para cada termo do polinomio no ponto dado, pelo que corre em O(n).
	 */
	public double avaliar(double ponto) {
		double result = 0;
		for(Termo t : this) {
			result += Math.pow(ponto, t.expoente) * t.base;
		}
		return result;
	}
	
	public Termo maiorCoeficiente() {
		Termo maior = first.item;
		for(Termo t : this) {
			if(t.base > maior.base)
				maior = t;
		}
		return maior;
	}
	
	public int numeroExpoentes() {
		return this.size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = first;
		while(current != null){
			sb.append(current.item);
			if(current.next != null) 
				sb.append(" + ");
			current = current.next;
		}
		return sb.toString();
	}

}
