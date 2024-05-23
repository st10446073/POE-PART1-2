//ASSIGNMENT PART1

package com.mycompany.poe;
import javax.swing.JOptionPane;

public class POE {

    public static void main(String[] args) {
        RegistrationAndLogin.registerUser();
    }
}

class RegistrationAndLogin {
    private static String username;
    private static String password;

    public static void registerUser() {
        while (true) {
            String inputUsername = JOptionPane.showInputDialog("Enter a username (must contain an underscore and no more than 20 characters):");
            if (inputUsername == null) {
                JOptionPane.showMessageDialog(null, "Registration cancelled.");
                return;
            }
            
            String inputPassword = JOptionPane.showInputDialog("Enter a password (must be at least 8 characters, contain a capital letter, a number, and a special character):");
            if (inputPassword == null) {
                JOptionPane.showMessageDialog(null, "Registration cancelled.");
                return;
            }

            if (isValidUsername(inputUsername) && isValidPassword(inputPassword)) {
                username = inputUsername;
                password = inputPassword;
                JOptionPane.showMessageDialog(null, "Registration successful! You can now login.");
                loginUser();
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Registration failed. Please try again.");
            }
        }
    }

    public static boolean isValidUsername(String username) {
        if (username.length() > 20) {
            JOptionPane.showMessageDialog(null, "Username must not be more than 20 characters.");
            return false;
        }
        if (!username.contains("_")) {
            JOptionPane.showMessageDialog(null, "Username must contain an underscore.");
            return false;
        }
        return true;
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters.");
            return false;
        }
        if (!password.matches(".[A-Z].")) {
            JOptionPane.showMessageDialog(null, "Password must contain a capital letter.");
            return false;
        }
        if (!password.matches(".[0-9].")) {
            JOptionPane.showMessageDialog(null, "Password must contain a number.");
            return false;
        }
        if (!password.matches(".[!@#$%^&()].*")) {
            JOptionPane.showMessageDialog(null, "Password must contain a special character.");
            return false;
        }
        return true;
    }

    public static void loginUser() {
        while (true) {
            String inputUsername = JOptionPane.showInputDialog("Enter your username:");
            if (inputUsername == null) {
                JOptionPane.showMessageDialog(null, "Login cancelled.");
                return;
            }
            
            String inputPassword = JOptionPane.showInputDialog("Enter your password:");
            if (inputPassword == null) {
                JOptionPane.showMessageDialog(null, "Login cancelled.");
                return;
            }

            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                JOptionPane.showMessageDialog(null, "Login successful!");
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Login failed. Please try again.");
            }
        }
    }
}