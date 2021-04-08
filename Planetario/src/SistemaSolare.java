import java.util.ArrayList;

public class SistemaSolare {

	private final static int MAX_PIANETE = 26000;
	
	private Stella stella;
	private ArrayList<Pianeta> pianete = new ArrayList<>();
	
	public SistemaSolare(Stella stella) {
		this.stella = stella;
	}

	public Stella getStella() {
		return stella;
	}

	public void setStella(Stella stella) {
		this.stella = stella;
	}
	
	public void aggiungiPianeta(Pianeta nuovoPianeta) {
		if(pianete.size() < MAX_PIANETE) {
			pianete.add(nuovoPianeta);
		}
	}
	
	public void vediPianete() {
		for(int i = 0; i < pianete.size(); i++) {
			System.out.println(pianete.get(i));
		}
	}
	
	/*public ArrayList<Pianeta> getPianeta() 
	{
		return pianete;
	}*/
	
}
