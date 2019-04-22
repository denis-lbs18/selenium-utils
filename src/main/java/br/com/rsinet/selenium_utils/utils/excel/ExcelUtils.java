package br.com.rsinet.selenium_utils.utils.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.format.CellNumberFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.rsinet.selenium_utils.controller.DiretoriosController;
import br.com.rsinet.selenium_utils.utils.NumberUtils;

/**
 * Clase que encapsula as operações com Excel
 * 
 * @author Denis Luna Borges da Silva
 *
 *         Atualização 11/12/2018 - Roberto Böker
 */
public class ExcelUtils {
	private String fileName;
	private HSSFWorkbook wb;
	private XSSFWorkbook wbx;
	private HSSFSheet planilha;
	private XSSFSheet planilhax;
	private FileInputStream arquivoEntrada;
	private FileOutputStream arquivoSaida;
	private int formato;
	private String path;
	public final static int XLS = 1;
	public final static int XLSX = 2;

	/**
	 * Construtor com parâmetro de nome do arquivo, permitindo a abertura de
	 * qualquer arquivo do excel
	 * 
	 * @param fileName nome do arquivo a ser aberto
	 */
	public ExcelUtils(String fileName) {

		this.setFileName(fileName);
		this.path = this.fileName; // this.getPastaDefault() +
		this.abrePlanilha();
	}

	public ExcelUtils(String fileName, boolean deletaArquivo) {
		if (deletaArquivo)
			this.deletaArquivo(fileName);
		this.setFileName(fileName);
		this.path = this.fileName; // this.getPastaDefault() +
		this.abrePlanilha();
	}

	private void deletaArquivo(String fileName) {
		File arquivo = new File(fileName);
		if (arquivo.exists())
			arquivo.delete();
	}

	/**
	 * Método que retorna o objeto manipulador de arquivos do excel
	 * 
	 * @return atributo do tipo XSSFSheet {@link XSSFSheet}
	 */
	public Sheet getPlanilha() {

		Sheet retorno = null;
		switch (this.formato) {

		case XLS:
			retorno = this.planilha;
			break;

		case XLSX:
			retorno = this.planilhax;
			break;
		}
		return retorno;
	}

	/**
	 * Método que retorna o nome do arquivo
	 * 
	 * @return String com o caminho do arquivo aberto
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * Método que retorna a planilha aberta
	 * 
	 * @return atributo do tipo XSSFWorkbook {@link XSSFWorkbook}
	 */
	public Workbook getWorkBook() {
		Workbook retorno = null;
		switch (this.getFormato()) {

		case XLS:
			retorno = this.wb;
			break;

		case XLSX:
			retorno = this.wbx;
			break;
		}
		return retorno;
	}

	/**
	 * Método que abre a planilha
	 */
	public void abrePlanilha() {

		try {

			File file = new File(this.path);

			if (!file.exists()) {
				this.arquivoSaida = new FileOutputStream(new File(this.path));

				switch (this.getFormato()) {

				case XLS:
					System.out.println("arquivo no formato xls");
					HSSFWorkbook wb = new HSSFWorkbook();
					wb.createSheet();
					wb.write(this.arquivoSaida);
					wb.close();
					break;

				case XLSX:
					System.out.println("arquivo no formato xlsx");
					this.wbx = new XSSFWorkbook();
					wbx.createSheet();
					wbx.write(arquivoSaida);
					wbx.close();
					break;
				}
			}

			this.arquivoEntrada = new FileInputStream(this.path);

			switch (this.getFormato()) {

			case XLS:
				System.out.println("arquivo no formato xls");
				this.wb = new HSSFWorkbook(this.arquivoEntrada);
				this.planilha = this.wb.getSheetAt(0);
				this.arquivoSaida = new FileOutputStream(file);
				this.wb.write(this.arquivoSaida);
				break;

			case XLSX:
				System.out.println("arquivo no formato xlsx");
				this.wbx = new XSSFWorkbook(this.arquivoEntrada);
				this.planilhax = this.wbx.getSheetAt(0);
				this.arquivoSaida = new FileOutputStream(file);
				this.wbx.write(this.arquivoSaida);
				break;
			}
			// salvaPlanilha();
		} catch (IOException e) {

			// e.printStackTrace();
		}

	}

