package com.sgro.model;

import com.sgro.utils.Enumerativo;

/**
 * Classe che estende Item aggiungendo la quantità
 * 
 * @author Sgrò
 *
 */
public class ItemQty extends Item {

	private Item item;
	private int qty;

	public ItemQty(int idOggetto, String nome, String descrizione, Enumerativo tipo, boolean imported, double price,
			int qty) {
		super(idOggetto, nome, descrizione, tipo, imported, price);
		this.qty = qty;
	}

	public ItemQty(Item x, int i) {
		super(x.getIdOggetto(), x.getNome(), x.getDescrizione(), x.getTipo(), x.isImported(), x.getPrice());
		this.item = x;
		this.qty = i;
	}

	public int getItemId() {
		return item.getIdOggetto();
	}

	public int getQty() {
		return qty;
	}

	public void incrQty() {
		this.qty++;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
