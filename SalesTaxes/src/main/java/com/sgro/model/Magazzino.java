package com.sgro.model;

import java.util.ArrayList;

import com.sgro.utils.Enumerativo;

/**
 * Classe che modella il Magazzino articoli e il carrello acquisti
 * 
 * @author Sgrò
 *
 */
public class Magazzino {
	ArrayList<Item> magazzino;

	public Magazzino(ArrayList<Item> magazzino) {
		this.magazzino = magazzino;
	}

	public Magazzino() {

		magazzino = new ArrayList<Item>();
	}

	public ArrayList<Item> getMagazzino() {
		return magazzino;
	}

	public void setMagazzino(ArrayList<Item> magazzino) {
		this.magazzino = magazzino;
	}

	/**
	 * metodo che inizializza una serie di articoli presenti in magazzino
	 */
	public void creaMagazzino() {

		magazzino.add(new Item(0, "book", "titolo", Enumerativo.BOOKS, false, 12.49));

		magazzino.add(new Item(1, "music CD", "album", Enumerativo.OTHER, false, 14.99));

		magazzino.add(new Item(2, "chocolate bar", "marca", Enumerativo.FOOD, false, 0.85));

		magazzino.add(new Item(3, "box of chocolate", "marca", Enumerativo.FOOD, true, 10.00));

		magazzino.add(new Item(4, "bottle of perfume", "profumo importato", Enumerativo.OTHER, true, 47.50));

		magazzino.add(new Item(5, "bottle of perfume", "profumo importato2", Enumerativo.OTHER, true, 27.99));

		magazzino.add(new Item(6, "bottle of perfume", "marca", Enumerativo.OTHER, false, 18.99));

		magazzino.add(new Item(7, "packet of headache pills", "medicine", Enumerativo.MEDICAL, false, 9.75));

		magazzino.add(new Item(8, "box of chocolate", "marca2", Enumerativo.FOOD, true, 11.25));

	}

	/**
	 * Inserisce gli articoli nel carrello
	 * 
	 * @param magazzino articoli disponibili
	 * @param args      id degli articoli da inserire
	 * @return carrello contente gli articoli scelti
	 */
	public Magazzino riempiCarrello(Magazzino magazzino, Integer... args) {

		for (int index : args)
			this.magazzino.add(magazzino.get(index));

		return this;
	}

	/**
	 * metodo che verifica che un articolo sia presente in magazzino
	 * 
	 * @param magazzino
	 * @param idArticolo
	 * @return true se presente false altrimenti
	 */
	public boolean verificaArticoloInMagazzino(int idArticolo) {
		for (Item i : magazzino)
			if (i.getIdOggetto() == idArticolo)
				return true;
		return false;
	}

	public void add(Item oggetto) {
		magazzino.add(oggetto);
	}

	public Item get(int index) {
		return magazzino.get(index);
	}

}
