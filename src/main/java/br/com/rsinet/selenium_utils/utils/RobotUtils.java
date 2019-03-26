package br.com.rsinet.selenium_utils.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import br.com.rsinet.selenium_utils.modelos.Usuario;
import br.com.rsinet.selenium_utils.utils.constants.TempoTimeouts;

public class RobotUtils {
	/**
	 * Método que insere os dados de login no pop-up de entrada, utilizando a classe
	 * Robot {@link Robot}, sem a necessidade de utilizar autoit
	 * 
	 * @param usuario objeto do tipo {@link Usuario} com os dados login.
	 */
	public void insereDadosLoginPopUp(Usuario usuario) {
		this.insereDadosLoginPopUp(usuario.getUsuario(), usuario.getSenha());
	}

	/**
	 * Método que insere os dados de login no pop-up de entrada, utilizando a classe
	 * Robot {@link Robot}, sem a necessidade de utilizar autoit
	 * 
	 * @param usuario {@link String} com os dados de usuário.
	 * @param senha   {@link String} com os dados de senha.
	 */
	public void insereDadosLoginPopUp(String usuario, String senha) {
		this.sleep(TempoTimeouts.TEMPO_MEDIO_LONG);

		Robot rb = null;
		try {
			rb = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		StringSelection username = new StringSelection(usuario);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);

		this.sleep(TempoTimeouts.TEMPO_CURTO_LONG);

		StringSelection pwd = new StringSelection(senha);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	private void sleep(long tempoEspera) {
		try {
			Thread.sleep(tempoEspera);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}