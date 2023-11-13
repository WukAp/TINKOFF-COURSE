package edu.hw5.Task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidationTest {

    @Test
    void isValid() {
        PasswordValidation passwordValidation = new PasswordValidation();
        assertTrue(passwordValidation.isPasswordValid("!"));
        assertTrue(passwordValidation.isPasswordValid("~"));
        assertTrue(passwordValidation.isPasswordValid("@"));
        assertTrue(passwordValidation.isPasswordValid("#"));
        assertTrue(passwordValidation.isPasswordValid("$"));
        assertTrue(passwordValidation.isPasswordValid("%"));
        assertTrue(passwordValidation.isPasswordValid("^"));
        assertTrue(passwordValidation.isPasswordValid("&"));
        assertTrue(passwordValidation.isPasswordValid("*"));
        assertTrue(passwordValidation.isPasswordValid("|"));
        assertTrue(passwordValidation.isPasswordValid("~ ! @ # $ % ^ & * |"));
        assertTrue(passwordValidation.isPasswordValid("#hgejwgeegq"));
        assertTrue(passwordValidation.isPasswordValid("djkashkdsa#"));
        assertTrue(passwordValidation.isPasswordValid("djka%shkdsa"));
        assertFalse(passwordValidation.isPasswordValid("sasa"));
    }
}
