package br.com.denisluna.selenium_utils.modelos;

/**
 * Classe pai para todos os tipos de testes automatizados.
 * 
 * @author Denis Luna Borges da Silva
 *
 */
public abstract class TesteBase {
	/**
	 * Método que insere mensagem de texto como log no relatório do
	 * {@link ExtentReports}, além de exibir a mensagem em console.
	 * 
	 * @param mensagem {@link String} com a mensagem a ser exibida e inserida no
	 *                 log.
	 */
	protected abstract void exibeConsoleELogaMensagem(String mensagem);
}
