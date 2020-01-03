package br.com.denisluna.selenium_utils.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import br.com.denisluna.selenium_utils.enums.Formato;

/**
 * Classe que permite obter datas formatadas em strings, para utilização nos
 * testes
 * 
 * @author Denis Luna Borges da Silva
 *
 */
public abstract class LocalDateTimeUtils {
	/**
	 * Pega primeiro dia do mês atual, com o formato DD/MM/AAAA
	 * 
	 * @return String no formato DD/MM/AAAA com o primeiro dia do mês
	 */
	public static String getPrimeiraDataDoMesAtual() {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataRetorno = dataAtual.withDayOfMonth(1);
		String retorno = dataRetorno.format(DateTimeFormatter.ofPattern(Formato.DDMMYYYY.toString()));

		return retorno;
	}

	/**
	 * Pega último dia do mês atual, com o formato DD/MM/AAAA
	 * 
	 * @return String no formato DD/MM/AAAA com o último dia do mês
	 */
	public static String getUltimaDataDoMesAtual() {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataRetorno = dataAtual.withDayOfMonth(dataAtual.lengthOfMonth());
		String retorno = dataRetorno.format(DateTimeFormatter.ofPattern(Formato.DDMMYYYY.toString()));

		return retorno;
	}

	/**
	 * Pega o último dia do mês atual (apenas o dia)
	 * 
	 * @return String no formato DD com o último dia do mês
	 */
	public static String getUltimoDiaDoMesAtual() {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataRetorno = dataAtual.withDayOfMonth(dataAtual.lengthOfMonth());
		String retorno = dataRetorno.format(DateTimeFormatter.ofPattern(Formato.DAY.toString()));

		return retorno;
	}

	/**
	 * Pega a data/hora atual
	 * 
	 * @return String com a data hora atual no formato DD/MM/AAAA HH:MM:SS
	 */
	public static String getDataHoraAtual() {
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		String retorno = dataHoraAtual.format(DateTimeFormatter.ofPattern(Formato.ISO_DATETIME.toString()));

		return retorno;
	}

	/**
	 * Pega data atual inversa
	 * 
	 * @return string com a data no formato AAAA/MM/DD
	 */
	public static String getDataAtualInversa() {
		LocalDate dataAtual = LocalDate.now();
		String retorno = dataAtual.format(DateTimeFormatter.ofPattern(Formato.YYYYMMDD.toString()));

		return retorno;
	}

	/**
	 * Pega a hora atual
	 * 
	 * @return String com a hora atual no formato HH:MM:SS
	 */
	public static String getHoraAtual() {
		LocalTime horaAtual = LocalTime.now();
		String retorno = horaAtual.format(DateTimeFormatter.ofPattern(Formato.HMS.toString()));

		return retorno;
	}

	/**
	 * Pega data atual
	 * 
	 * @return string com a data no formato DD/MM/AAAA
	 */
	public static String getDataAtual() {
		LocalDate dataAtual = LocalDate.now();
		String retorno = dataAtual.format(DateTimeFormatter.ofPattern(Formato.DDMMYYYY.toString()));

		return retorno;
	}

	/**
	 * Pega data atual
	 * 
	 * @return String com a data no formato AAAA-MM
	 */
	public static String getDataAtualAnoMes() {
		LocalDate dataAtual = LocalDate.now();
		String retorno = dataAtual.format(DateTimeFormatter.ofPattern(Formato.YEAR_MONTH.toString()));

		return retorno;
	}

	/***
	 * Pega datas de meses anteriores
	 * 
	 * @param mesesDiferenca quantidade de meses anteriores a ser pega
	 * @return String com a data no formato AAAA-MM
	 */
	public static String getDataAtualAnoMesAnterior(int mesesDiferenca) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataAnterior = dataAtual.minusMonths(mesesDiferenca);
		String retorno = dataAnterior.format(DateTimeFormatter.ofPattern(Formato.YEAR_MONTH.toString()));

