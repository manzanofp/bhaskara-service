# Baskhara Service

## Descrição do Problema

Um professor de matemática deseja fornecer para escolas públicas um software
lúdico para ensinar alunos a entenderem equações do segundo grau, com isso
realizando o cálculo de raízes para entenderem como funciona a fórmula de Baskhara.

Na conversa com o professor, ele pediu para criarmos um MVP que permita o cálculo
da equação utilizando bhaskara e uma maneira simples, podendo ser por linha de comando,
para interagir com a solução.

> Chamamos de MVP versão 1. SEM APIs!!!

Num futuro momento, ele desejou criarmos uma interface gráfica podendo ser um app.
Mas isso vai ficar para renovação do contrato de prestação de serviço.

> Chamamos de MVP versão 2. Somente iremos expor APIs AQUI!

## Proposta de Solução

Queremos fornecer uma forma automatizada de se calcular raízes de 
equações do segundo grau. Podemos lembrar como é a função do segundo grau na sua
**forma original**.

```
y = ax^2 + bx + c
ou
f(x) = ax^2 + bx + c
```

Analisamos que existe um grande interesse em se obter os zeros da equação.
Os zeros de equação ocorrem quando queremos obter os valores possíveis
das variáveis para y = 0. A equação na forma de busca do zero fica sendo

```
y = ax^2 + bx + c = 0
ax^2 + bx + c = 0
```

### Análise do Caso A

Definimos a função `f(x) = x^2 −2x - 3`. Analisando-se o gráfico da função
plotada. As respectivas raízes são `x1 = -1` e `x2 = 3`.

<center>
    <img width="50%" src="./docs/plot_caso_a.png" />
</center>

É útil definirmos este caso para conhecer um exemplo de função
que gera raízes com valores em números reais.

## Parecer técnico

O cliente (sendo professor de matemática) sugeriu uso de interfaces gráficas no
futuro para melhorar a acessibilidade da solução. Nós, aqui da equipe de TI,
identificamos que independente da interface gráfica, precisamos de criar
um serviço de backend (isto é, não tem interface gráfica) para nos dar a possibilidade
de gerar inteligência unificada entre os demais dispositivos que fornecerão
a interface de aplicativo.

Podemos para o cliente que essa decisão consiste em separar o frontend
do backend para podermos reaproveitar o código e assim tornar o desenvolvimento
menos custoso.

## Análise de Requisitos

Na fase de análise de requisitos, temos que levantar as features e suas
respectivas histórias de usuário. Vale lembrar que features são recursos ou
funcionalidades a serem colocadas no produto. Precisamos informar cliente
no contrato e chegar a um acordo sobre as features desejadas.

### Feature F001 : Dar suporte ao Cálculo de Raízes de Equação do Segundo Grau por Linha de Comando

> Vamos agora refinar os requisitos.

#### Mapeamento de User Story

**INTRODUÇÃO DE HISTÓRIA**.

Precisamos pensar no que consiste o cálculo de raízes. O cálculo consiste
em formular entradas dos valores que acompanham os termos da expressão matemática.
Vamos definir quais valores acompanham dada a expressão a seguir.

* `ax^2 + bx + c`. É um polinômio com 3 termos. Cada termo podemos utilizar a seguinte
nomenclatura: para `ax^2` chamamos de termo A, `bx` de termo B e `c` de termo C.

Para os termos A, B e C, temos que definir as constantes numéricas `a`, `b` e `c`
como sendo pertencentes ao conjunto dos números reais. Discutimos um caso
em que quando `a` é zero, acabamos descrevendo uma expressão que é uma função de
primeiro grau a partir da forma original da equação do segundo grau e também
se considerarmos que estamos utilizando a fórmula de Bhaskara, ela se torna conveniente
se tivermos uma equação do segundo grau com `a` diferente de zero.

> Agora começamos a restringir os valores possíveis como entrada de dados.

Recapitulando, temos agora que a feature demanda uma maneira de fornecer
dados de entrada para definir os valores das constantes `a`, `b` e `c`.

##### CENÁRIO 1

> Podemos utilizar a linguagem do BDD para descrever o cenário.

```
Scenario: dadas constantes a, b e c validas calcule as raizes.

    Given Os parametros de entrada a, b e c como sendo valores do tipo texto
    When Os parametros a, b e c forem validos, isto e, sendo numeros reais
    Then Então a função de calcular raizes Deve retornar as raizes da equacao
```

##### CENÁRIO 2

```
Scenario: dadas constantes ou 'a' ou 'b' ou 'c' invalidas, indique "Por favor, insira somente numeros reais" 

    Given Os parametros de entrada a, b e c como sendo valores do tipo texto
    When Alguns dos parametros forem invalidos, isto e, for inserido caracteres invalidos
    Then Deve lançar o erro 'Por favor, insira somente numeros reais'
```

##### CENÁRIO 3

```
Scenario: dada constante 'a' sendo zero, indique "Nao existem raizes reais".
Como observacao, nao calcule as raizes.

    Given Os parametros de entrada a, b e c como sendo valores do tipo texto
    When O parametro 'a' for zero mas b e c forem numeros reais
    Then Lance o erro 'Nao existem raizes reais'
```

### Feature F002 : BhaskaraApp - Seu app de calculo de equacao do segundo grau

#### Mapeamento de User Story

...

### Feature F003 : MathReport - um analisador matemático que gera relatório da Equação do Segundo Grau

#### Mapeamento de User Story

...

### Feature F004 : Historico de Expressoes Matematicas

#### Mapeamento de User Story

...
