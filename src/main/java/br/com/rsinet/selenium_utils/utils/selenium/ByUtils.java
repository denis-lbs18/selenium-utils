package br.com.rsinet.selenium_utils.utils.selenium;

import org.openqa.selenium.By;

/**
 * Classe que efetua encapsulamento das funções da classe {@link By} do
 * Selenium, com métodos de busca de objetos Web por texto, classe e id
 * 
 * @author Denis Luna Borges da Silva
 *
 */
public abstract class ByUtils {
	/**
	 * Constantes que servem como parâmetro 'elemento' dos métodos, que são as TAGs
	 * HTML
	 */
	public static final String ALL = "*", MAIN = "main", A_LINK = "a", DIV = "div", SPAN = "span", INPUT = "input",
			SELECT = "select", BUTTON = "button", LABEL = "label", IMG = "img", H1 = "H1", H2 = "H2", H3 = "H3",
			H4 = "H4", H5 = "H5", B = "b", TEXTAREA = "textarea", P = "p", I = "i", TABLE = "table", TR = "tr",
			TD = "td", HEADER = "header", LI = "li";
	public static final String HTML_STRING_TEXT = "html-string-text";

	/**
	 * Busca elemento {@link By} utilizando o parâmetro ID
	 * 
	 * @param elemento tag HTML do elemento.
	 * @param id       nome do @id do elemento.
	 * @return objeto {@link By} encontrado.
	 */
	public static By encontraByID(String elemento, String id) {
		return By.xpath(String.format("//%1$s[@id='%2$s']", elemento, id));
	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro ID
	 * 
	 * @param elemento tag HTML do elemento.
	 * @param id       nome do @id do elemento.
	 * @param index    índice do elemento.
	 * @return objeto {@link By}encontrado.
	 */
	public static By encontraByID(String elemento, String id, int index) {
		return By.xpath(String.format("(//%1$s[@id='%2$s'])[%3$d]", elemento, id, index));
	}

	/**
	 * Busca elemento considerando o seletor CSS do elemento
	 * 
	 * @param elemento seletor CSS do elemento
	 * @return objeto {@link By} encontrado
	 */
	public static By encontraByCssSelector(String elemento) {
		return By.cssSelector(String.format(".%1$s", elemento));
	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro da classe
	 * 
	 * @param elemento tag HTML do elemento
	 * @param classe   classe do elemento
	 * @return objeto {@link By} encontrado
	 */
	public static By encontraByClass(String elemento, String classe) {
		return By.xpath(String.format("//%1$s[@class = '%2$s']", elemento, classe));
	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro da classe, buscando pelo
	 * índice de exibição
	 * 
	 * @param elemento tag HTML do elemento
	 * @param classe   classe do elemento
	 * @param index    índice do elemento
	 * @return objeto {@link By} encontrado
	 */
	public static By encontraByClass(String elemento, String classe, int index) {
		return By.xpath(String.format("(//%1$s[@class = '%2$s'])[%3$d]", elemento, classe, index));
	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro da classe com o método
	 * contains()
	 * 
	 * @param elemento tag HTML do elemento
	 * @param classe   classe do elemento
	 * @return objeto {@link By} encontrado
	 */
	public static By encontraByClassContains(String elemento, String classe) {
		return By.xpath(String.format("//%1$s[contains(@class,'%2$s')]", elemento, classe));
	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro da classe com o método
	 * contains(), buscando pelo índice de exibição
	 * 
	 * @param elemento tag HTML do elemento
	 * @param classe   classe do elemento
	 * @param index    índice do elemento
	 * @return objeto {@link By} encontrado
	 */
	public static By encontraByClassContains(String elemento, String classe, int index) {
		return By.xpath(String.format("(//%1$s[contains(@class,'%2$s')])[%3$d]", elemento, classe, index));
	}

	/**
	 * Busca elemento buscando por classe e por texto
	 * 
	 * @param elemento tag HTML do elemento
	 * @param classe   classe do elemento
	 * @param texto    texto do elemento
	 * @return objeto {@link By} encontrado
	 */
	public static By encontraByClassTextoContains(String elemento, String classe, String texto) {
		return By.xpath(String.format("//%1$s[@class='%2$s' and contains(text(), '%3$s')]", elemento, classe, texto));
	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro do texto absoluto do
	 * elemento
	 * 
	 * @param elemento tag HTML do elemento
	 * @param texto    texto absoluto do elemento
	 * @return objeto {@link By} encontrado
	 */
	public static By encontraByTexto(String elemento, String texto) {
		return By.xpath(String.format("//%1$s[text()='%2$s']", elemento, texto));
	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro do texto absoluto do
	 * elemento, buscando pelo índice de exibição
	 * 
	 * @param elemento tag HTML do elemento
	 * @param texto    texto absoluto do elemento
	 * @param index    índice do elemento
	 * @return objeto {@link By} encontrado
	 */
	public static By encontraByTexto(String elemento, String texto, int index) {
		return By.xpath(String.format("(//%1$s[text()='%2$s'])[%3$d]", elemento, texto, index));
	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro do texto absoluto do
	 * elemento, considerando as letras em minúsculo
	 * 
	 * @param elemento tag HTML do elemento
	 * @param texto    texto absoluto do elemento em minúsculas
	 * @return objeto {@link By} encontrado
	 */
	public static By encontraByTextoLowerCase(String elemento, String texto) {
		return By.xpath(String.format("(//%1$s[contains(lower-case(@title)='%2$s')])", elemento, texto));
	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro do texto absoluto do
	 * elemento, considerando as letras em minúsculo, buscando pelo índice de
	 * exibição
	 * 
	 * @param elemento tag HTML do elemento
	 * @param texto    texto absoluto do elemento em minúsculas
	 * @param index    índice do elemento
	 * @return objeto {@link By} encontrado
	 */
	public static By encontraByTextoLowerCase(String elemento, String texto, int index) {
		return By.xpath(String.format("(//%1$s[lower-case(@title)='%2$s'])[%3$d]", elemento, texto, index));

	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro do texto contido no
	 * elemento, usando o método contains()
	 * 
	 * @param elemento tag HTML do elemento
	 * @param texto    texto contido no elemento
	 * @return objeto {@link By} encontrado
	 */
	public static By encontraByTextoContains(String elemento, String texto) {
		return By.xpath(String.format("//%1$s[contains(text(),'%2$s')]", elemento, texto));
	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro do texto contido no
	 * elemento, usando o método contains(), buscando pelo índice de exibição
	 * 
	 * @param elemento tag HTML do elemento
	 * @param texto    texto contido no elemento
	 * @param index    índice do elemento
	 * @return objeto {@link By} encontrado
	 */
	public static By encontraByTextoContains(String elemento, String texto, int index) {
		return By.xpath(String.format("(//%1$s[contains(text(),'%2$s')])[%3$d]", elemento, texto, index));
	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro do texto, desconsiderando os
	 * espaãos a esquerda e a direita (normalize-space(.))
	 * 
	 * @param elemento tag HTML do elemento
	 * @param texto    texto do elemento
	 * @return objeto {@link By} encontrado
	 */
	public static By encontraByTextoTrim(String elemento, String texto) {
		return By.xpath(String.format("//%1$s[normalize-space(.)='%2$s']", elemento, texto));
	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro do texto, desconsiderando os
	 * espaãos a esquerda e a direita (normalize-space(.))
	 * 
	 * @param elemento tag HTML do elemento
	 * @param texto    texto do elemento
	 * @param index    índice do elemento
	 * @return objeto {@link By} encontrado
	 */
	public static By encontraByTextoTrim(String elemento, String texto, int index) {
		return By.xpath(String.format("(//%1$s[normalize-space(.)='%2$s'])[%3$d]", elemento, texto, index));
	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro @type
	 * 
	 * @param elemento tag HTML do elemento.
	 * @param type     parâmetro @type a ser considerado.
	 * @return objeto {@link By} encontrado.
	 */
	public static By encontraByType(String elemento, String type) {
		return By.xpath(String.format("//%1$s[@type = '%2$s']", elemento, type));
	}

	/**
	 * Busca elemento {@link By} utilizando o parâmetro @type
	 * 
	 * @param elemento tag HTML do elemento.
	 * @param type     parâmetro @type a ser considerado.
	 * @param index    índice do elemento.
	 * @return objeto {@link By} encontrado.
	 */
	public static By encontraByType(String elemento, String type, int index) {
		return By.xpath(String.format("(//%1$s[@type = '%2$s'])[%3$d]", elemento, type, index));
	}

	/**
	 * Busca elemento considerando o parâmetro IMG SRC
	 * 
	 * @param src parâmetro SRC da imagem.
	 * @return objeto {@link By} encontrado.
	 */
	public static By encontraByImgSrc(String src) {
		return By.xpath(String.format("//%1$s[@src='%2$s']", ByUtils.IMG, src));
	}

	/**
	 * Busca elemento considerando o parâmetro IMG SRC
	 * 
	 * @param src   parâmetro SRC da imagem
	 * @param index índice do objeto a ser encontrado.
	 * @return objeto {@link By} encontrado.
	 */
	public static By encontraByImgSrc(String src, int index) {
		return By.xpath(String.format("(//%1$s[@src='%2$s'])[%3$s]", ByUtils.IMG, src, index));
	}

	/**
	 * Busca elemento considerando o método @role='gridcell' dentro de uma table,
	 * buscando pelo índice da linha.
	 * 
	 * @param index índice da linha a ser considerada na table.
	 * @return objeto {@link By} encontrado.
	 */
	public static By encontraByTableRow(String classe, int index) {
		return By.xpath(String.format("//%1$s[@class='%2$s']//%3$s[%4$d]", ByUtils.TR, classe, ByUtils.TD, index));
	}

	/**
	 * Busca elemento considerando um select, com parâmetro @size='1', buscando pelo
	 * índice do select.
	 * 
	 * @param index índice do select a ser considerado.
	 * @return objeto {@link By} encontrado.
	 */
	public static By encontraBySelect(int index) {
		return By.xpath(String.format("(//%1$s[1])[%2$d]", ByUtils.SELECT, index));
	}

	/**
	 * Busca elemento considerando uma linha de tabela, retornando uma table row.
	 * 
	 * @param idTabela id da tablea a ser considerado.
	 * @return objeto {@link By} encontrado.
	 */
	public static By encontraLinhasTabela(String idTabela) {
		return By.xpath(String.format("id('%1$s')/tbody/tr", idTabela));
	}

	/**
	 * Busca elemento considerando o atributo @name.
	 * 
	 * @param elemento tag HTML do elemento.
	 * @param nome     valor do atributo @name a ser considerado.
	 * @return objeto {@link By} encontrado.
	 */
	public static By encontraByName(String elemento, String nome) {
		return By.xpath(String.format("//%1$s[@name='%2$s']", elemento, nome));
	}

	/**
	 * Busca elemento considerando o atributo @name.
	 * 
	 * @param elemento tag HTML do elemento.
	 * @param nome     valor do atributo @name a ser considerado.
	 * @param index    índice do elemento.
	 * @return objeto {@link By} encontrado.
	 */
	public static By encontraByName(String elemento, String nome, int index) {
		return By.xpath(String.format("(//%1$s[@name='%2$s'])[%3$d]", elemento, nome, index));
	}
}