package br.com.denisluna.selenium_utils.utils;

import java.text.Normalizer;

/**
 * Classe que facilita a manipulação e tratamento de Strings.
 * 
 * @author Denis Luna Borges da Silva
 *
 */
public abstract class StringUtils {
	/**
	 * Mètodo que remove a acentuação de um texto.
	 * 
	 * @param texto {@link String} original.
	 * @return {@link String} com os acentos removidos.
	 */
	public static String removeAcentos(String texto) {
		return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
}
