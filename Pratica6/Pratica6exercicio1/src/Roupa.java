
public class Roupa extends Produto {

	public Roupa(int codigo, String nome, String tipo, double valor) {
		double d = desconto();
		super(codigo, nome, tipo, valor, d);

	}

	public double desconto() {
		return valor * 0.5;
	}

}
