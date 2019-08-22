package br.com.denisluna.selenium_utils.utils.selenium;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public abstract class WebDriverUtils {
	/**
	 * Método que instancia um navegador do Firefox, utilizando o GeckoDriver. Para
	 * correta execução do teste, é preciso que o diretório onde o GeckoDriver se
	 * encontra esteja configurado na variável PATH do sistema operacional.
	 * 
	 * GeckoDriver pode ser baixado no site
	 * https://github.com/mozilla/geckodriver/releases
	 * 
	 */
	public static FirefoxDriver instanciaFirefoxDriver() {
		FirefoxOptions options = new OptionsDriversUtils().getFirefoxOptions();
		return new FirefoxDriver(options);
	}

	/**
	 * Método que instancia um navegador do Chrome, utilizando o ChromeDriver. Para
	 * correta execução do teste, é preciso que o diretório onde o ChromeDriver se
	 * encontra esteja configurado na variável PATH do sistema operacional.
	 * 
	 * ChromeDriver pode ser baixado no site
	 * https://sites.google.com/a/chromium.org/chromedriver/
	 * 
	 */
	public static ChromeDriver instanciaChromeDriver() {
		ChromeOptions options = new OptionsDriversUtils().getChromeOptions();
		return new ChromeDriver(options);
	}

	/**
	 * Método que instancia um navegador do Edge, utilizando o MicrosoftWebDriver.
	 * Para correta execução do teste, é preciso que o diretório onde o
	 * MicrosoftWebDriver se encontra esteja configurado na variável PATH do sistema
	 * operacional.
	 * 
	 * MicrosoftWebDriver pode ser baixado no site
	 * https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
	 * 
	 */
	public static EdgeDriver instanciaEdgeDriver() {
		final EdgeOptions options = new EdgeOptions();
		options.setCapability("acceptSslCerts", true);
		return new EdgeDriver(options);
	}

	/**
	 * Método que instancia um navegador do Safari, utilizando o SafariDriver. Para
	 * correta execução do teste, é preciso que o diretório onde o SafariDriver se
	 * encontra esteja configurado na variável PATH do sistema operacional.
	 */
	public static SafariDriver instanciaSafariDriver() {
		final SafariOptions options = new SafariOptions();
		options.setCapability("acceptSslCerts", true);
		return new SafariDriver(options);
	}

	/**
	 * Método que instancia um navegador do Internet Explorer, utilizando o
	 * IEDriverServer. Para correta execução do teste, é preciso que o diretório
	 * onde o IEDriverServer se encontra esteja configurado na variável PATH do
	 * sistema operacional.
	 * 
	 * IEDriverServer pode ser baixado no site http://docs.seleniumhq.org/download/
	 */
	public static InternetExplorerDriver instanciaInternetExplorerDriver() {
		InternetExplorerOptions options = new OptionsDriversUtils().getInternetExplorerOptions();
		return new InternetExplorerDriver(options);
	}

	/**
	 * Método que instancia um navegador do Opera, utilizando o OperaDriver. Para
	 * correta execução do teste, é preciso que o diretório onde o OperaDriver se
	 * encontra esteja configurado na variável PATH do sistema operacional.
	 * 
	 * OperaDriver pode ser baixado no site
	 * https://github.com/operasoftware/operachromiumdriver/releases
	 */
	public static OperaDriver instanciaOperaDriver() {
		OperaOptions options = new OperaOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-web-security");
		options.addArguments("--no-first-run");
		options.addArguments("--no-check-default-driver");
		options.addArguments("--allow-running-insecure-content");
		/*
		 * Necessário colocar o caminho do Opera abaixo. Costuma ser uma pasta com o
		 * nome do usuário
		 */
		String user = "nome.do.usuario";
		options.setBinary(new File("C:\\Users\\" + user + "\\AppData\\Local\\Programs\\Opera\\launcher.exe"));

		return new OperaDriver(options);
	}

}
