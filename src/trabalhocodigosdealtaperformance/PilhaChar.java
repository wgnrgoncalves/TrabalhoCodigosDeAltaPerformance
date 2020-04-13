package trabalhocodigosdealtaperformance;
/**
*
* @author g_o_n
*/
public class PilhaChar {
	private final int N = 30;

	private char[] dados = new char[30];
	private int topo = 0;

	public void init() {
		topo = 0;
	}

	public boolean isFull() {
		return topo == N;
	}

	public void push(char elem) {
		if (!isFull()) {
			dados[topo] = elem;
			topo++;

		} else {
			System.out.println("stack overflow");
		}
	}

	public boolean isEmpty() {
		return topo == 0;
	}

	public static class RetornoChar {
		char elem;
		boolean sucesso;
	}

	public RetornoChar pop() {
		RetornoChar saida = new RetornoChar();
		if (!isEmpty()) {
			topo--;
			saida.elem = dados[topo];
			saida.sucesso = true;
		} else {
			saida.sucesso = false;
		}
		return saida;
	}

	public RetornoChar top() {
		RetornoChar saida = new RetornoChar();
		if (!isEmpty()) {
			saida.elem = dados[topo - 1];
			saida.sucesso = true;
		} else {
			saida.sucesso = false;
		}
		return saida;
	}
}
