package fabrica.bolo;

public class BoloSimples extends Bolo {
	private boolean semLactose;

	public BoloSimples(int codigo, double custo, IFormato formato) {
		super(codigo, custo, formato);
		this.semLactose = false;
	}

	public BoloSimples(int codigo, double custo, IFormato formato, boolean semLactose) {
		super(codigo, custo, formato);
		this.semLactose = semLactose;
	}

	@Override
	public double preco() {
		double precoBase = getCusto() * getFormato().area();
		if (semLactose) {
			return precoBase + 25.0;
		}
		return precoBase;
	}

	@Override
	public String toString() {
		return "BoloSimples [codigo=" + getCodigo() +
		       ", custo=" + getCusto() +
		       ", semLactose=" + semLactose +
		       ", preco=" + preco() + "]";
	}
}
