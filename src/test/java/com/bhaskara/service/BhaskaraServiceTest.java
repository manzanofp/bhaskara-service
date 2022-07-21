package com.bhaskara.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//TDD traz o ciclo RED-GREEN-REFACTORING
// 1.RED: primeiramente criamos um teste que falha
// 2.RED: fazer de forma mais rapida e barata com que o teste passe com sucesso -> GREEN
// 3.GREEN: os testes estão passando mas o código não é aquilo que devemos ter como implementação. A implementação
//          está no modo fakep para fazer o teste passar.
// 4.REFACTORING: vamos refatorar o código tendo certeza de que o comportamento externo esteja garantido
//                devido as asserções feitas na escrita dos códigos de teste da etapa 1.
// 5. PROXIMO CENARIO OU CONTINUAR MELHORANDO COM NOVAS HIPÓTESES NO MESMO CENÁRIO
// 6. RED: produzir um teste que vai falhar para fazer passar

@SpringBootTest
class BhaskaraServiceTest {

	@Test
	void givenParametrosEntradaTipoTexto_whenParametrosConvertidosReal_thenRaizesEquacao() {

		//Asserção (afirmação): Espero que algo seja verdadeiro quando eu receber algum dado ou seja
		//o teste só passa se a expectativa corresponder a necessidade de ser verdade ou falsidade

		var bhaskaraCalcInputDTO = new BhaskaraCalcInputDTO("1","-2","-3");

		// Percebemos que o lado externo pede uma String e internamente convertemos para double
		//isso indica que precisamos de algum código de aplicação que vá se interessar em receber algum parametro
		// do tipo String, A quem interessa receber uma String e converter para double
		// Vamos introduzir a ideia de DTO (Data Transfer Object).

		assertThat(bhaskaraCalcInputDTO.parametroAToDouble()).isInstanceOf(Double.class); // mesma coisa que dizer "constante_a é um numero real"
		assertThat(bhaskaraCalcInputDTO.parametroBToDouble()).isInstanceOf(Double.class);
		assertThat(bhaskaraCalcInputDTO.parametroCToDouble()).isInstanceOf(Double.class);

		List<Double> raizes = Bhaskara.calculoRaizes(bhaskaraCalcInputDTO);
		assertThat(raizes).containsExactly(-1.0,3.0);
	}

}
