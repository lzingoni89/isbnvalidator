package com.violetacorp.tdd.isbnvalidator.service;

import com.violetacorp.tdd.isbnvalidator.service.impl.ISBNValidatorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ISBNValidatorServiceTests {

    private ISBNValidatorService isbnValidatorService;

    @BeforeEach
    void setUp() {
        isbnValidatorService = new ISBNValidatorServiceImpl();
    }

    @Test
    public void nullValuesAreNotAllowed() {
        assertFalse(this.isbnValidatorService.checkISBNNumber(null), "Value NULL");

    }

    @Test
    public void checkValid10DigitISBN() {
        assertTrue(this.isbnValidatorService.checkISBNNumber("0137081073"), "Value 0137081073");
        assertTrue(this.isbnValidatorService.checkISBNNumber("0134494164"), "Value 0134494164");

    }

    @Test
    public void checkValid13DigitISBN() {
        assertTrue(this.isbnValidatorService.checkISBNNumber("978-1949982534"), "Value 978-1949982534");
        assertTrue(this.isbnValidatorService.checkISBNNumber("978-0486264653"), "Value 978-0486264653");

    }

    @Test
    public void checkAnInvalid10ISBNNumber() {
        assertFalse(this.isbnValidatorService.checkISBNNumber("0137081083"), "Value 0137081083");
        assertFalse(this.isbnValidatorService.checkISBNNumber("0134494154"), "Value 0134494154");

    }

    @Test
    public void checkAnInvalid13ISBNNumber() {
        assertFalse(this.isbnValidatorService.checkISBNNumber("978-1949982535"), "Value 978-1949982535");
        assertFalse(this.isbnValidatorService.checkISBNNumber("978-0422264656"), "Value 978-0422264656");

    }

    @Test
    public void lengthDifferentOf10Or13AreNotAllowed() {
        assertThrows(NumberFormatException.class, () -> this.isbnValidatorService.checkISBNNumber("01381073234234234234"), "Value 01381073234234234234");
        assertThrows(NumberFormatException.class, () -> this.isbnValidatorService.checkISBNNumber("013873"), "Value 013873");
        assertThrows(NumberFormatException.class, () -> this.isbnValidatorService.checkISBNNumber("978-042226465655555"), "Value 978-042226465655555");
        assertThrows(NumberFormatException.class, () -> this.isbnValidatorService.checkISBNNumber("978-04264656"), "Value 978-04264656");
        assertThrows(NumberFormatException.class, () -> this.isbnValidatorService.checkISBNNumber(""), "Value empty");

    }

    @Test
    public void nonNumericISBNBodyIsNotAllowed() {
        assertThrows(NumberFormatException.class, () -> this.isbnValidatorService.checkISBNNumber("123456789A"), "Value 123456789A");
        assertThrows(NumberFormatException.class, () -> this.isbnValidatorService.checkISBNNumber("hola_loco"), "Value hola_loco");
        assertThrows(NumberFormatException.class, () -> this.isbnValidatorService.checkISBNNumber("1234-56789"), "Value 1234-56789");

    }

    @Test
    public void isbnNumbersEndingWithXAreValid() {
        assertTrue(this.isbnValidatorService.checkISBNNumber("194998253X"), "Value 194998253X");

    }

}
