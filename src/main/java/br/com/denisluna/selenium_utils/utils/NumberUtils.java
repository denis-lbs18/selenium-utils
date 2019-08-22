package br.com.denisluna.selenium_utils.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.math3.util.Precision;

/**
 * Classe que facilita a conversão entre Integer e String
 * 
 * @author Denis Luna Borges da Silva
 *
 */
public abstract class NumberUtils {
	/**
	 * Método que trata e converte um valor int para {@link String}.
	 * 
	 * @param value valor int a ser convertido.
	 * @return {@link String} com o número.
	 */
	public static String converteIntegerParaString(int value) {
		return Integer.toString(value);
	}

	/**
	 * Método que trata e converte um texto {@link String} para int.
	 * 
	 * @param value {@link String} com o valor a ser convertido.
	 * @return int com o texto convertido.
	 */
	public static int converteStringParaInteger(String value) {
		int retorno = 0;

		if ((!value.equals("-")) || (!value.isEmpty())) {
			try {
				retorno = Integer.parseInt(value);
			} catch (NumberFormatException ex) {
				System.out.println("Erro na conversão de String para integer");
				System.out.println("Erro: " + ex.toString());
			}
		}

		return retorno;
	}

	/**
	 * Método que trata e converte um valor float para {@link String}.
	 * 
	 * @param value valor float a ser convertido.
	 * @return {@link String} com o número.
	 */
	public static String converteFloatParaString(float value) {
		return Float.toString(value);
	}

	/**
	 * Método que trata e converte valores de {@link String} para float.
	 * 
	 * @param value {@link String} com o valor a ser convertido.
	 * @return float com o valor convertido.
	 */
	public static float converteStringParaFloat(String value) {
		float retorno = 0;
		value = removeCaracteresFloat(value);

		if ((!value.equals("-")) || (!value.isEmpty())) {
			try {
				retorno = Float.parseFloat(value);
			} catch (NumberFormatException ex) {
				try {
					value = transformaVirgulaEmPonto(value);
					retorno = Float.parseFloat(value);
				} catch (NumberFormatException nbEx) {
					System.out.println("Erro na conversão de String para float");
					System.out.println("Erro: " + ex.toString());
				}
			}
		}

		return retorno;
	}

	/**
	 * Método que trata e converte valores de {@link String} para o wrapper
	 * {@link Double}.
	 * 
	 * @param value {@link String} com o valor a ser convertido.
	 * @return {@link Double} com o valor convertido.
	 */
	public static Double converteStringParaDouble(String value) {
		double retorno = 0;
		value = removeCaracteresFloat(value);
		value = transformaVirgulaEmPonto(value);

		if ((!value.equals("-")) || (!value.isEmpty())) {
			try {
				retorno = Double.parseDouble(value);
			} catch (NumberFormatException ex) {
				System.out.println("Erro na conversão de String para double");
				System.out.println("Erro: " + ex.toString());
			}
		}

		return retorno;
	}

	/**
	 * Método que converte de double para {@link String}.
	 * 
	 * @param valorDouble
	 * @return
	 */
	public static String converteDoubleParaString(double valorDouble) {
		int valorInt = Double.valueOf(valorDouble).intValue();

		return Integer.valueOf(valorInt * 100).toString();
	}

	/**
	 * Método que trata e soma valores em um ArrayList de String
	 * 
	 * @param listaItens ArrayList com os valores em String
	 * @return String com os valores somados
	 */
	public static String somaItemsListaString(List<String> listaItens) {
		List<Integer> listaNumeros = new ArrayList<Integer>();

		for (String item : listaItens) {
			listaNumeros.add(NumberUtils.converteStringParaInteger(item));
		}

		int soma = 0;

		for (Integer numero : listaNumeros) {
			soma += numero;
		}

		return NumberUtils.converteIntegerParaString(soma);
	}

	/**
	 * Método que trata e soma valores em um ArrayList de Strings
	 * 
	 * @param listaItens ArrayList com os valores em String
	 * @return int com os valores somados
	 */
	public static int somaItemsListaInt(List<String> listaItens) {
		List<Integer> listaNumeros = new ArrayList<Integer>();

		for (String item : listaItens) {
			listaNumeros.add(NumberUtils.converteStringParaInteger(item));
		}

		int soma = 0;

		for (Integer numero : listaNumeros) {
			soma += numero;
		}

		return soma;
	}

