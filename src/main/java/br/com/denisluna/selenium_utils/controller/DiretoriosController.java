package br.com.denisluna.selenium_utils.controller;

import java.io.File;
import java.io.IOException;

import br.com.denisluna.selenium_utils.utils.LocalDateTimeUtils;

/**
 * Classe que controla a criação de diretórios de evidência.
 * 
 * @author Denis Luna Borges da Silva
 *
 */
public class DiretoriosController {
	/**
	 * Constantes com os caminhos padrões de pastas.
	 */
	public static final String CAMINHO_BASE = "output/EXECUCAO_%1$s/%2$s", DIRETORIO_SUCESSO = "SUCESSO",
			DIRETORIO_FALHA = "FALHA", DIRETORIO_PDF = "PDF", DIRETORIO_RELATORIO = "RELATORIO",
			DIRETORIO_TEMPORARIO = "RELATORIO/tmp", DIRETORIO_PLANILHAS = "Planilhas";

	public static String getCaminhoBase(String diretorioSecundario) {
		String caminhoBase = String.format(CAMINHO_BASE, LocalDateTimeUtils.getDataAtual(), diretorioSecundario);
		return caminhoBase;
	}

	/**
	 * Método que cria uma pasta e arquivo.
	 * 
	 * @param nomePasta Nome do diretório a ser criado.
	 * @param nomeArq   Nome do arquivo a ser criado.
	 * @return {@link String} com o caminho completo do arquivo.
	 */
	public static String criaDiretorio(String nomePasta, String nomeArq) {
		String retorno = "./" + nomeArq;
		File diretorio = new File(nomePasta);
		diretorio.mkdirs();

		try {
			diretorio.createNewFile();
			retorno = diretorio.getCanonicalPath().toString().replace("\\", "/") + "/" + nomeArq;
		} catch (IOException e) {

			e.printStackTrace();
		}

		return retorno;
	}
}
