# Repositório de bibliotecas utilitárias para automação em Selenium (selenium-utils)

## Sobre
O repositório de bibliotecas utilitárias para automação em Selenium utiliza tecnologia Java para automação (Maven, Selenium).


## Configuração do ambiente de desenvolvimento

Pré-requisitos

* [Java] 1.8
* [GIT] (https://git-for-windows.github.io/) versão mais atual é recomendada
* [Maven](http://pow.cx/) versão 3.2.1
* [Eclipse] versão mais atual

## Clone do projeto

Abra o prompt gitbash, entre na estrutura de sua workspace, apague as pastas existentes e digite o comando abaixo:

```sh
	git clone git@github.com:denis-lbs18/selenium-utils.git
```

## Configuração do WebDriver

Drivers recomendados:

* Chromedriver:

```sh
    https://sites.google.com/a/chromium.org/chromedriver/downloads
```
* Geckodriver (Firefox):

```sh
    https://github.com/mozilla/geckodriver/releases
```

* Baixe o driver do seu navegador escolhido (Firefox, Chrome, Safari, etc...) compatível com a versão instalada em sua máquina, e extraia os arquivos baixados para uma pasta de drivers.

* Crie uma variável de ambiente em seu sistema operacional chamada WebDrivers, apontada para a pasta onde estão os drivers baixados.

* Adicione na variável PATH do seu sistema operacional a variável WebDrivers, permitindo que todos os projetos de automação acessem o driver do navegador escolhido.

## Configuração do projeto

Primeiramente, é necessário instalar o projeto selenium-utils no repositório local do Maven com o comando:

```sh
	mvn clean install
```

Após isso, basta importar o projeto selenium-utils em seu pom.xml, inserindo a seguinte dependência:

```sh
	<dependency>
		<groupId>br.com.denisluna</groupId>
		<artifactId>selenium-utils</artifactId>
	</dependency>
```

## POM.XML

Não faça alterações no POM.XML (adicionar dependências, alterar variáveis e ou fluxo de build e execução) sem comunicar antecipadamente sua necessidade. 

Tais alterações podem quebrar o projeto e impactar no trabalho dos demais desenvolvedores. 


## Dúvidas e Suporte

No caso de dúvidas e ou suporte, além de sugestões, entre em contato com o autor do projeto.