		return retorno;
	}

	/**
	 * Pega mês atual
	 * 
	 * @return int com a data no formato MM (mês atual)
	 */
	public static int getMesAtual() {
		LocalDate dataAtual = LocalDate.now();
		String retorno = dataAtual.format(DateTimeFormatter.ofPattern(Formato.MONTH.toString()));

		return NumberUtils.converteStringParaInteger(retorno);

	}

	/**
	 * Pega mês anterior
	 * 
	 * @param mesesDiferenca quantidade de meses anteriores
	 * @return int com a data no formato MM (mês anterior)
	 */
	public static int getMesAnterior(int mesesDiferenca) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataAnterior = dataAtual.minusMonths(mesesDiferenca);
		String retorno = dataAnterior.format(DateTimeFormatter.ofPattern(Formato.MONTH.toString()));

		return NumberUtils.converteStringParaInteger(retorno);
	}

	/**
	 * Pega anos atual
	 * 
	 * @return int com a data no formato yyyy (ano atual)
	 */
	public static int getAnoAtual() {
		LocalDate dataAtual = LocalDate.now();
		String retorno = dataAtual.format(DateTimeFormatter.ofPattern(Formato.YEAR.toString()));

		return NumberUtils.converteStringParaInteger(retorno);

	}

	/**
	 * Pega dia atual
	 * 
	 * @return string com a data no formato DD (dia do mês)
	 */
	public static int getDiaAtual() {
		LocalDate dataAtual = LocalDate.now();
		String retorno = dataAtual.format(DateTimeFormatter.ofPattern(Formato.DAY.toString()));

		return NumberUtils.converteStringParaInteger(retorno);

	}

	/**
	 * Pega data atual + 3 dias
	 * 
	 * @return string com a data atual no formato DD/MM/AAAA + 3 dias
	 */
	@Deprecated
	public static String getDataAtualMais3Dias() {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataSeguinte = dataAtual.plusDays(3);
		String retorno = dataSeguinte.format(DateTimeFormatter.ofPattern(Formato.YEAR_MONTH.toString()));

		return retorno;
	}

	/**
	 * Calcula a diferença entre datas, considerando data atual - data inicial
	 * 
	 * @param data data inicial a ser subtraída da data atual
	 * @return valor em dias entre a diferença de datas
	 */
	private static long calculaDiferencaDatas(String data) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataAnterior = LocalDate.parse(data);
		long dias = ChronoUnit.DAYS.between(dataAtual, dataAnterior);

		return dias;
	}

	/**
	 * Método que valida se data ultrapassa determinada quantidade de dias
	 * 
	 * @param data           data a ser considerada
	 * @param quantidadeDias quantidade de dias passados
	 * @return boolean validando se data é maior que período especificado
	 */
	public static boolean validaDataMaiorQue(String data, int quantidadeDias) {
		long diff = LocalDateTimeUtils.calculaDiferencaDatas(data);
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) >= quantidadeDias;
	}

	/**
	 * Método que valida se data está entre período de dias
	 * 
	 * @param data                 data a ser considerada
	 * @param quantidadeDiasInicio data inicial
	 * @param quantidadeDiasFim    data final
	 * @return boolean validando se data está entre os dias especificados
	 */
	public static boolean validaDataEntre(String data, int quantidadeDiasInicio, int quantidadeDiasFim) {
		long diff = LocalDateTimeUtils.calculaDiferencaDatas(data);
		boolean estaEntrePeriodo = (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) >= quantidadeDiasInicio)
				&& (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) <= quantidadeDiasFim);

		return estaEntrePeriodo;
	}

	/**
	 * Método que valida se data é menor que determinada quantidade de dias
	 * 
	 * @param data           data a ser considerada
	 * @param quantidadeDias quantidade de dias passados
	 * @return boolean validando se data é menor que período especificado
	 */
	public static boolean validaDataMenorQue(String data, int quantidadeDias) {
		long diff = LocalDateTimeUtils.calculaDiferencaDatas(data);
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) <= quantidadeDias;
	}

	/**
	 * Método que retorna primeiro dia de um determinado mês
	 * 
	 * @param i mês a ser considerado
	 * @return String com a data no formato yyyy/MM/dd
	 */
	public static String getPrimeiraDataMesInversa(int i) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataRetorno = dataAtual.withDayOfMonth(1);
		String retorno = dataRetorno.format(DateTimeFormatter.ofPattern(Formato.YMD.toString()));

		return retorno;
	}

	/**
	 * Método que retorna último dia de um determinado mês
	 * 
	 * @param i mês a ser considerado
	 * @return String com a data no formato yyyy/MM/dd
	 */
	public static String getUltimaDataMesInversa(int i) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataRetorno = dataAtual.withDayOfMonth(dataAtual.lengthOfMonth());
		String retorno = dataRetorno.format(DateTimeFormatter.ofPattern(Formato.YMD.toString()));

		return retorno;
	}

	public static LocalDate converteData(String formato, String data) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern(formato);
		return LocalDate.parse(data, df);
	}

	public static LocalDate converteData(Formato formato, String data) {
		return converteData(formato.toString(), data);
	}

	public static LocalDate geraDataAleatoria(int anoMinimo, int anoMaximo) {
		Random random = new Random();
		int diaMinimo = (int) LocalDate.of(anoMinimo, 1, 1).toEpochDay();
		int diaMaximo = (int) LocalDate.of(anoMaximo, 1, 1).toEpochDay();
		long diaAleatorio = diaMinimo + random.nextInt(diaMaximo - diaMinimo);

		return LocalDate.ofEpochDay(diaAleatorio);
	}

	public static void aguardaTempoDeEspera(int tempoEspera) {
		LocalTime localTime = LocalTime.now();
		int minutos = localTime.getMinute();

		tempoEspera = tempoEspera + 1 - minutos % 5;

		System.out.printf("\nAguardando %1$d minutos...\n", tempoEspera);

		try {
			Thread.sleep(TimeUnit.MINUTES.toMillis(tempoEspera));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static String formataData(Formato formato, LocalDate date) {
		String retorno = date.format(DateTimeFormatter.ofPattern(formato.toString()));

		return retorno;
	}

	public static String formataHora(Formato formato, LocalTime hora) {
		String retorno = hora.format(DateTimeFormatter.ofPattern(formato.toString()));

		return retorno;
	}
}