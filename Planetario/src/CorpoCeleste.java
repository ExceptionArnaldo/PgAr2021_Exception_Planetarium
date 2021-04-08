
public class CorpoCeleste {

	private String nome;
	private double massa;
	private Punto punto;
	
	public CorpoCeleste(String nome, double massa, Punto punto) {
		this.nome = nome;
		this.massa = massa;
		this.punto = punto;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getMassa() {
		return massa;
	}


	public void setMassa(double massa) {
		this.massa = massa;
	}


	public Punto getPunto() {
		return punto;
	}


	public void setPunto(Punto punto) {
		this.punto = punto;
	}


	@Override
	public String toString() {
		return "CorpoCeleste [nome=" + nome + ", massa=" + massa + ", punto=" + punto + "]";
	}
	
	
	
}
