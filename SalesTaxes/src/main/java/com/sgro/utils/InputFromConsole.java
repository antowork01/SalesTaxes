package com.sgro.utils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sgro.model.Item;
import com.sgro.model.Magazzino;

/**
 * Classe che gestisce input/output from CMD
 * 
 * @author Sgrò
 *
 */
public class InputFromConsole {

	public static void StampaMagazzino(ArrayList<Item> magazzino) {
		for (Item x : magazzino)
			System.out.println(x.toString());
	}

	public static Magazzino scegliElementiCarrello(Magazzino magazzino) {
		System.out.println("Al termine digita qualsiasi lettera per uscire");
		Scanner in = new Scanner(System.in);
		try {
			int i;
			boolean bool = true;

			ArrayList<Integer> id = new ArrayList<Integer>();
			do {
				if (in.hasNextInt()) {
					i = in.nextInt();
					if (magazzino.verificaArticoloInMagazzino(i))
						id.add(i);
					else
						System.out.println("Articolo non presente in magazzino");
				} else
					bool = false;
			} while (bool);
			Integer[] idArray = id.toArray(new Integer[id.size()]);
			return new Magazzino().riempiCarrello(magazzino, idArray);
		} catch (InputMismatchException i) {
			i.printStackTrace();
			return null;
		} catch (IndexOutOfBoundsException i) {
			i.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			in.close();
		}
	}
}
