package fabrica.bolo;



public abstract class Bolo implements IBolo {
	private int codigo;
	private double custo;
	private IFormato formato;
	
	
	
	
	
	public Bolo(int codigo, double custo) {
		this.codigo=codigo;
		this.custo=custo;
		
	}
	public Bolo(int codigo, double custo, IFormato formato) {
		this.codigo=codigo;
		this.custo=custo;
		this.formato=formato;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public IFormato getFormato() {
		return formato;
	}
	public void setFormato(IFormato formato) {
		this.formato = formato;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null) {
	        return false;
	    }
	    if (!(obj instanceof Bolo)) {
	        return false;
	    }
	    Bolo other = (Bolo) obj;
	    return this.codigo == other.codigo;
	}
	



@Override
public String toString() {
	return "Bolo [codigo: " + codigo + ", custo:" + custo +
			" formato do bolo:" + formato + "]";
}
	

}