	/**
	 * Método que grava as alterações efetuadas na planilha
	 */
	public void salvaPlanilha() {
		try {
			this.arquivoSaida = new FileOutputStream(new File(this.fileName));

			this.getWorkBook().write(this.arquivoSaida);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void salvaPlanilha(String nomeArq) {
		this.fileName = nomeArq;
		this.salvaPlanilha();
	}

	public void fechaPlanilha() {

		try {
			this.arquivoEntrada.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Método que pega o valor de uma célula em texto
	 * 
	 * @param linha  inteiro que representa a linha da célula desejada, iniciando em
	 *               0
	 * @param coluna inteiro que representa a coluna da célula desejada, iniciando
	 *               em 0
	 * @return String com o texto contido na célula encontrada
	 */
	public String getTextoCelula(int linha, int coluna) {
		String textoCelula;

		try {

			this.getPlanilha().getRow(linha).getRowNum();

		} catch (NullPointerException e) {
			this.getPlanilha().createRow(linha);

		}
		try {

			this.getPlanilha().getRow(linha).getCell(coluna).getColumnIndex();

		} catch (NullPointerException e) {

			this.getPlanilha().getRow(linha).createCell(coluna).setCellValue("");
			textoCelula = this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue();

		}

		try {
			textoCelula = this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue();

		} catch (Exception ex) {
			textoCelula = Integer
					.toString((int) this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue());
		}

		return textoCelula;

	}

	public String getTextoCelulaFormatada(int linha, int coluna) {
		DataFormatter dataFormatter = new DataFormatter();
		Cell cell = this.getPlanilha().getRow(linha).getCell(coluna);
		String retorno = dataFormatter.formatCellValue(cell);
		return retorno;
	}

	/**
	 * Método que pega o texto absoluto de uma célula
	 * 
	 * @param linha  inteiro que representa a linha da célula desejada, iniciando em
	 *               0
	 * @param coluna inteiro que representa a coluna da célula desejada, iniciando
	 *               em 0
	 * @return String com o texto absoluto contido na célula encontrada
	 */

	public String getTextoSimplesCelula(int linha, int coluna) {
		String textoCelula;

		textoCelula = this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue();

		String stringFormat = this.getPlanilha().getRow(linha).getCell(coluna).getCellStyle().getDataFormatString();
		CellNumberFormatter fmt = new CellNumberFormatter(stringFormat);
		textoCelula = fmt.format(this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue());

		return textoCelula;
	}

	/**
	 * Método que pega o valor da célula em Double
	 * 
	 * @param linha  inteiro que representa a linha da célula desejada, iniciando em
	 *               0
	 * @param coluna inteiro que representa a coluna da célula desejada, iniciando
	 *               em 0
	 * @return Double com o valor contido na célula encontrada
	 */

	public double getValorCelulaDouble(int linha, int coluna) {
		double valorCelula;
		try {
			valorCelula = this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue();
		} catch (Exception ex) {
			valorCelula = Double.parseDouble(this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue());
		}

		return valorCelula;

	}

	/**
	 * Método que pega o valor da célula em int
	 * 
	 * @param linha  inteiro que representa a linha da célula desejada, iniciando em
	 *               0
	 * @param coluna inteiro que representa a coluna da célula desejada, iniciando
	 *               em 0
	 * @return inteiro com o valor contido na célula encontrada
	 */
	public int getValorCelulaInt(int linha, int coluna) {
		int valorCelula;
		try {
			valorCelula = (int) this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue();
		} catch (Exception ex) {
			try {
				valorCelula = Integer.parseInt(this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue());
			} catch (Exception ex1) {
				valorCelula = 0;
			}
		}

		return valorCelula;
	}

	/**
	 * Método que insere o valor em texto em uma célula
	 * 
	 * @param linha  inteiro que representa a linha da célula desejada, iniciando em
	 *               0
	 * @param coluna inteiro que representa a coluna da célula desejada, iniciando
	 *               em 0
	 * @param value  String com o texto a ser inserido na célula
	 */

	public void setTextoCelula(int linha, int coluna, String value) {

		/**
		 * Alteração feita por Roberto Böker 19/09/2018 Caso não exista a linha e/ou a
		 * célula a ser editada, o método a cria.
		 */
		try {

			this.getPlanilha().getRow(linha).getRowNum();

		} catch (NullPointerException e) {
			this.getPlanilha().createRow(linha);

		}
		try {

			this.getPlanilha().getRow(linha).getCell(coluna).getColumnIndex();

		} catch (NullPointerException e) {

			this.getPlanilha().getRow(linha).createCell(coluna);

		}

		this.getPlanilha().getRow(linha).getCell(coluna).setCellValue(value);

	}

	public FileInputStream getArquivoEntrada() {
		return arquivoEntrada;
	}

	public void setArquivoEntrada(FileInputStream arquivoEntrada) {
		this.arquivoEntrada = arquivoEntrada;
	}

	/**
	 * Método que insere o valor em int em uma célula.
	 * 
	 * @param linha  inteiro que representa a linha da célula desejada, iniciando em
	 *               0.
	 * @param coluna inteiro que representa a coluna da célula desejada, iniciando
	 *               em 0.
	 * @param value  int com o valor a ser inserido na célula.
	 */
	public void setTextoCelula(int linha, int coluna, int value) {
		this.setTextoCelula(linha, coluna, NumberUtils.converteIntegerParaString(value));
	}

	/**
	 * Método que insere o valor em float em uma célula.
	 * 
	 * @param linha  inteiro que representa a linha da célula desejada, iniciando em
	 *               0.
	 * @param coluna inteiro que representa a coluna da célula desejada, iniciando
	 *               em 0.
	 * @param value  float com o valor a ser inserido na célula.
	 */
	public void setTextoCelula(int linha, int coluna, float value) {
		this.setTextoCelula(linha, coluna, NumberUtils.converteFloatParaString(value));
	}

	/**
	 * Método que insere o valor de uma {@link Enum} em uma célula.
	 * 
	 * @param linha  inteiro que representa a linha da célula desejada, iniciando em
	 *               0.
	 * @param coluna inteiro que representa a coluna da célula desejada, iniciando
	 *               em 0.
	 * @param value  {@link Enum} com o name a ser inserido na célula.
	 */
	public void setTextoCelula(int linha, int coluna, Enum<?> enumValue) {
		if (enumValue == null)
			this.setTextoCelula(linha, coluna, "");
		else
			this.setTextoCelula(linha, coluna, enumValue.name());
	}

	/**
	 * Método que insere a data de um {@link LocalDate} em uma célula.
	 * 
	 * @param linha  inteiro que representa a linha da célula desejada, iniciando em
	 *               0.
	 * @param coluna inteiro que representa a coluna da célula desejada, iniciando
	 *               em 0.
	 * @param value  {@link LocalDate} com a data a ser inserido na célula.
	 */
	public void setTextoCelula(int linha, int coluna, LocalDate localDate) {
		this.setTextoCelula(linha, coluna, localDate.toString());
	}

	/**
	 * Método que insere o valor em Double em uma célula
	 * 
	 * @param linha  inteiro que representa a linha da célula desejada, iniciando em
	 *               0
	 * @param coluna inteiro que representa a coluna da célula desejada, iniciando
	 *               em 0
	 * @param value  Double com o valor a ser inserido na célula
	 */

	public void setValorCelulaDouble(int linha, int coluna, double value) {
		this.getPlanilha().getRow(linha).getCell(coluna).setCellValue(value);
	}

	/**
	 * Método que insere o valor em int em uma célula
	 * 
	 * @param linha  inteiro que representa a linha da célula desejada, iniciando em
	 *               0
	 * @param coluna inteiro que representa a coluna da célula desejada, iniciando
	 *               em 0
	 * @param value  int ocm o valor a ser inserido na célula
	 */

	public void setValorCelulaInt(int linha, int coluna, int value) {

		try {

			this.getPlanilha().getRow(linha).getRowNum();

		} catch (NullPointerException e) {
			this.getPlanilha().createRow(linha);

		}
		try {

			this.getPlanilha().getRow(linha).getCell(coluna).getColumnIndex();

		} catch (NullPointerException e) {

			this.getPlanilha().getRow(linha).createCell(coluna);

		}

		this.getPlanilha().getRow(linha).getCell(coluna).setCellValue(value);

	}

	/**
	 * Método que retorna lista com os itens de uma coluna
	 * 
	 * @param coluna índice da coluna desejada
	 * @return List com os valores encontrados na coluna
	 */

	public List<String> itensColuna(Integer coluna) {
		List<String> valores = new ArrayList<String>();
		for (Row r : this.getWorkBook().getSheetAt(0)) {
			Cell c = r.getCell(coluna);
			if (c != null) {
				valores.add(c.getStringCellValue());
			}
		}

		return valores;
	}

	/**
	 * Método que procura um texto em uma planilha, e retorna o índice da linha onde
	 * o texto foi encontrado
	 * 
	 * @param textoCelula valor a ser encontrado em uma célula
	 * @return número da linha onde o texto foi encontrado. Caso o texto não tenha
	 *         sido encontrado, retorna 1
	 */

	public int achaLinhaPorTexto(String textoCelula) {
		for (Row linha : this.getWorkBook().getSheetAt(0)) {
			for (Cell celula : linha) {
				if (celula.getCellType().equals(CellType.STRING)) {
					if (celula.getRichStringCellValue().getString().trim().equals(textoCelula)) {
						return linha.getRowNum();
					}
				}
			}
		}
		return 1;
	}

	public int achaLinhaPorTextoR(String textoCelula) {
		for (Row linha : this.getWorkBook().getSheetAt(0)) {
			for (Cell celula : linha) {
				if (celula.getCellType().equals(CellType.STRING)) {
					if (celula.getRichStringCellValue().getString().trim().equals(textoCelula)) {
						return linha.getRowNum();
					}
				}
			}
		}
		return -1;
	}

	/**
	 * Método que retorna o número de linhas em uma planilha
	 * 
	 * Roberto Böker 12/09/2018
	 */

	public int getNumeroDeLinhas() {
		return this.getWorkBook().getSheetAt(0).getPhysicalNumberOfRows();
	}

	/**
	 * Método que remove uma linha inteira de uma planilha.
	 * 
	 * @param linha inteiro que representa a linha da célula desejada, iniciando em
	 *              0
	 *
	 *              Roberto Böker 19/09/2018
	 */
	public void removeLinha(int linha) {

		try {
			this.getPlanilha().getRow(linha).getRowNum();

		} catch (NullPointerException e) {
			this.getPlanilha().createRow(linha);

		}

		this.getPlanilha().removeRow(this.getPlanilha().getRow(linha));
	}

	public ExcelUtils criaExcel(String nomePasta, String nomeArq) {
		ExcelUtils arquivo = null;

		try {
			String newPath = DiretoriosController.criaDiretorio(nomePasta, nomeArq);

			FileOutputStream arquivoSaida = new FileOutputStream(newPath);
			HSSFWorkbook wb = new HSSFWorkbook();
			wb.createSheet("plan1");
			wb.write(arquivoSaida);
			wb.close();
			arquivoSaida.close();
			arquivo = new ExcelUtils(newPath);

		} catch (Exception e) {
			System.out.println("Deu excessão na criação do arquivo excel");
			e.printStackTrace();
		}
		return arquivo;

	}

	public void copiaPlanilha(String nomeArq, String nomePasta, String salvarComo) {
		DiretoriosController.criaDiretorio(nomePasta, nomeArq);
		ExcelUtils planilha = new ExcelUtils(nomeArq);
		String newPath = nomePasta + salvarComo;
		planilha.salvaPlanilha(newPath);

	}

	public void apagaPlanilha(ExcelUtils planilha) {

		int linhas_cont = planilha.getNumeroDeLinhas();

		for (int i = 0; i < linhas_cont; i++) {
			planilha.removeLinha(i);
		}

	}

	public int pegaTotalDeLinhas() {
		return this.planilha.getPhysicalNumberOfRows();
	}

	public void setFormulaCelula(int linha, int coluna, String value) {

		/**
		 * Alteração feita por Roberto Böker 19/09/2018 Caso não exista a linha e/ou a
		 * célula a ser editada, o método a cria.
		 */
		try {

			this.getPlanilha().getRow(linha).getRowNum();

		} catch (NullPointerException e) {
			this.getPlanilha().createRow(linha);

		}
		try {

			this.getPlanilha().getRow(linha).getCell(coluna).getColumnIndex();

		} catch (NullPointerException e) {

			this.getPlanilha().getRow(linha).createCell(coluna);

		}

		this.getPlanilha().getRow(linha).getCell(coluna).setCellFormula(value);

	}

	public int getFormato() {
		return formato;
	}

	public void setFormato(int formato) {
		this.formato = formato;
	}

	public XSSFSheet getPlanilhax() {
		return planilhax;
	}

	public void setPlanilhax(XSSFSheet planilhax) {
		this.planilhax = planilhax;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		this.setFormato(this.fileName.contains(".xlsx") ? XLSX : XLS);
	}
}