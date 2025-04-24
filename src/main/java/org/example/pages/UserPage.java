package org.example.pages;

public class UserPage {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;

    public UserPage(String username, String password, String confirmPassword, String email) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
    }

    // Getters only, no setters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getConfirmPassword() { return confirmPassword; }
    public String getEmail() { return email; }
}
