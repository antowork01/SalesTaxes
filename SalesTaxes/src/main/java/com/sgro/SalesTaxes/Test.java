package com.sgro.SalesTaxes;

import com.sgro.model.Magazzino;
import com.sgro.model.Scontrino;
import com.sgro.utils.InputFromConsole;

/**
 * Classe contenente alcuni metodi per testare l'applicazione
 * 
 * @author Sgrò
 *
 */
public class Test {

	/**
	 * Metodo che riproduce l'esempio proposto nell'esercizio
	 */
	public static void esempioEsercizio() {
		Magazzino magazzino = new Magazzino(), carrello1 = new Magazzino(), carrello2 = new Magazzino(),
				carrello3 = new Magazzino();
		Scontrino scontrino = new Scontrino();
		magazzino.creaMagazzino();
		carrello1.riempiCarrello(magazzino, 0, 0, 1, 2);
		carrello2.riempiCarrello(magazzino, 3, 4);
		carrello3.riempiCarrello(magazzino, 5, 6, 7, 8, 8, 8);

		System.out.println("carrello1");
		System.out.println(scontrino.generaScontrino(carrello1).stampaScontrino());

		System.out.println("carrello2");
		System.out.println(scontrino.generaScontrino(carrello2).stampaScontrino());

		System.out.println("carrello3");
		System.out.println(scontrino.generaScontrino(carrello3).stampaScontrino());

	}

	/**
	 * Metodo che permette di scegliere degli articoli presenti in magazzino,
	 * metterli nel carrello e generare lo scontrino.
	 */
	public static void scegliArticoli() {
		Magazzino magazzino = new Magazzino();
		magazzino.creaMagazzino();
		Scontrino scontrino = new Scontrino();
		System.out.println("Elenco elementi acquistabili: \n");

		InputFromConsole.StampaMagazzino(magazzino.getMagazzino());

		System.out.println("Inserisci l'id dell'articolo da acquistare: \n");
		System.out.println(
				scontrino.generaScontrino(InputFromConsole.scegliElementiCarrello(magazzino)).stampaScontrino());
	}
}
