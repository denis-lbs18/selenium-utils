package br.com.rsinet.selenium_utils.utils.selenium;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.selenium_utils.enums.Formato;
import br.com.rsinet.selenium_utils.utils.LocalDateTimeUtils;
import br.com.rsinet.selenium_utils.utils.NumberUtils;
import br.com.rsinet.selenium_utils.utils.constants.TempoTimeouts;

/**
 * Classe que trabalha com wait do WebElement, permitindo que o objeto esteja
 * clicável antes de executar o código.
 * 
 * @author Denis Luna Borges da Silva
 *
 */
;

public class ElementoWebUtils {
	private WebDriver driver;

	/**
	 * Construtor da classe, recebe o WebDriver das demais classes.
	 * 
	 * @param driver WebDriver escolhido para executar os testes
	 */
	public ElementoWebUtils(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * retorna o codigo HTML da página
	 * 
	 * @return o codigo HTML da página
	 */
	public String getCodigoHTML() {
		driver.getCurrentUrl();
		String pageSource = driver.getPageSource();
		return pageSource;
	}

	/**
	 * Getter para o Driver do objeto.
	 * 
	 * @return o driver da classe
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

	/**
	 * Método que acha a referência WebElement na página. Usufrui do recurso
	 * {@link WebDriverWait}: A cada x segundos definidos pela constante
	 * {@link TempoTimeouts}.TEMPOPOLLING, será efetuada uma busca pelo elemento
	 * clicável, em até y segundos, com timeout definido pela constante
	 * {@link TempoTimeouts}.TEMPOWAIT.
	 * 
	 * @param by o identificador By do elemento a ser encontrado
	 * @return WebElement encontrado na página através do By
	 */
	public WebElement elementoWebAchaElementoClicavel(By by) {
		WebElement elemento = (new WebDriverWait(this.getDriver(), TempoTimeouts.TEMPO_WAIT))
				.withTimeout(TempoTimeouts.TEMPO_WAIT, TimeUnit.SECONDS)
				.pollingEvery(TempoTimeouts.TEMPO_POLLING, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(by));

		return elemento;
	}

	/**
	 * Método que acha a referência WebElement na página. Usufrui do recurso
	 * {@link WebDriverWait}: A cada x segundos definidos pela constante
	 * {@link TempoTimeouts}.TEMPOPOLLING, será efetuada uma busca pelo elemento
	 * visível, em até y segundos, com timeout definido pela constante
	 * {@link TempoTimeouts}.TEMPOWAIT.
	 * 
	 * @param by o identificador By do elemento a ser encontrado
	 * @return WebElement encontrado na página através do By
	 */
	public WebElement elementoWebAchaElementoVisivel(By by) {
		WebElement elemento = new WebDriverWait(this.getDriver(), TempoTimeouts.TEMPO_WAIT)
				.withTimeout(TempoTimeouts.TEMPO_WAIT, TimeUnit.SECONDS)
				.pollingEvery(TempoTimeouts.TEMPO_POLLING, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(by));

		return elemento;
	}

	/**
	 * Método que acha a referência WebElement na página. Usufrui do recurso
	 * WebDriverWait: A cada x segundos definidos pela constante
	 * {@link TempoTimeouts}.TEMPOPOLLING, será efetuada uma busca pelo elemento, em
	 * até y segundos, com timeout definido pela constante
	 * {@link TempoTimeouts}.TEMPOWAIT
	 * 
	 * @param by o identificador By do elemento a ser encontrado
	 * @return lista de WebElements encontrados
	 */
	public List<WebElement> elementoWebAchaElementosWait(By by) {
		List<WebElement> listaElementos = new WebDriverWait(this.getDriver(), TempoTimeouts.TEMPO_WAIT)
				.withTimeout(TempoTimeouts.TEMPO_WAIT, TimeUnit.SECONDS)
				.pollingEvery(TempoTimeouts.TEMPO_POLLING, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

		return listaElementos;
	}

	/**
	 * Método que executa um Thread.sleep, efetuando uma pausa no teste.
	 * 
	 * @param l quantidade de milissegundos que o teste deve aguardar
	 */
	private void sleep(long l) {
		try {
			Thread.sleep(l);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * metodo para seleção de opção em combobox
	 * 
	 * @param by
	 * @param option
	 */
	@Deprecated
	public void elementoWebSelecionaRadio(By by, int option) {
		List<WebElement> radios = driver.findElements(by);
		if (option > 0 && option <= radios.size()) {
			WebElement elemento = radios.get(option);
			// if (this.elementoWebEstaVisivelWait(elemento))
			elemento.click();
			// radios.get(option - 1).click();

		}
	}

	/**
	 * Método que permite selecionar uma opção do combobox pelo index. Seleciona o
	 * índice na lista e aperta o enter.
	 * 
	 * @param by    o identificador By do elemento a ser selecionado
	 * @param index o índice a ser escolhido dentro do combobox
	 */
	public void elementoWebSelecionaListaSelect(By by, int index) {
		try {
			Select listaSelect = new Select(this.elementoWebAchaElementoClicavel(by));
			listaSelect.selectByIndex(index);
		} catch (Exception ex) {
			System.out.println("Erro ao selecionar opção por index.");
		}
	}

	/**
	 * Método que permite selecionar uma opção do combobox pelo texto. Seleciona o
	 * texto da lista e aplica o enter.
	 * 
	 * @param by    o identificador By do elemento a ser selecionado
	 * @param texto o texto a ser escolhido dentro do combobox
	 */
	public void elementoWebSelecionaListaSelect(By by, String texto) {
		try {
			Select listaSelect = new Select(this.elementoWebAchaElementoClicavel(by));
			listaSelect.selectByVisibleText(texto);
		} catch (Exception ex) {
			System.out.println("Erro ao selecionar opção por texto.");
		}
	}

	/**
	 * Método que permite selecionar uma opção do combobox pelo texto. Seleciona o
	 * texto da lista com um clique.
	 * 
	 * @param by    o identificador By do elemento a ser selecionado.
	 * @param texto o texto a ser escolhido dentro do combobox.
	 */
	public void elementoWebSelecionaListaPorClique(By by, String texto) {
		this.elementoWebClica(by);
		this.sleep(TempoTimeouts.TEMPO_PADRAO_TELA);
		By elementoLista = ByUtils.encontraByTextoContains(ByUtils.LI, texto);
		this.elementoWebMoveParaOElemento(elementoLista);
		this.sleep(TempoTimeouts.TEMPO_PADRAO_TELA);
		this.elementoWebClica(elementoLista);
	}

	/**
	 * Método que permite selecionar uma opção do combobox pelo texto. Seleciona o
	 * texto da lista com movimentação do teclado através do Keys.
	 * 
	 * @param by    objeto {@link By} mapeado.
	 * @param texto texto a ser escolhido dentro do combobox.
	 */
	public void elementoWebSelecionaListaPorKeys(By by, String texto) {
		this.elementoWebInsereTexto(by, texto);
		this.sleep(TempoTimeouts.TEMPO_PADRAO_TELA);
		this.elementoWebInsereTexto(by, Keys.DOWN);
		this.sleep(TempoTimeouts.TEMPO_PADRAO_TELA);
		this.elementoWebInsereTexto(by, Keys.ENTER);
	}

	/**
	 * Método que permite inserir texto em um input WebElement. Recebe como
	 * parâmetros o By do elemento e o texto a ser inserido.
	 * 
	 * @param by    o identificador By do elemento a ser selecionado
	 * @param texto o texto a ser inserido dentro do campo de texto
	 */
	public void elementoWebInsereTexto(By by, String texto) {
		this.sleep(TempoTimeouts.TEMPO_PADRAO_TELA);
		this.elementoWebAguardaVisibilidade(by);
		this.elementoWebAchaElementoClicavel(by).sendKeys(texto);
	}

	/**
	 * Método que permite inserir uma key (tecla) em um input WebElement.
	 * 
	 * @param by  o identificador By do elemento a ser selecioando
	 * @param key a key (tecla) a ser inserida no campo de texto
	 */
	public void elementoWebInsereTexto(By by, Keys key) {
		this.elementoWebAchaElementoClicavel(by).sendKeys(key);
	}

	/**
	 * Método que permite utilizar o método click() em um WebElement.
	 * 
	 * @param by o identificador By do elemento a ser selecionado
	 */
	public void elementoWebClica(By by) {
		WebElement elemento = this.elementoWebAchaElementoClicavel(by);
		elemento.click();
	}

	/**
	 * Método que efetua um clique em um elemento, através de {@link Actions}.
	 * 
	 * @param by
	 */
	public void elementoWebClicaActions(By by) {
		WebElement elementoSVG = this.elementoWebAchaElementoClicavel(by);
		Actions acaoSVG = new Actions(this.getDriver());
		acaoSVG.moveToElement(elementoSVG).click().build().perform();
	}

	/**
	 * Método que efetua um clique em um elemento, através de
	 * {@link JavascriptExecutor}.
	 * 
	 * @param by objeto {@link By} mapeado.
	 */
	public void elementoWebClicaJavaScript(By by) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) this.getDriver();
		jsExecutor.executeScript("var evt = document.createEvent('MouseEvents');"
				+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
				+ "arguments[0].dispatchEvent(evt);", this.elementoWebAchaElementoClicavel(by));
	}

	/**
	 * Método que permite utilizar o botão ESC em um WebElement.
	 * 
	 * @param by o identificador By do elemento a ser digitado ESC
	 */
	public void pressionaTeclaEsc(By by) {
		this.elementoWebAchaElementoClicavel(by).sendKeys(Keys.ESCAPE);
	}

	/**
	 * Método para buscar determinado item por texto.
	 * 
	 * @param texto o texto a ser buscado.
	 * @return By do elemento da tela
	 */
	public By elementoWebBuscaPorTexto(String texto) {
		String busca = "(//*[text()='%1$s'])";
		this.sleep(TempoTimeouts.TEMPO_LONGO);
		By elemento = By.xpath(String.format(busca, texto));
		return elemento;
	}

	/**
	 * Método que limpa o texto do elemento web.
	 * 
	 * @param by o identificador By do elemento a ser selecionado
	 */
	public void elementoWebLimpa(By by) {
		this.sleep(TempoTimeouts.TEMPO_PADRAO_TELA);
//		this.elementoWebAchaElementoClicavel(by).clear();
		this.elementoWebAchaElementoClicavel(by).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	/**
	 * Método que retorna se elemento web está visível na tela.
	 * 
	 * @param by o identificador By do elemento a ser selecionado
	 * @return boolean que identifica se o objeto está visível ou não
	 */
	public boolean elementoWebEstaVisivel(By by) {
		try {
			return this.getDriver().findElement(by).isDisplayed();
		} catch (NoSuchElementException ex) {
			System.out.println("Elemento não visível (NoSuchElementException).");
			return false;
		} catch (StaleElementReferenceException ex) {
			System.out.println("Elemento não visível (StaleElementReferenceException).");
			return false;
		} catch (Exception ex) {
			System.out.println("Elemento não visível " + ex.getMessage());
			return false;
		}
	}

	/**
	 * Método que retorna se elemento web está visível na tela, utilizando o recurso
	 * WebDriverWait que espera um determinado tempo até o elemento ficar visível.
	 * 
	 * @param by o identificador By do elemento a ser selecionado
	 * @return boolean que identifica se o objeto está visível ou não
	 */
	public boolean elementoWebEstaVisivelWait(By by) {
		try {
			boolean retorno = this.elementoWebAchaElementoVisivel(by).isDisplayed();
			return retorno;
		} catch (NoSuchElementException ex) {
			System.out.println("Elemento não visível (NoSuchElementException).");
			return false;
		} catch (StaleElementReferenceException ex) {
			System.out.println("Elemento não visível (StaleElementReferenceException).");
			return false;
		} catch (Exception ex) {
			System.out.println(("Elemento não visível " + ex.getMessage()));
			return false;
		}
	}

	/**
	 * Método que retorna se elemento web está visível na tela.
	 * 
	 * @param by o identificador By do elemento a ser selecionado
	 * @return boolean que identifica se o objeto está visível ou não
	 */
	public boolean elementoWebEstaVisivelWait(WebElement elemento) {
		try {
			return elemento.isDisplayed();
		} catch (NoSuchElementException ex) {
			System.out.println("Elemento não visível (NoSuchElementException).");
			return false;
		} catch (StaleElementReferenceException ex) {
			System.out.println("Elemento não visível (StaleElementReferenceException).");
			return false;
		} catch (Exception ex) {
			System.out.println("Elemento não visível " + ex.getMessage());
			return false;
		}
	}

	/**
	 * Método que retorna se elemento web está habilitado na tela.
	 * 
	 * @param by o identificador By do elemento a ser selecionado
	 * @return o identificador By do elemento a ser selecionado
	 */
	public boolean elementoWebEstaHabilitado(By by) {
		boolean retorno = this.getDriver().findElement(by).isEnabled();
		return retorno;
	}

	/**
	 * Método que retorna se elemento web está habilitado na tela. Recebe como
	 * parâmetro o By do elemento. Utiliza o método WebDriverWait
	 * 
	 * @param by
	 * @return
	 */
	public boolean elementoWebEstaHabilitadoWait(By by) {
		boolean retorno = this.elementoWebAchaElementoVisivel(by).isEnabled();
		return retorno;
	}

	/**
	 * Método que retorna uma string com o texto do elemento encontrado
	 * 
	 * @param by objeto By da página
	 * @return String do texto contido no WebElement encontrado através do parâmetro
	 *         By
	 */
	public String elementoWebPegaTexto(By by) {
		return this.elementoWebAchaElementoClicavel(by).getText();
	}

	/**
	 * Método que retorna um inteiro com o número do elemento encontrado
	 * 
	 * @param by objeto By da página
	 * @return int do texto contido no WebElement encontrado através do parâmetro By
	 */
	public int elementoWebPegaTextoInt(By by) {
		String texto = this.elementoWebAchaElementoClicavel(by).getText();
		int numero = NumberUtils.converteStringParaInteger(texto);

		return numero;
	}

	/**
	 * Método que valida se região final das validações dos testes está visível.
	 * Caso esteja, retorna true. Caso não esteja, lança uma NoSuchElementException,
	 * para que o teste falhe
	 * 
	 * @param by objeto By da página
	 * @return boolean true caso objeto esteja visível
	 */
	public boolean procuraRegiaoValidacaoFinal(By by) {
		return this.elementoWebAchaElementoClicavel(by).isDisplayed();
	}

	/**
	 * Método que encontra todos os elementos de uma coluna dentro de uma tabela
	 * 
	 * @param tableDados   {@link By} com a tabela (talbe) mapeada.
	 * @param botaoProximo {@link By} com o botão próximo mapeado.
	 * @param indiceColuna índice da coluna com os dados a serem extraídos.
	 * @return {@link List}<{@link String}> com os valores coletados.
	 */
	public List<String> elementoWebPegaItensTabela(By tableDados, By botaoProximo, int indiceColuna) {
		this.elementoWebAguardaVisibilidade(tableDados);
		List<WebElement> elementoLinhasTabela = this
				.elementoWebAchaElementosWait(By.xpath(String.format("//tr[@class='ng-scope']/td[%d]", indiceColuna)));
		List<String> listaItens = new ArrayList<String>();

		boolean estaVisivel = this.elementoWebEstaVisivelWait(botaoProximo);

		while (estaVisivel)
			this.elementoWebClica(botaoProximo);

		for (WebElement tdElement : elementoLinhasTabela)
			listaItens.add(tdElement.getText());

		return listaItens;
	}

	/**
	 * Método que efetua mouseover dentro de um WebElement.
	 * 
	 * @param by objeto {@link By} mapeado.
	 */
	public void elementoWebMouseOver(By by) {
		WebElement elemento = this.elementoWebAchaElementoClicavel(by);

		Actions builder = new Actions(this.getDriver());
		builder.moveToElement(elemento).perform();
	}

	/**
	 * Método que efetua um MouseOver no lado direito do elemento.
	 * 
	 * @param by objeto {@link By} mapeado.
	 */
	public void elementoWebMouseOverLadoDireito(By by) {
		WebElement elemento = this.elementoWebAchaElementoClicavel(by);
		int width = elemento.getSize().width;

		Actions builder = new Actions(this.getDriver());
		builder.moveToElement(elemento, width, 1).perform();
	}

	/**
	 * Método que permite a seleção de uma data em um objeto datepicker.
	 * 
	 * @param by   objeto {@link By} mapeado com o datepicker.
	 * @param date {@link LocalDate} com a data a ser inserida.
	 */
	public void elementoWebSelecionaDatePicker(By by, LocalDate date) {
		String dataBusca = LocalDateTimeUtils.formataData(Formato.DAY, date);

		WebElement dateWidget = this.elementoWebAchaElementoClicavel(by);
		List<WebElement> colunas = dateWidget.findElements(By.tagName("td"));

		for (WebElement celula : colunas) {
			if (celula.getText().equals(dataBusca)) {
				celula.click();
				break;
			}
		}
	}

	/**
	 * Método que permite a seleção de uma data em um objeto datepicker.
	 * 
	 * @param by   objeto {@link By} mapeado com o datepicker.
	 * @param data {@link String} com a data a ser inserida.
	 */
	public void elementoWebSelecionaDatePicker(By by, String data) {
		LocalDate localDate = LocalDateTimeUtils.converteData(Formato.DDMMYYYY, data);
		this.elementoWebSelecionaDatePicker(by, localDate);
	}

	/**
	 * Método que aguarda a visibilidade de um elemento específico.
	 * 
	 * @param by objeto {@link By} mapeado.
	 */
	public void elementoWebAguardaVisibilidade(By by) {
		(new WebDriverWait(this.getDriver(), TempoTimeouts.TEMPO_WAIT))
				.withTimeout(TempoTimeouts.TEMPO_WAIT, TimeUnit.SECONDS)
				.pollingEvery(TempoTimeouts.TEMPO_POLLING, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(by));

	}

	/**
	 * Método que efetua uma ação JavaScript, movendo para o elemento.
	 * 
	 * @param by objeto {@link By} mapeado.
	 */
	public void elementoWebMoveParaOElemento(By by) {
		WebElement elemento = this.elementoWebAchaElementoClicavel(by);
		((JavascriptExecutor) this.getDriver()).executeScript("arguments[0].scrollIntoView();", elemento);
	}

	/**
	 * Método que permite o envio de arquivos para o servidor.
	 * 
	 * @param by      objeto {@link By} mapeado com a propriedade //*[@type =
	 *                'file'].
	 * @param arquivo objeto {@link File} a ser enviado.
	 */
	public void elementoWebEnviaArquivoUpload(By by, File arquivo) {
		this.sleep(TempoTimeouts.TEMPO_CURTO);
		try {
			this.getDriver().findElement(by).sendKeys(arquivo.getCanonicalPath());
		} catch (IOException e) {
			System.out.println("Erro ao enviar imagem ao servidor.");
			e.printStackTrace();
		}
	}

	/**
	 * Método que permite o envio de arquivos para o servidor.
	 * 
	 * @param by      objeto {@link By} mapeado com a propriedade //*[@type =
	 *                'file']
	 * @param caminho {@link String} com o caminho do arquivo.
	 */
	public void elementoWebEnviaArquivoUpload(By by, String caminho) {
		this.sleep(TempoTimeouts.TEMPO_CURTO);
		File arquivo = new File(caminho);
		this.elementoWebEnviaArquivoUpload(by, arquivo);
	}

	/**
	 * Método que verifica se um objeto está selecionado.
	 * 
	 * @param by objeto {@link By} mapeado.
	 * @return booolean com o retorno do método isSelected().
	 */
	public boolean elementoWebEstaSelecionado(By by) {
		boolean retorno = this.elementoWebAchaElementoVisivel(by).isSelected();
		return retorno;
	}

	/**
	 * Método que tenta efetuar um clique em uma lista de elementos possíveis.
	 * 
	 * @param listaElementos {@link List} de objetos {@link By} com os possíveis
	 *                       elementos a serem clicados.
	 */
	public void elementoWebClicaPossiveisElementos(List<By> listaElementos) {
		for (By elementoBy : listaElementos) {
			try {
				this.elementoWebClica(elementoBy);
				break;
			} catch (Exception ex) {
				System.out.println("Elemento da lista não visível ou não clicável.");
				System.out.println("Mensagem de erro: " + ex.toString());
			}

		}
	}
}