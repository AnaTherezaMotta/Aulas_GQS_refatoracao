
public class Produto {
	private int codigo;
	private String nome;
	private String tipo;
	protected double valor;
	private double desconto;

	public Produto(int codigo, String nome, String tipo, double valor, double desconto) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
		this.desconto = desconto;

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

}
