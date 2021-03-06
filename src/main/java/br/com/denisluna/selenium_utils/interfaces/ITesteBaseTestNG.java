package br.com.denisluna.selenium_utils.interfaces;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public interface ITesteBaseTestNG {

	/**
	 * Método que executa a inicialização do teste baseado em navegação
	 * {@link WebDriver}.
	 */
	@BeforeClass
	void start();

	/**
	 * Método que executa a finalizaçao do teste baseado em navegação
	 * {@link WebDriver}.
	 * 
	 * @param result objeto do tipo {@link ITestResult} com o resultado do teste.
	 */
	@AfterClass
	void finish(ITestResult result);
}