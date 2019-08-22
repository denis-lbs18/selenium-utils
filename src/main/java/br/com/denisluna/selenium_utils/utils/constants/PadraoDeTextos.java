package br.com.denisluna.selenium_utils.utils.constants;

/**
 * Classe com as constantes utilizadas como parâmetro para os textos padrões.
 * 
 * @author Denis Luna Borges da Silva
 *
 */
public abstract class PadraoDeTextos {
	/**
	 * Constantes com mensagens de falhas presentes em validações finais de testes.
	 */
	public final static String TEXTO_SUCESSO_VALIDACAO = "Teste executado com sucesso.",
			TEXTO_FALHA_SKIP = "Teste nao executado devido falha de configuracao.",
			TEXTO_FALHA_DATA = "Falha devido data fora do periodo.",
			TEXTO_FALHA_SOMA_VALORES = "Falha devido soma de valores divergente da quantidade exibida.",
			TEXTO_FALHA_VALOR_INDEVIDO = "Falha devido valor indevido na tela, não sendo maior que zero.",
			TEXTO_FALHA_QUANTIDADE_TELAS = "Falha devido quantidade de itens divergente entre telas.",
			TEXTO_FALHA_QUANTIDADE_GRAFICOS = "Falha devido quantidade de itens divergente nos graficos.",
			TEXTO_FALHA_VALORES_PERCENTUAL = "Falha devido valores de percentual estarem divergente entre telas.",
			TEXTO_FALHA_ELEMENTO_NAO_VISIVEL = "Falha devido elemento na pagina nao estar presente.",
			TEXTO_FALHA_ELEMENTO_FUNCIONAMENTO_INCORRETO = "Falha devido elemento na pagina nao apresentar o funcionamento correto.",
			TEXTO_FALHA_ELEMENTO_NAO_CLICAVEL_NAO_REFERENCIADO = "Falha devido elemento na pagina nao ser clicavel ou elemento ter perdido referencia devido refresh.",
			TEXTO_FALHA_CADASTRO = "Falha devido a problema no preenchimento do cadasro.",
			TEXTO_FALHA_SERVICO = "Falha devido a um problema no sistema de abertura de conta digital",
			TEXTO_FALHA_ASSERTION_ERROR = "Falha devido ponto de verificação no teste não bater com o resultado esperado.",
			TEXTO_FALHA_FALHA_DOCUMENTO = "Falha devido ao documento não ter sido encontrado, ou estar divergente da massa.";

	/**
	 * Constantes com os textos padrões de navegação de tabelas.
	 */
	public static final String PROXIMO = "PRÓXIMO", ANTERIOR = "ANTERIOR";

	/**
	 * Constante com os textos padrões para requests.
	 */
	public final static String REQUEST_INCIDENTE = "incident", REQUEST_SUPORTE = "support";

	/**
	 * Constante com o hostname padrão.
	 */
	public static final String NOTEBOOK_RSI = "RSI4793", JENKINS = "42feddd00de7";

	/**
	 * Constante com o caminho para o certificado SSL para o endpoint.
	 */
	public static final String CERTIFICADO_ENDPOINT = "src/main/resources/certificado/cacerts";

	/**
	 * Constante com o valor padrão de Token.
	 */
	public static final String TOKEN = "99999";

	/**
	 * Constantes com os valores de texto para aprovação no cenário do PAD.
	 */
	public static final String DOCUMENTO_APROVADO_COM_SUCESSO = "Documento Aprovado com sucesso",
			TEXTO_DESCRICAO_PAD_APROVACAO = "Aprovação de proposta de abertura de conta digital, gerada via automação.",
			TEXTO_DESCRICAO_PAD_REJEICAO = "Rejeição de proposta de abertura de conta digital, gerada via automação.";

	/**
	 * Constante com o valor de texto para aprovação no PAD - Produção.
	 */
	public static final String TEXTO_DESCRICAO_PAD_APROVACAO_PRODUCAO = "Conta aprovada por robô (TF 10/2018)";

	/**
	 * Constante com o valor de texto dos botões de escolha de pacote no passo 2.
	 */
	public static final String BOTAO_QUERO_ESSE = "Quero esse";

	/**
	 * Constante com o comando que mata o processo ChromeDriver.
	 */
	public static final String COMANDO_MATA_PROCESSO_CHROMEDRIVER = "taskkill /F /IM chrome.exe";

	/**
	 * Constantes com os padrões de títuo do relatório PDF.
	 */
	public static final String PASSO_EVIDENCIA_1 = "Passo 1 - Tela de CPF",
			PASSO_EVIDENCIA_2 = "Passo 2 - Tela de Pacotes de tarifas",
			PASSO_EVIDENCIA_3 = "Passo 3 – Tela de formulário (dados como nome, nome da mãe e etc.) e resumo",
			PASSO_EVIDENCIA_4 = "Passo 4 - Tela de cartão e Tela de resumo",
			PASSO_EVIDENCIA_5 = "Passo 5 - Termos e Valores",
			PASSO_EVIDENCIA_6 = "Passo 6 - Tela de subida de comprovante",
			PASSO_EVIDENCIA_PAD = "PAD - Comprovante de aprovação",
			PASSO_EVIDENCIA_PASTA = "Tela de evidencia de decisão do pasta";

	public static final String TEXTO_PROPOSTA_PAD_NAO_ENCONTRADA = "\nProposta de CPF nº %1$s não encontrada.\n";

	public static final String EMAIL_AUTOMACAO = "tstdsftwr@gmail.com";
}