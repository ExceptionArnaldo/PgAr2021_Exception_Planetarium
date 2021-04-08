
public class Pianeta extends CorpoCeleste{

	final static int MAX_LUNE = 5000;
	
	public Pianeta(String nome, double massa, Punto punto) {
		super(nome, massa, punto);
		
	}

	@Override
	public String toString() {
		return "Pianeta [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
