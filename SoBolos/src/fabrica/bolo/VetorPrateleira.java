package fabrica.bolo;

public class VetorPrateleira implements IPrateleira {

	private IBolo[] prateleira;
	private int qtdBolo;

	public VetorPrateleira(int tamanho) {
		prateleira = new IBolo[tamanho];
		qtdBolo = 0;
	}

	@Override
	public boolean vazia() {
		return qtdBolo == 0;
	}

	@Override
	public boolean cheia() {
		return qtdBolo == prateleira.length;
	}

	@Override
	public int buscar(IBolo bolo) {
		for (int i = 0; i < qtdBolo; i++) {
			if (prateleira[i].equals(bolo)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean existe(IBolo bolo) {
		return buscar(bolo) != -1;
	}

	@Override
	public boolean inserir(IBolo bolo) {
		if (cheia()) {
			throw new RuntimeException("Prateleira cheia.");
		}
		if (existe(bolo)) {
			throw new RuntimeException("Bolo já cadastrado.");
		}
		prateleira[qtdBolo] = bolo;
		qtdBolo++;
		return true;
	}

	@Override
	public IBolo remover(IBolo bolo) {
		int pos = buscar(bolo);
		if (pos == -1) {
			throw new RuntimeException("Bolo não encontrado.");
		}
		IBolo removido = prateleira[pos];
		for (int i = pos; i < qtdBolo - 1; i++) {
			prateleira[i] = prateleira[i + 1];
		}
		prateleira[qtdBolo - 1] = null;
		qtdBolo--;
		return removido;
	}

	@Override
	public IBolo remover(int posicao) {
		if (posicao < 0 || posicao >= qtdBolo) {
			throw new RuntimeException("Bolo não encontrado.");
		}
		IBolo removido = prateleira[posicao];
		for (int i = posicao; i < qtdBolo - 1; i++) {
			prateleira[i] = prateleira[i + 1];
		}
		prateleira[qtdBolo - 1] = null;
		qtdBolo--;
		return removido;
	}

	@Override
	public IBolo consultar(IBolo bolo) {
		int pos = buscar(bolo);
		if (pos == -1) {
			throw new RuntimeException("Bolo não encontrado.");
		}
		return prateleira[pos];
	}

	@Override
	public IBolo[] listar() {
		IBolo[] lista = new IBolo[qtdBolo];
		for (int i = 0; i < qtdBolo; i++) {
			lista[i] = prateleira[i];
		}
		return lista;
	}

	@Override
	public IBolo[] listar(char tipoDoBolo) {
		int cont = 0;
		for (int i = 0; i < qtdBolo; i++) {
			if (tipoDoBolo == 'S' && prateleira[i] instanceof BoloSimples) {
				cont++;
			}
			if (tipoDoBolo == 'T' && prateleira[i] instanceof Torta) {
				cont++;
			}
		}
		IBolo[] lista = new IBolo[cont];
		int j = 0;
		for (int i = 0; i < qtdBolo; i++) {
			if (tipoDoBolo == 'S' && prateleira[i] instanceof BoloSimples) {
				lista[j++] = prateleira[i];
			}
			if (tipoDoBolo == 'T' && prateleira[i] instanceof Torta) {
				lista[j++] = prateleira[i];
			}
		}
		return lista;
	}
}
