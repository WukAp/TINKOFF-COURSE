package edu.hw5.Task4;

public class PasswordValidation {
    public boolean isPasswordValid(String password) {
        return password.matches(".*[~!@#$%^&*|].*");
    }
}
