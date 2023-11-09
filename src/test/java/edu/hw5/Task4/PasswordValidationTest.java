package edu.hw5.Task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordValidationTest {

    @Test
    void isValid() {
        PasswordValidation passwordValidation = new PasswordValidation();
        Assertions.assertTrue(passwordValidation.isPasswordValid("~"));
        Assertions.assertTrue(passwordValidation.isPasswordValid("!"));
        Assertions.assertTrue(passwordValidation.isPasswordValid("@"));
        Assertions.assertTrue(passwordValidation.isPasswordValid("#"));
        Assertions.assertTrue(passwordValidation.isPasswordValid("$"));
        Assertions.assertTrue(passwordValidation.isPasswordValid("%"));
        Assertions.assertTrue(passwordValidation.isPasswordValid("^"));
        Assertions.assertTrue(passwordValidation.isPasswordValid("&"));
        Assertions.assertTrue(passwordValidation.isPasswordValid("*"));
        Assertions.assertTrue(passwordValidation.isPasswordValid("|"));
        Assertions.assertTrue(passwordValidation.isPasswordValid("~ ! @ # $ % ^ & * |"));
        Assertions.assertTrue(passwordValidation.isPasswordValid("#hgejwgeegq"));
        Assertions.assertTrue(passwordValidation.isPasswordValid("djkashkdsa#"));
        Assertions.assertTrue(passwordValidation.isPasswordValid("djka%shkdsa"));
        Assertions.assertFalse(passwordValidation.isPasswordValid("sasa"));
    }
}
