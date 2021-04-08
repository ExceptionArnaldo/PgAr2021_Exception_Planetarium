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
	
	public Pianeta trovaPianeta(String nomePianeta) {
		
		for(int i = 0; i < pianete.size(); i++) {
			if (pianete.get(i).getNome().equalsIgnoreCase(nomePianeta));
			return pianete.get(i);
		}
		
		return null;
		
	}
	
	public void aggiungiLuna(Luna nuovaLuna, String nomePianeta) {
		
		trovaPianeta(nomePianeta).aggiungiLuna(nuovaLuna);;
		
	}
	
	public void stampaPianete() {
		for(int i = 0; i < pianete.size(); i++) {
			System.out.println("nome: " + pianete.get(i).getNome());
			System.out.println("massa: " + pianete.get(i).getMassa());
			System.out.println(pianete.get(i).getPunto());
		}
	}
	
}
