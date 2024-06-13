package br.edu.uniritter.gestaoqualidade;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import br.edu.uniritter.gestaoqualidade.controllers.AppController;
import br.edu.uniritter.gestaoqualidade.exceptions.CPFIncompleteException;
import br.edu.uniritter.gestaoqualidade.exceptions.CPFMalFormedException;

class ControllerTests {

    @Test
    @DisplayName("CPF incompleto")
    void testCPFIncomplete() {
        assertThrows(CPFIncompleteException.class, () -> {
            AppController.checkCPF("123.456.789");
        });
    }

	@Test
    @DisplayName("CPF incompleto")
    void testCPFInvalido() {
        assertThrows(CPFMalFormedException.class, () -> {
            AppController.checkCPF("123.456.789/00");
        });
    }

	@Test
    @DisplayName("CPF  Null")
    void testCPFNull() {
        assertThrows(NullPointerException.class, () -> {
            AppController.checkCPF(null);
        });
    }
	@Test
    @DisplayName("CPF completo com Throws")
    void testCPFComplete2() {
		try {
		assertTrue(
            AppController.checkCPF("123.456.789-00")
        );
		} catch (Exception e) {
			
		}
    }

	@Test
	@DisplayName("CPF correto")
	void testCPFCorreto() {
		
		assertTrue(AppController.checkCPFSException("123.456.789-00"));
		assertFalse(AppController.checkCPFSException("123.456.789-01"));
		

	}

	@Test
	

	void testDesconto() {
		assertEquals(90.09, AppController.desconto(100.10f, 10));
	}

    /*
	@Test
	@DisplayName("1 + 1 = 2")
	void addsTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void add(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}
    */
}