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
	
	public boolean aggiungiPianeta(Pianeta nuovoPianeta) {
		if(pianete.size() < MAX_PIANETE) {
			if(checkNome(nuovoPianeta.getNome()) == false) {
				pianete.add(nuovoPianeta);
				return true;
			}
			
			else return false;
			
		}
		return false;
	}
	
	public boolean checkNome(String nomePianeta) {
		
		for(int i = 0; i < pianete.size(); i++) {
			if(pianete.get(i).getNome().equalsIgnoreCase(nomePianeta)) return true;
		}
		
		return false;
		
	}
	
	public Pianeta trovaPianeta(String nomePianeta) {
		
		for(int i = 0; i < pianete.size(); i++) {
			if (pianete.get(i).getNome().equals(nomePianeta));
			return pianete.get(i);
		}
		
		return null;
		
	}
	
	public boolean aggiungiLuna(Luna nuovaLuna, String nomePianeta) {
		
		if(checkNome(nomePianeta) == true) {
			trovaPianeta(nomePianeta).aggiungiLuna(nuovaLuna);
			return true;
		}
		else return false;
		
	}
	
	public void stampaPianete() {
		for(int i = 0; i < pianete.size(); i++) {
			System.out.println("nome: " + pianete.get(i).getNome());
			System.out.println("massa: " + pianete.get(i).getMassa());
			System.out.println(pianete.get(i).getPunto());
		}
	}
	
}
