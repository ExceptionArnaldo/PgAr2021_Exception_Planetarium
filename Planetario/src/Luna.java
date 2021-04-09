
public class Luna extends CorpoCeleste{

	public Luna(String nome, double massa, Punto punto) {
		super(nome, massa, punto);
		
	}

	@Override
	public String toString() {
		return "Luna [Nome=" + getNome() + ", Massa=" + getMassa() + ", Punto()=" + getPunto();
	}
	
	
}
