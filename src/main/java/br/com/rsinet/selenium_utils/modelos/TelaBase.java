package br.com.rsinet.selenium_utils.modelos;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.selenium_utils.utils.constants.PadraoDeTextos;
import br.com.rsinet.selenium_utils.utils.selenium.ElementoWebUtils;

/**
 * PageObject base do projeto. Todo PageObject deve herdar desta classe.
 * 
 * @author Denis Luna Borges da Silva
 *
 */
public abstract class TelaBase {
	protected WebDriver driver;
	protected ElementoWebUtils elemento;

	/**
	 * Construtor da classe.
	 * 
	 * @param driver Objeto {@link WebDriver} do Selenium.
	 */
	public TelaBase(WebDriver driver) {
		this.driver = driver;
		this.elemento = new ElementoWebUtils(this.getDriver());
	}

	/**
	 * Método que retorna o WebDriver.
	 * 
	 * @return retorna o {@link WebDriver} instanciado no pageObject.
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

	/**
	 * Método que acessa uma URL no browser.
	 * 
	 * @param url Endereço web da página a ser acessada.
	 */
	public void navega(String url) {
		this.getDriver().get(url);
	}

	/**
	 * Método que efetua uma pausa no script.
	 * 
	 * @param milissegundos quantidade de milissegundos em long.
	 */
	public void sleep(long milissegundos) {
		try {
			Thread.sleep(milissegundos);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Método que efetua uma pausa no script.
	 * 
	 * @param segundos quantidade de segundos em int.
	 */
	public void sleep(int segundos) {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(segundos));
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Método que maximiza a janela do browser.
	 */
	public void maximizaBrowser() {
		this.getDriver().manage().window().maximize();
	}

	/**
	 * Método que efetua o fechamento da instância do browser.
	 */
	public void fecha() {
		try {
			this.getDriver().close();
		} catch (Exception e) {
			System.out.println("Erro ao chamar o método close(): " + e.toString());
		}

		try {
			this.getDriver().quit();
		} catch (Exception e) {
			System.out.println("Erro ao chamar o método quit(): " + e.toString());
		}

		if ((System.getProperty("os.name").startsWith("Windows")) & (this.driver instanceof ChromeDriver))
			try {
				Runtime.getRuntime().exec(PadraoDeTextos.COMANDO_MATA_PROCESSO_CHROMEDRIVER);
			} catch (IOException e) {
				System.out.println("Erro ao matar os processos do driver: " + e.toString());
			}
	}

	/**
	 * Método que retorna instância do utilitário de manipulação de elementos web.
	 * 
	 * @return objeto {@link ElementoWebUtils}.
	 */
	public ElementoWebUtils getElemento() {
		return this.elemento;
	}

	/**
	 * Método que altera o timeout implícito do Selenium.
	 * 
	 * @param tempo tempo em segundos de TimeOut.
	 */
	public void setTimeOut(int tempo) {
		this.getDriver().manage().timeouts().implicitlyWait(tempo, TimeUnit.SECONDS);
	}

	/**
	 * Método que retorna a URL da página atual.
	 * 
	 * @return {@link String} com a URL atual.
	 */
	public String pegaUrlAtual() {
		return this.getDriver().getCurrentUrl();
	}

	/**
	 * Método que aguarda o carregamento completo da página.
	 */
	protected void aguardaCarregamento() {
		new WebDriverWait(this.getDriver(), 30).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

	/**
	 * Mètodo que insere uma ação com a tecla PAGE UP.
	 */
	public void inserePageUp() {
		new Actions(this.getDriver()).sendKeys(Keys.PAGE_UP).perform();
	}

	/**
	 * Método que insere uma ação com a tecla PAGE DOWN.
	 */
	public void inserePageDown() {
		new Actions(this.getDriver()).sendKeys(Keys.PAGE_DOWN).perform();
	}
}