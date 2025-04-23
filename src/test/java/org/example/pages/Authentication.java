package org.example.pages;

public class Authentication {
    private String username;
    private String password;
    private boolean rememberMe;

    private Authentication(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
        this.rememberMe = builder.rememberMe;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public static class Builder {
        private String username;
        private String password;
        private boolean rememberMe;

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRememberMe(boolean rememberMe) {
            this.rememberMe = rememberMe;
            return this;
        }

        public Authentication build(){
            return new Authentication(this);
        }
    }

    public static Authentication getDefaultAuthentication() {
        return new Builder()
                .setUsername("admin")
                .setPassword("admin")
                .setRememberMe(false)
                .build();
    }
}
