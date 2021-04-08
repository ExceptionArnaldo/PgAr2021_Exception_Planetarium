import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class MainPlanetario {

	final static String MENU_TITOLO = "Benvenuti in planetario";
	final static String VOCI_MENU[] = {"Aggiungi un corpo celeste", "Rimuovi un corpo celeste"};
	
	final static String AGGIUNGERE_CORPO_CELESTE = "Aggiungere un corpo celeste";
	final static String AGGIUNGERE_CORPO_CELESTE_VOCI[] = {"Aggiungi un pianeta", "Rimuovi una luna"};
	
	final static String ELIMINARE_CORPO_CELESTE = "Rimuovi un corpo celeste";
	final static String ELIMINARE_CORPO_CELESTE_VOCI[] = {"Rimuovi un pianeta", "Rimuovi una luna"};
	
	public static void main(String[] args) {
		
		SistemaSolare sistemaSolare = new SistemaSolare();
		
		MyMenu menu = new MyMenu(MENU_TITOLO, VOCI_MENU);
		MyMenu menuAggiungereCorpo = new MyMenu(AGGIUNGERE_CORPO_CELESTE, AGGIUNGERE_CORPO_CELESTE_VOCI);
		MyMenu menuEliminareCorpo = new MyMenu(ELIMINARE_CORPO_CELESTE, ELIMINARE_CORPO_CELESTE_VOCI);
		
		switch(menu.scegli()) {
			case 1: {
				menuAggiungereCorpo.stampaMenu();
				break;
			}
			case 2: {
				menuEliminareCorpo.stampaMenu();
				break;
			}
		}
		
	}

}
