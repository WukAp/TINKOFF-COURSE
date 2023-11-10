package edu.hw5.Task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarNumberValidationTest {

    @Test
    void isCarNumberValid() {
        CarNumberValidation carNumberValidation = new CarNumberValidation();
        assertTrue(carNumberValidation.isCarNumberValid("А012АА77"));
        assertTrue(carNumberValidation.isCarNumberValid("В412АА102"));
        assertFalse(carNumberValidation.isCarNumberValid("В412АА1032"));
        assertFalse(carNumberValidation.isCarNumberValid("Б412АА1032"));
        assertFalse(carNumberValidation.isCarNumberValid("В12АА102"));
        assertFalse(carNumberValidation.isCarNumberValid("В412Аы102"));
        assertFalse(carNumberValidation.isCarNumberValid("Ва412АА102"));
        assertFalse(carNumberValidation.isCarNumberValid("фВ412АА102"));
    }
}
