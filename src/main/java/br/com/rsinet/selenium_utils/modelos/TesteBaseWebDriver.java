package br.com.rsinet.selenium_utils.modelos;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Classe pai que serve como base para a estrutura de testes que utilizam uma
 * instância de WebDriver.
 * 
 * @author Denis Luna Borges da Silva
 *
 */
public abstract class TesteBaseWebDriver extends TesteBase {
	/**
	 * Método que executa a inicialização do teste baseado em navegação
	 * {@link WebDriver}.
	 */
	@BeforeMethod
	public abstract void start();

	/**
	 * Método que executa a finalizaçao do teste baseado em navegação
	 * {@link WebDriver}.
	 * 
	 * @param result objeto do tipo {@link ITestResult} com o resultado do teste.
	 */
	@AfterMethod
	public abstract void finish(ITestResult result);
}