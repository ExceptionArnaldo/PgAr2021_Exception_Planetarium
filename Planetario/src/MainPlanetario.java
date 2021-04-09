import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class MainPlanetario {

	final static int MIN_MASSA = 0;
	
	final static String MENU_TITOLO = "Benvenuti in planetario";
	final static String VOCI_MENU[] = {"Aggiungi un corpo celeste", "Rimuovi un corpo celeste", "Ricercare un corpo celeste", "Stampare le lune di un pianeta", "Stamapre il percorso di una luna", "Stampa tutti i pianeti", "Calcola centro di massa"};
	
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
	
	final static String SUCCESSO_CORPO = "Aggiunto il corpo celeste";
	final static String ERRORE_CORPO = "Impossibile aggiungere il corpo celeste";
	
	final static String SUCCESSO_RIMUOVERE_CORPO = "Il corpo celeste ии stato rimosso";
	final static String ERRORE_RIMUOVERE_CORPO = "impossibile rimuovere il corpo celeste";
	
	final static String ERRORE_RICERCA = "Non esiste il corpo celeste";
	
	final static String MASSA = "Massa totale: ";
	final static String MASSA_POSIZIONE = "Massa pesata delle posizioni: (%.2f, %.2f)";
	final static String CENTRO_DI_MASSA = "Centro massa: (%.2f, %.2f)";
	
	final static String PERCORSO = "Il percorso da percorrere: %s < %s < %s";
	
	final static String LUNA_IN_PIANETA = "Inserire il nome della pianeta in cui gira la luna: ";
	
	public static void main(String[] args) {
		
		Stella stella = nuovaStella();
		SistemaSolare sistemaSolare = new SistemaSolare(stella);
		sistemaSolare.aggiornaMassa(stella.getMassa(), stella.getPunto(), 1);
		
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
							if(sistemaSolare.aggiungiPianeta(nuovoPianeta())) System.out.println(SUCCESSO_CORPO);
							else System.out.println(ERRORE_CORPO);
							break;
						}
						case 2: {
							if(sistemaSolare.aggiungiLuna(nuovaLuna(), InputDati.leggiStringaNonVuota(LUNA_IN_PIANETA))) System.out.println(SUCCESSO_CORPO);
							else System.out.println(ERRORE_CORPO);
							break;
						}
					}
					break;
				}
				case 2: {
					switch(menuEliminareCorpo.scegli()) {
						case 1: {
							if(sistemaSolare.eliminaPianeta(InputDati.leggiStringaNonVuota(NOME_CORPO)) == true) System.out.println(SUCCESSO_RIMUOVERE_CORPO);
							break;
						}
						case 2: {
							if(sistemaSolare.eliminaLuna(InputDati.leggiStringaNonVuota(NOME_CORPO)) == true) System.out.println(SUCCESSO_RIMUOVERE_CORPO);
						}
					}
					break;
				}
				case 3: {
					switch(menuRicercaCorpo.scegli()) {
						case 1: {
							String nome = InputDati.leggiStringaNonVuota(NOME_CORPO);
							if(sistemaSolare.checkNomePianeta(nome) == true) {
								System.out.println(sistemaSolare.trovaPianeta(nome).toString());
							}
							else System.out.println(ERRORE_RICERCA);
							break;
						}
						case 2: {
							String nome = InputDati.leggiStringaNonVuota(NOME_CORPO);
							if(sistemaSolare.checkNomeLuna(nome) == true) {
								System.out.println(sistemaSolare.trovaLuna(nome).toString());
								System.out.println(sistemaSolare.trovaPianeta(sistemaSolare.trovaLuna(nome)).toString());
							}
							else System.out.println(ERRORE_RICERCA);
							break;
						}
					}
					break;
				}
				case 4: {
					String nome = InputDati.leggiStringaNonVuota(NOME_CORPO);
					if(sistemaSolare.checkNomePianeta(nome) == true) {
						sistemaSolare.stampaLune(nome);
					}
					else System.out.println(ERRORE_RICERCA);

					break;
				}
				case 5: {
					String nome = InputDati.leggiStringaNonVuota(NOME_CORPO);
					if(sistemaSolare.checkNomeLuna(nome) == true) {
						System.out.println(String.format(PERCORSO, stella.getNome(), sistemaSolare.trovaPianeta(sistemaSolare.trovaLuna(nome)).getNome(), nome));
					}
					else System.out.println(ERRORE_RICERCA);
					
					break;
				}
				case 6:{
					sistemaSolare.stampaTuttiPianeti();
					break;
				}
				case 7:{
					System.out.println(MASSA + sistemaSolare.getMassaTotale());
					System.out.println(String.format(MASSA_POSIZIONE, sistemaSolare.getSommaPosizioni().getX(), sistemaSolare.getSommaPosizioni().getY()));
					System.out.println(String.format(CENTRO_DI_MASSA, sistemaSolare.getCentroMassa().getX(), sistemaSolare.getCentroMassa().getY()));
					break;
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
		double massa, x, y;
		Punto punto;
		
		nome = InputDati.leggiStringa(NOME_CORPO);
		massa = InputDati.leggiDoubleConMinimo(MASSA_CORPO, MIN_MASSA);
		x = InputDati.leggiDouble(String.format(COORDINATE, "x"));
		y = InputDati.leggiDouble(String.format(COORDINATE, "y"));
		
		punto = new Punto(x, y);
		
		return new Pianeta(nome, massa, punto);
	}
	
	public static Luna nuovaLuna() {
		
		String nome;
		double massa, x, y;
		Punto punto;
		
		nome = InputDati.leggiStringa(NOME_CORPO);
		massa = InputDati.leggiDoubleConMinimo(MASSA_CORPO, MIN_MASSA);
		x = InputDati.leggiDouble(String.format(COORDINATE, "x"));
		y = InputDati.leggiDouble(String.format(COORDINATE, "y"));
		
		punto = new Punto(x, y);
		
		return new Luna(nome, massa, punto);
	}
	

}
