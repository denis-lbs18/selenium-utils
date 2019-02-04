# Repositório de bibliotecas utilitárias para automação em Selenium (selenium-utils)

## Sobre
O repositório de bibliotecas utilitárias para automação em Selenium utiliza tecnologia Java para automação (Maven, Selenium).

## Licença

> Copyright © 2019 Santander. All Rights Reserved.
>
> Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
> You may obtain a copy of the License at
>
>    http://www.apache.org/licenses/LICENSE-2.0
>
>Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
>WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.


## Configuração do ambiente de desenvolvimento

Pré-requisitos

* [Java] 1.8
* [GIT] (https://git-for-windows.github.io/) versão mais atual é recomendada
* [Maven](http://pow.cx/) versão 3.2.1
* [Eclipse] versão mais atual

## Clone do projeto

Abra o prompt gitbash, entre na estrutura de sua workspace, apague as pastas existentes e digite o comando abaixo:

```sh
	git clone git@gitlab.produbanbr.corp:automacao/selenium-utils.git
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

Basta importar o projeto selenium-utils em seu pom.xml, inserindo a seguinte dependência:

```sh
    <dependency>
		<groupId>br.com.rsinet</groupId>
		<artifactId>selenium-utils</artifactId>
	</dependency>
```

## POM.XML

Não faça alterações no POM.XML (adicionar dependências, alterar variáveis e ou fluxo de build e execução) sem comunicar antecipadamente sua necessidade. 

Tais alterações podem quebrar o projeto e impactar no trabalho dos demais desenvolvedores. 


## Dúvidas e Suporte

No caso de dúvidas e ou suporte, além de sugestões, entre em contato com a equipe de automação.