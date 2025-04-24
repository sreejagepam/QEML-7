package org.example.pages;

import java.io.Serializable;
public class BankAccount implements Serializable {
    private Object id;
    private String name;
    private Double balance;
    private UserPage user;

    BankAccount(){}

    private BankAccount(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.balance = builder.balance;
        this.user = builder.user;
    }

    // Getters
    public Object getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setUser(UserPage user) {
        this.user = user;
    }

    public UserPage getUser() {
        return user;
    }

    // Builder Class
    public static class Builder {
        private Object id;
        private String name;
        private double balance;
        private UserPage user;

        public Builder setId(Object id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder setUser(UserPage user) {
            this.user = user;
            return this;
        }

        public BankAccount build() {
            return new BankAccount(this);
        }
    }

    public static BankAccount createDefaultBankAccount(){
        return new Builder()
                .setName("User 3")
                .setBalance(4500)
                .setUser(null)
                .build();
    }
}