	/**
	 * Mètodo que arredonda um valor decimal em duas casas.
	 * 
	 * @param value float com o valor original.
	 * @return float com o valor arredondado.
	 */
	public static float arredondaDuasCasas(float value) {
		BigDecimal bd = new BigDecimal(Float.toString(value));
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}

	/**
	 * Método que arredonda um valor decimal para cima.
	 * 
	 * @param value         float com o valor original.
	 * @param casasDecimais número de casas decimais para arredondar.
	 * @return float com o valor arredondado.
	 */
	public static float arredondaNumero(float value, int casasDecimais) {
		BigDecimal retorno = new BigDecimal(value).setScale(casasDecimais, BigDecimal.ROUND_HALF_UP);
		return retorno.floatValue();
	}

	/**
	 * Método que arredonda um valor decimal para cima.
	 * 
	 * @param value         double com o valor original.
	 * @param casasDecimais número de casas decimais para arredondar.
	 * @return double com valor arredondado.
	 */
	public static double arredondaNumero(double value, int casasDecimais) {
		BigDecimal retorno = new BigDecimal(value).setScale(casasDecimais, BigDecimal.ROUND_HALF_UP);
		return retorno.doubleValue();
	}

	/**
	 * Método que tranforma um valor decimal em porcentagem.
	 * 
	 * @param valor float com o valor original.
	 * @return float com o valor em porcentagem.
	 */
	public static float converteParaPorcentagem(float valor) {
		float retorno = Precision.round(valor, 2) * 100;

		return retorno;
	}

	/**
	 * Método que remove caracteres inválidos de um texto.
	 * 
	 * @param texto {@link String} com o texto original.
	 * @return {@link String} com o texto transformado.
	 */
	public static String removeCaracteres(String texto) {
		return texto.replaceAll("\\D+", "");
	}

	/**
	 * Método que remove caractere de %.
	 * 
	 * @param texto {@link String} com o texto original.
	 * @return {@link String} com o texto transformado.
	 */
	public static String removeCaracteresFloat(String texto) {
		return texto.replaceAll("%", "");
	}

	/**
	 * Método que transforma o caractere vírgula (,) em ponto (.).
	 * 
	 * @param texto {@link String} com o texto original.
	 * @return {@link String} com o texto transformado.
	 */
	public static String transformaVirgulaEmPonto(String texto) {
		if (!texto.contains(","))
			return texto;

		texto = texto.replace(".", ";");
		texto = texto.replace(",", ".");
		texto = texto.replace(";", ",");

		return texto;
	}

	/**
	 * Método que gera números inteiros aleatórios.
	 * 
	 * @return int com valor entre 1 e 100.
	 */
	public static int pegaNumeroAleatorio() {
		int retorno = ThreadLocalRandom.current().nextInt(1, 101);
		return retorno;
	}

	/**
	 * Método que gera números inteiros aleatórios.
	 * 
	 * @param valorMinimo valor mínimo a ser gerado
	 * @param valorMaximo valor máximo a ser gerado (inclusivo)
	 * @return int com valor aleatório entre os dois valores enviados como
	 *         parâmetro.
	 */
	public static int pegaNumeroAleatorio(int valorMinimo, int valorMaximo) {
		int retorno = ThreadLocalRandom.current().nextInt(valorMinimo, valorMaximo + 1);
		return retorno;
	}

	/**
	 * Método que gera números inteiros aleatórios.
	 * 
	 * @param valorMinimo valor mínimo a ser gerado
	 * @param valorMaximo valor máximo a ser gerado (inclusivo)
	 * @return long com valor aleatório entre os dois valores enviados como
	 *         parâmetro.
	 */
	public static long pegaNumeroAleatorio(long valorMinimo, long valorMaximo) {
		long retorno = ThreadLocalRandom.current().nextLong(valorMinimo, valorMaximo + 1);
		return retorno;
	}
}