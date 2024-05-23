
public class Casa extends Produto{
	public Casa(int codigo, String nome, String tipo, double valor, 
			double desconto) {
			super(codigo, nome, tipo, valor, desconto);
			
			}
		public double total () {
			double desconto = this.valor * 0.3;
			return desconto;s
			
		}
}
