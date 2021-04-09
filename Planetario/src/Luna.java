
public class Luna extends CorpoCeleste{

	public Luna(String nome, double massa, Punto punto) {
		super(nome, massa, punto);
		
	}

	@Override
	public String toString() {
		return "Luna [getNome()=" + getNome() + ", getMassa()=" + getMassa() + ", getPunto()=" + getPunto()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	
}
