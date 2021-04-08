import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class MainPlanetario {

	final static int MIN_MASSA = 0;
	
	final static String MENU_TITOLO = "Benvenuti in planetario";
	final static String VOCI_MENU[] = {"Aggiungi un corpo celeste", "Rimuovi un corpo celeste", "Ricercare un corpo celeste", "Stampa tutti i pianeti"};
	
	final static String AGGIUNGERE_CORPO_CELESTE = "Aggiungere un corpo celeste";
	final static String AGGIUNGERE_CORPO_CELESTE_VOCI[] = {"Aggiungi un pianeta", "Aggiungi una luna"};
	
	final static String ELIMINARE_CORPO_CELESTE = "Rimuovi un corpo celeste";
	final static String ELIMINARE_CORPO_CELESTE_VOCI[] = {"Rimuovi un pianeta", "Rimuovi una luna"};
	
	final static String RICERCA_CORPO_CELESTE = "Cercare un corpo celeste";
	final static String RICERCA_CORPO_CELESTE_VOCI[] = {"Cerca un pianeta", "Cerca una luna"};
	
	final static String NOME_STELLA = "Inserisci un nome per la Stella: ";
	final static String MASSA_STELLA = "Inserisci la massa della Stella: ";
	final static String MASSA_CORPO = "Inserisci la massa: ";
	final static String NOME_CORPO = "Inserisci il nome: ";
	final static String COORDINATE = "Inserisci la coordinata %s: ";
	
	public static void main(String[] args) {
		
		Stella stella = nuovaStella();
		SistemaSolare sistemaSolare = new SistemaSolare(stella);
		
		MyMenu menu = new MyMenu(MENU_TITOLO, VOCI_MENU);
		MyMenu menuAggiungereCorpo = new MyMenu(AGGIUNGERE_CORPO_CELESTE, AGGIUNGERE_CORPO_CELESTE_VOCI);
		MyMenu menuEliminareCorpo = new MyMenu(ELIMINARE_CORPO_CELESTE, ELIMINARE_CORPO_CELESTE_VOCI);
		MyMenu menuRicercaCorpo = new MyMenu(RICERCA_CORPO_CELESTE, RICERCA_CORPO_CELESTE_VOCI);
		
		int scelta = menu.scegli();
		
		do {
			switch(scelta) {
				case 1: {
					switch(menuAggiungereCorpo.scegli()) {
						case 1: {
							sistemaSolare.aggiungiPianeta(nuovoPianeta());
							break;
						}
					}
					break;
				}
				case 2: {
					menuEliminareCorpo.stampaMenu();
					break;
				}
				case 3: {
					menuRicercaCorpo.stampaMenu();
				}
				case 4:{
					sistemaSolare.vediPianete();
				}
			}
			scelta = menu.scegli();
			
		}while(scelta != 0);
		
	}
	
	public static Stella nuovaStella() {
		
		String nome;
		double massa;
		
		nome = InputDati.leggiStringaNonVuota(NOME_STELLA);
		massa = InputDati.leggiDoubleConMinimo(MASSA_STELLA, MIN_MASSA);
		
		return new Stella(nome, massa, new Punto(0, 0));
	}
	
	public static Pianeta nuovoPianeta() {
		
		String nome;
		double massa;
		Punto punto = new Punto();
		
		nome = InputDati.leggiStringa(NOME_CORPO);
		massa = InputDati.leggiDoubleConMinimo(MASSA_CORPO, MIN_MASSA);
		punto.setX(InputDati.leggiDouble(String.format(COORDINATE, "x")));
		punto.setY(InputDati.leggiDouble(String.format(COORDINATE, "y")));
		
		return new Pianeta(nome, massa, punto);
	}
	
	public static Pianeta nuovaLuna() {
		
		String nome;
		double massa;
		Punto punto = new Punto();
		
		nome = InputDati.leggiStringa(NOME_CORPO);
		massa = InputDati.leggiDoubleConMinimo(MASSA_CORPO, MIN_MASSA);
		punto.setX(InputDati.leggiDouble(String.format(COORDINATE, "x")));
		punto.setY(InputDati.leggiDouble(String.format(COORDINATE, "y")));
		
		return new Pianeta(nome, massa, punto);
	}
	

}
