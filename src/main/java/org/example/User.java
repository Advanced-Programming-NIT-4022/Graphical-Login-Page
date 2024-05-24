package org.example;

class User {
    String username;
    PasswordUtils password;
    String email;

    public User(String username, PasswordUtils password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return username + ',' + password + ',' + email;
    }
}