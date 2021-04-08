
public class CorpoCeleste {

	private String nome;
	private double massa;
	private Punto punto;
	
	public CorpoCeleste(String nome, double massa, Punto punto) {
		this.nome = nome;
		this.massa = massa;
		this.punto = punto;
	}

	@Override
	public String toString() {
		return "CorpoCeleste [nome=" + nome + ", massa=" + massa + ", punto=" + punto + "]";
	}
	
	
	
}
