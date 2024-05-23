
public class Calcado extends Produto {
		public Calcado(int codigo, String nome, String tipo, double valor, 
			double desconto) {
			super(codigo, nome, tipo, valor, desconto);
			
			}
		public double total () {
			double descontar = this.valor * 0.4;
			return descontar;
			
		}
}
