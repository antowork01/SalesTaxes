package com.sgro.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Classe che modella uno scontrino contenente articoli, quantità, prezzo e iva
 * 
 * @author Sgrò
 *
 */
public class Scontrino {

	public ArrayList<ItemQty> getScontrino() {
		return scontrino;
	}

	public void setScontrino(ArrayList<ItemQty> scontrino) {
		this.scontrino = scontrino;
	}

	ArrayList<ItemQty> scontrino;

	public Scontrino() {
		scontrino = new ArrayList<ItemQty>();
	}

	public Scontrino(ArrayList<ItemQty> scontrino) {
		this.scontrino = scontrino;
	}

	/**
	 * Metodo che a partire da un carrello acquisti genera uno scontrino, accorpa
	 * tutti gli elementi uguali sommandone il prezzo ed evidenziandone la quantità
	 * 
	 * @param carrello
	 * @return
	 */
	public Scontrino generaScontrino(Magazzino carrello) {

		ArrayList<ItemQty> visti = new ArrayList<ItemQty>();

		boolean bool = false;
		for (Item x : carrello.getMagazzino()) {
			bool = false;
			if (visti.isEmpty()) {
				visti.add(new ItemQty(x, 1));
				bool = true;
			} else {
				for (ItemQty y : visti) {
					if (y.getItemId() == x.getIdOggetto()) {
						y.incrQty();
						bool = true;
					}

				}

			}
			if (!bool) {
				visti.add(new ItemQty(x, 1));
				bool = false;
			}

		}
		return new Scontrino(visti);

	}

	/**
	 * metodo che produce una stringa che descrive gli articoli presenti nel
	 * carrello
	 * 
	 * @return
	 */
	public String stampaScontrino() {
		String string = "";
		double prezzo = 0.00;
		double iva = 0.00;
		for (ItemQty y : scontrino) {
			string += (y.getQty() + " " + y.getItem().getNome() + " prezzo: " + y.getItem().getPrice()
					+ ", totale con IVA: " + (y.getItem().getPriceTaxed()) * y.getQty());
			string += ("\n");
			prezzo += new BigDecimal(y.getItem().getPriceTaxed() * (double) y.getQty()).setScale(2, BigDecimal.ROUND_UP)
					.doubleValue();
			iva += new BigDecimal((y.getItem().getPriceTaxed() - y.getItem().getPrice()) * (double) y.getQty())
					.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
		}
		string += "Sales Taxes: " + iva + "\r\n" + "Total: " + prezzo + "\r\n";

		return string;
	}
}
