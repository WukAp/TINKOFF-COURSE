package edu.hw5.Task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNumberValidationTest {

    @Test
    void isCarNumberValid() {
        CarNumberValidation carNumberValidation = new CarNumberValidation();
        Assertions.assertTrue(carNumberValidation.isCarNumberValid("А012АА77"));
        Assertions.assertTrue(carNumberValidation.isCarNumberValid("В412АА102"));
        Assertions.assertFalse(carNumberValidation.isCarNumberValid("В412АА1032"));
        Assertions.assertFalse(carNumberValidation.isCarNumberValid("Б412АА1032"));
        Assertions.assertFalse(carNumberValidation.isCarNumberValid("В12АА102"));
        Assertions.assertFalse(carNumberValidation.isCarNumberValid("В412Аы102"));
        Assertions.assertFalse(carNumberValidation.isCarNumberValid("Ва412АА102"));
        Assertions.assertFalse(carNumberValidation.isCarNumberValid("фВ412АА102"));
    }
}
