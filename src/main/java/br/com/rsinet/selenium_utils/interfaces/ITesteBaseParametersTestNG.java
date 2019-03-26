package br.com.rsinet.selenium_utils.interfaces;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public interface ITesteBaseParametersTestNG {

	/**
	 * Método que executa a inicialização do teste baseado em navegação
	 * {@link WebDriver}, recebendo uma {@link String} como parâmetro.
	 */
	@BeforeClass
	void start(String parametro);

	/**
	 * Método que executa a finalizaçao do teste baseado em navegação
	 * {@link WebDriver}.
	 * 
	 * @param result objeto do tipo {@link ITestResult} com o resultado do teste.
	 */
	@AfterClass
	void finish(ITestResult result);
}