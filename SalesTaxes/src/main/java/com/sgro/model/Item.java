package com.sgro.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.sgro.utils.Enumerativo;

/**
 * Classe contenente i dati di un articolo presente in catalogo
 * 
 * @author Sgrò
 *
 */
public class Item {

	private int idOggetto;
	private String nome;
	private String descrizione;
	private Enumerativo tipo;
	private boolean imported;
	private double price;
	private double priceTaxed;

	public Item(int idOggetto, String nome, String descrizione, Enumerativo tipo, boolean imported, double price) {
		this.idOggetto = idOggetto;
		this.nome = nome;
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.imported = imported;
		this.price = price;
		this.priceTaxed = calculateTaxedPrice();
	}

	public int getIdOggetto() {
		return idOggetto;
	}

	public void setIdOggetto(int idOggetto) {
		this.idOggetto = idOggetto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Enumerativo getTipo() {
		return tipo;
	}

	public void setTipo(Enumerativo tipo) {
		this.tipo = tipo;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPriceTaxed() {
		return priceTaxed;
	}

	public void setPriceTaxed(double priceTaxed) {
		this.priceTaxed = priceTaxed;
	}

	/**
	 * @parameter double prezzo d'acquisto metodo che verifica il tipo di oggetto,
	 *            verifica se è d'importazione e calcola il prezzo di vendita
	 *            comprensivo di iva
	 * @return double prezzoVendita
	 */
	private double calculateTaxedPrice() {
		if (this.tipo == Enumerativo.OTHER) {
			if (this.imported == false) {
				return new BigDecimal(this.price * (1.1)).setScale(2,  RoundingMode.HALF_UP).doubleValue();// Math.round(this.price*(1.1)*100.0)/100.0;
			} else
				return new BigDecimal(this.price * (1.15)).setScale(2, RoundingMode.HALF_UP).doubleValue();
			// Math.round(this.price*(1.15)*100.0)/100.0;
		} else {
			if (this.imported == false) {
				return this.price;
			} else
				return new BigDecimal(this.price * (1.05)).setScale(2, RoundingMode.HALF_UP).doubleValue();// Math.round(this.price*(1.05)*100.0)/100.0;
		}
	}

	@Override
	public String toString() {
		if (imported)
			return idOggetto + "imported" + " " + nome + ", price = " + price + ", Taxed price = " + priceTaxed;
		else
			return idOggetto + " " + nome + ", price = " + price + ", Taxed price = " + priceTaxed;
	}

	public boolean equals(Item x) {
		if (this.getIdOggetto() == x.getIdOggetto())
			return true;
		return false;

	}

}
