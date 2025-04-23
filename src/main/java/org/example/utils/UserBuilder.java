package org.example.utils;

import org.example.pages.UserPage;

public class UserBuilder {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserPage build() {
        return new UserPage(username, password, confirmPassword, email);
    }
}
