package fabrica.bolo;

public class Torta extends Bolo{
	private boolean recheio;
	private boolean cobertura;
	
	
	public Torta(int codigo, double custo, IFormato formato) {
		super(codigo, custo, formato);
		this.recheio=true;
		this.cobertura=true;
	}
	
	
	public Torta(int codigo, double custo, IFormato formato, boolean recheio, boolean cobertura) {
		super(codigo, custo, formato);
		this.recheio=recheio;
		this.cobertura=cobertura;
	}
	@Override
	public double preco() {
		double precoBase = getCusto() * getFormato().area();
		
		if(recheio&&cobertura) {
			return precoBase +32.5;
		}else if(recheio && !cobertura) {
			return precoBase +20.00;
		}else if(cobertura&&!recheio) {
			return precoBase + 12.50;
		}else
		return precoBase;
		
	}
	@Override
	public String toString() {
		return "Torta [codigo=" + getCodigo() +
		       ", custo=" + getCusto() +
		       ", recheio=" + recheio +
		       ", cobertura=" + cobertura +
		       ", preco=" + preco() + "]";
	}
}