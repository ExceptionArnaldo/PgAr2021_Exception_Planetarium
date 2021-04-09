import java.util.ArrayList;

public class Pianeta extends CorpoCeleste{

	final static int MAX_LUNE = 5000;
	
	private ArrayList<Luna> lune = new ArrayList<>();
	
	public Pianeta(String nome, double massa, Punto punto) {
		super(nome, massa, punto);
		
	}

	public boolean aggiungiLuna(Luna nuovaLuna) {
		if(lune.size() < MAX_LUNE) {
			lune.add(nuovaLuna);
			return true;
		}
		else return false;
	}
	
	public ArrayList<Luna> getLuna() {
		return lune;
	}
	
	@Override
	public String toString() {
		return "Pianeta [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
