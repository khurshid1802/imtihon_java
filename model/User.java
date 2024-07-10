package model;

import java.util.UUID;

public class User {
    public UUID id;
    public String fullName;
    public String username;
    public String password;

    public User(String fullName, String username, String password) {
        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
